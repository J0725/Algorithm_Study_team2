import java.util.Scanner;

public class ey7_1463 {

    static Integer[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        dp = new Integer[N + 1];

        dp[1] = 0; // 1은 0번의 연산으로 만들 수 있음

        System.out.print(recur(N));
    }

    static int recur(int N) {

        if (dp[N] == null) { // 아직 dp[N] 값이 계산된 적 없다면, 즉 처음 호출된 경우라면 계산을 진행
            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
                // 세 가지 연산을 모두 시도해보고, 최소값 + 1을 저장
                // +1은 지금 이 순간 내가 한 연산 1번
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
