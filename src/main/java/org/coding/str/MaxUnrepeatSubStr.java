package org.coding.str;

import java.util.HashMap;
import java.util.Map;

public class MaxUnrepeatSubStr {
    public int maxNoRepeatSubstr(String source) {
        Map<Character, Integer> locationMap = new HashMap<>();
        int max= 0, start = 0;
        for (int i = 0; i < source.length(); i++) {
            if (locationMap.containsKey(source.charAt(i))) {
                if (start != i) {
                    start = Math.max(start, locationMap.get(source.charAt(i)) + 1);
                }
            }
            locationMap.put(source.charAt(i), i);
            max = Math.max(max, i- start + 1);
        }
        return max;
    }
}
