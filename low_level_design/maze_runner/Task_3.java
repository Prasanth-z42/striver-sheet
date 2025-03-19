package low_level_design.maze_runner;

import java.util.LinkedList;
import java.util.Queue;

public class Task_3 {
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        board[1][0] = 'A';
        board[4][4] = 'G';
        board[0][0] = 'M';

        int stepsAngel = 0;
        int stepMonster = 0;

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == 'A') {
                    stepsAngel = f(i, j, board, new boolean[n][n], n);
                } else if (board[i][j] == 'M') {
                    stepMonster = f(i, j, board, new boolean[n][n], n);
                }
            }
        }
        if (stepsAngel >= stepMonster) System.out.println("No solution");
        else System.out.println(stepsAngel);
    }

    public static int f(int row, int col, char[][] board, boolean[][] vis, int n) {
        vis[row][col] = true;
        Queue<Node> q = new LinkedList<>();
        int[][] dir = {
                {0, -1}, {-1, 0}, {0, 1}, {1, 0}
        };
        q.add(new Node(row, col, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int[] d : dir) {
                int newRow = node.row + d[0];
                int newCol = node.col + d[1];

                if (newRow < n && newRow >= 0 && newCol >= 0 && newCol < n && !vis[newRow][newCol]) {
                    if (board[newRow][newCol] == 'G') return node.steps + 1;
                    Node newNode = new Node(newRow, newCol, node.steps + 1);
                    q.add(newNode);
                    vis[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}
