import java.util.*;

public class ey5_1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 회의 수
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            time[i][0] = scanner.nextInt(); // 시작 시간
            time[i][1] = scanner.nextInt(); // 끝나는 시간
            // time[][0] 은 시작시점을 의미
            //time[][1] 은 종료시점을 의미
        }

        Arrays.sort(time, new Comparator<int[]>() {
            // 배열을 정렬, 두 번째 인자로 정렬 기준을 정의한 Comparator를 넣을 수 있다
            // 익명 클래스 선언
            @Override // 부모 클래스나 인터페이스에서 상속받은 메서드를 재정의했다는 표시
            public int compare(int[] a, int[] b) { // compare() 함수를 사용해서 두 원소 a와 b를 비교
                if (a[1] != b[1]) {                // 끝나는 시간이 다르면
                    return a[1] - b[1];            // 끝나는 시간 기준 정렬
                } else {                           // 끝나는 시간이 같으면
                    return a[0] - b[0];            // 시작 시간 기준 정렬
                }
            }
        });

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if (time[i][0] >= endTime) {
                endTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
