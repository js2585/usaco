/*
ID: jatongs1
LANG: JAVA
TASK: sprime
 */
import java.io.*;
import java.util.*;
public class sprime {
    public static int N;
    public static TreeSet<Integer> primes = new TreeSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("sprime.in"));
        FileWriter out = new FileWriter("sprime.out");
        N = Integer.parseInt(inp.readLine());
        generatePrime(0, 0);
        String finalAnswer = "";
        for (int x: primes){
            finalAnswer += String.valueOf(x) + '\n';
        }
        out.write(finalAnswer);
        out.close();
        inp.close();
    }

    public static boolean checkPrime(int num){
        boolean prime = true;
        for (int i = 2; i <= Math.sqrt(num); i ++){
            if (num % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }

    public static void generatePrime(int num, int depth){
        int[] digits = {2, 3, 5, 7};
        if (depth == N){
            primes.add(num);
        }
        if (depth == 0){
            for (int digit: digits){
                num = digit;
                generatePrime(num, depth + 1);
            }
        } else if (depth < N){
            for (int i = 1; i <= 9; i++ ){
                num = num * 10 + i;
                if (checkPrime(num)){
                    generatePrime(num, depth + 1);
                }
                num = (num - i) / 10;
            }
        }
    }

}
