import java.util.Scanner;

public class ey4_2231 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int result = 0; //생성자가 없으면 기본값 0 출력됨

        // 1부터 N-1까지 모든 수를 생성자 후보로 시도
        for(int i = 1; i < N; i++) {
            int number = i;
            int sum = 0;	// 각 자릿수 합 변수

            while(number != 0) {
                sum += number % 10;	// 1. 가장 오른쪽 자릿수를 더함
                number /= 10;       // 2. 오른쪽 자릿수를 제거함 (10으로 나눠서 한 자리 줄임)
            }

            // i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
            if(sum + i == N) {
                result = i;
                break;
            }

        }

        System.out.println(result);
    }
}
