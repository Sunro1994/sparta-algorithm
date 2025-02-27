package Sunro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    static int N;
    static int[] dp;
    static int[] cost;
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        cost = new int[N+1];
        value = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int nextDay = i + cost[i];
            if (nextDay <= N + 1) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + value[i]);
            }
        }
        System.out.println(Math.max(dp[N], dp[N + 1]));  // 최종 최대 이익 출력
    }

    private static int getDp(int i) {
        if(i+cost[i]>N) return 0;
        else if (i== N && i+cost[i]<=N+1) return value[i];
        return value[i] + getDp(i+cost[i]);
    }
}
