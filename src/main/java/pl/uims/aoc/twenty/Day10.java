package pl.uims.aoc.twenty;

import pl.uims.aoc.twenty.support.Day10Node;

import java.util.List;
import java.util.stream.Collectors;

public class Day10 {

    private final List<Long> data;

    public Day10(List<Long> data) {
        this.data = data;
    }

    private Day10Node createNodesTree(final List<Long> inputDataLines) {

        //creating all the nodes
        final List<Day10Node> nodeList = inputDataLines.stream().map(Day10Node::new).collect(Collectors.toList());

        //creating root node
        Day10Node rootNode = new Day10Node(0L);
        nodeList.add(rootNode);

        //connecting nodes
        for (int i = 0; i < nodeList.size(); i++) {
            Day10Node node =  nodeList.get(i);
            node.setChildren(inputDataLines.stream()
                    .filter(n -> isBetween(node.getValue(), node.getValue() + 3, n))
                    .map(n -> nodeList.stream()
                            .filter( f -> f.getValue().equals(n))
                            .findFirst().get()).collect(Collectors.toSet()));
        }

        return rootNode;
    }

    public Long solvePart2(final long value) {
        return createNodesTree(data).countValueDown(value);
    }

    public Integer solvePart1() {

        List<Long> sorted = data.stream().sorted().collect(Collectors.toList());

        //initial values - there is always one "3" diff at the end
        int m1 = countDiff(1, 0, sorted.get(0));
        int m3 = 1;

        for (int i = 1; i < sorted.size(); i++) {
            m1 += countDiff(1, sorted.get(i-1), sorted.get(i));
            m3 += countDiff(3, sorted.get(i-1), sorted.get(i));
        }

        return m1 * m3;
    }

    private boolean isBetween(final long rangeFrom, final long rangeTo, final long value){
        return rangeFrom < value && value <= rangeTo;
    }

    private Integer countDiff(final int diffValue, final long op1, final long op2) {
        return op2 - op1 == diffValue ? 1 : 0;
    }
}
