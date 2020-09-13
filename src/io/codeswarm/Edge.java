package io.codeswarm;

public class Edge<T> {

    private final Long id;
    private final Vertex<T> source;
    private final Vertex<T> destination;
    private final Integer weight;

    public Edge(Long id, Vertex<T> source, Vertex<T> destination, Integer weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source.toString() + " " + destination.toString();
    }
}
