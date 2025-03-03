package Sunro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_9084 {
    static int testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            int N = Integer.parseInt(br.readLine());
            int[] coinArr = new int[N];
            int goal = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                coinArr[i] = Integer.parseInt(st.nextToken());
            }
            goal = Integer.parseInt(br.readLine());//입력완료
            int[] dp = new int[goal+1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                int coin = coinArr[i];
                for (int j = coin; j <=goal ; j++) {
                    dp[j] += dp[j-coin];
                }
            }
            System.out.println(dp[goal]);
        }
    }
}
