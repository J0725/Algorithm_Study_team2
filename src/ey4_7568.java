import java.util.Scanner;

public class ey4_7568 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = scanner.nextInt();	// [i][0] : 몸무게
            arr[i][1] = scanner.nextInt();	// [i][1] : 키
        }

        // 각 사람에 대해 덩치 등수 계산
        for(int i = 0; i < N; i++) {
            int rank = 1; // 등수는 기본적으로 1등에서 시작

            for(int j = 0; j < N; j++) {
                if(i == j) continue; // 자기 자신과는 비교하지 않음
                // 자신보다 몸무게도 크고, 키도 큰 사람이 있다면 → 덩치가 더 크다
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }

            // 현재 사람의 등수 출력 (공백으로 구분)
            System.out.print(rank + " ");
        }

    }
}
