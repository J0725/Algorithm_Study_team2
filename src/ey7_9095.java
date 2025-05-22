import java.util.Scanner;

public class ey7_9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 개수
        int[] dp = new int[11]; // n < 11

        // 초기값 설정
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        // DP 점화식 적용
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        // i를 만들 수 있는 모든 경우의 수 =
        // i-1까지의 경우에 +1을 붙인 경우 +
        // i-2까지의 경우에 +2를 붙인 경우 +
        // i-3까지의 경우에 +3을 붙인 경우

        // 테스트 케이스 출력
        while (T-- > 0) { // T--는 현재 T값을 사용하고 1 감소시킴. 즉, T번 반복
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
    }
}
