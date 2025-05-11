import java.util.Arrays;
import java.util.Scanner;

public class Problem_11399{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 사람 수 입력
        int n = sc.nextInt();
        int[] times = new int[n];

        // 2. 각 사람이 돈을 인출하는 데 걸리는 시간 입력
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }

        // 3. 오름차순 정렬 (Greedy 핵심)
        Arrays.sort(times);

        int sum = 0;       // 최종 총합
        int waiting = 0;   // 현재까지의 누적합

        // 4. 누적합을 계산
        for (int i = 0; i < n; i++) {
            waiting += times[i]; // 현재 사람이 기다린 총 시간
            sum += waiting;      // 그 시간들을 계속 더함
        }

        // 5. 출력
        System.out.println(sum);
    }
}
