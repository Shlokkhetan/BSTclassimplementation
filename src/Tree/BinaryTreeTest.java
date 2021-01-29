package Tree;

import org.junit.Test;



public class BinaryTreeTest {
    @Test
    public void test(){
        BinaryTree tree = new BinaryTree();

        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(10);
        tree.add(30);
        tree.add(60);
        tree.add(65);
        tree.add(80);
        tree.add(76);
        tree.add(77);
        tree.add(85);
        tree.add(1);
        tree.add(100);
        tree.delete(75);
        tree.traverse();

    }
}
