/*
ID: jatongs1
LANG: JAVA
TASK: wormhole
 */

import java.io.*;
import java.util.*;

class wormhole {

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        int wormholes = Integer.parseInt(f.readLine());
        int[] enter = new int[wormholes];
        Integer[] exit = new Integer[wormholes];
        HashMap<Integer,ArrayList<Wormhole>> ys = new HashMap<Integer, ArrayList<Wormhole>>();
        ArrayList<Integer> holes = new ArrayList<Integer>();
        for(int i = 0; i < wormholes; i++){
            holes.add(i);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(ys.containsKey(y)){
                ArrayList<Wormhole> xs = ys.get(y);
                xs.add(new Wormhole(x,i));
            } else {
                ArrayList<Wormhole> newList = new ArrayList<Wormhole>();
                newList.add(new Wormhole(x,i));
                ys.put(y, newList);
            }
        }
        for(Integer y: ys.keySet()){
            ArrayList<Wormhole> xs = ys.get(y);
            Collections.sort(xs, new CustomComparator());
            for(int i = 1; i < xs.size(); i++){
                int prevId = xs.get(i-1).id;
                int currId = xs.get(i).id;
                exit[prevId] = currId;
            }
        }
        int cycles = findCycles(exit, enter, holes);
        System.out.println(cycles);
        out.println(cycles);
        out.close();
    }

    public static int findCycles(Integer[] exit, int[] enter, ArrayList<Integer> holes){
        if(holes.size() == 0){
            //System.out.println("exit:");
            //System.out.println(Arrays.toString(exit));
            //System.out.println("enter: ");
            //System.out.println(Arrays.toString(enter));
            boolean cycleExists = checkCycle(exit, enter);
            return cycleExists? 1:0;
        }
        int holeA = 0;
        int cyclesFound = 0;
        for(int i = 1; i < holes.size(); i++){
            int[] newEnter = enter.clone();
            int holeB = i;
            ArrayList<Integer> newHoles = new ArrayList(holes);
            Integer b = newHoles.remove(holeB);
            Integer a = newHoles.remove(holeA);
            newEnter[a] = b;
            newEnter[b] = a;
            cyclesFound += findCycles(exit, newEnter, newHoles);
        }
        return cyclesFound;
    }

    public static boolean checkCycle(Integer[] exit, int[] enter){
        for(int i = 0; i < enter.length; i++){
            Integer nextNode = i;
            HashSet<Integer> entered = new HashSet<Integer>();
            boolean entering = true;
            while(true){
                if(entering){
                    if(entered.contains(enter[nextNode])){
                        return true;
                    } else {
                        nextNode = enter[nextNode];
                        entered.add(nextNode);
                    }
                } else {
                    if(exit[nextNode] == null){
                        break;
                    }
                    nextNode = exit[nextNode];
                }
                entering = !entering;
            }
        }
        return false;
    }

    public static class Wormhole{
        int x;
        int id;
        public Wormhole(int x, int id){
            this.x = x;
            this.id = id;
        }
        public String toString(){
            return "id: "+id+ " x: "+x;
        }
    }

    static class CustomComparator implements Comparator<Wormhole> {
        @Override
        public int compare(Wormhole m1, Wormhole m2) {
            return m1.x - m2.x;
        }
    }
}
//
//
//import java.io.*;
//import java.util.*;
//
//public class wormhole {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader inp = new BufferedReader(new FileReader("wormhole.in"));
//        FileWriter out = new FileWriter("wormhole.out");
//        StringTokenizer st = new StringTokenizer(inp.readLine());
//        int numCases = 0;
//        int numWormholes = Integer.parseInt(st.nextToken());
//        int[][] coordinates = new int[numWormholes][3]; // [[x, y, index of paired wormhole], ...]]
//        for (int i = 0; i < numWormholes; i ++){
//            int[] coordinate = new int[3];
//            StringTokenizer st2 = new StringTokenizer(inp.readLine());
//            coordinate[0] = Integer.parseInt(st2.nextToken());
//            coordinate[1] = Integer.parseInt(st2.nextToken());
//            coordinate[2] = -1;
//            coordinates[i] = coordinate;
//        }
//
//        Arrays.sort(coordinates, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return (Integer.valueOf(o1[0]).compareTo(o2[0]));
//            }
//        });
//        ArrayList<int[][]> cases = new ArrayList<>();
//        createCases(coordinates, cases);
//        for (int[][] trial: cases){
//            if (checkCase(trial)){
//                numCases += 1;
//            }
//        }
//        out.write(String.valueOf(numCases) + '\n');
//        out.close();
//        inp.close();
//    }
//    public static Object deepClone(Object object) {
//        try {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(baos);
//            oos.writeObject(object);
//            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            return ois.readObject();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public static void createCases(int[][] coordinates, ArrayList<int[][]>cases){
//        int counter = 0;
//        for (int[] coordinate: coordinates){
//            if (coordinate[2] == -1){
//                counter += 1;
//            }
//        }
//        if (counter == 0){
//            boolean add = true;
//            int[][]clone = (int[][])deepClone(coordinates);
//            for (int[][] a: cases){
//                if (Arrays.deepEquals(a, clone)){
//                    add = false;
//                }
//            }
//            if (add){
//                cases.add(clone);
//            }
//        }
//        for (int i = 0; i < coordinates.length; i ++){
//            if (coordinates[i][2] == -1){ //wormhole does not have partner
//                for (int a = 1; a < coordinates.length - i; a ++){ //chooses the next wormhole
//                    if (coordinates[i + a][2] == -1){
//                        coordinates[i][2] = i + a;
//                        coordinates[a + i][2] = i;
//                        createCases(coordinates, cases);
//                        coordinates[i][2] = -1;
//                        coordinates[a + i][2] = -1;
//                    }
//                }
//            }
//        }
//
//    }
//    //when given a case; will check to see if there is a loop
//    public static boolean checkCase(int[][] coordinates){
//        boolean possible = false; //initially not working
//        for (int[] startingCoordinate: coordinates){ //treating every starting coordinate as a case
//            int[] currentCoordinate = startingCoordinate;
//            ArrayList<int[]> passedCoordinates = new ArrayList<>(); //contains list of coordinates passed
//            boolean escape = false;
//            boolean loop = false;
//            boolean justTeleported = false; //if object got teleported, it doesn't go through the wormhole in reverse
//            //direction
//            while (!escape && !loop){
//                for (int[] coord: passedCoordinates){ //checks to see if coordinate has been visited
//                    if (coord == currentCoordinate){
//                        loop = true;
//                    }
//                }
//                passedCoordinates.add(currentCoordinate);
//                if (!justTeleported){
//                    currentCoordinate = coordinates[currentCoordinate[2]];
//                    justTeleported = true;
//                } else {
//                    justTeleported = false;
//                    int possibleWormholes = 0;
//                    for (int i = Arrays.asList(coordinates).indexOf(currentCoordinate) + 1; i < coordinates.length; i ++){
//                        if (coordinates[i][1] == currentCoordinate[1]){
//                            possibleWormholes += 1;
//                            currentCoordinate = coordinates[i];
//                        }
//                    }
//                    if (possibleWormholes == 0){
//                        escape = true;
//                    }
//                }
//            }
//            possible = loop;
//            if (possible){
//                break;
//            }
//        }
//        return possible;
//
//    }
//
//}
