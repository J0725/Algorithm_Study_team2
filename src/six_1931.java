import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class six_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] time = new int[N][2];

        for(int i = 0; i < N; i++) {
            time[i][0] = sc.nextInt();	// 시작시간
            time[i][1] = sc.nextInt();	// 종료시간
        }

        sc.close();

        // 종료 시간 기준으로 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {  // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prev_end_time = 0;

        for(int i = 0; i < N; i++) {
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
