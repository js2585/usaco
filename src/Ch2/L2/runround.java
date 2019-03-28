/*
ID: jatongs1
LANG: JAVA
TASK: runround
 */
import java.util.*;
import java.io.*;

public class runround {
    public static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("runround.in"));
        FileWriter out = new FileWriter("runround.out");
        M = Integer.parseInt(inp.readLine());
        int fin = 0;
        for (int i = M + 1; i < 999999999; i ++){
            if (checkRun(i)){
                fin = i;
                break;
            }
        }
        out.write(String.valueOf(fin) + '\n');
        out.close();
        inp.close();
    }

    public static boolean checkRun(int num){
        String numStr = Integer.toString(num);
        int numLen = numStr.length();
        boolean isRun = true;
        int[] digits = new int[numLen];
        int max = -1;
        for (int i = 0; i < numLen; i ++){
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        for (int a: digits){
            if (a == 0){
                return false;
            }
            if (a > max){
                max = a;
            }
        }
        boolean[] traveled = new boolean[max + 1];
        int position = 0;
        for (int i = 0; i < numLen; i ++){
            int digit = digits[position];
            position = (position + digit) % numLen;
            if (!traveled[digits[position]]){
                traveled[digits[position]] = true;
            } else {
                isRun = false;
                break;
            }
        }
        return isRun;
    }

}
