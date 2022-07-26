    import java.io.*;
    import java.util.*;

    class pair{
        int x;
        String str;
        pair(int x, String str){
            this.x = x;
            this.str = str;
        }
    }
    public class Main {
        static Queue<pair> q;
        static int[]checked;
        static int B =0;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int T = Integer.parseInt(st.nextToken());

            for(int i=0; i<T; i++) {

                q=new LinkedList<>();
                str = br.readLine();
                st = new StringTokenizer(str);
                int A = Integer.parseInt(st.nextToken());
                B =Integer.parseInt(st.nextToken());
                bfs(A);

            }
        }

        static void bfs(int x){
            checked =new int[100001];
            q.add(new pair(x,""));

            while(!q.isEmpty()) {

                pair tmp = q.remove();
                int k=0;
                if(tmp.x == B){
                    System.out.println(tmp.str);
                    return;
                }

                if (checked[tmp.x] != 1) {
                for (int i = 0; i < 4; i++) {
                    String ST = tmp.str;

                        switch (i) {
                            case 0: {
                                k = D(tmp.x);
                                ST = ST.concat("D");
                                break;
                            }
                            case 1: {
                                k = S(tmp.x);
                                ST = ST.concat("S");
                                break;
                            }
                            case 2: {
                                k = L(tmp.x);
                                ST = ST.concat("L");
                                break;
                            }
                            case 3: {
                                k = R(tmp.x);
                                ST = ST.concat("R");
                                break;
                            }
                        }
                        q.add(new pair(k, ST));
                        checked[tmp.x]=1;
                    }


                }
            }


        }
        static int D(int x){
            int result = 2*x;
            if(result>9999){
                result%=10000;
            }
            return result;
        }
        static int S(int x){
            int result = x-1;
            if(result+1==0){
                result=9999;
            }
            return result;
        }
        static int L(int x){
            int first = x/1000;
            int result = (x-first*1000)*10+first;
            return result;
        }
        static int R(int x){
            int first = x/10;
            int last = x-first*10;
            int result = first+last*1000;
            return result;
        }
    }