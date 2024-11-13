package java8features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethod {

    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();

        for (int i= 0; i< 10;i++) myList.add(i);

        //traversing through the list using iterator
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println("Iterator value::"+i);
        }

        //Traversing through foreach method using the amonymous inner class
        myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Foreach anonymous inner class::"+ integer);
            }
        });

        //traversing through for each using the consumer Impl
        MyConsumer consumer = new MyConsumer();
        myList.forEach(consumer);
    }
}

class MyConsumer implements Consumer<Integer>{

    @Override
    public void accept(Integer integer) {
        System.out.println("Consumer Impl value::"+ integer);
    }
}