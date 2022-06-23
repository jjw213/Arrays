import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int n = 10;

    public static void main(String[] args) {
        int[][] map = new int[n][n];

        //맨 처음 어디서부터 탐색을 시작할 건지 먼저 큐에다 저장
        //map의 좌표정보(다음에 탐색할 좌표)를 큐에다 저장
        //몇행인지? r / 몇번 째 열인지 c
        //1. 클래스를 만들어서 좌표를 나타내는 새로운 타입을 생성
        //2. int[] 배열을 만들어서 배열의 0번 째 원소를 r이라고 생각,
        Queue<Point> queue = new LinkedList<>();
        Queue<int[]> queue1 = new LinkedList<>();

        //1번 방법올 어디서 부터 탐색할건지 큐에다 시작점 저장
        queue.add(new Point(0, 0));
        map[0][0]=1;
        queue1.add(new int[]{0, 0});

//        Point p=queue.poll();
        boolean[][] visited = new boolean[n][n];
        //visited[r][c]==true?? 방문한 적이 있는 위치
        //방문했던 위치라면 더 탐색 안 해도 됨
        visited[0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        //너비 우선 탐색 실시
        //큐에 다음에 갈 곳 저장
        //내가 간 곳이 있으면 visited 배열에 true로 세팅
        //계속 탐색을 하다보면 visited가 모두 true가 됨
        //큐에 아무것도 안 남게 될 때 탐색 끝

        //시간의 흐름에 따라 어떻게 지도가 변하는지 확인 하기 위해
        int time=0;

        while (!queue.isEmpty()) {
            int size=queue.size();
            time++;
            for (int k=0;k<size;k++) {
                //다음에 방문할 위치정보를 하나 꺼내옴
//            Point cur = new Point(0,0);
                Point cur = queue.poll();
                //위치정보의 상하좌우를 탐색해서 큐에 저장
                //내가 방문한 적이 있으면 큐에 저장 하지 않음
                //상하좌우 탐색할 때 지도의 범위를 벗어나지 않았는 지도 검사
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                        //다음에 올 수 있는 위치
                        visited[nr][nc] = true;
                        map[nr][nc] = 1;
                        queue.add(new Point(nr, nc));

                    }
                }// end
            }
            System.out.println("--------time"+time+"-----------");
            //map의 정보 출력
            for (int i=0;i<n;i++){
                System.out.println(Arrays.toString(map[i]));
            }
        }
    }
}
