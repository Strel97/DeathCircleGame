package rpg;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by strel on 14.05.15.
 */
public class Animation {

    private List<AnimationFrame> frames;
    private int current;

    private long startTime;
    private long totalTime;
    private long elapsedTime;


    public Animation() {
        frames = new ArrayList<AnimationFrame>();
        current = 0;

        startTime = 0;
        totalTime = 0;
        elapsedTime = 0;
    }

    public void add(Image frame, long time) {
        totalTime += time;
        frames.add(new AnimationFrame(frame, totalTime));
    }

    public void start() {
        startTime = System.currentTimeMillis();
        current = 0;
        elapsedTime = 0;
    }

    public void update() {
        if (frames.isEmpty())
            return;

        if (current >= frames.size())
            return;

        elapsedTime = System.currentTimeMillis() - startTime;

        for (AnimationFrame frame : frames)
            if (frame.endTime <= elapsedTime)
                current++;
    }

    public Image getCurrent() {
        return frames.get(current).img;
    }


    private class AnimationFrame {

        public Image img;
        public long endTime;

        public AnimationFrame(Image img, long endTime) {
            this.img = img;
            this.endTime = endTime;
        }
    }
}
