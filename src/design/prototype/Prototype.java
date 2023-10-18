package design.prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype implements Cloneable{
    private List<String> emps;

    public List<String> getEmps() {
        return emps;
    }

    public Prototype(){
        this.emps = new ArrayList<>();
    }

    public Prototype(List<String> emps){
        this.emps = emps;
    }

    public void loadData(){
        emps.add("emp1");
        emps.add("emp2");
        emps.add("emp3");
        emps.add("emp4");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        temp.addAll(emps);
        return new Prototype(temp);
    }
}
