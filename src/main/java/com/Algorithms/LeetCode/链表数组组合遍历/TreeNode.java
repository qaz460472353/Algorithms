package com.Algorithms.LeetCode.链表数组组合遍历;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class TreeNode {

    /**
     * [
     *   level0_0/									----------node []
     *   	level0_0/level1_0/						----------node.next []
     *   		level0_0/level1_0/level2_0          ----------node.next.next []
     *   		level0_0/level1_0/level2_1
     *   		level0_0/level1_0/level2_2
     *   	level0_0/level1_1/
     *   		level0_0/level1_1/level2_0
     *   		level0_0/level1_1/level2_1
     *   		level0_0/level1_1/level2_2
     *   level0_1/
     *
     * ]
     */
    public static Node getNodes(List<Node> nodes, String path) {
        if (nodes == null || path == null) {
            return null;
        }
        Node result = new Node();
        for (Node node : nodes) {
            if (path.equals(node.path)) {
                result = node;
                return result;
            }
            if (node.children.size() > 0) {
                result = getNodes(node.children,path);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String nodes="[\n" +
                "    {\n" +
                "        \"path\":\"level0_0/\",\n" +
                "        \"value\":\"value\",\n" +
                "        \"children\":[\n" +
                "            {\n" +
                "                \"path\":\"level0_0/level1_0/\",\n" +
                "                \"value\":\"value\",\n" +
                "                \"children\":[\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_0/level2_0\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_0/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_0/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"path\":\"level0_0/level1_1/\",\n" +
                "                \"value\":\"value\",\n" +
                "                \"children\":[\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_1/level2_0\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_1/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"path\":\"level0_0/level1_1/level2_1\",\n" +
                "                        \"value\":\"value\",\n" +
                "                        \"children\":[\n" +
                "\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"path\":\"level0_1/\",\n" +
                "        \"value\":\"avaluearg\",\n" +
                "        \"children\":[\n" +
                "\n" +
                "        ]\n" +
                "    }\n" +
                "]";
        List<Node> nodes1 = JSON.parseArray(nodes, Node.class);
        Node nodes2 = getNodes(nodes1, "level0_0/level1_1/level2_0");
        String s = JSON.toJSONString(nodes2);
        System.out.println(s);
    }
}
