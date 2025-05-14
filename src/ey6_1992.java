import java.util.Scanner;

public class ey6_1992 {
    static int[][] image;
    public static StringBuilder result = new StringBuilder();
    // StringBuilder: Java에서 문자열을 반복해서 추가하거나 수정할 때 String보다 훨씬 빠르게 처리할 수 있는 클래스
    // 문자열을 메모리상에서 계속 이어붙이기 위해 사용
    // StringBuilder sb = new StringBuilder();
    // sb.append("a");
    // sb.append("b");
    // System.out.println(sb); // ab

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        image = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String line = scanner.next(); //문자열로 받음

            for (int j = 0; j < N; j++) {
                image[i][j] = line.charAt(j) - '0'; // 문자 -> 숫자
                // line.charAt(j)는 문자열의 j번째 문자를 가져오는 것
                // '0'을 빼는 이유: 문자 '0'은 ASCII 값으로 48. 문자를 숫자로 바꾸는 방법.
                // 이 과정을 통해 입력으로 받은 문자열 "01011"을 → [0,1,0,1,1] 숫자 배열로 변환
            }
        }

        // 분할 정복 시작
        QuadTree(0, 0, N);

        // 결과 출력
        System.out.println(result);
    }

    // 분할 함수
    static void QuadTree(int x, int y, int size) {
        if(isPossible(x, y, size)) { // 현재 영역이 모두 같은 값이라면
            result.append(image[x][y]); // 더 분할할 필요 없이 숫자만 추가하고
            return; // 함수 종료
        }

        // 섞여있다면
        result.append("("); // 각 레벨(depth)에서 여는괄호로 시작해야한다.
        
        // 다른 색이라면
        int newSize = size / 2;	// 절반 사이즈로 사이즈 줄이고
        // 재귀 호출
        QuadTree(x, y, newSize);						    // 왼쪽 위
        QuadTree(x, y + newSize, newSize);				// 오른쪽 위
        QuadTree(x + newSize, y, newSize);				// 왼쪽 아래
        QuadTree(x + newSize, y + newSize, newSize);	// 오른쪽 아래

        result.append(")"); // 해당 레벨이 끝나면 닫는괄호도 닫아준다.
    }

    // 같은 값인지 확인
    static boolean isPossible(int x, int y, int size) {
        int value = image[x][y]; // 첫번째 원소 기준으로 검사
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (image[i][j] != value) {
                    return false;
                }// 첫번째 칸의 값과 다르면 false
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }
}

