package org.example;

import java.util.Scanner;

/**
 * 车位监视器
 */
public class ParkingMonitor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineAndColNumStr = scanner.nextLine();
        String[] lineAndCol = lineAndColNumStr.split("");
        int m = Integer.parseInt(lineAndCol[0]);
        int n = Integer.parseInt(lineAndCol[1]);

        int[][] mn = new int[m][n];
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            String numsStr = scanner.nextLine();
            String[] split = numsStr.split(" ");
            for (int j = 0; j < split.length; j++) {
                mn[i][j] = Integer.parseInt(split[j]);
                result[i][j] = mn[i][j];
            }
        }

        scanner.close();

        for (int i = 0; i < mn.length; i++) {
            for (int j = 0; j < mn[i].length; j++) {
                int val = mn[i][j];
                if (val == 1) {
                    // 为周围元素赋值为1
                    if (i - 1 >= 0) {
                        result[i - 1][j] = 1;
                    }
                    if (i + 1 < m) {
                        result[i + 1][j] = 1;
                    }
                    if (j - 1 >= 0) {
                        result[i][j - 1] = 1;
                    }
                    if (j + 1 < n) {
                        result[i][j + 1] = 1;
                    }
                }
            }
        }

        // 统计1的个数
        int count = 0;
        for (int[] col : result) {
            for (int item : col) {
                if (item == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
