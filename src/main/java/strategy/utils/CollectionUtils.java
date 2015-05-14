package strategy.utils;

import java.util.List;

/**
 * Created by sergey on 03.05.2015.
 */
public class CollectionUtils {

    public static int getMaxWidth(List<String> list) {
        int max_width = list.get(0).length();
        for (String line : list) {
            if (line.length() > max_width)
                max_width = line.length();
        }

        return max_width;
    }
}
