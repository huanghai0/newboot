package com.example.newboot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class TreeNode {
    /**
     * 节点ID
     */
    private String nodeId;

    /**
     * 分支ID
     */
    private String branchId;

    /**
     * 孩子节点
     */
    private List<TreeNode> children;

    /**
     * 父节点
     */
    @JSONField(serialize = false)
    private TreeNode parentNode;

    @Override
    public String toString() {
        return "TreeNode{" +
                "nodeId='" + nodeId + '\'' +
                ", branchId='" + branchId + '\'' +
                ", children=" + children +
                '}';
    }


}

