/*
ID: jatongs1
LANG: JAVA
TASK: hamming
 */

// use xor

import java.util.*;
import java.io.*;
public class hamming {
    static int N;
    static int B;
    static int D;
    public static void main (String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("hamming.in"));
        FileWriter out = new FileWriter("hamming.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        while (numbers.size() < N){
            for (int i = numbers.get(numbers.size() - 1) + 1; i < Math.pow(2, B); i ++){
                int sum = 0;
                for (int num: numbers){
                    if (countSetBits(i ^ num) >= D){
                        sum += 1;
                    }
                }
                if (sum == numbers.size()){
                    numbers.add(i);
                    break;
                }
            }
        }
        int index = 0;
        int count = 0;
        String fin = "";
        while (index < N){
            if (count < 9 && index != N - 1){
                fin += String.valueOf(numbers.get(index)) + " ";
            }
            if (count == 9 && index != N - 1){
                fin += String.valueOf(numbers.get(index)) + '\n';
            }
            if (index == N - 1){
                fin += String.valueOf(numbers.get(index)) + '\n';
            }
            count += 1;
            if (count == 10){
                count = 0;
            }
            index ++;
        }
        out.write(fin);
        out.close();
        inp.close();
    }
    public static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

}
