package java8features;

@FunctionalInterface
interface Interface1 {
    void method1(String str);

    default void log(String str) {
        System.out.println("I1 logging::" + str);
    }
    default void log4(String str) {
        System.out.println("I1 logging::" + str);
    }
    static void print(String str) {
        System.out.println("Printing::" + str);
    }
    // cannot override the deault method from the Object class
//    default String toString(){
//        return "i1";
//    }

}

@FunctionalInterface
interface Interface2 {
    void method2();

    default void log(String str) {
        System.out.println("I2 logging::" + str);
    }

}

public class DefaultAndStaticMethods implements Interface1, Interface2 {
    @Override
    public void method1(String str) {

    }

    @Override
    public void method2() {

    }

    // class will not complie without having its own implementation
    @Override
    public void log(String str) {
        System.out.println("Main class logging::" + str);
        Interface1.print(str);
        Interface1.super.log(str);
    }

    public static void main(String[] args) {
        DefaultAndStaticMethods defaultAndStaticMethods = new DefaultAndStaticMethods();
        defaultAndStaticMethods.log("hello");


        //Lambda expressions
        Interface1 i1 = (s) -> System.out.println(s);
        i1.method1("Test");
    }

    //Interfaces are not allowed to object class default method
}