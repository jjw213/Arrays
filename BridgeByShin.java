import java.util.Scanner;

public class BridgeByShin {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[][] map=new int[n][n];
        for (int r=0;r<n;r++){
            for (int c=0;c<n;c++){
                map[r][c]=sc.nextInt();
            }
        }
        //최대로 지을 수 있는 다리의 길이
        int maxDistance =0;

        //2차원 배열 전체를 순회
        //먼저 지금 내위치가 1인지 아닌지(섬인지 바다인지)
        //1이면 다리 짓기 시작
        for (int r=0;r<n;r++) {
            for (int c = 0; c < n; c++) {
                if(map[r][c]==1){
                    //지금 내 위치가 바다가 아닌 섬이면 다리 짓기 시작
                    //상하좌우로 탐색 이어나가기
                    //위쪽으로 섬이 다시 나올 때까지 뻗어나가기
                    for(int d=1;r-d>0;d++){
                        if(map[r-d][c]==1){
                            maxDistance=Math.max(maxDistance,d);
                            break;
                        }
                    }
                    //왼쪽
                    for(int d=1;c-d>0;d++){
                        if(map[r][c-d]==1){
                            maxDistance=Math.max(maxDistance,d);
                            break;
                        }
                    }
                }
            }
        }
    }
}
