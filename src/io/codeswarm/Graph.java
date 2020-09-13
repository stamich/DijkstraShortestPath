package io.codeswarm;

import java.util.List;

public class Graph<T> {

    private final List<Vertex<T>> vertices;
    private final List<Edge<T>> edges;

    public Graph(List<Vertex<T>> vertices, List<Edge<T>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }
}
