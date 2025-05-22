/*DP (Bottom-Up)- Tabulation
정수 X가 주어졌을 때, 아래 세 가지 연산을 이용해서 1을 만들려고 한다. 연산을 사용하는 최소 횟수를 구하시오.

🎯 사용할 수 있는 연산
X가 3으로 나누어 떨어지면 3으로 나눔

X가 2로 나누어 떨어지면 2로 나눔

1을 뺌

🧠 입력
자연수 X (1 ≤ X ≤ 1,000,000)

📤 출력
연산을 사용하는 최소 횟수*/
import java.util.Scanner;

public class Problem_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] dp = new int[x+1];
        dp[1] = 0;

        for (int i =2; i <= x; i++){
            //1을 빼는 경우
            dp[i] = dp[i-1]+1;
            //2로 나누는 경우
            if(i%2 == 0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if (i%3 == 0) {//3으로 나누는 경우
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }System.out.println(dp[x]);
    }
}