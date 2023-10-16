package design.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {


    public static void main(String[] args) {
        EagerIntializedSingleton first = EagerIntializedSingleton.getInstance();
        EagerIntializedSingleton second = null;
        try {
            Constructor[] constructors = EagerIntializedSingleton.class.getDeclaredConstructors();
            for (Constructor c : constructors) {
                c.setAccessible(true);
                second = (EagerIntializedSingleton)c.newInstance();
                break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("first"+ first);
        System.out.println("second"+second);
    }
}
