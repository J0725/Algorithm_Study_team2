import java.util.Scanner;

public class Problem_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int result = 0;

        // 1부터 N-1까지 모두 검사
        for (int i = 1; i < N; i++) {
            int sum = i;
            int temp = i;

            // 각 자리수를 더함
            while (temp != 0) {
                sum += temp % 10;  // 마지막 자리수 더하기
                temp /= 10;        // 마지막 자리수 제거
            }

            // 생성자가 N과 같으면 result에 저장 후 종료
            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
