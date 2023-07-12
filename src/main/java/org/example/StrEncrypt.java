package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串加密
 */
public class StrEncrypt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<String> sources = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String source = scanner.nextLine();
            sources.add(source);
        }
        scanner.close();
        for (String source : sources) {
            System.out.println(encrypt(source));
        }
    }

    private static String encrypt(String source) {
        if (source == null || source.length() == 0) {
            return "";
        }

        char[] chars = source.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int val = getVal(i);
            char c = chars[i];
            int target = c + val;
            if (97 <= target && target <= 122) {
                sb.append((char) target);
            } else {
                sb.append((char) ((target - 97) % 26 + 97));
            }
        }
        return sb.toString();
    }

    private static int getVal(int index) {
        if (index == 0) {
            return 1;
        } else if (index == 1) {
            return 2;
        } else if (index == 2) {
            return 4;
        } else {
            return getVal(index - 1) + getVal(index - 2) + getVal(index - 3);
        }
    }
}
