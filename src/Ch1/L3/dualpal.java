package Ch1.L3;/*
ID: jatongs1
LANG: JAVA
TASK: dualpal
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class dualpal {

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"));
        StringTokenizer st = new StringTokenizer(inp.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int found = 0;
        int start = S + 1;
        while (found < N){
            int nump = 0;
            for (int base = 2; base < 11; base ++){
                if (isPalindrome(convBase(start, base))){
                    nump += 1;
                }
                if (nump == 2){
                    out.println(start);
                    numbers.add(start);
                    found ++;
                    break;
                }
            }
            start ++;
        }
        out.close();
        inp.close();

    }

    public static String convBase(int num, int base){
        int power = 0;
        while(Math.pow(base,power) <= num){
            power++;
        }
        char[] res = new char[power];
        for(int i = power-1; i > -1; i--){
            int quotient = num/((int)Math.pow(base,i));
            int remainder = num%((int)Math.pow(base,i));
            res[power-1-i] = Character.toUpperCase(Character.forDigit(quotient,base));
            num = remainder;
        }
        return new String(res);
    }

    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}