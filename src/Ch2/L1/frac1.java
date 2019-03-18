/*
ID: jatongs1
LANG: JAVA
TASK: frac1
 */
import java.util.*;
import java.io.*;

public class frac1 {
    public static int N;
    public static double[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("frac1.in"));
        FileWriter out = new FileWriter("frac1.out");
        N = Integer.parseInt(inp.readLine());
        arr = new double[N + 1];
        for (int i = 0; i <= N; i ++){
            arr[i] = i;
        }
        HashSet<Double> val = new HashSet<>();
        ArrayList<double[]> frac = new ArrayList<>();
        for (int i = 0; i <= N; i ++){
            if (arr[i] > 0){
                for (int a = i; a <= N; a ++){
                    if (!val.contains((double) i / a)){
                        frac.add(new double[]{i, a, (double)i / a});
                        val.add((double) i / a);
                    }
                }
            } else {
                for (int a = 1; a <= N; a ++){
                    if (!val.contains((double) i / a)){
                        frac.add(new double[]{i, a, (double)i / a});
                        val.add((double) i / a);
                    }
                }
            }
        }
        Collections.sort(frac, new Comparator<double[]>(){
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) Math.signum(o1[2] - o2[2]);
            }
        });

//        for (double[] a: frac){
//            System.out.println(Arrays.toString(a));
//        }
        String finalA = "";
        for (double[] a: frac){
            finalA += String.valueOf((int) a[0] + "/" + (int) a[1] + '\n');
        }
        System.out.println(finalA);
        out.write(finalA);
        out.close();
        inp.close();

    }


}
