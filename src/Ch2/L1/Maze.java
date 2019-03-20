import java.util.*;

public class Maze {

    public static void main(String[] args){
        int[][] maze = {{1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1}};
        class Point {
            int row;
            int col;
            Point previous;
            public Point(int row, int col, Point previous){
                this.row = row;
                this.col = col;
                this.previous = previous;
            }
            public int getRow(){
                return row;
            }
            public int getCol(){
                return col;
            }
            public int[] getCoord(){
                int[] coord = {row, col};
                return coord;
            }
            public Point getPrevious(){
                return previous;
            }
        }
        LinkedList<Point> points = new LinkedList<>();

        Point first = new Point(0, 0, null);
        points.add(first);
        boolean[][] traveled = new boolean[4][5];
        traveled[0][0] = true;
        Point check = new Point(0, 0, null);
        while (!(check.getRow() == 3 && check.getCol() == 4)){
            check = points.poll();
            if (check.getRow() != 0){
                if (maze[check.getRow() - 1][check.getCol()] == 1 && !traveled[check.getRow() - 1][check.getCol()]){
                    traveled[check.getRow() - 1][check.getCol()] = true;
                    points.add(new Point(check.getRow() - 1, check.getCol(), check));
                }
            }
            if (check.getRow() != 3){
                if (maze[check.getRow() + 1][check.getCol()] == 1 && !traveled[check.getRow() + 1][check.getCol()]){
                    traveled[check.getRow() + 1][check.getCol()] = true;
                    points.add(new Point(check.getRow() + 1, check.getCol(), check));
                }
            }
            if (check.getCol() != 0){
                if (maze[check.getRow()][check.getCol() - 1] == 1 && !traveled[check.getRow()][check.getCol() - 1]){
                    traveled[check.getRow()][check.getCol() - 1] = true;
                    points.add(new Point(check.getRow(), check.getCol() - 1, check));
                }
            }
            if (check.getCol() != 4){
                if (maze[check.getRow()][check.getCol() + 1] == 1 && !traveled[check.getRow()][check.getCol() + 1]){
                    traveled[check.getRow()][check.getCol() + 1] = true;
                    points.add(new Point(check.getRow(), check.getCol() + 1, check));
                }
            }
        }
        System.out.println(Arrays.toString(check.getCoord()));
        Point previous = check.getPrevious();
        while (previous != null){
            System.out.println(Arrays.toString(previous.getCoord()));
            previous = previous.getPrevious();
        }
    }


}
