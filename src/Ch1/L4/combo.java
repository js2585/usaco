/*
ID: jatongs1
LANG: JAVA
TASK: combo
 */
import java.util.*;
import java.io.*;

public class combo {
    static ArrayList<Integer> possibleCombos = new ArrayList<>();
    static int maxNum;
    static int[] combo1;
    static int[] combo2;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("combo.in"));
        FileWriter out = new FileWriter("combo.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        maxNum = Integer.parseInt(st.nextToken());
        combo1 = new int[3];
        combo2 = new int[3];
        StringTokenizer st2 = new StringTokenizer(inp.readLine());
        for (int i = 0; i < 3; i ++){
            combo1[i] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(inp.readLine());
        for (int i = 0; i < 3; i ++){
            combo2[i] = Integer.parseInt(st3.nextToken());
        }
        createCombo(combo1);
        createCombo(combo2);
        out.write(String.valueOf(possibleCombos.size()) + '\n');
        out.close();
        inp.close();

    }
    public static void createCombo(int[] combo){
        ArrayList<Integer> firstDigit = new ArrayList<>();
        ArrayList<Integer> secondDigit = new ArrayList<>();
        ArrayList<Integer> thirdDigit = new ArrayList<>();
        for (int a = 0; a < 3; a ++){
            if (maxNum >= 2){
                for (int i = combo[a] - 2; i <= combo[a] + 2; i ++){
                    int possibleDigit = i;
                    if (i < 1){
                        possibleDigit = maxNum + i;
                    }
                    if (i > maxNum){
                        possibleDigit = i - maxNum;
                    }
                    switch (a){
                        case 0:
                            firstDigit.add(possibleDigit);
                            break;
                        case 1:
                            secondDigit.add(possibleDigit);
                            break;
                        case 2:
                            thirdDigit.add(possibleDigit);
                            break;
                    }
                }
            } else if (maxNum == 1){
                if (a == 0){
                    firstDigit.add(1);
                } else if (a == 1){
                    secondDigit.add(1);
                } else{
                    thirdDigit.add(1);
                }
            }
        }
        for (int a: firstDigit){
            for (int b: secondDigit){
                for (int c: thirdDigit){
                    boolean duplicate = false;
                    for (int combos: possibleCombos){
                        if (100*a + 10*b + c == combos){
                            duplicate = true;
                        }
                    }
                    if (!duplicate){
                        possibleCombos.add(100*a + 10*b + c);
                    }
                }
            }
        }

    }



}
