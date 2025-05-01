

import java.util.Scanner;

public class P7568 {
    public P7568() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];

        for(int i = 0; i < N; ++i) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        for(int i = 0; i < N; ++i) {
            int rank = 1;

            for(int j = 0; j < N; ++j) {
                if (i != j && A[i][0] < A[j][0] && A[i][1] < A[j][1]) {
                    ++rank;
                }
            }

            System.out.print(rank + " ");
        }

    }
}
