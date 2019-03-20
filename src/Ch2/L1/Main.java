package Ch2.L1;
import java.util.*;
class Main {
    public static int N = 0;
    public static void main(String[] args) {
        ArrayList<int[]> orders = new ArrayList<>();
        int[] arr = {3, 2, 7, 3, 11, 5};
        ArrayList<Integer> current = new ArrayList<>();
        N = arr.length;
        for (int i = 1; i < arr.length + 1; i ++){
            recurse(current, 0, i, -1, orders);
        }
        int num = 0;
        for (int[] order: orders){
            int sum = 0;
            for (int a: order){
                sum += arr[a];
            }
            if (sum == 20){
                System.out.println(Arrays.toString(order));
                num += 1;
            }
        }
        System.out.println(num);


    }
    public static void recurse(ArrayList<Integer> current, int depth, int length, int previous, ArrayList<int[]> orders){
        if (depth == length){
            int[] order = new int[length];
            for (int i = 0; i < current.size(); i ++){
                order[i] = current.get(i);
            }
            orders.add(order);
        } else {
            for (int i = previous + 1; i <= N - length + depth; i ++){
                current.add(i);
                recurse(current, depth + 1, length, i, orders);
                current.remove(new Integer(i));
            }
        }
    }
}
