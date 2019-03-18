/*
ID: jatongs1
LANG: JAVA
TASK: pprime
 */
import java.util.*;
import java.io.*;
public class pprime {
    public static int a;
    public static int b;
    public static TreeSet<Integer> pal = new TreeSet<>();
    public static int lenA;
    public static int lenB;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("pprime.in"));
        FileWriter out = new FileWriter("pprime.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        String str = st.nextToken();
        String str2 = st.nextToken();
        a = Integer.parseInt(str);
        b = Integer.parseInt(str2);
        lenA = str.length();
        lenB = str2.length();
        for (int i = lenA; i <= lenB; i ++){
            getPal(0, i, 0);
        }
        if (a == 5){
            pal.add(5);
        }
        System.out.println(pal);
        TreeSet<Integer> finalA = new TreeSet<>();
        for (int x: pal){
            if (checkPrime(x)){
                finalA.add(x);
            }
        }
        System.out.println(finalA);
        String finalAnswer = "";
        for (int x: finalA){
            finalAnswer += String.valueOf(x) + '\n';
        }
        out.write(finalAnswer);
        out.close();
        inp.close();
    }

    public static boolean checkPrime(int num){
        boolean prime = true;
        for (int i = 3; i <= Math.sqrt(num); i ++){
            if (num % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }

    public static void getPal(int num, double len, int depth){
        int[] firstDigit = {1, 3, 7, 9};
        if (depth == Math.ceil(len / 2)){
            if (num >= a && num <= b){
                pal.add(num);
            }
        }
        if (depth == 0){
            for (int digit: firstDigit){
                if (len != 1){
                    num += digit * Math.pow(10, len - 1 - depth);
                    num += digit * Math.pow(10, depth);
                    getPal(num, len, depth + 1);
                    num -= digit * Math.pow(10, len - 1 - depth);
                    num -= digit * Math.pow(10, depth);

                } else {
                    num += digit * Math.pow(10, depth);
                    getPal(num, len, depth + 1);
                    num -= digit * Math.pow(10, depth);
                }

            }
        } else if (depth < Math.ceil(len / 2)) {
            for (int i = 0; i <= 9; i ++){
                if (len % 2 == 1){
                    if (depth != Math.ceil(len / 2) - 1){
                        num += i * Math.pow(10, depth);
                        num += i * Math.pow(10, len - 1 - depth);
                        getPal(num, len, depth + 1);
                        num -= i * Math.pow(10, depth);
                        num -= i * Math.pow(10, len - 1 - depth);

                    } else {
                        num += i * Math.pow(10, depth);
                        getPal(num, len, depth + 1);
                        num -= i * Math.pow(10, depth);
                    }
                } else {
                    num += i * Math.pow(10, depth);
                    num += i * Math.pow(10, len - 1 - depth);
                    getPal(num, len, depth + 1);
                    num -= i * Math.pow(10, depth);
                    num -= i * Math.pow(10, len - 1 - depth);
                }


            }

        }
    }

}
