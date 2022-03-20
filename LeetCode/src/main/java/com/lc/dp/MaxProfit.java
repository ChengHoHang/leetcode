package com.lc.dp;

/**
 * @author chh
 * @date 2022/3/20 15:00
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }

            int todayProfit = price - minPrice;
            if (todayProfit > maxProfit) {
                maxProfit = todayProfit;
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit.maxProfit(new int[]{7,6,4,3,1}));
    }
}
