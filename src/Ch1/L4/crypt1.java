/*
ID: jatongs1
LANG: JAVA
TASK: crypt1
 */
import java.util.*;
import java.io.*;

public class crypt1 {

    public static void main (String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("crypt1.in"));
        FileWriter out = new FileWriter("crypt1.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        int numDigits = Integer.parseInt(st.nextToken());
        int[] digits = new int[numDigits];
        StringTokenizer st2 = new StringTokenizer(inp.readLine());
        for (int i = 0; i < numDigits; i++){
            digits[i] = Integer.parseInt(st2.nextToken());
        }
        int counter = 0;
        ArrayList<Integer> twoDigit = new ArrayList<>();
        ArrayList<Integer> threeDigit = new ArrayList<>();
        for (int a: digits){
            for (int b: digits){
                twoDigit.add(10*a + b);
            }
        }
        for (int a: digits){
            for (int b: digits){
                for (int c: digits){
                    threeDigit.add(100*a + 10*b + c);
                }
            }
        }
        for (int num2: twoDigit){
            for (int num3: threeDigit){
                if (checkMultiply(digits, num3, num2)){
                    counter += 1;
                }
            }
        }
        out.write(String.valueOf(counter) + '\n');
        out.close();
        inp.close();

    }

    public static boolean checkMultiply(int[] digits, int num3, int num2){
        int firstProduct = num3 * (num2 % 10);
        int secondProduct = num3 * ((num2 - (num2 % 10))/10);
        int thirdProduct = num3 * num2;
        if (notInDigits(firstProduct, digits) || notInDigits(secondProduct, digits) || notInDigits(thirdProduct, digits)){
            return false;
        }
        if (thirdProduct - 10000 > 0 || firstProduct - 1000 > 0 || secondProduct - 1000 > 0){
            return false;
        }
        return true;
    }

    public static boolean notInDigits(int num, int[] digits){
        String newNum = String.valueOf(num);
        char[] numDigits = newNum.toCharArray();
        int matches = 0;
        for (char digit: numDigits){
            for (int item: digits){
                if (Character.getNumericValue(digit) == item){
                    matches += 1;
                }
            }
        }
        return !(matches == newNum.length());
    }



}
