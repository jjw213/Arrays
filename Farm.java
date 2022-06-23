import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Farm {
    public static void main(String[] args) throws IOException {
        /*
            은퇴하고 귀농
            사과나무를 심으려고 함
            배열로 N*N 크기의 땅의 정보가 주어짐
            각 따엥는 사과나무가 흡수할 수 있는 영양분이 얼마나 되는지 정수로 나타냄
            최대한 많은 영양분을 흡수할 수 있는 땅에 사과나무를 심고싶다.
            사과나무가 얻을수 있는 영양분은 나무를 심은 위치+상하좌우에 있는 땅
            땅의 영양분 정보가 N*N 2차원 배열로 주어질 때
            사과 나무가 최대로 얻을 수 있는 영양분이 얼마인지 출력

            첫 줄 입력 N => 땅의 크기
            2번 째 줄에는 땅의 영양분 정보

            입력 예
            5
            1   1   1   1   1
            1   1   1   2   2
            1   1   1   2   1
            1   9   1   1   1
            1   1   1   1   1

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        br.read();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            br.read();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result < square(arr, i, j))
                {
                    result = square(arr, i, j);
                }
            }
        }
        System.out.println(result);
    }

    static int n = 0;

    public static int square(int[][] arr, int x, int y) {
        int sum=0;
        if (x == 0) {
            if (y == 0)
            {
                sum = arr[x][y] + arr[x + 1][y] + arr[x][y + 1];
            }
            else if (y+1 == arr[x].length)
                sum = arr[x][y] + arr[x + 1][y] + arr[x][y - 1];
            else
            {
                sum = arr[x][y] + arr[x + 1][y] + arr[x][y - 1] + arr[x][y + 1];
            }
        } else if (x+1 == arr.length) {
            if (y == 0)
                sum = arr[x][y] + arr[x - 1][y] + arr[x][y + 1];
            else if (y+1 == arr[x].length)
                sum = arr[x][y] + arr[x - 1][y] + arr[x][y - 1];
            else
                sum = arr[x][y] + arr[x - 1][y] + arr[x][y - 1] + arr[x][y + 1];
        } else if(y == 0){
            sum = arr[x][y] + arr[x - 1][y] +arr[x + 1][y] + arr[x][y + 1];
        } else if (y+1 == arr[x].length){
            sum = arr[x][y] + arr[x - 1][y] +arr[x + 1][y] + arr[x][y - 1];
        }
        else

            // 값 더해주기
            sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1] + arr[x][y + 1];

        return sum;
    }
}
