import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class planting {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new FileReader("planting.in"));
        FileWriter out = new FileWriter("planting.out");
        N = Integer.parseInt(inp.readLine());
        int[][] connections = new int[N - 1][2];
        for (int i = 0; i < N - 1; i ++){
            StringTokenizer st = new StringTokenizer(inp.readLine());
            int[] connect = new int[2];
            connect[0] = Integer.parseInt(st.nextToken());
            connect[1] = Integer.parseInt(st.nextToken());
            connections[i] = connect;
        }
        int[][] types = new int[N][2];
        for (int i = 0; i < N; i ++){
            int[] test = {i, 1};
            types[i] = test;
        }
        check(types, connections);
        int finalAnswer = 1;
        for (int[] test: types){
            if (test[1] > finalAnswer){
                finalAnswer = test[1];
            }
        }

        out.write(String.valueOf(finalAnswer) + '\n');
        out.close();
        inp.close();

    }

    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }

    public static void check(int[][] types, int[][] connections){
        for (int[] field1: types){
            for (int[] field2: types){
                if (field1[0] < field2[0]){
                    if ((isAdjacent(field1[0], field2[0], connections) || isSkip(field1[0], field2[0], connections))
                            && field1[1] == field2[1]){
                        field2[1] += 1;
                    }
                }
            }
        }
    }

    public static boolean isAdjacent(int field1, int field2, int[][]connections){
        for (int[] connection: connections){
            if (contains(connection, field1) && contains(connection, field2)){
                return true;
            }
        }
        return false;
    }
    public static boolean isSkip(int field1, int field2, int[][]connections){
        ArrayList<Integer> possibleField1 = new ArrayList<>();
        ArrayList<Integer> possibleField2 = new ArrayList<>();
        for (int[] connection: connections){
            if (connection[0] == field1){
                possibleField1.add(connection[1]);
            }
            if (connection[1] == field1){
                possibleField1.add(connection[0]);
            }
            if (connection[0] == field2){
                possibleField2.add(connection[1]);
            }
            if (connection[1] == field2){
                possibleField2.add(connection[0]);
            }
        }
        for (int a: possibleField1){
            if (possibleField2.contains(a)){
                return true;
            }
        }

        return false;
    }



}
