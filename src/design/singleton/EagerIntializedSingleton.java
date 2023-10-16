package design.singleton;

public class EagerIntializedSingleton {
    private  static  final EagerIntializedSingleton eagerIntializedSingleton = new EagerIntializedSingleton();
//here there is no option for exception handling
    private EagerIntializedSingleton(){}

    public static  EagerIntializedSingleton getInstance(){
        return eagerIntializedSingleton;
    }
}
