package pl.uims.aoc.twenty.support;

import java.util.Set;

public abstract class AocNode<T> implements Comparable<AocNode<T>> {

    protected T value;

    protected AocNode<T> parent;
    protected Set<? extends AocNode<T>> children;


    public AocNode<T> getParent() {
        return parent;
    }

    public void setParent(AocNode<T> parent) {
        this.parent = parent;
    }

    public abstract Set<? extends AocNode<T>> getChildren();
    public abstract void setChildren(Set<? extends AocNode<T>> children);

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasNoParent() {
        return this.parent == null;
    }
}
