import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n + 1];
        int[] pay = new int[n + 1];
        int[] dp = new int[n + 2]; // n일 째 부터 일한 값 중 최대 이익

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=n; i>0; i--){
            if(i + time[i] > n+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], pay[i] + dp[i+time[i]]);
            }
        }
        System.out.println(dp[1]);
    }
}
