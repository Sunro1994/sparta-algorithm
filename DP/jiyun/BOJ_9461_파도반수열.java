import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;

        for (int i=4; i<101; i++){
            p[i] = p[i-3] + p[i-2];
        }

        for (int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(p[n]);
        }
    }
}