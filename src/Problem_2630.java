import java.util.Scanner;

public class Problem_2630 {
    static int[][] paper;       // 색종이 배열
    static int white = 0;       // 하얀색 색종이 개수
    static int blue = 0;        // 파란색 색종이 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 종이의 크기 (2의 제곱수)

        // 색종이 배열 초기화
        paper = new int[n][n];

        // 색종이 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        // 분할 정복 시작
        divide(0, 0, n);

        // 결과 출력
        System.out.println(white);  // 하얀색 색종이 개수
        System.out.println(blue);   // 파란색 색종이 개수
    }

    // 종이의 (x, y)에서 시작하여 size 크기의 정사각형을 검사
    public static void divide(int x, int y, int size) {
        if (checkSameColor(x, y, size)) {
            // 모두 같은 색이면 해당 색 증가
            if (paper[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }

        // 같지 않으면 4등분해서 재귀 호출
        int newSize = size / 2;

        // 왼쪽 위
        divide(x, y, newSize);

        // 오른쪽 위
        divide(x, y + newSize, newSize);

        // 왼쪽 아래
        divide(x + newSize, y, newSize);

        // 오른쪽 아래
        divide(x + newSize, y + newSize, newSize);
    }

    // 현재 구역이 모두 같은 색인지 확인하는 함수
    public static boolean checkSameColor(int x, int y, int size) {
        int color = paper[x][y];  // 기준 색

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color)
                    return false;  // 하나라도 다르면 false
            }
        }
        return true;  // 모두 같으면 true
    }
}
