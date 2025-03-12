package Sunro;

import java.util.Scanner;

public class 파도반_수열_repeat_9461 {
    static int testCaseCount;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCaseCount = sc.nextInt();
        while (testCaseCount-- > 0) {
            int tryCase = sc.nextInt();
            dp = new int[tryCase + 1];
            if (tryCase <= 3) {
                System.out.println(1);
                continue;
            }
            for (int i = 1; i <= tryCase; i++) {
                if (i <= 3) dp[i] = 1;
                else dp[i] = dp[i - 3] + dp[i - 2];
            }
            System.out.println(dp[tryCase]);
        }
    }
}
