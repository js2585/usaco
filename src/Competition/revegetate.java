
import java.util.*;
import java.io.*;
public class revegetate {

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("revegetate.in"));
        FileWriter out = new FileWriter("revegetate.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        int numPas = Integer.parseInt(st.nextToken());
        int numCow = Integer.parseInt(st.nextToken());
        HashSet<int[]> fields = new HashSet<>();
        int num1 = -1;
        int num2 = -1;
        for (int i = 0; i < numCow; i ++){
            StringTokenizer st2 = new StringTokenizer(inp.readLine());
            String h = st2.nextToken();
            num1 = Integer.parseInt(st2.nextToken());
            num2 = Integer.parseInt(st2.nextToken());
            int[] field = {num1, num2};
            fields.add(field);
        }
        int numSys = 1;
        int[] numbers = new int[numPas];
        numbers[0] = num1;
        numbers[1] = num2;
        int count = 2;
        for (int i = 0; i < numbers.length; i ++){
            if (numbers[i] == 0){
                numSys += 1;
                for (int[] field: fields){
                    numbers[count] = field[0];
                    count += 1;
                    numbers[count] = field[1];
                    count += 1;
                    break;
                }
            }
            if (fields.size() > 0){
                for (int[] field: fields){
                    if (contains(field, numbers[i])){
                        if (field[0] != numbers[i] && field[0] != numbers[0] && field[0] != numbers[1]){
                            numbers[count] = field[0];
                            count += 1;
                        }
                        if (field[1] != numbers[i] && field[1] != numbers[0] && field[1] != numbers[1]){
                            numbers[count] = field[1];
                            count += 1;
                        }
                        fields.remove(field);
                    }
                }
            }

        }
        int finalA = (int)Math.pow(10, numSys);
        out.write(String.valueOf(finalA) + '\n');
        out.close();
        inp.close();
    }

    public static boolean contains(int[]arr, int value){
        boolean con = false;
        for (int a: arr){
            if (a == value){
                con = true;
                break;
            }
        }
        return con;
    }

}
