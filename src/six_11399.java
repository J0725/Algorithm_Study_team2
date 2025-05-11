import java.util.Arrays;
import java.util.Scanner;

public class six_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람 수

        int[] arr = new int[N]; // 각각 걸리는 시간

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        int cumul = 0;	// 대기시간 누적합
        int sum = 0;	// 사람별 대기시간 총합

        for(int i = 0; i < N; i++) {
            // 이전 대기시간 + 걸리는 시간
            sum += cumul + arr[i];

            // 이전까지의 누적합 + 걸리는 시간
            cumul += arr[i];
        }
        System.out.println(sum);
    }
}
