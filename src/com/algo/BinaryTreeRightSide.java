package src.com.algo;

import java.util.*;

public class BinaryTreeRightSide {

    LinkedList<Integer> list = new LinkedList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        
        return traverseRight(root.right, list);
    }

    public List<Integer> traverseRight(TreeNode node, List<Integer> list){
        if(node.right==null){
            return list;
        }
        list.add(node.val);
        list = traverseRight(node.right, list);
        return list;
        
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new );

    }
    
}
