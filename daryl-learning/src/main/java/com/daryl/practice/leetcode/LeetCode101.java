package com.daryl.practice.leetcode;

import org.junit.Test;

/**
 * ClassDescription
 *
 * @author wl
 * @create 2022-04-07
 */
public class LeetCode101 {

    @Test
    public boolean isSymmetric(TreeNode root) {
        TreeNode node = root;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        while(node.left != null && node.right != null){

        }
        return false;
    }

    public boolean hasLeaf(TreeNode root, StringBuilder sb) {
        if (root.left != null) {
            sb.append(root.left.val);
        }
        if (root.right != null) {
            sb.append(root.right.val);
        }
        return false;
    }

    static class TreeNode {

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
}


