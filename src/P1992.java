import java.util.Scanner;

public class P1992 {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        video = new int[N][N];

        for(int i = 0; i < N; i++){
            String line = sc.next();
            for(int j = 0; j < N; j++){
                video[i][j] = line.charAt(j) - '0'; //문자열을 정수로 변환
            }
        }

        divide(0, 0, N);

        System.out.println(sb.toString());
    }

    public static void divide(int row, int col, int size){
        if (checkSame(row, col, size)) {
            sb.append(video[row][col]); // 모두 같은 숫자면 해당 숫자 출력
            return;
        }

        // 다르면 괄호 열고 4분할
        sb.append('(');
        int newSize = size / 2;

        divide(row, col, newSize);                         // 왼쪽 위
        divide(row, col + newSize, newSize);               // 오른쪽 위
        divide(row + newSize, col, newSize);               // 왼쪽 아래
        divide(row + newSize, col + newSize, newSize);     // 오른쪽 아래

        sb.append(')');
    }

    public static boolean checkSame(int row, int col, int size){
        int value = video[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (video[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
