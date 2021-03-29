package com.Algorithms.中科三清;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadJsonFile {

    static List<String> names = new ArrayList<>();

    public static void main(String[] args) {
        String json = readJsonFile("src/main/resources/省市县三级联动.json");
        List<Node> nodes = JSON.parseArray(json, Node.class);
        List<String> nodes1 = getNodes(nodes, 2,null);
        System.out.println(nodes1.toString());
    }

    public static List<String> getNodes(List<Node> nodes, int n,String nodeName) {
        if (nodes == null || n <= 0) {
            return null;
        }

        for (Node node : nodes) {
            if (nodeName == null) {
                nodeName = node.name;
            } else {
               nodeName += ("-"+node.name);
            }

            if (n == 1) {
                names.add(nodeName);
                nodeName = null;
            }
            
            if (node.children.size() > 0 && n > 1) {
                getNodes(node.children,n-1,nodeName);
            }
        }
        return names;
    }



    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static class Node {
        String code;
        String name;
        List<Node> children;

        public Node() {}

        public Node(String code, String name, List<Node> children) {
            this.code = code;
            this.name = name;
            this.children = children;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }
}
