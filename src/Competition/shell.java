import java.util.*;
import java.io.*;

public class shell {

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("shell.in"));
        FileWriter out = new FileWriter("shell.out");
        int numSwaps = Integer.parseInt(inp.readLine());
        int[][] swapGuess = new int[numSwaps][3];
        for (int i = 0; i < numSwaps; i ++){
            int[] swap = new int[3];
            StringTokenizer st = new StringTokenizer(inp.readLine());
            for (int a = 0; a < 3; a ++){
                swap[a] = Integer.parseInt(st.nextToken());
            }
            swapGuess[i] = swap;
        }
        int[] possibleCorrect = new int[3];
        int[] shells = {1,2,3};
        int numCorrect = 0;
        int[][] swapped = new int[numSwaps][3];
        int counter = 0;
        for (int[] combo: swapGuess) {
            int placeholder = shells[combo[0] - 1];
            shells[combo[0] - 1] = shells[combo[1] - 1];
            shells[combo[1] - 1] = placeholder;
            int[] phase = new int[3];
            phase[0] = shells[0];
            phase[1] = shells[1];
            phase[2] = shells[2];
            swapped[counter] = phase;
            counter += 1;
        }
        for (int i = 1; i <= 3; i ++){
            for (int a = 0; a < numSwaps; a ++){
                if (swapped[a][swapGuess[a][2] - 1] == i){
                    numCorrect += 1;
                }
            }
            possibleCorrect[i - 1] = numCorrect;
            numCorrect = 0;
        }
        Arrays.sort(possibleCorrect);
        int finalAnswer = possibleCorrect[2];
        out.write(String.valueOf(finalAnswer) + '\n');
        out.close();
        inp.close();

    }

}
