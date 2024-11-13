package series.Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NaryNode<E> {
    E data;
    ArrayList<NaryNode> child;

    public NaryNode(E data) {
        this.data = data;
        child = new ArrayList<>();
    }
}

public class NaryTraversal {
    public static void main(String[] args) {
        NaryNode<Integer> root = new NaryNode(1);
        root.child.add(new NaryNode(2));
        root.child.add(new NaryNode(3));
        root.child.add(new NaryNode(4));

        root.child.get(0).child.add(new NaryNode(8));
        root.child.get(0).child.add(new NaryNode(9));
        root.child.get(1).child.add(new NaryNode(8));
        root.child.get(1).child.add(new NaryNode(9));
        root.child.get(2).child.add(new NaryNode(8));
        root.child.get(2).child.add(new NaryNode(9));

        BFStraversal(root);
        LOTBFStraversal(root);
    }

    private static void BFStraversal(NaryNode<Integer> node) {
        Queue<NaryNode<Integer>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            NaryNode<Integer> child = queue.poll();
            System.out.println(child.data);
            for (NaryNode n : child.child) {
                if (n != null) {
                    queue.offer(n);
                }
            }
        }
    }


    private static void LOTBFStraversal(NaryNode<Integer> node) {
        List<List<Integer>> res = new ArrayList<>();
        if(node==null){
            return;
        }
        Queue<NaryNode<Integer>> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            while (size > 0) {
                NaryNode<Integer> child = queue.poll();
                levelList.add(child.data);
                for (NaryNode n : child.child) {
                    if (n != null) {
                        queue.offer(n);
                    }
                }
                size--;
            }
            res.add(levelList);
        }

        System.out.println(res);
    }

}
