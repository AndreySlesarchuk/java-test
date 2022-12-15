package by.atmm.java.__early.__topics.threads;

public class Main {
    public static void main(String[] args) {
        new MyFirstTread().start();
        new MySecondTread().start();
    }
}

class MyFirstTread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " *");
        }
    }

}

class MySecondTread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " !");
        }
    }

}