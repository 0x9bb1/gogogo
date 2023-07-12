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
        for (int i = 0; i < m; i++) {
            String numsStr = scanner.nextLine();
            String[] split = numsStr.split(" ");
            for (int j = 0; j < split.length; j++) {
                mn[i][j] = Integer.parseInt(split[j]);
            }
        }

        scanner.close();

        int result = 0;
        for (int i = 0; i < mn.length; i++) {
            for (int j = 0; j < mn[i].length; j++) {
                int sum = mn[i][j];

            }
        }
    }
}
