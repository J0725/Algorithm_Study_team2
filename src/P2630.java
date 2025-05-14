import java.util.Scanner;

public class P2630 {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        paper = new int[N][N];

        for(int i = 0; i < N; i++){ //입력값
            for(int j = 0; j < N; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int row, int col, int size){
        if(checkColor(row, col, size)){
            if(paper[row][col] == 0){
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        //분할
        int newSize = size / 2;
        divide(row, col, newSize);
        divide(row, col+newSize, newSize);
        divide(row+newSize, col, newSize);
        divide(row+newSize, col+newSize, newSize);
    }



    public static boolean checkColor(int row, int col, int size){
        int color = paper[row][col];

        for(int i = row; i <  row + size; i++){
            for(int j = col; j < col + size; j++){
                if(paper[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
