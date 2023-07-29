package org.example;

import java.util.Scanner;

/**
 * 购物单
 */
public class ShoppingList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();// 总物品数目
        int[][] prices = new int[n + 1][3];
        int[][] weights = new int[m + 1][3];
        sc.nextLine();

        for (int i = 1; i <= m; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt() * v;// 钱*重要度
            int q = sc.nextInt();
            sc.nextLine();
            if (q == 0) {// 主件直接加就行
                prices[i][0] = v;
                weights[i][0] = p;
            } else if (prices[q][1] == 0) {// 从件先试着赋值到主件的第一个位置去
                prices[q][1] = v;
                weights[q][1] = p;
            } else {// 1号有从件后赋值到从件2
                prices[q][2] = v;
                weights[q][2] = p;
            }
        }

        sc.close();

        int[] dp = new int[n + 1];// 压缩空间到1维
        for (int i = 1; i <= m; i++) {// 遍历所有物品
            for (int j = n; j >= 1; j--) {// 从后向前遍历防止出错
                // 分为四种情况：只放主，放主+从1，放主+从2，放主+从1+从2
                int p1 = prices[i][0];// 从件都为0的
                int w1 = weights[i][0];
                int p2 = prices[i][1];
                int w2 = weights[i][1];
                int p3 = prices[i][2];
                int w3 = weights[i][2];

                if (j - p1 >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - p1] + w1);
                }
                if (j - p1 - p2 >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - p1 - p2] + w1 + w2);
                }
                if (j - p1 - p3 >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - p1 - p3] + w1 + w3);
                }
                if (j - p1 - p2 - p3 >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - p1 - p2 - p3] + w1 + w2 + w3);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
