package thread;

public class ThreadClass extends Thread{

    @Override
    public void run() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();
    }

}
