package Ch1.L3;/*
ID: jatongs1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;

class palsquare {

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(f.readLine());
        for(int i = 1; i < 301; i++){
            String squaredB = convBase((int)Math.pow(i,2), base);
            if(isPalindrome(squaredB)){
                String iB = convBase(i, base);
                out.println(iB + " " + squaredB);
            }
        }
        out.close();
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

//
//import java.io.*;
//import java.util.*;
//
//public class palsquare {
//
//    private static String convertBase(int number, int base){
//        ArrayList<String> digits = new ArrayList<String>();
//        HashMap<Integer, String> letters = new HashMap<Integer, String>();
//        letters.put(10, "A");
//        letters.put(11, "B");
//        letters.put(12, "C");
//        letters.put(13, "D");
//        letters.put(14, "E");
//        letters.put(15, "F");
//        letters.put(16, "G");
//        letters.put(17, "H");
//        letters.put(18, "I");
//        letters.put(19, "J");
//        letters.put(20, "K");
//        int n = number;
//        while (n != 0){
//            if (n % base >= 10){
//                digits.add(letters.get(n % base));
//            } else {
//                digits.add((n % base).toString());
//            }
//            n = (int)Math.floor(n / base);
//        }
//        StringBuilder newNumber = new StringBuilder();
//        for (int i = digits.size() - 1; i >= 0; i--){
//            newNumber.append(digits.get(i));
//        }
//        String lastNumber = newNumber.toString();
//        return Integer.valueOf(lastNumber);
//    }
//
//    private static boolean checkPalindrome(int test){
//        int reversedNum = 0;
//        while (test != 0){
//            reversedNum = reversedNum * 10 + test % 10;
//            test = (int)Math.floor(test / 10);
//        }
//        if (reversedNum == test){
//            return true;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        ArrayList<String> data = new ArrayList<String>();
//        BufferedReader reader;
//        BufferedWriter output;
//        try{
//            File outputFile = new File("palsquare.out");
//            output = new BufferedWriter(new FileWriter(outputFile));
//            reader = new BufferedReader(new FileReader("palsquare.in"));
//            String line = reader.readLine();
//            while (line != null){
//                data.add(line);
//                line = reader.readLine();
//            }
//            int base = Integer.valueOf(data.get(0));
//            for (int i = 1; i <= 300; i ++){
//                if (checkPalindrome(convertBase((int)Math.pow(i, 2), base))){
//                    output.write(convertBase(i, base) + " " + convertBase((int)Math.pow(i, 2), base) + "\n");
//                }
//            }
//            reader.close();
//            output.close();
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//
//}