import java.util.Scanner;
import java.util.Arrays;

public class ey5_11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 사람 수
        int[] time = new int[n];

        // 시간 입력 받기
        for (int i = 0; i < n; i ++) {
            time[i] = scanner.nextInt();
        }

        // 정렬 (작은 순서대로)
        Arrays.sort(time);

        // 누적 합 계산
        int total = 0;  // 전체 최소 시간 합
        int now = 0;    // 지금까지의 누적 시간

        for (int i = 0; i < n; i++) {
            now += time[i];
            total += now;
        }

        System.out.println(total);
    }
}
