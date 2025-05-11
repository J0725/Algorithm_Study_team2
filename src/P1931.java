import java.util.Arrays;
import java.util.Scanner;

public class P1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] time = new int[N][2];

        for(int i = 0; i < N; i++){
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, (o1, o2) -> { //람다식
            if(o1[1] == o2[1]){
                return o1[0] - o2[0]; //종료시간이 같을 경우, 시작 시간이 빠른순으로 정렬
            }
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int end = 0;

        for(int i = 0; i < N; i++){
            if(end <= time[i][0]){ //한 회의의 시작 시간이 종료 시간보다 같거나 늦는 경우
                end = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
