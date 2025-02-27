package Sunro;

import java.util.Scanner;

public class 파도반_수열_9461 {
    static int N;
    static long[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();


        while (N-- > 0) {
            int x = sc.nextInt();
            data = new long[102];

            data[0] =0;
            data[1] = 1;
            data[2] = 1;
            data[3] = 1;
            data[4] = 2;
            data[5] = 2;
            if (x < 6) {
                System.out.println(data[x]);
                continue;
            }else {
                for (int i = 6; i <=x; i++) {
                    data[i] = data[i-5] + data[i-1];
                }
            }
            System.out.println(data[x]);
        }

    }
}
