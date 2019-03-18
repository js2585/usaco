/*
ID: jatongs1
LANG: JAVA
TASK: ariprog
 */
import java.io.*;
import java.util.*;

public class ariprog {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));


        int N = Integer.parseInt(f.readLine());
        int M = Integer.parseInt(f.readLine());


        int[] arr = new int[(M + 1) * (M + 2) / 2];
        boolean[] contains = new boolean[125001];
        //HashSet<Integer> hs = new HashSet<Integer>();
        int x = 0;

        for (int i = 0; i <= M; i++) {
            for (int j = i; j <= M; j++) {
                arr[x++] = i * i + j * j;
                contains[i * i + j * j] = true;
                //hs.add(i * i + j * j);
            }
        }
        Arrays.sort(arr);

        boolean one = false;
        int lastA = -1;
        int lastB = -1;
        for (int b = 1; b <= arr[arr.length - 1] / (N - 1); b++) {//System.out.println(b);
            for (int j = 0; arr[j] + b * (N - 1) <= arr[arr.length - 1]; j++) {//System.out.println(arr[j]);
                int a = arr[j];
                int count = 0;
                int index = j + 1;

                boolean good = true;
                for (int k = 0; k < N; k++) {
                    if (!contains[a + b * k]) {
                        good = false;
                        break;
                    }
                }


                if (/*count >= N - 1*/good && !(arr[j] == lastA && b == lastB)) {
                    out.println(arr[j] + " " + b);
                    lastA = arr[j];
                    lastB = b;
                    one = true;
                }
            }
        }
        if (!one) {
            out.println("NONE");
        }


        out.close();
    }

}
//import java.lang.reflect.Array;
//import java.util.*;
//import java.io.*;
//public class ariprog {
//    static int lenProg;
//    static int numNumbers;
//    static int upperBound;
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader inp = new BufferedReader(new FileReader("ariprog.in"));
//        FileWriter out = new FileWriter("ariprog.out");
//        lenProg = Integer.parseInt(inp.readLine());
//        upperBound = Integer.parseInt(inp.readLine());
//        ArrayList<Integer> numbers = new ArrayList<>();
//        ArrayList<int[]> answers = new ArrayList<>();
//        boolean[] contains = new boolean[1000000];
//        for (int p = 0; p <= upperBound;  p ++){
//            for (int q = p; q <= upperBound; q ++){
//                if (!contains[p * p + q * q]){
//                    numbers.add(p * p + q * q);
//                    contains[p * p + q * q] = true;
//                }
//            }
//        }
//        Collections.sort(numbers);
//        getProg(numbers, answers);
//        StringBuilder finalAnswer = new StringBuilder();
//        for (int[] data: answers){
//            finalAnswer.append(data[0]);
//            finalAnswer.append(" " + data[1]);
//            finalAnswer.append('\n');
//        }
//        if (answers.size() == 0){
//            finalAnswer.append("NONE\n");
//        }
//        out.write(finalAnswer.toString());
//        out.close();
//        inp.close();
//    }
//    public static boolean contains(final ArrayList<Integer> array, final int v) {
//
//        boolean result = false;
//
//        for(int i : array){
//            if(i == v){
//                result = true;
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    public static void getProg(ArrayList<Integer> numbers, ArrayList<int[]> answers){
//        int max = Collections.max(numbers);
//        int maxDifference = max/(lenProg - 1);
//        for (int difference = 1; difference <= maxDifference; difference ++){
//            for (int number: numbers){
//                if (number + difference * (lenProg - 1) <= max){
//                    int startNum = number;
//                    int counter = 0;
//                    for (int i = 0; i < lenProg; i ++){
//                        if (contains(numbers, startNum + difference * i)){
//                            counter += 1;
//                        } else {
//                            break;
//                        }
//                    }
//                    if (counter == lenProg){
//                        int[] data = new int[2];
//                        data[0] = startNum;
//                        data[1] = difference;
//                        answers.add(data);
//                    }
//                }
//            }
//        }
//
//    }
//
//}
