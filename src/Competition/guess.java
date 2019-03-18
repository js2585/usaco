import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class guess {

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new FileReader("guess.in"));
        FileWriter out = new FileWriter("guess.out");
        int numAnimals = Integer.parseInt(inp.readLine());
        ArrayList<String[]> traits = new ArrayList<>();
        for (int i = 0; i < numAnimals; i ++){
            StringTokenizer st = new StringTokenizer(inp.readLine());
            String name = st.nextToken();
            int numTraits = Integer.parseInt(st.nextToken());
            String[] characteristics = new String[numTraits];
            for (int a = 0; a < numTraits; a ++){
                characteristics[a] = st.nextToken();
            }
            traits.add(characteristics);
        }
        ArrayList<Integer> possibleYes = new ArrayList<>();
        for (String[] character: traits){
            possibleYes.add(getDuplicate(traits, character));
        }
        int finalAnswer = Collections.max(possibleYes);
        out.write(String.valueOf(finalAnswer) + '\n');
        out.close();
        inp.close();

    }
    public static boolean contains(final String[] array, final String v) {

        boolean result = false;

        for(String i : array){
            if(i.equals(v)){
                result = true;
                break;
            }
        }

        return result;
    }

    public static int getDuplicate(ArrayList<String[]> traits, String[] character){
        int matches = 0;
        for (String[] characteristics: traits){
            int numSame = 0;
            for (String trait: characteristics){
                if (contains(character, trait)){
                    numSame += 1;
                }
            }
            if (!(character.length == characteristics.length && numSame == character.length)){
                if (numSame < character.length){
                    numSame += 1;
                }
                if (numSame > matches){
                    matches = numSame;
                }
            }
        }
        return matches;
    }

}
