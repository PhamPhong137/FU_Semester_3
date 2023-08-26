
import Tree.MyTree;

public class Main {

    public static void main(String[] args) {
        MyTree my = new MyTree();
        my.add(30);
        my.add(15);
        my.add(31);
        my.add(11);
        my.add(16);
        my.add(33);
        my.add(9);
        my.add(12);
        my.add(32);
        my.add(17);
        my.add(18);
        my.add(19);
        my.add(20);
        System.out.println(my.getMaxSum());
    }
}
