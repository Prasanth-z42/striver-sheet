package java_solutions.multi_threading;

public class Anonymous_And_Lambda_Expression {
    public static void main(String[] args) {
        // Anonymous class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<5; i++) {
                    System.out.println("HI");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ignored) {

                    }
                }
            }
        };

        Thread t3 = new Thread(() -> {
            for (int i = 0; i<5; i++) {
                System.out.println("hi");
            }
        });

        // Lambda Expression
        Runnable r2 = () -> {
                for (int i = 0; i<5; i++) {
                    System.out.println("Hello");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ignored) {

                    }
                }
            };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t3.start();

        try {
            Thread.sleep(10);
        } catch (Exception ignored) {

        }

        t2.start();
    }
}
