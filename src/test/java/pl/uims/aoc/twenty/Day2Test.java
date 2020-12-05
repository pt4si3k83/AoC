package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.List;


class Day2Test {

    final List<String> EXAMPLE_DATA = List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");

    final List<String> PUZZLE_DATA = ResourcesService.getDay2PuzzleInput();

    @Test
    public void testPart1Example1() {

        //when
        long result = new Day2(EXAMPLE_DATA).calculatePart1();

        //then
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testPart1Solution() {

        //when
        long result = new Day2(PUZZLE_DATA).calculatePart1();

        //then
        Assertions.assertTrue(result > 0);

        System.out.println(String.format("Day2 Part1 result is %d", result));
    }

    @Test
    public void testPart2Example1() {

        //when
        long result = new Day2(EXAMPLE_DATA).calculatePart2();

        //then
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testPart2Solution() {

        //when
        long result = new Day2(PUZZLE_DATA).calculatePart2();

        //then
        Assertions.assertTrue(result > 0);

        System.out.println(String.format("Day2 Part2 result is %d", result));
    }

}