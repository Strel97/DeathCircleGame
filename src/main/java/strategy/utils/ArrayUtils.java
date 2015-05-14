package strategy.utils;

/**
 * Created by sergey on 03.05.2015.
 */
public class ArrayUtils {

    public static void showArray(int[][] arr) {
        for (int[] i : arr) {
            System.out.println();
            for (int j : i)
                System.out.print(j);
        }
    }
}
