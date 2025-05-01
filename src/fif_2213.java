import java.io.IOException;
import java.util.Scanner;

public class fif_2213 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;

        int k = n - Integer.toString(n).length() * 9;

        for(int i = k; i < n; i++) {
            int number = i;
            int sum = 0;	// 각 자릿수 합

            while(number != 0) {
                sum += number % 10;	// 각 자릿수 더하기
                number /= 10;       // 마지막 자릿수 제거
            }

            if(sum + i == n) {
                result = i;
                break;
            }

        }

        System.out.println(result);
    }
}
