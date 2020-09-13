package io.codeswarm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Let's try a graph containing numerical vertices
        var v0 = new Vertex<>(1L, 10);
        var v1 = new Vertex<>(2L, 20);
        var v2 = new Vertex<>(3L, 25);
        var v3 = new Vertex<>(4L, 30);
        var v4 = new Vertex<>(5L, 35);
        var v5 = new Vertex<>(6L, 40);
        var v6 = new Vertex<>(7L, 15);

        List<Vertex<Integer>> vertices = new ArrayList<>();
        Collections.addAll(vertices, v0, v1, v2, v3, v4, v5, v6);

        var e0 = new Edge<>(1L, v0, v1, 2);
        var e1 = new Edge<>(2L, v1, v2, 2);
        var e2 = new Edge<>(3L, v2, v3, 2);
        var e3 = new Edge<>(4L, v0, v4, 2);
        var e4 = new Edge<>(5L, v4, v6, 1);

        List<Edge<Integer>> edges = new ArrayList<>();
        Collections.addAll(edges, e0, e1, e2, e3, e4);

        var numericalGraph = new Graph<>(vertices, edges);

        DijkstraShortestPath<Integer> dst = new DijkstraShortestPath<>(numericalGraph);

        dst.markBeginning(v0);

        //For existing path
        LinkedList<Vertex<Integer>> result0 = dst.getShortestPath(v3);
        System.out.println(result0.toString()+"\n");

        LinkedList<Vertex<Integer>> result1 = dst.getShortestPath(v6);
        System.out.println(result1.toString()+"\n");

        //When the path is null
        LinkedList<Vertex<Integer>> result2 = dst.getShortestPath(v5);
        System.out.println(result2.toString()+"\n");

        //
        // Now another graph constructed from names:
        //
        var vs0 = new Vertex<>(1L, "Paris");
        var vs1 = new Vertex<>(2L, "London");
        var vs2 = new Vertex<>(3L, "Madrid");
        var vs3 = new Vertex<>(4L, "Gibraltar");
        var vs4 = new Vertex<>(5L, "Casablanca");
        var vs5 = new Vertex<>(6L, "New York");

        List<Vertex<String>> vertexList = new ArrayList<>();
        Collections.addAll(vertexList, vs0, vs1, vs2, vs3, vs4, vs5);

        var es0 = new Edge<>(1L, vs0, vs1, 1);
        var es1 = new Edge<>(2L, vs1, vs5, 5);
        var es2 = new Edge<>(3L, vs0, vs2, 1);
        var es3 = new Edge<>(4L, vs2, vs3, 1);
        var es4 = new Edge<>(5L, vs3, vs4, 1);

        List<Edge<String>> edgeList = new ArrayList<>();
        Collections.addAll(edgeList, es0, es1, es2, es3, es4);

        var geographicalGraph = new Graph<>(vertexList, edgeList);
        DijkstraShortestPath<String> dst1 = new DijkstraShortestPath<>(geographicalGraph);

        dst1.markBeginning(vs0);

        LinkedList<Vertex<String>> result3 = dst1.getShortestPath(vs5);
        System.out.println(result3+"\n");

        LinkedList<Vertex<String>> result4 = dst1.getShortestPath(vs4);
        System.out.println(result4+"\n");

        LinkedList<Vertex<String>> result5 = dst1.getShortestPath(vs0);
        System.out.println(result5);

    }
}
