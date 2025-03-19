package com.zoho.level3.snakegame;
import java.util.Scanner;
public class SnakeGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SnakeLogic sl = new SnakeLogic();
        while (true) {
            System.out.println("Enter your choice ");
            String str = sc.next();
            switch (str) {
                case "L":
                    sl.moveSnake(0,-1);
                    break;
                case "U":
                    sl.moveSnake(-1,0);
                    break;
                case "R":
                    sl.moveSnake(0,1);
                    break;
                case "D":
                    sl.moveSnake(1,0);
                default:
                    System.out.println("Invalid options");
            }
        }
    }
}
