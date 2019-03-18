/*
ID: jatongs1
LANG: JAVA
TASK: barn1
 */
import java.util.*;
import java.io.*;

public class barn1 {

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("barn1.in"));
        FileWriter out = new FileWriter("barn1.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        int numBoards = Integer.parseInt(st.nextToken());
        int totalStalls = Integer.parseInt(st.nextToken());
        int numCows = Integer.parseInt(st.nextToken());
        int[] stallNumbers = new int[numCows];
        int[] differences = new int[numBoards - 1];
        for (int i = 0; i < numCows; i ++){
            StringTokenizer st2 = new StringTokenizer(inp.readLine());
            stallNumbers[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(stallNumbers);
        for (int i = 1; i < numCows; i ++){
            Arrays.sort(differences);
            for (int a = 0; a < differences.length; a ++){
                if (stallNumbers[i] - stallNumbers[i-1] - 1 > differences[a]){
                    differences[a] = stallNumbers[i] - stallNumbers[i-1] - 1;
                    System.out.println(Arrays.toString(differences));
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(differences));
        int finalLength = stallNumbers[numCows - 1] - stallNumbers[0] + 1;
        for (int difference: differences){
            finalLength -= difference;
        }
        System.out.println(finalLength);
        inp.close();
        out.write(String.valueOf(finalLength) + "\n");
        out.close();
    }

}
