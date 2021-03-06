package com.vaani.algo.ds.tree.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Get all the root-to-leaf paths of a binary tree.
 */
public class GetBinaryTreePaths {

    public List<List<Integer>> getAllPaths(TreeNode node) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        find(node, cur, res);
        return res;
    }

    private void find(TreeNode node, List<Integer> cur, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            List<Integer> copy = new ArrayList<Integer>(cur);
            copy.add(node.val);
            res.add(copy);
        } else {
            cur.add(node.val);
            if (node.left != null) {
                find(node.left, cur, res);
            }
            if (node.right != null) {
                find(node.right, cur, res);
            }
            cur.remove(cur.size() - 1);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
