import java.util.Scanner;

public class ey6_2630 {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        paper = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }

        // 분할 정복 시작
        divide(0, 0, N);

        // 결과 출력
        System.out.println(white);
        System.out.println(blue);
    }

    // 분할 함수
    static void divide(int row, int col, int size) {
        if(colorCheck(row, col, size)) { // 같은 색이라면
            if(paper[row][col] == 0) { // 색깔 확인
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        // 다른 색이라면
        int newSize = size / 2;	// 절반 사이즈로 사이즈 줄이고
        // 재귀 호출
        divide(row, col, newSize);						        // 왼쪽 위
        divide(row, col + newSize, newSize);				// 오른쪽 위
        divide(row + newSize, col, newSize);				// 왼쪽 아래
        divide(row + newSize, col + newSize, newSize);	// 오른쪽 아래
    }

    // 같은 색인지 확인
    static boolean colorCheck(int row, int col, int size) {
        int color = paper[row][col]; // 첫번째 원소 기준으로 검사
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }// 첫번째 칸의 색깔과 다르면 false
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }
}
