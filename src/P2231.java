
import java.util.Scanner;

public class P2231 {
    public P2231() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for(int i = 0; i < n; ++i) {
            int sum = 0;

            for(int number = i; number != 0; number /= 10) {
                sum += number % 10;
            }

            if (sum + i == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
