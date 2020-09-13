package io.codeswarm;

public class Vertex<T> {

    private final Long id;
    private final T value;

    public Vertex(Long id, T value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return id.equals(vertex.id) &&
                value.equals(vertex.value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        var result = 1;
        return prime * result + ((id == null) ? 0 : id.hashCode());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
