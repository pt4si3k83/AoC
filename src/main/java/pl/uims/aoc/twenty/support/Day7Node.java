package pl.uims.aoc.twenty.support;

import java.util.ArrayList;
import java.util.List;

public class Day7Node implements Comparable<Day7Node> {

    public static final Day7Node EMPTY_NODE = new Day7Node(AocConstants.EMPTY);

    private final String color;
    private int capacity;
    private Day7Node parent;
    private List<Day7Node> content;

    public Day7Node(String color) {
        this.color = color;
        this.capacity = 0;
        this.parent = null;
        this.content = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(Day7Node other) {
        return this.color.compareTo(other.getColor());
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setContent(List<Day7Node> content) {
        content.forEach( node -> node.setParent(this));
        this.content = content;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean containsColorDown(final String colorToFind, final List<Day7Node> nodes){

        if(content.isEmpty()){
            return false;
        } else {
            return content.stream().anyMatch( n -> colorToFind.equals(n.getColor()) ||
                    nodes.stream().filter( n1 -> n1.hasNoParent() && n1.getColor().equals(n.getColor()))
                            .findFirst().orElse(EMPTY_NODE).containsColorDown(colorToFind, nodes)
                    );
        }
    }

    public long countBagsInside(final List<Day7Node> nodes) {
        return content.isEmpty() ? this.capacity
                : content.stream().map( n -> n.getCapacity() * nodes.stream().filter(n1 -> n1.hasNoParent() && n1.getColor().equals(n.getColor()))
                                                                             .findFirst().orElse(EMPTY_NODE).countBagsInside(nodes) + n.getCapacity()
                                      ).reduce(Long::sum).orElse(AocConstants.NOT_FOUND);
    }

    public void setParent(Day7Node parent) {
        this.parent = parent;
    }

    public boolean hasNoParent() {
        return this.parent == null;
    }

}
