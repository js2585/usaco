package Ch2.L1;/*
ID: jatongs1
LANG: JAVA
TASK: Ch2.L1.castle
 */
import java.util.*;
import java.io.*;
/*
creat 2d array of modules
use flood fill to mark adjacent modules without walls with number
highest number is number of rooms
size of largest room is mode of numbers
test walls to remove
 */
public class castle {
    public static int M, N;
    public static int[][] cells;
    public static int[][] values;
    public static int visitedIndex = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new FileReader("Ch2.L1.castle.in"));
        FileWriter out = new FileWriter("Ch2.L1.castle.out");
        StringTokenizer st = new StringTokenizer(inp.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cells = new int[N][M];
        values = new int[N][M];
        for (int i = 0; i < N; i ++){
            StringTokenizer st2 = new StringTokenizer(inp.readLine());
            for (int j = 0; j < M; j ++){
                values[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int row = 0; row < N; row ++){
            for (int col = 0; col < M; col ++){
                if (!visited[row][col]){
                    count += 1;
                    floodfill(row, col, count, visited);
                }
            }
        }
        for (int[] a: cells){
            System.out.println(Arrays.toString(a));
        }
        int numRooms = count;
        int[] sizes = new int[count + 1];
        for (int row = 0; row < N; row ++){
            for (int col = 0; col < M; col ++){
                sizes[cells[row][col]] += 1;
            }
        }
        int maxSize = 0;
        for (int size: sizes){
            if (size > maxSize){
                maxSize = size;
            }
        }
        int maxCombo = 0;
        String wallRemove = "";
        boolean found = false;
        if (N == 1 && M != 1){
            int row = 0;
            for (int col = 0; col < M - 1; col ++){
                if (cells[row][col] != cells[row][col + 1]){
                    if (sizes[cells[row][col]] + sizes[cells[row][col + 1]] >= maxCombo){
                        maxCombo = sizes[cells[row][col]] + sizes[cells[row][col + 1]];
                    }
                }
            }
            for (int col = 0; col < M - 1; col ++){
                if (!found){
                    if (cells[row][col] != cells[row][col + 1]){
                        if (sizes[cells[row][col]] + sizes[cells[row][col + 1]] == maxCombo){
                            wallRemove = String.valueOf(row + 1) + " " + String.valueOf(col + 1) + " E";
                            found = true;
                            break;
                        }
                    }
                }
            }
        } else if (N != 1 && M == 1){
            int col = 0;
            for (int row = 0; row < N - 1; row ++){
                if (cells[row][col] != cells[row + 1][col]){
                    if (sizes[cells[row][col]] + sizes[cells[row + 1][col]] >= maxCombo){
                        maxCombo = sizes[cells[row][col]] + sizes[cells[row + 1][col]];
                    }
                }
            }
            for (int row = N - 1; row >= 1; row --){
                if (!found){
                    if (cells[row][col] != cells[row - 1][col]){
                        if (sizes[cells[row][col]] + sizes[cells[row - 1][col]] == maxCombo){
                            wallRemove = String.valueOf(row + 1) + " " + String.valueOf(col + 1) + " N";
                            found = true;
                            break;
                        }
                    }
                }
            }
        } else if (N == 1 && M == 1){
            maxCombo = 1;
        } else {
            for (int row = 0; row < N; row ++){
                for (int col = 0; col < M; col ++){
                    if (row == N - 1 || col == M - 1){
                        if (row == N - 1 && col != M - 1){
                            if (cells[row][col] != cells[row][col + 1]){
                                if (sizes[cells[row][col]] + sizes[cells[row][col + 1]] >= maxCombo){
                                    maxCombo = sizes[cells[row][col]] + sizes[cells[row][col + 1]];
                                }
                            }
                        } else if (row != N - 1 && col == M - 1){
                            if (cells[row][col] != cells[row + 1][col]){
                                if (sizes[cells[row][col]] + sizes[cells[row + 1][col]] >= maxCombo){
                                    maxCombo = sizes[cells[row][col]] + sizes[cells[row + 1][col]];
                                }
                            }
                        }
                    } else {
                        if (cells[row][col] != cells[row][col + 1]){
                            if (sizes[cells[row][col]] + sizes[cells[row][col + 1]] >= maxCombo){
                                maxCombo = sizes[cells[row][col]] + sizes[cells[row][col + 1]];
                            }
                        }
                        if (cells[row][col] != cells[row + 1][col]){
                            if (sizes[cells[row][col]] + sizes[cells[row + 1][col]] >= maxCombo){
                                maxCombo = sizes[cells[row][col]] + sizes[cells[row + 1][col]];
                            }
                        }
                    }
                }
            }
            for (int col = 0; col < M; col ++){
                for (int row = N - 1; row >= 0; row --){
                    if (!found){
                        if (row == 0 || col == M - 1){
                            if (row == 0 && col != M - 1){
                                if (cells[row][col] != cells[row][col + 1]){
                                    if (sizes[cells[row][col]] + sizes[cells[row][col + 1]] == maxCombo){
                                        wallRemove = String.valueOf(row + 1) + " " + String.valueOf(col + 1) + " E";
                                        found = true;
                                        break;
                                    }
                                }
                            } else if (row != 0 && col == M - 1){
                                if (cells[row][col] != cells[row - 1][col]){
                                    if (sizes[cells[row][col]] + sizes[cells[row - 1][col]] == maxCombo){
                                        wallRemove = String.valueOf(row + 1) + " " + String.valueOf(col + 1) + " N";
                                        found = true;
                                        break;
                                    }
                                }
                            }
                        } else {
                            if (cells[row][col] != cells[row - 1][col]){
                                if (sizes[cells[row][col]] + sizes[cells[row - 1][col]] == maxCombo){
                                    wallRemove = String.valueOf(row + 1) + " " + String.valueOf(col + 1) + " N";
                                    found = true;
                                    break;
                                }
                            } else if (cells[row][col] != cells[row][col + 1]){
                                if (sizes[cells[row][col]] + sizes[cells[row][col + 1]] == maxCombo){
                                    wallRemove = String.valueOf(row + 1) + " " + String.valueOf(col + 1) + " E";
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(sizes));
        System.out.println(numRooms);
        System.out.println(maxSize);
        System.out.println(maxCombo);
        System.out.println(wallRemove);
        out.write(String.valueOf(numRooms) + '\n' + String.valueOf(maxSize) + '\n' + String.valueOf(maxCombo) + '\n' + wallRemove + '\n');
        out.close();
        inp.close();


    }



    public static void floodfill(int row, int col, int count, boolean[][] visited){
        if (!visited[row][col]){
            visited[row][col] = true;
            cells[row][col] = count;
            int noWall = 15 - values[row][col];
            if (noWall >= 8){
                floodfill(row + 1, col, count, visited);
                noWall -= 8;
            }
            if (noWall >= 4){
                floodfill(row, col + 1, count, visited);
                noWall -= 4;
            }
            if (noWall >= 2){
                floodfill(row - 1, col, count, visited);
                noWall -= 2;
            }
            if (noWall >= 1){
                floodfill(row, col - 1, count, visited);
                noWall -= 1;
            }
        }
    }

}
