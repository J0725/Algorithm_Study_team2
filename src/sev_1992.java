import java.util.Scanner;

public class sev_1992 {
    // 쿼드 트리
    static StringBuilder result = new StringBuilder();
    static int[][] vid; // 기본 영상

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 영상의 크기
        sc.nextLine();

        vid = new int[n][n];

        for (int i=0; i<n; i++) {
            String line = sc.nextLine(); // 한 줄 문자열로 읽기
            for (int j=0; j<n; j++) {
                vid[i][j] = line.charAt(j) - '0'; // ASCII 값을 빼주면 실제 숫자 값이 됨
            }
        }

        divideVid(0, 0, n);

        System.out.print(result.toString());
    }

    public static void divideVid(int row, int col, int n) {
        if(colorCheck(row, col, n)) {
            result.append(vid[row][col]); // 압축
            return; // 색이 같으면 더 나누지 않고 종료 !
        }

        int newSize = n/2;

        result.append("("); // 각 레벨에서 여는 괄호로 시작

        divideVid(row, col, newSize); // 좌상단
        divideVid(row, col + newSize, newSize); // 우상단
        divideVid(row + newSize, col, newSize); // 좌하단
        divideVid(row + newSize, col + newSize, newSize); // 우하단

        result.append(")"); // 각 레벨이 끝나면 괄호 닫아줌
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = vid[row][col];

        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if(vid[i][j] != color) return false;
            }
        }

        return true;
    }
}
