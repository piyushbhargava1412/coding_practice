package main.java.leetcode.easy;

import java.util.*;

public class Graph {

    public Map<Integer, Set<Integer>> adjacentList;
    public Stack<Integer> stack;
    public Set<Integer> visited;

    public Graph() {
        adjacentList = new HashMap<>();
    }

    public void addNode(int node) {
        adjacentList.putIfAbsent(node, new HashSet<>());
    }

    public void addEdge(int node1, int node2) {
        adjacentList.computeIfAbsent(node1, k -> new HashSet<>()).add(node2);
        adjacentList.computeIfAbsent(node2, k -> new HashSet<>()).add(node1);
    }

    public Set<Integer> getAdjacent(int vertex) {
        return adjacentList.get(vertex);
    }

    public void printGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : adjacentList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            {
                for (Integer i : entry.getValue()) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    public void DFS(int node) {
        stack = new Stack<>();
        visited = new HashSet<>();
        stack.addAll(adjacentList.get(node));
        visited.add(node);
        System.out.print(node + " , ");
        depthTraversal(stack, visited);
    }

    private void depthTraversal(Stack<Integer> stack, Set<Integer> visited) {
        if (stack.isEmpty())
            return;
        Integer currentNode = stack.pop();
        if (!visited.contains(currentNode)) {
            visited.add(currentNode);
            System.out.print(currentNode + " , ");
        }

        for (int i : adjacentList.get(currentNode)) {
            if (!visited.contains(i) && currentNode != i)
                stack.push(i);
        }
        depthTraversal(stack, visited);
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
//        // Add nodes
//        graph.addNode(1);
//        graph.addNode(2);
//        graph.addNode(3);
//        graph.addNode(4);
//
//        // Add edges
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(3, 4);

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.DFS(2);

//        int[][] edges = new int[][]{{1,2},{1,3},{2,4},{3,4},{1,2}};
//        for(int i=0;i< edges.length;i++){
//            int vertex = edges[i][0];
//            int edge = edges[i][1];
//            graph.addNode(vertex);
//            graph.addEdge(vertex,edge);
//        }


//        graph.printGraph();

    }
}


