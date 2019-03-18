/*
ID: jatongs1
LANG: JAVA
TASK: sort3
 */
import java.util.*;
import java.io.*;

public class sort3 {
    public static int N;
    public static int[] sorted;
    public static int[] original;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("sort3.in"));
        FileWriter out = new FileWriter("sort3.out");
        N = Integer.parseInt(inp.readLine());
        int numOne = 0;
        int numTwo = 0;
        int numThr = 0;
        sorted = new int[N];
        original = new int[N];
        for (int i = 0; i < N; i ++){
            int a = Integer.parseInt(inp.readLine());
            if (a == 1){
                numOne += 1;
            } else if (a == 2){
                numTwo += 1;
            } else {
                numThr += 1;
            }
            sorted[i] = a;
            original[i] = a;
        }
        int numMoves = 0;
        Arrays.sort(sorted);
        for (int i = 0; i < numOne; i ++){
            if (original[i] == 2){
                for (int a = numOne; a < numOne + numTwo; a ++){
                    if (original[a] == 1){
                        original[i] = 1;
                        original[a] = 2;
                        numMoves += 1;
                        break;
                    }
                }
            } if (original[i] == 3){
                for (int a = numOne + numTwo; a < numOne + numTwo + numThr; a ++){
                    if (original[a] == 1){
                        original[i] = 1;
                        original[a] = 3;
                        numMoves += 1;
                        break;
                    }
                }
            }
        }
        for (int i = numOne; i < numOne + numTwo; i ++){
            if (original[i] == 3){
                for (int a = numOne + numTwo; a < numOne + numTwo + numThr; a ++){
                    if (original[a] == 2){
                        original[a] = 3;
                        original[i] = 2;
                        numMoves += 1;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < numOne; i ++){
            if (original[i] != 1){
                numMoves += 2;
            }
        }
        System.out.println(numMoves);
        out.write(String.valueOf(numMoves) + '\n');
        out.close();
        inp.close();

    }

}
