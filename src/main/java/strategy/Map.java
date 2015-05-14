package strategy;

import strategy.utils.CollectionUtils;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sergey on 27.04.2015.
 */
public class Map {

    private int[][] map;


    public Map(int width, int height) {
        map = new int[width][height];
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    public void setTile(int x, int y, int tile) {
        map[x][y] = tile;
    }

    public int getTile(int x, int y) {
        return map[x][y];
    }

    public boolean loadMap(String filename) {
        try {
            Scanner in = new Scanner(new FileInputStream(filename));
            ArrayList<String> content = new ArrayList<String>();

            while ( in.hasNextLine() ) {
                String line = in.nextLine();
                if (!line.startsWith("#")) {
                    content.add(line);
                }
            }

            return parseMap(content);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean parseMap(ArrayList<String> content) {
        map = new int[content.size()][CollectionUtils.getMaxWidth(content)];

        for (int i = 0; i < content.size(); i++) {
            String line = content.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (!parseTile(line.charAt(j), i, j))
                    return false;
            }
        }

        return true;
    }

    public boolean parseTile(char tile, int x, int y) {
        int ntile = Character.getNumericValue(tile);
        if (ntile < 0 || ntile > MapObjects.TILE_NUM)
            return false;

        map[x][y] = ntile;
        return true;
    }

    public int[][] getMapArray() {
        return map;
    }


    public void draw(Graphics g) {
        int sy = 2;
        int sx;
        int sTile = MapObjects.TILE_SIZE;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sx = map[i][j] + 1;
                g.drawImage(Game.getSpriteSheet(),
                        i * sTile, j * sTile,
                        i * sTile + sTile, j * sTile + sTile,
                        sx * sTile, sy * sTile,
                        sx * sTile + sTile, sy * sTile + sTile,
                        null);
            }
        }
    }
}
