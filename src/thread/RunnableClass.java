package thread;

public class RunnableClass implements Runnable{

    @Override
    public void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {
        RunnableClass runnableClass = new RunnableClass();
        runnableClass.run();
    }
}
