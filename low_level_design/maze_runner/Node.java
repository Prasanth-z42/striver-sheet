package low_level_design.maze_runner;

public class Node {
    int row;
    int col;
    int steps;
    Node(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
