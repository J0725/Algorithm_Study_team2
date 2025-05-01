import java.util.Scanner;

public class Problem_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] people = new int[N][2]; // [몸무게, 키]

        // 사람들의 몸무게와 키 입력 받기
        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt(); // 몸무게
            people[i][1] = sc.nextInt(); // 키
        }

        sc.close();

        for (int i = 0; i < N; i++) {
            int rank = 1; // 시작 등수는 1등

            for (int j = 0; j < N; j++) {
                if (i == j)//i번째 사람과 j번째 사람을 비교
                    continue; // 자기 자신은 비교하지 않음

                // 나보다 몸무게, 키 둘 다 큰 사람 발견 → 등수 밀림
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }
    }
}
