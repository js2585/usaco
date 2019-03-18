/*
ID: jatongs1
LANG: JAVA
TASK: numtri
 */

import java.util.*;
import java.io.*;
public class numtri {
    public static double start = System.nanoTime();

    public static int numRows;
    public static HashSet<Integer> sums = new HashSet<>();
    public static int[][] tree;
    public static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("numtri.in"));
        FileWriter out = new FileWriter("numtri.out");
        numRows = Integer.parseInt(inp.readLine());
        tree = new int[numRows][numRows];
        for (int i = 0; i < numRows; i ++){
            StringTokenizer st = new StringTokenizer(inp.readLine());
            int[] arr = new int[numRows];
            for (int a = 0; a < i + 1; a ++){
                arr[a] = Integer.parseInt(st.nextToken());
            }
            tree[i] = arr;
        }
//        recurse(0, 0, tree[0][0], 0);
        for (int i = numRows - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                tree[i - 1][j] += Math.max(tree[i][j], tree[i][j + 1]);
            }
        }
        int finalAnswer = tree[0][0];
        out.write(String.valueOf(finalAnswer) + '\n');
        double endTime = System.nanoTime();
        double time = (endTime - start) / 1000000000;
        System.out.println(time);
        out.close();
        inp.close();

    }

    public static void recurse(int row, int column, int value, int depth){
        String key = String.valueOf(row) + "," + String.valueOf(column);
        if (depth == numRows - 1){
            sums.add(value);
        }
        if (map.containsKey(key)){
            if (depth < numRows - 1 && value > map.get(key)){
                map.put(key, value);
                if (tree[row + 1][column] >= tree[row + 1][column + 1]){
                    recurse(row + 1, column, value + tree[row + 1][column], depth + 1);
                    recurse(row + 1, column + 1, value + tree[row + 1][column + 1], depth + 1);
                }
                else{
                    recurse(row + 1, column + 1, value + tree[row + 1][column + 1], depth + 1);
                    recurse(row + 1, column, value + tree[row + 1][column], depth + 1);
                }
            }
        } else if (depth < numRows - 1){
            map.put(key, value);
            if (tree[row + 1][column] >= tree[row + 1][column + 1]){
                recurse(row + 1, column, value + tree[row + 1][column], depth + 1);
                recurse(row + 1, column + 1, value + tree[row + 1][column + 1], depth + 1);
            }
            else{
                recurse(row + 1, column + 1, value + tree[row + 1][column + 1], depth + 1);
                recurse(row + 1, column, value + tree[row + 1][column], depth + 1);
            }
        }

    }

}
