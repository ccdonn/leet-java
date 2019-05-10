package com.donn.leet;

public class P121 {
    public static void main(String[] args) {
        System.out.println(new P121().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(new P121().maxProfit(new int[] { 7, 6, 4, 3, 1 }));

    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int v = prices[i] - prices[j];
                if (v > max) {
                    max = v;
                }
            }
        }
        return max;
    }
}
