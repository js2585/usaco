import java.util.*;
import java.io.*;

public class perimeter {
    static int len;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("perimeter.in"));
        FileWriter out = new FileWriter("perimeter.out");
        len = Integer.parseInt(inp.readLine());
        String[][] rows = new String[len][len];
        for (int i = 0; i < len; i ++){
            String line = inp.readLine();
            String[] arr = line.split("");
            rows[i] = arr;
        }
        ArrayList<int[]> coordinates = new ArrayList<>();
        getCoordinates(rows, coordinates);

    }

    public static void getCoordinates(String[][] rows, ArrayList<int[]> coordinates){
        for (int y = 0; y < len; y ++){
            for (int x = 0; x < len; x ++){
                if (rows[y][x].equals("#")){
                    int[]coord = {y, x};
                    coordinates.add(coord);
                }
            }
        }
    }

    public static void getArea(int[] first, ArrayList<int[]> coordinates, ArrayList<int[]> area, ArrayList<int[]> used){
        used.add(first);
        area.add(first);
        for (int[] check: coordinates){
            if (isAdjacent(first, check)){
                area.add(check);
                used.add(check);
            }
        }

    }
    public static boolean isAdjacent(int[] coord1, int[] coord2){
        if (coord1[0] == coord2[0] && Math.abs(coord2[1] - coord1[1]) == 1){
            return true;
        }
        if (coord1[1] == coord2[1] && Math.abs(coord2[0] - coord1[0]) == 1){
            return true;
        }
        return false;
    }


}
