import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge {
    static int n = 0;
    static int length = 0;
    static int up_length = 1;
    static int down_length = 1;
    static int left_length = 1;
    static int right_length = 1;

    public static void main(String[] args) throws IOException {
        /*
            어떤 섬나라 대통령
            공약으로 섬끼리 연결할 수 있는 다리를 지어주겠다함
            과장을 하기 위해 제일 긴 다리를 지어주려고 함
            N * N 크기 지형 정보가 2차원 배열로
            1 이 섬, 0 이 바다
            이 지형정보가 주어졌을 때 지을 수 있는 다리의 최대 길이
            다리는 상하좌우로만

            첫 번 째 줄에는 지도의 크기 N
            두 번 째 줄 부터는 지도의 지형 정보
            8
            1 0 1 0 0 0 1 1
            1 1 1 1 0 1 0 0
            0 1 0 0 1 0 0 0
            0 1 0 0 0 0 0 1
            1 0 0 1 1 1 0 1
            0 1 1 0 0 0 1 0
            0 0 0 1 1 0 0 1
            1 1 1 0 0 1 1 1

            출력 6
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
        }
        int best = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    best = Math.max(best, dfs(arr, i, j));
                    up_length = 1;
                    down_length = 1;
                    left_length = 1;
                    right_length = 1;
                }
            }
        }
        System.out.println(best);
    }

    public static int dfs(int[][] arr, int row, int col) {
        int up = dfs1(arr, row - 1, col);
        int down = dfs2(arr, row + 1, col);
        int left = dfs3(arr, row, col - 1);
        int right = dfs4(arr, row, col + 1);
        return Math.max(Math.max(Math.max(up, down), left), right);
    }

    public static int dfs1(int[][] arr, int row, int col) {
        if (row < 0 || row == arr.length || col < 0 || col == arr[row].length) {
            return 0;
        }
        if (arr[row][col] == 1) {
            return 0;
        }
        dfs1(arr, row - 1, col);
        return ++up_length;
    }

    public static int dfs2(int[][] arr, int row, int col) {
        if (row < 0 || row == arr.length || col < 0 || col == arr[row].length) {
            return 0;
        }
        if (arr[row][col] == 1) {
            return 0;
        }
        dfs2(arr, row + 1, col);
        return ++down_length;
    }

    public static int dfs3(int[][] arr, int row, int col) {
        if (row < 0 || row == arr.length || col < 0 || col == arr[row].length) {
            return 0;
        }
        if (arr[row][col] == 1) {
            return 0;
        }
        dfs3(arr, row, col - 1);
        return ++left_length;
    }

    public static int dfs4(int[][] arr, int row, int col) {
        if (row < 0 || row == arr.length || col < 0 || col == arr[row].length) {
            return 0;
        }
        if (arr[row][col] == 1) {
            return 0;
        }
        dfs4(arr, row, col + 1);
        return ++right_length;
    }

}
