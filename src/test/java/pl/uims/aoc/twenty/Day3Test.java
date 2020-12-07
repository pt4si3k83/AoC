package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

class Day3Test {

    private char[][] EXAMPLE_DATA = new char[][]{
            {'.','.','#','#','.','.','.','.','.','.','.'},
            {'#','.','.','.','#','.','.','.','#','.','.'},
            {'.','#','.','.','.','.','#','.','.','#','.'},
            {'.','.','#','.','#','.','.','.','#','.','#'},
            {'.','#','.','.','.','#','#','.','.','#','.'},
            {'.','.','#','.','#','#','.','.','.','.','.'},
            {'.','#','.','#','.','#','.','.','.','.','#'},
            {'.','#','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','#','.','.','.','#','.','.','.'},
            {'#','.','.','.','#','#','.','.','.','.','#'},
            {'.','#','.','.','#','.','.','.','#','.','#'}
    };

    private char[][] PUZZLE_DATA = ResourcesService.getDay3PuzzleInput();

    @Test
    public void testPar1Examples() {

        //given
        Day3 day3 = new Day3(EXAMPLE_DATA);

        //when/then
        Assertions.assertEquals(2, day3.countTrees(1, 1));
        Assertions.assertEquals(7, day3.countTrees(3, 1));
        Assertions.assertEquals(3, day3.countTrees(5, 1));
        Assertions.assertEquals(4, day3.countTrees(7, 1));
        Assertions.assertEquals(2, day3.countTrees(1, 2));

    }

    @Test
    public void testPar1Solution() {

        //given
        Day3 day3 = new Day3(PUZZLE_DATA);

        //when
        int result = day3.countTrees(3, 1);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 187
        System.out.printf("Day3 Part1 result is %d%n", result);
    }

    @Test
    public void testPart2Examples() {

        //given
        Day3 day3 = new Day3(EXAMPLE_DATA);

        //when
        long result = day3.countTrees(1, 1);
        result *= day3.countTrees(3, 1);
        result *= day3.countTrees(5, 1);
        result *= day3.countTrees(7, 1);
        result *= day3.countTrees(1, 2);

        //then
        Assertions.assertEquals(336, result);
    }

    @Test
    public void testPart2Solution() {

        //given
        Day3 day3 = new Day3(PUZZLE_DATA);

        //when
        long result = day3.countTrees(1, 1);
        result *= day3.countTrees(3, 1);
        result *= day3.countTrees(5, 1);
        result *= day3.countTrees(7, 1);
        result *= day3.countTrees(1, 2);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 4723283400
        System.out.printf("Day3 Part2 result is %d%n", result);
    }

}