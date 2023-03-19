package lab2;

class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Demo Thread"); // main child
        System.out.println("Child thread: " + t);
        t.start();
    }

    public void run() {
        try {

            for (int i = 0; i < 4; i++) {
                System.out.println("waiting:");
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }

        System.out.println("Thank you dear customer");
    }
}

public class proj1 {
    void message() {
        System.out.println("hey! this is from a different file within the same package");
    }
}
