package java_solutions.multi_threading;

public class ThreadDemo {
    public static void main(String[] args) {
        Hi hi = new Hi();  // extends thread class
        Hello hello = new Hello(); // implements runnable interface

        Thread t1 = new Thread(hello);

        hi.start();  // anonymous
        try {
            Thread.sleep(10);
        } catch (Exception ignored) {

        }
        t1.start();
    }
}

// using Thread class
class Hi extends Thread {

    public void run() {

        for (int i = 0; i<5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(1000);
            } catch(Exception ignored) {

            }
        }
    }
}

// using Runnable interface
class Hello implements Runnable {

    public void run() {

        for (int i = 0; i<5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch(Exception ignored) {

            }
        }
    }
}