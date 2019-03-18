/*
ID: jatongs1
LANG: JAVA
TASK: milk3
 */


import java.util.*;
import java.io.*;
public class milk3 {

    public static int A;
    public static int B;
    public static int C;
    public static TreeSet<Integer> set;

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("milk3.in"));
        FileWriter out = new FileWriter("milk3.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        set = new TreeSet<>();
        pour(0,0, C,0);
        String finalAnswer = "";
        for (int num: set){
            finalAnswer = finalAnswer + String.valueOf(num) + " ";
        }
        finalAnswer = finalAnswer.substring(0, finalAnswer.length() - 1);
        finalAnswer += '\n';
        System.out.println(finalAnswer);
        out.write(finalAnswer);
        out.close();
        inp.close();

    }

    public static void pour(int currentA, int currentB, int currentC, int depth){
        if (currentA == 0){
            set.add(currentC);
        }
        if (depth <= 13) {
            if (currentA != 0) {
                if (currentB != B) {
                    pour(Math.max(0, currentA - (B - currentB)), Math.min(currentB + currentA, B), currentC, depth + 1);
                }
                if (currentC != C) {
                    pour(Math.max(0, currentA - (C - currentC)), currentB, Math.min(currentC + currentA, C), depth + 1);
                }
            }
            if (currentB != 0) {
                if (currentA != A) {
                    pour(Math.min(currentB + currentA, A), Math.max(0, currentB - (A - currentA)), currentC, depth + 1);
                }
                if (currentC != C) {
                    pour(currentA, Math.max(0, currentB - (C - currentC)), Math.min(currentC + currentB, C), depth + 1);
                }
            }
            if (currentC != 0) {
                if (currentB != B) {
                    pour(currentA, Math.min(currentB + currentC, B), Math.max(0, currentC - (B - currentB)), depth + 1);
                }
                if (currentA != A) {
                    pour(Math.min(currentC + currentA, A), currentB, Math.max(0, currentC - (A - currentA)), depth + 1);
                }
            }
        }


    }

}
