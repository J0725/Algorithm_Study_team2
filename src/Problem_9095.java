/*DP (Bottom-Up)- Tabulation
정수 n이 주어졌을 때, 1, 2, 3의 합으로 n을 만드는 방법의 수를 구하시오.
(단, 순서가 다르면 다른 방법으로 센다)
🧠 입력
첫째 줄에 테스트 케이스 개수 T

그 다음 줄부터 n이 주어짐 (1 ≤ n ≤ 11)

📤 출력
각 테스트 케이스마다 방법의 수를 한 줄에 하나씩 출력*/
import java.util.Scanner;

public class Problem_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        int[] dp = new int[12]; // 1 <= n <= 11
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 미리 DP 테이블 계산
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
