package low_level_design.maze_runner;

import java.util.*;

public class Task_5 {
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        board[1][0] = 'A';
        board[4][4] = 'G';
        board[4][0] = 'M';
        board[2][3] = 'T';
        board[3][4] = '1';
        board[3][3] = '1';


        int stepsAngel = 0;
        int stepMonster = 0;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == 'A') {
                    stepsAngel = f(i, j, board, new boolean[n][n], n);
                }
            }
        }
        if (stepsAngel != -1) System.out.println(stepsAngel);
        else System.out.println("No Solution");
    }

    public static int f(int row, int col, char[][] board, boolean[][] vis, int n) {
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        int[][] dir = {
                {0, -1}, {-1, 0}, {0, 1}, {1, 0}
        };
        q.add(new Pair(row, col, 0, null));

        while (!q.isEmpty()) {
            Pair node = q.poll();

            for (int[] d : dir) {
                int newRow = node.row + d[0];
                int newCol = node.col + d[1];

                if (newRow < n && newRow >= 0 && newCol >= 0 && newCol < n
                        && board[newRow][newCol] != 'M' && !vis[newRow][newCol] && board[newRow][newCol] != '1') {
                    if (board[newRow][newCol] == 'G') {
                        shortestPath(node, board);
                        return node.steps + 1;
                    }
                    Pair newNode = new Pair(newRow, newCol, node.steps + 1, node);
                    q.add(newNode);
                    vis[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }

    public static void shortestPath(Pair node, char[][] board) {
        List<int[]> path = new ArrayList<>();
        while (node != null) {
            if (board[node.row][node.col] != 'A' || board[node.row][node.col] != 'G')
            path.add(new int[] {node.row, node.col});
            node = node.prev;
        }

        for (int[] a : path) {
            System.out.print(Arrays.toString(a)+", ");
        }

    }
    public static void print(char[][] a) {
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Pair {
    int row;
    int col;
    int steps;
    Pair prev;

    public Pair(int row, int col, int steps, Pair prev) {
        this.row = row;
        this.col = col;
        this.steps = steps;
        this.prev = prev;
    }
}