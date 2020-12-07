package pl.uims.aoc.twenty;

import java.util.*;
import static pl.uims.aoc.twenty.support.AocConstants.*;

import pl.uims.aoc.twenty.support.Day7Node;

public class Day7 {

    private static final String COLOR_CHILDREN_SEPARATOR = "contain";
    private static final String BAG_WITH_NO_CHILDREN_LINE = "bags contain no other bags.";
    private static final String BAG_WORD = "bag";
    private static final String BAGS_WORD = "bags";

    private final List<Day7Node> nodes;

    public Day7(final List<String> inputDataLines){
        nodes = createNodes(inputDataLines);
    }

    private List<Day7Node> createNodes(final List<String> inputDataLines) {

        List<Day7Node> nodeList = new ArrayList<>();

        for(String line : inputDataLines){

            Day7Node node = new Day7Node(getColorFromLine(line));

            if(!line.endsWith(BAG_WITH_NO_CHILDREN_LINE)){
                node.setContent(getNodesFromLine(line));
            }

            if(!nodeList.contains(node)){
                nodeList.add(node);
            }
        }

        return nodeList;
    }

    private String getColorFromLine(final String line){
        return String.join(SPACE, Arrays.copyOfRange(line.split(SPACE), 0, 2));
    }

    public long countColor(final String color){
        return nodes.stream().filter( node -> node.containsColorDown(color, nodes)).count();
    }

    public long countBagsInsideColor(final String color){
        return nodes.stream()
                .filter( node -> node.hasNoParent() && node.getColor().equals(color))
                .findFirst().orElse(Day7Node.EMPTY_NODE)
                .countBagsInside(nodes);
    }

    private List<Day7Node> getNodesFromLine(final String line) {

        String parsedLine = line.substring(line.indexOf(COLOR_CHILDREN_SEPARATOR) + COLOR_CHILDREN_SEPARATOR.length())
                .replaceAll(REGEX_DOT, EMPTY)
                .replaceAll(BAGS_WORD, EMPTY)
                .replaceAll(BAG_WORD, EMPTY)
                .replaceAll( SPACE + COMMA, COMMA)
                .replaceAll( COMMA + SPACE, COMMA)
                .trim();

        List<Day7Node> childNodes = new ArrayList<>();

        for(String bag : parsedLine.split(COMMA)){
            int capacity = Integer.parseInt(bag.substring(0, bag.indexOf(SPACE) ).trim());
            String color = bag.substring(bag.indexOf(SPACE)).trim();

            Day7Node node = new Day7Node(color);
            node.setCapacity(capacity);

            childNodes.add(node);
        }


        return childNodes;
    }

}
