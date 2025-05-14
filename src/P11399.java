import java.util.Arrays;
import java.util.Scanner;

public class P11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); //누적 대기시간 최소화 위해 오름차순 정렬

        int prevSum = 0;
        int minSum = 0;

        for(int i = 0; i < N; i++){
            minSum += prevSum + arr[i];
            prevSum += arr[i];
        }

        System.out.println(minSum);




    }
}
