package design.creational.singleton;

public class Test {

    public static void main(String[] args) {
        EagerIntializedSingleton first =  EagerIntializedSingleton.getInstance();
        EagerIntializedSingleton second =  EagerIntializedSingleton.getInstance();
        System.out.println("first"+first);
        System.out.println("second"+second);
    }
}