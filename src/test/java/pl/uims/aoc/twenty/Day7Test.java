package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.*;


class Day7Test {

    final List<String> EXAMPLE_INPUT = Arrays.asList(
        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
        "bright white bags contain 1 shiny gold bag.",
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
        "faded blue bags contain no other bags.",
        "dotted black bags contain no other bags."
    );

    final static String PUZZLE_BAG_COLOR = "shiny gold";

    @Test
    public void testPart1Example() {

        //given
        Day7 day7 = new Day7(EXAMPLE_INPUT);

        //when
        long result = day7.countColor(PUZZLE_BAG_COLOR);

        //then
        Assertions.assertEquals(4, result);
    }

    @Test
    public void testPart1Solution() {

        //given
        Day7 day7 = new Day7(ResourcesService.getDay7PuzzleInput());

        //when
        long result = day7.countColor(PUZZLE_BAG_COLOR);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 128
        System.out.printf("Day7 Part1 result is %d%n", result);
    }

    @Test
    public void testPart2Example() {

        //given
        Day7 day7 = new Day7(EXAMPLE_INPUT);

        //when
        long result = day7.countBagsInsideColor(PUZZLE_BAG_COLOR);

        //then
        Assertions.assertEquals(32, result);
    }

    @Test
    public void testPart2Solution() {

        //given
        Day7 day7 = new Day7(ResourcesService.getDay7PuzzleInput());

        //when
        long result = day7.countBagsInsideColor(PUZZLE_BAG_COLOR);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 20189
        System.out.printf("Day7 Part2 result is %d%n", result);
    }
}