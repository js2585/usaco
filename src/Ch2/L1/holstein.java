/*
ID: jatongs1
LANG: JAVA
TASK: holstein
 */
import java.util.*;
import java.io.*;
public class holstein {
    public static int V;
    public static int G;
    public static int[] vitaLimit;
    public static int[][] feeds;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("holstein.in"));
        FileWriter out = new FileWriter("holstein.out");
        V = Integer.parseInt(inp.readLine());
        vitaLimit = new int[V];
        StringTokenizer st = new StringTokenizer(inp.readLine());
        for (int i = 0; i < V; i ++){
            vitaLimit[i] = Integer.parseInt(st.nextToken());
        }
        G = Integer.parseInt(inp.readLine());
        feeds = new int[G][V];
        for (int i = 0; i < G; i ++){
            StringTokenizer st2 = new StringTokenizer(inp.readLine());
            for (int a = 0; a < V; a ++){
                feeds[i][a] = Integer.parseInt(st2.nextToken());
            }
        }

        ArrayList<int[]> orders = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 1; i <= G; i ++){
            recurse(current, 0, i, -1, orders);
        }
        
        int minFeed = G;
        String fin = "";
        for (int[] order: orders){
            int[] fill = new int[V];
            for (int i = 0; i < order.length; i ++){
                for (int a = 0; a < V; a ++){
                    fill[a] += feeds[order[i]][a];
                }
            }
            if (allValuesGreater(fill, vitaLimit)){
                minFeed = order.length;
                fin = String.valueOf(minFeed);
                for (int i = 0; i < order.length; i ++){
                    fin += " " + String.valueOf(order[i] + 1);
                }
                break;
            }
        }
        out.write(fin + '\n');
        System.out.println(fin);
        out.close();
        inp.close();
    }

    public static boolean allValuesGreater(int[] arr, int[] target){
        boolean ret = true;
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] < target[i]){
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static void recurse(ArrayList<Integer> current, int depth, int length, int previous, ArrayList<int[]> orders){
        if (depth == length){
            int[] order = new int[length];
            for (int i = 0; i < current.size(); i ++){
                order[i] = current.get(i);
            }
            orders.add(order);
        } else {
            for (int i = previous + 1; i <= G - length + depth; i ++){
                current.add(i);
                recurse(current, depth + 1, length, i, orders);
                current.remove(new Integer(i));
            }
        }
    }

}
