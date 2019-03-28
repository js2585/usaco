/*
ID: jatongs1
LANG: JAVA
TASK: subset
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class subset {

    static int total, N;
    static long[] holder = new long[1080];
    static long[] holderTemp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("subset.in"));
        PrintWriter pw = new PrintWriter("subset.out");
        holder[0] = 1;
        holderTemp = Arrays.copyOf(holder, holder.length);

        N = Integer.parseInt(br.readLine());
        total = N * (N + 1) / 2;

        if(total % 2 != 0) {
            pw.println(0);
        }
        else{

            total /= 2;
            int temp = 0;

            for(int i = 1; i <= N; i++){

                for(int j = 0; j <= temp; j++){

                    holder[j + i] += holderTemp[j];

                }

                holderTemp = Arrays.copyOf(holder, holder.length);
                temp = i * (i + 1) / 2;

            }

            pw.println(holder[total]/2);

        }

        pw.flush();
        pw.close();
        br.close();
        System.exit(0);

    }

}
//import java.util.*;
//import java.io.*;
//public class subset {
//    public static int N = 0;
//    public static int sum = 0;
//    public static HashMap<List<Integer>, Integer> partitions = new HashMap<>();
//    public static void main(String[] args) throws IOException{
//        BufferedReader inp = new BufferedReader(new FileReader("subset.in"));
//        FileWriter out = new FileWriter("subset.out");
//        N = Integer.parseInt(inp.readLine());
//        sum = N * (N + 1) / 2;
//        int fin = findPartition(sum / 2, N) / 2;
//        System.out.println(fin);
////        for (List<Integer> a: partitions.keySet()){
////            System.out.println(a + ": " + partitions.get(a));
////        }
//        out.write(String.valueOf(fin) + '\n');
//        out.close();
//        inp.close();
//
//    }
//
//    public static int findPartition(int total, int max){
//        int numPart = 0;
//        List<Integer> key = new ArrayList<>();
//        key.add(total);
//        key.add(max);
//        if (partitions.containsKey(key)){
//            numPart = partitions.get(key);
//        } else {
//            for (int i = max; i > 0; i --){
//                if (total - i == 0){
//                    numPart += 1;
//                } else if (total - i > 0 && (i - 1) * i / 2 >= total - i) {
//                    numPart += findPartition(total - i, i - 1);
//                }
//                if (numPart < 0){
//                    System.out.println(String.valueOf(total) + String.valueOf(max) + " " + String.valueOf(i));
//                    System.out.println("neg");
//                }
//            }
//            partitions.put(key, numPart);
//        }
//
//        return numPart;
//    }
//
//}
