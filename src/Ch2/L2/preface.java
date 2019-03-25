/*
ID: jatongs1
LANG: JAVA
TASK: preface
 */
import java.util.*;
import java.io.*;

public class preface {
    public static int N = -1;
    public static int numI = 0;
    public static int numV = 0;
    public static int numX = 0;
    public static int numL = 0;
    public static int numC = 0;
    public static int numD = 0;
    public static int numM = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("preface.in"));
        FileWriter out = new FileWriter("preface.out");
        N = Integer.parseInt(inp.readLine());
        for (int i = 1; i <= N; i ++){
            getLetters(i);
        }
        System.out.println(numI);
        System.out.println(numV);
        System.out.println(numX);
        System.out.println(numL);
        System.out.println(numC);
        System.out.println(numD);
        System.out.println(numM);
        String fin = "";
        if (numM > 0){
            fin += "I " + String.valueOf(numI) + '\n';
            fin += "V " + String.valueOf(numV) + '\n';
            fin += "X " + String.valueOf(numX) + '\n';
            fin += "L " + String.valueOf(numL) + '\n';
            fin += "C " + String.valueOf(numC) + '\n';
            fin += "D " + String.valueOf(numD) + '\n';
            fin += "M " + String.valueOf(numM) + '\n';
        } else if (numD > 0){
            fin += "I " + String.valueOf(numI) + '\n';
            fin += "V " + String.valueOf(numV) + '\n';
            fin += "X " + String.valueOf(numX) + '\n';
            fin += "L " + String.valueOf(numL) + '\n';
            fin += "C " + String.valueOf(numC) + '\n';
            fin += "D " + String.valueOf(numD) + '\n';
        } else if (numC > 0){
            fin += "I " + String.valueOf(numI) + '\n';
            fin += "V " + String.valueOf(numV) + '\n';
            fin += "X " + String.valueOf(numX) + '\n';
            fin += "L " + String.valueOf(numL) + '\n';
            fin += "C " + String.valueOf(numC) + '\n';
        } else if (numL > 0){
            fin += "I " + String.valueOf(numI) + '\n';
            fin += "V " + String.valueOf(numV) + '\n';
            fin += "X " + String.valueOf(numX) + '\n';
            fin += "L " + String.valueOf(numL) + '\n';
        } else if (numX > 0){
            fin += "I " + String.valueOf(numI) + '\n';
            fin += "V " + String.valueOf(numV) + '\n';
            fin += "X " + String.valueOf(numX) + '\n';
        } else if (numV > 0){
            fin += "I " + String.valueOf(numI) + '\n';
            fin += "V " + String.valueOf(numV) + '\n';
        } else if (numI > 0){
            fin += "I " + String.valueOf(numI) + '\n';
        }
        out.write(fin);
        out.close();
        inp.close();
    }
    public static void getLetters(int n){
        if (n % 10 >= 1 && n % 10 < 4){
            numI += n % 10;
        }
        if (n % 10 == 4){
            numI += 1;
            numV += 1;
        }
        if (n % 10 == 5){
            numV += 1;
        }
        if (n % 10 >= 6 && n % 10 < 9){
            numI += n % 10 - 5;
            numV += 1;
        }
        if (n % 10 == 9){
            numI += 1;
            numX += 1;
        }
        if (n % 100 >= 10 && n % 100 < 40){
            numX += Math.floorDiv(n % 100, 10);
        }
        if (n % 100 >= 40 && n % 100 < 50){
            numX += 1;
            numL += 1;
        }
        if (n % 100 >= 60 && n % 100 < 90){
            numX += Math.floorDiv(n % 100 - 50, 10);
        }
        if (n % 100 >= 90){
            numX += 1;
            numC += 1;
        }
        if (n % 100 >= 50 && n % 100 < 90){
            numL += 1;
        }
        if (n % 1000 >= 100 && n % 1000 < 400){
            numC += Math.floorDiv(n % 1000, 100);
        }
        if (n % 1000 >= 400 && n % 1000 < 500){
            numC += 1;
            numD += 1;
        }
        if (n % 1000 >= 600 && n % 1000 < 900){
            numC += Math.floorDiv(n % 1000 - 500, 100);
        }
        if (n % 1000 >= 900){
            numC += 1;
            numM += 1;
        }
        if (n % 1000 >= 500 && n % 1000 < 900){
            numD += 1;
        }
        if (n % 10000 >= 1000){
            numM += Math.floorDiv(n % 10000, 1000);
        }
    }

}
