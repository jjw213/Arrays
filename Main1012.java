import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1012 {
    static int c=0;
    static int n = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        br.read();
        for(int i=0;i<n;i++){
            int M,N,K;
            st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            //입력받은 M,N 값으로 2차원 char 배열 생성
            char[][] board=new char[M][N];

            //배열 값 'n' 으로 초기화
            for(int x=0;x<board.length;x++)
                Arrays.fill( board[x], 'n' );

            //총 배추 개수만큼 배추 하나하나의 좌표 입력받기
            for(int num=0;num<K;num++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                board[x][y]='c';
            }

            //입력 받은 좌표 토대로 dfs
            for(int j=0;j<M;j++){
                for (int k=0;k<N;k++){
                    if(board[j][k]=='c')
                    {
                        dfs(board,j,k);
                        c++;
                    }
                }
            }
            System.out.println(c);
            c=0;
        }
    }

    public static void dfs(char[][] board, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[row].length) {
            return;
        }
        if (board[row][col] == 'n' || board[row][col] == 'N') {
            return;
        }
        board[row][col] = 'N';
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
//        return c++;
    }
}
