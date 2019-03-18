import java.util.*;
import java.io.*;

public class mountains {
    static int numMountains;

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new FileReader("mountains.in"));
        FileWriter out = new FileWriter("mountains.out");
        numMountains = Integer.parseInt(inp.readLine());

    }
}
