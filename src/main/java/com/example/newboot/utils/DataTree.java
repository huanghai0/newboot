package com.example.newboot.utils;

import com.example.newboot.entity.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class DataTree {


    /**
     * 解析决策树结构，获取从根节点到叶子节点的所有路径
     *
     * @param tree      树结构
     * @param stack     队列，用于解析树结构时的临时存储节点
     * @param nodeLocus 根节点到叶子节点的路径集合
     */
    public static void iterator(TreeNode tree, Deque<String> stack, Map<String, List<String>> nodeLocus) {
        stack.addLast(tree.getNodeId());
        if (CollectionUtils.isEmpty(tree.getChildren())) {
            // 如果children为空，代表当前节点为叶子节点
            List<String> nodes = new ArrayList<>(stack);
            nodeLocus.put(tree.getNodeId(), nodes);
            return;
        }
        // 如果不是叶子节点，进行递归，遍历该节点下的子节点。
        List<TreeNode> children = tree.getChildren();
        for (TreeNode child : children) {
            iterator(child, stack, nodeLocus);
            stack.pollLast();
        }
    }
}
