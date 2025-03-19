package com.zoho.level3.snakegame;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class SnakeLogic {
    private int row;
    private int col;
    private final char EMPTY = '.';
    private final char FOOD = '*';
    private final char SNAKE_HEAD = 'O';
    private final char SNAKE_BODY = 'o';
    private int[] headPos;
    private Queue<int[]> snakeBody;
    private char[][] grid;
    public SnakeLogic() {
        this.row = 5;
        this.col = 5;
        this.grid = new char[5][5];
        this.snakeBody = new LinkedList<>();
        initialize();
        placeFood();
        printBoard();
    }

    private void initialize() {
        // Initialize the grid and snake position
        for (char[] ch : grid) {
            Arrays.fill(ch,EMPTY);
        }
        headPos = new int[]{row/2,col/2};
        grid[headPos[0]][headPos[1]] = SNAKE_HEAD;
        snakeBody.add(new int[]{headPos[0],headPos[1]});
    }

    private void placeFood() {
        Random random = new Random();
        int x,y;
        do {
            x = random.nextInt();
            y = random.nextInt();
        } while (grid[x][y] != EMPTY);
        grid[x][y] = FOOD;
    }

    public boolean moveSnake(int row, int col) {
        int newRow = headPos[0] + row;
        int newCol = headPos[1] + col;

        // check if the new position is available?
        if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col)
            return true;

        if (grid[newRow][newCol] == FOOD) {
            snakeBody.add(new int[] {newRow, newCol});
            grid[newRow][newCol] = SNAKE_HEAD;
            headPos = new int[]{newRow, newCol};
            placeFood();
        } else {
            snakeBody.add(new int[] {newRow, newCol});
            grid[newRow][newCol] = SNAKE_HEAD;
            grid[headPos[0]][headPos[1]] = SNAKE_BODY;
            headPos = new int[] {newRow, newCol};
            int[] tail = snakeBody.poll();
            // Remove the tail segment
            grid[tail[0]][tail[1]] = EMPTY;
        }
        printBoard();
        return false;
    }

    void printBoard() {
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
