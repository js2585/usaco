import java.util.*;
import java.io.*;

public class sleepy {

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new FileReader("sleepy.in"));
        FileWriter out = new FileWriter("sleepy.out");
        int numCows = Integer.parseInt(inp.readLine());
        int[] initialOrder = new int[numCows];
        StringTokenizer st = new StringTokenizer(inp.readLine());
        for (int i = 0; i < numCows; i ++){
            initialOrder[i] = Integer.parseInt(st.nextToken());
        }
        int numSteps = 0;
        int[] sorted = new int[numCows];
        for (int i = 0; i < numCows; i ++){
            sorted[i] = initialOrder[i];
        }
        Arrays.sort(sorted);
        while (!Arrays.equals(initialOrder, sorted)){
            //create array of values form backwards
            int numItems = 1;
            for (int index = numCows - 1; index >= 1; index --){
                if (initialOrder[index] > initialOrder[index - 1]){
                    numItems += 1;
                } else {
                    break;
                }
            }
            int[] back = new int[numItems + 1];
            for (int i = 0; i < numItems; i ++){
                back[i] = initialOrder[numCows - i - 1];
            }
            back[numItems] = initialOrder[0];
            Arrays.sort(back);
            int[] tempArr = new int[numCows];
            for (int i = 0; i < numCows - numItems - 1; i ++){
                tempArr[i] = initialOrder[i + 1];
            }
            for (int i = 0; i < numItems + 1; i ++){
                tempArr[numCows - numItems - 1 + i] = back[i];
            }
            for (int i = 0; i < numCows; i ++){
                initialOrder[i] = tempArr[i];
            }
            numSteps += 1;
        }
        out.write(String.valueOf(numSteps) + '\n');
        out.close();
        inp.close();
    }

}
