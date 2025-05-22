import java.util.Scanner;

public class eig_9095 {
   // 1, 2, 3 더하기

    public static void main(String[] args) {
        // Scanner를 사용하여 입력 받기
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수 입력
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            // 정수 n 입력 (1부터 10까지의 수로 가정)
            int n = sc.nextInt();

            // dp 배열 초기화 (dp[i]는 i를 1, 2, 3의 합으로 나타내는 방법의 수)
            int[] dp = new int[11];

            // 기본값 설정
            dp[1] = 1; // 1 = (1)
            dp[2] = 2; // 2 = (1+1), (2)
            dp[3] = 4; // 3 = (1+1+1), (1+2), (2+1), (3)

            // Bottom-up 방식으로 dp 배열 채우기
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                // i를 만들기 위한 방법:
                // - 마지막 수가 1인 경우 → dp[i-1]
                // - 마지막 수가 2인 경우 → dp[i-2]
                // - 마지막 수가 3인 경우 → dp[i-3]
            }

            // 결과 출력
            System.out.println(dp[n]);
        }

        // Scanner 닫기
        sc.close();
    }
}
