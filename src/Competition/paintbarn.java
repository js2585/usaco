import java.util.*;
import java.io.*;
public class paintbarn {

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new FileReader("paintbarn.in"));
        FileWriter out = new FileWriter("paintbarn.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] points = new int[N][4];
        for (int i = 0; i < N; i ++){
            StringTokenizer st2 = new StringTokenizer(inp.readLine());
            for (int a = 0; a < 4; a ++){
                points[i][a] = Integer.parseInt(st2.nextToken());
            }
        }
        System.out.println(Arrays.deepToString(points));
        int left = 1001;
        int down = 1001;
        int right = -1001;
        int up = -1001;
        int finalAnswer = 0;
        for (int[] coord: points){
            if (coord[0] < left){
                left = coord[0];
            }
            if (coord[1] < down){
                down = coord[1];
            }
            if (coord[2] > right){
                right = coord[3];
            }
            if (coord[3] > up){
                up = coord[3];
            }
        }

        for (int x = left; x <= right; x ++){
            for (int y = down; y <= up; y ++){
                int numRec = 0;
                int numCoordPassed = 0;
                for (int[] coord: points){
                    if (x >= coord[0] && x < coord[2] && y >= coord[1] && y < coord[3]){
                        numRec += 1;
                    }
                    if (N - numCoordPassed + numRec < K){
                        break;
                    }
                    if (numRec > K){
                        break;
                    }
                    numCoordPassed += 1;
                }
                if (numRec == K){
                    System.out.println(String.valueOf(x) + ", " + String.valueOf(y));
                    finalAnswer += 1;
                }
            }
        }
        System.out.println(finalAnswer);
        out.write(String.valueOf(finalAnswer) + '\n');
        out.close();
        inp.close();
    }
    public static boolean contains(ArrayList<String>arr, String value){
        boolean con = false;
        for (String a: arr){
            if (a.equals(value)){
                con = true;
                break;
            }
        }
        return con;
    }
}
