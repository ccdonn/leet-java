package com.donn.leet;

public class P11_2 {
    public static void main(String[] args) {
        System.out.println(new P11_2().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(new P11_2().maxArea(new int[] { 1, 1, 1, 1, 1 }));
        System.out.println(new P11_2().maxArea(new int[] { 1, 2, 4, 3 }));
    }

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        while (leftIndex < rightIndex) {
            int area = (rightIndex - leftIndex) * Math.min(height[rightIndex], height[leftIndex]);
            // System.out.println("" + Math.min(height[rightIndex], height[leftIndex]) + " * (" + rightIndex + "-" + leftIndex +
            // ") = " + area);
            if (area > max) {
                max = area;
            }
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return max;
    }

}
