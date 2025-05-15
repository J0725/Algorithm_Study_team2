import java.util.Scanner;

public class sev_2630 {
    // 색종이 만들기
    static int white; // 하얀색 개수
    static int blue; // 파란색 개수
    static int[][] paper; // 기본 종이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 한 변의 길이

        paper = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        dividePaper(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void dividePaper(int row, int col, int n) {
        if(colorCheck(row, col, n)) {
            if(paper[row][col] == 0) white++;
            else blue++;
            return; // 색이 같으면 더 나누지 않고 종료 !
        }

        int newSize = n/2;

        dividePaper(row, col, newSize); // 좌상단
        dividePaper(row, col + newSize, newSize); // 우상단
        dividePaper(row + newSize, col, newSize); // 좌하단
        dividePaper(row + newSize, col + newSize, newSize); // 우하단
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = paper[row][col];

        for (int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {
                if(paper[i][j] != color) return false;
            }
        }

        return true;
    }
}
