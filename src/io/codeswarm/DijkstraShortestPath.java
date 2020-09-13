package io.codeswarm;

import java.util.*;

public class DijkstraShortestPath<T> {

    private final List<Vertex<T>> vertices;
    private final List<Edge<T>> edges;
    private Set<Vertex<T>> settledNodes;
    private Set<Vertex<T>> unsettledNodes;
    private Map<Vertex<T>, Vertex<T>> predecessors;
    private Map<Vertex<T>, Long> distance;

    public DijkstraShortestPath(Graph<T> graph) {
        this.vertices = new ArrayList<>(graph.getVertices());
        this.edges = new ArrayList<>(graph.getEdges());
    }

    /**
     * This method marks the beginning of path
     * @param source
     */
    public void markBeginning(Vertex<T> source) {
        settledNodes = new HashSet<>();
        unsettledNodes = new HashSet<>();
        predecessors = new HashMap<>();
        distance = new HashMap<>();

        distance.put(source, 0L);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            Vertex<T> vertex = getMinimum(unsettledNodes);
            settledNodes.add(vertex);
            unsettledNodes.remove(vertex);
            findMinimalDistances(vertex);
        }
    }

    /**
     * This method returns the path from the source to the selected target or
     * null if no path exists
     * @param target
     * @return
     */
    public LinkedList<Vertex<T>> getShortestPath(Vertex<T> target) {
        LinkedList<Vertex<T>> path = new LinkedList<>();
        Vertex<T> step = target;

        // In this case path is null
        if (predecessors.get(step) == null) {
            System.out.println("In this case the path does not exist.");
            return new LinkedList<>();
        }

        path.add(step);

        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }

        // Put it into the correct order
        System.out.println("The shortest path looks like:");
        Collections.reverse(path);
        return path;
    }

    private void findMinimalDistances(Vertex<T> node) {
        List<Vertex<T>> adjacentNodes = getNeighbors(node);
        for (Vertex<T> target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unsettledNodes.add(target);
            }
        }
    }

    private int getDistance(Vertex<T> node, Vertex<T> target) {
        for (Edge<T> edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex<T>> getNeighbors(Vertex<T> node) {
        List<Vertex<T>> neighbors = new ArrayList<>();
        for (Edge<T> edge : edges) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex<T> getMinimum(Set<Vertex<T>> vertexes) {
        Vertex<T> minimum = null;
        for (Vertex<T> vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex<T> vertex) {
        return settledNodes.contains(vertex);
    }

    private long getShortestDistance(Vertex<T> destination) {
        Long d = distance.get(destination);
        return Objects.requireNonNullElse(d, Long.MAX_VALUE);
    }
}
