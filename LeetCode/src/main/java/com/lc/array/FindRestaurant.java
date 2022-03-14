package com.lc.array;

import java.util.*;

/**
 * @author chh
 * @date 2022/3/14 21:26
 */
public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length == 0 || list2.length == 0) {
            return new String[]{};
        }
        
        Map<String, Integer> list1Map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            list1Map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            String key = list2[i];
            if (list1Map.containsKey(key)) {
                int sum = list1Map.get(key) + i;
                if (sum == minLength) {
                    result.add(key);
                } else if (sum < minLength) {
                    result.clear();
                    result.add(key);
                    minLength = sum;
                }
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        FindRestaurant findRestaurant = new FindRestaurant();
        System.out.println(Arrays.toString(findRestaurant.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
}
