package inflearn.stringarray.sec4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //이진트리를 트리 레벨에 따라 리스트에 담기 (큐 사용)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()){
            int size = que.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0){
                TreeNode node = que.poll();
                System.out.println("node.val = " + node.val);
                level.add(node.val);
                if (node.left != null){
                    que.add(node.left);
                }
                if (node.right != null){
                    que.add(node.right);
                }
                size--;
            }

            result.add(level);
        }
        return result;
    }

    //bfs
    public List<List<Integer>> levelOrderBfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelbfs(result, root, 0);
        return result;
    }

    private void levelbfs(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null) return;
        if (height >= result.size()){
            result.add(new LinkedList<>());
        }
        result.get(height).add(root.val);
        levelbfs(result, root.left, height+1);
        levelbfs(result, root.right, height+1);
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal b= new BinaryTreeLevelOrderTraversal();
        System.out.println(b.levelOrder(root));
        System.out.println(b.levelOrderBfs(root));
    }
}


