package design.creational.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}

    private static final class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }


}