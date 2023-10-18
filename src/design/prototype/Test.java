package design.prototype;

import java.util.List;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.loadData();

        Prototype prototype1 = (Prototype) prototype.clone();
        Prototype prototype2 = (Prototype) prototype.clone();
        List<String> list = prototype1.getEmps();
        list.add("emp5");
        List<String> list1 = prototype2.getEmps();
        list1.remove("emp1");

        System.out.println("emps List: "+prototype.getEmps());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);

    }
}
