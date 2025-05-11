import java.util.*;

public class Problem_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 회의 수 입력
        int n = sc.nextInt();
        int[][] meetings = new int[n][2]; //n개의 회의에 대해 각 회의를 2개의 정수로 저장

        // 2. 회의 시작 시간과 끝 시간 입력
        for (int i = 0; i < n; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 종료 시간
        }

        // 3. 끝나는 시간을 기준으로 정렬 (끝나는 시간이 같다면 시작 시간 오름차순)
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; // 시작 시간 기준 오름차순
            }
            return a[1] - b[1]; // 종료 시간 기준 오름차순
        });

        // 4. 회의 선택
        int count = 0;        // 선택된 회의 수
        int endTime = 0;      // 이전 회의의 종료 시간

        for (int i = 0; i < n; i++) {
            // 겹치지 않으면 선택
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                count++;
            }
        }

        // 5. 출력
        System.out.println(count);
    }
}
