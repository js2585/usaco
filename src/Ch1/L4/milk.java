//package Ch1.L4;
/*
ID: jatongs1
LANG: JAVA
TASK: milk
 */
import java.util.*;
import java.io.*;

class milk {

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("milk.in"));
        FileWriter out = new FileWriter("milk.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        int desiredMilk = Integer.parseInt(st.nextToken());
        int numFarmers = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> prices = new HashMap<>();
        for (int i = 0; i < numFarmers; i ++){
            StringTokenizer st2 = new StringTokenizer(inp.readLine());
            int price = Integer.parseInt(st2.nextToken());
            int amount = Integer.parseInt(st2.nextToken());
            if (prices.containsKey(price)){
                prices.put(price, prices.get(price) + amount);
            } else {
                prices.put(price, amount);
            }
        }
        TreeMap<Integer, Integer> sortedPrices = new TreeMap<>(prices);
        int cost = 0;
        for (Map.Entry<Integer, Integer> entry: sortedPrices.entrySet()){
            if (entry.getValue() <= desiredMilk){
                cost += entry.getValue() * entry.getKey();
                desiredMilk -= entry.getValue();
            } else {
                cost += entry.getKey() * desiredMilk;
                break;
            }

        }
        out.write(String.valueOf(cost) + '\n');
        out.close();
        inp.close();

    }

}
