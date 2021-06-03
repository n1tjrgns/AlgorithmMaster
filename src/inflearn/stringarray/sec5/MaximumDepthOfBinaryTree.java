package inflearn.stringarray.sec5;


import java.util.Stack;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //루트 노드가 있을 때 가장 깊은 깊이를 출력하는 문제
    //재귀 방식
    public int maxDepthRec(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxDepthRec(root.left);
        int rightMax = maxDepthRec(root.right);

        return Math.max(leftMax, rightMax)+1;
    }

    //dfs 방식
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int max = 1; //깊이는 1부터 시작
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>(); //각 마지막 노드 별 최대 깊이를 저장해야함

        nodes.push(root);
        depths.push(1);

        while (!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            int depth = depths.pop();

            //노드의 자식이 전부 없다면 더 이상 탐색 할 필요가 없으니 max값 갱신
            if (node.left == null && node.right == null){
                max = Math.max(max, depth);
            }

            if (node.left != null) {
                nodes.push(node.left);
                depths.push(depth+1);
                System.out.println("leftdepths.peek() = " + depths.peek());
                System.out.println("leftdepths = " + depths);
            }

            if (node.right != null) {
                nodes.push(node.right);
                depths.push(depth+1);
                System.out.println("rightdepths.peek() = " + depths.peek());
                System.out.println("rightdepths = " + depths);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(m.maxDepth(root));
        System.out.println(m.maxDepthRec(root));
    }
}
