/*
ID: jatongs1
LANG: JAVA
TASK: skidesign
 */

import java.util.*;
import java.io.*;

public class skidesign {

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("skidesign.in"));
        FileWriter out = new FileWriter("skidesign.out");
        int numHills = Integer.parseInt(inp.readLine());
        Integer[] hillHeights = new Integer[numHills];
        Integer[] initialHeights = new Integer[numHills];
        for (int i = 0; i < numHills; i ++){
            int x = Integer.parseInt(inp.readLine());
            hillHeights[i] = x;
            initialHeights[i] = x;
        }
        int cost;
        Arrays.sort(initialHeights);
        hillHeights = getFinalHeights(hillHeights, initialHeights);
        System.out.println(Arrays.toString(initialHeights));
        System.out.println(Arrays.toString(hillHeights));
        cost = calculateSum(hillHeights, initialHeights);
        out.write(String.valueOf(cost) + '\n');
        System.out.println(cost);
        out.close();
        inp.close();

    }

    private static int calculateSum(Integer[] hillHeights, Integer[] initialHeights){
        int sum = 0;
        for (int i = 0; i < hillHeights.length; i ++){
            sum += (hillHeights[i] - initialHeights[i]) * (hillHeights[i] - initialHeights[i]);
        }
        return sum;
    }

    /**
     * Makes a deep copy of any Java object that is passed.
     */
    private static Object deepCopy(Object object) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
            outputStrm.writeObject(object);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
            return objInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Integer[] getFinalHeights(Integer[] hillHeights, Integer[] initialHeights){
        Arrays.sort(hillHeights);
        int numHills = hillHeights.length;
        int difference = Collections.max(Arrays.asList(hillHeights)) - Collections.min(Arrays.asList(hillHeights));
        while (difference > 17){
            int numSimMin = 0;
            int numSimMax = 0;
            Integer[] minChange = new Integer[numHills];
            Integer[] maxChange = new Integer[numHills];
            for (int i = 0; i < numHills; i ++){
                minChange[i] = hillHeights[i];
                maxChange[i] = hillHeights[i];
            }
            for (int item: hillHeights){
                if (item == hillHeights[0]){
                    numSimMin += 1;
                }
                if (item == hillHeights[numHills - 1]){
                    numSimMax += 1;
                }
            }
            for (int i = 0; i < numSimMin; i ++){
                minChange[i] += 1;
            }
            for (int i = 0; i < numSimMax; i ++ ){
                maxChange[numHills - i - 1] -= 1;
            }
            if (calculateSum(maxChange, initialHeights) <= calculateSum(minChange, initialHeights)){
                for (int i = 0; i < numSimMax; i ++ ){
                    hillHeights[numHills - i - 1] -= 1;
                }
            } else {
                for (int i = 0; i < numSimMin; i ++){
                    hillHeights[i] += 1;
                }
            }
            difference = Collections.max(Arrays.asList(hillHeights)) - Collections.min(Arrays.asList(hillHeights));
        }
        return hillHeights;

    }

}
