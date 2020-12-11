package pl.uims.aoc.twenty.support;

import java.util.Set;

public class Day10Node extends AocNode<Long> {

    private Long cachedCount = null;

    public Day10Node(final Long value) {
        this.value = value;
    }

    @Override
    public int compareTo(AocNode<Long> o) {
        return 0;
    }

    @Override
    public Set<Day10Node> getChildren() {
        return (Set<Day10Node>) this.children;
    }

    @Override
    public void setChildren(Set<? extends AocNode<Long>> children) {
        children.forEach( c -> c.setParent(this));
        this.children = children;
    }

    public Long countValueDown(final Long value){

        //this 'cachedCount' speeds up all the algo "more than a trillion" times
        if(cachedCount==null) {

            if (children.isEmpty()) {
                cachedCount = 0L;
            } else {
                cachedCount = getChildren().stream().map(n -> n.countValueDown(value)).reduce(Long::sum).orElse(0L)
                            + getChildren().stream().filter(n -> value.equals(n.getValue())).count();
            }
        }
        return cachedCount;
    }
}
