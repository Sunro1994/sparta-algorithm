package Sunro;
import java.util.Scanner;

public class 제곱수의합_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        // 초기값 설정
        for (int i = 1; i <= N; i++) {
            dp[i] = i; // 최악의 경우, 1^2을 i번 더하는 경우 (ex: 4 = 1+1+1+1)
            for (int j = 1; j * j <= i; j++) {
                 dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
