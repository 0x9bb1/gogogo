package org.example;

import java.util.Scanner;

/**
 * 合唱队
 */
public class Choir {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] numsStr = scanner.nextLine().split(" ");
        int[] nums = new int[num];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        scanner.close();
        System.out.println(findLeast(nums));
    }

    /**
     * 动态规划
     * 1. 从左到右，找到最长递增子序列
     * 2. 从右到左，找到最长递减子序列
     * 3. 两个序列的最大值相加，再减去1为最大合唱队人数
     * 4. 总人数减去最大合唱队人数为最少出列人数
     *
     * @param nums input
     * @return min num
     */
    private static int findLeast(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (left[j] + 1 > left[i])) {
                    left[i] = left[j] + 1;
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i] && (right[j] + 1 > right[i])) {
                    right[i] = right[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(left[i] + right[i], max);
        }
        return nums.length - max + 1;
    }
}
