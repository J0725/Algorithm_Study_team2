import java.util.Scanner;

public class Problem_1992 {
    static int[][] video;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 영상 크기
        video = new int[n][n];

        // 영상 데이터 입력
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                video[i][j] = line.charAt(j) - '0'; // 문자 '0' → 정수 0
            }
        }

        // 쿼드트리 압축 시작
        System.out.println(compress(0, 0, n));
    }

    // 영상의 (x, y)에서 시작해서 size 크기인 정사각형을 압축
    static String compress(int x, int y, int size) {
        if (checkSameColor(x, y, size)) {
            return Integer.toString(video[x][y]);  // 모두 같은 색이면 해당 숫자 출력
        }

        // 4등분하여 압축한 결과를 이어붙임
        int newSize = size / 2;
        StringBuilder sb = new StringBuilder();

        sb.append("(");  // 괄호 열기
        sb.append(compress(x, y, newSize));                         // 왼쪽 위
        sb.append(compress(x, y + newSize, newSize));              // 오른쪽 위
        sb.append(compress(x + newSize, y, newSize));              // 왼쪽 아래
        sb.append(compress(x + newSize, y + newSize, newSize));    // 오른쪽 아래
        sb.append(")");  // 괄호 닫기

        return sb.toString();
    }

    // 구역이 모두 같은 색인지 확인
    static boolean checkSameColor(int x, int y, int size) {
        int color = video[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != color) {
                    return false;  // 하나라도 다르면 false
                }
            }
        }
        return true;  // 모두 같으면 true
    }
}
