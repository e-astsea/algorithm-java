    import java.io.*;
    import java.util.*;

    class pair{
        int x;
        int y;
        int time;
        pair(int x, int y,int time){
            this.x =x;
            this.y = y;
            this.time =time;
        }
    }
    public class Main {
        static int[][]arr;
        static int[] dx = {-1,1,0,0};
        static int[] dy ={0,0,-1,1};
        static int[][]checked;
        static ArrayList<Integer> al;
        static Queue<pair> q = new LinkedList<>();
        static int N;
        static int K;
        static int S;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N+1][N+1];

            for(int i=1; i<=N; i++){
                str = br.readLine();
                st = new StringTokenizer(str);
                for(int j=1; j<=N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            str = br.readLine();
            st = new StringTokenizer(str);
            S = Integer.parseInt(st.nextToken());
            int finalx = Integer.parseInt(st.nextToken());
            int finaly = Integer.parseInt(st.nextToken());

            checked = new int[N+1][N+1];
            al = new ArrayList<>();
            bfs(finalx,finaly,0);

            Collections.sort(al);
            System.out.println(al.get(0));
        }
        static int ttmp=0;
        static void bfs(int x, int y,int time){

            checked[x][y]=1;
            q.add(new pair(x,y,time));
            int flag=0;

            while(!q.isEmpty()){
                pair tmp = q.remove();

                if(tmp.time!=0 && ttmp!=tmp.time)
                    if(!al.isEmpty()){
                        break;
                    }

                    ttmp = tmp.time;


                if(arr[tmp.x][tmp.y]!=0){
                    al.add(arr[tmp.x][tmp.y]);
                    break;
                }
                if(tmp.time ==S){
                    if(al.size()==0){
                        al.add(0);
                    }
                    break;
                }

                for(int i=0; i<4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx>0 && ny>0 && nx<=N&&ny<=N){
                        if(checked[nx][ny]!=1){
                            if(arr[nx][ny]!=0){
                                al.add(arr[nx][ny]);
                                flag=1;
                            }
                            else{
                                q.add(new pair(nx,ny,tmp.time+1));
                            }
                        }
                    }
                }

            }
        }
    }