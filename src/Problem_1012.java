import java.util.Scanner;

public class Problem_1012 {
    static int[][] map; // 배추밭 정보를 저장할 2차원 배열 (0: 배추 x, 1: 배추 o)
    static boolean[][] check; // 방문했는지 체크
    static int cnt=0; //지렁이 개수 세기
    public static int dx[] = {0,0,1,-1}; //상하좌우 이동(x 방향)
    public static int dy[] = {1,-1,0,0}; // 상하좌우 이동(y 방향)
    static int m,n; //배추밭 가로, 세로

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트 수 입력
        for(int i = 0; i<t;i++){
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt(); // 배추 개수

            map = new int[m][n]; //배추밭 정보 배열
            check = new boolean[m][n]; //방문 여부 배열
            for(int j = 0; j<k;j++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = 1; //배추 위치 표시
            }
            // 군락 찾기
            for(int x = 0; x<m;x++){
                for(int y = 0; y<n;y++){
                    if(map[x][y] == 1 && !check[x][y]){
                        cnt++; //새 군락 발견 -> 지렁이 수 증가
                        dfs(x,y);
                    }
                }
            }
            System.out.println(cnt); //현재 케이스의 지렁이 수 출력
            cnt = 0; // 초기화
        }
    sc.close();
    }

    private static void dfs(int x, int y) {
        check[x][y] = true; // 현재 위치 방문 표시

        for(int i = 0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx <m && ny<n){
                if(map[nx][ny] == 1 && !check[nx][ny]){
                    dfs(nx,ny); //다음 배추로 재귀 탐색
                }
            }
        }
    }
}
