package Collections;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map map = new Hashtable();
        List list = new LinkedList();
        Collections.synchronizedList(list);
        Collections.reverse(list);
        Collections.unmodifiableCollection(Collections.EMPTY_LIST);
    }
}