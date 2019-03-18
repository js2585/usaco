import java.util.*;
import java.io.*;

public class herding {

    public static int N;
    public static int minMoves = 0;
    public static int maxMoves = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("herding.in"));
        FileWriter out = new FileWriter("herding.out");
        N = Integer.parseInt(inp.readLine());
        int[] initialOrder = new int[N];
        for (int i = 0; i < N; i ++){
            initialOrder[i] = Integer.parseInt(inp.readLine());
        }
        Arrays.sort(initialOrder);
        getMin(initialOrder);
        System.out.println(getMin(initialOrder));
    }

    public static boolean consecutive(int[] order){
        boolean con = true;
        for (int i = 0; i < order.length - 2; i ++){
            if (order[i] + 1 != order[i + 1]){
                con = false;
            }
        }
        return con;
    }

    public static boolean contains(int[] arr, int value){
        boolean con = false;
        for (int a: arr){
            if (a == value){
                con = true;
                break;
            }
        }
        return con;
    }

    public static int getMax(int[] order){
        int minNum = N - 1;
        return 0;
    }

    public static int x;
    public static int y;
    public static int getMin(int[] order){
        int maxNum = 0;
        for (int i = 0; i < order.length; i ++){
            for (int a = 0; a < order.length; a ++){
                if (order[a] - order[i] <= order.length - 1){
                    if (a - i >= maxNum){
                        x = i;
                        y = a;
                    }
                }
            }
        }
        if (N - (x -y + 1) != 1){
            return N - (y - x + 1);
        } else {
            return 2;
        }

//        double length = order.length;
//        int mid = order[(int)Math.ceil(length / 2) - 1];
//        int distanceBottom = order[mid] - order[0] + 1 - mid;
//        int distanceTop = order[order.length - 1] - mid + 1 - (int)Math.floor(length / 2) - 1;
//        int[] spotsOpen = new int[distanceBottom];
//        int count = 0;
//        for (int i = order[mid] -1; i > order[0]; i --){
//            if (!contains(order, i)){
//                spotsOpen[count] = i;
//                count += 1;
//            }
//        }

    }

}
