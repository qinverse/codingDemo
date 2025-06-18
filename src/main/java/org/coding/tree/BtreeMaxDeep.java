package org.coding.tree;

import org.coding.node.TreeNode;

import java.util.concurrent.LinkedBlockingDeque;

public class BtreeMaxDeep {

    /**
     * 二叉树最大深度 DFS实现
     * @param treeNode
     * @return
     */
    public int maxDeepDfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
         return Math.max(maxDeepDfs(treeNode.left), maxDeepDfs(treeNode.right)) + 1;
    }

    /**
     * 最大深度 BFS实现
     * @param treeNode
     * @return
     */
    public int MaxDeepBfs(TreeNode treeNode) {
        LinkedBlockingDeque<TreeNode> blockingDeque = new LinkedBlockingDeque<>();
        if (treeNode== null) {
            return 0;
        }
        blockingDeque.addLast(treeNode);
        int level = 0;
        while (!blockingDeque.isEmpty()) {
            int queSize = blockingDeque.size();
            while (queSize > 0) {
                TreeNode tmpNode = blockingDeque.pollFirst();
                queSize--;
                if (tmpNode.left != null) {
                    blockingDeque.addLast(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    blockingDeque.addLast(tmpNode.right);
                }
            }
            level++;
        }

        return level;
    }
}
