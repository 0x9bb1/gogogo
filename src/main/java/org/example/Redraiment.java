package org.example;

import java.util.Scanner;

/**
 * Redraiment的走法
 * 即最长递增子序列
 */
public class Redraiment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] numsStr = scanner.nextLine().split(" ");

        scanner.close();

        int[] nums = new int[num];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        System.out.println(maxSteps(nums));
    }

    private static int maxSteps(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (dp[j] + 1 > maxVal)) {
                    maxVal = dp[j] + 1;
                }
            }
            dp[i] = maxVal;
            max = Math.max(max, maxVal);
        }
        return max;
    }
}
