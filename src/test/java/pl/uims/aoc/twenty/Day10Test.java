package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Day10Test {

    private final static List<Long> EXAMPLE_DATA = Stream.of(16,
            10,
            15,
            5,
            1,
            11,
            7,
            19,
            6,
            12,
            4
    ).map(Long::new).collect(Collectors.toList());

    private final static List<Long> EXAMPLE_DATA2 = Stream.of(28,
            33,
            18,
            42,
            31,
            14,
            46,
            20,
            48,
            47,
            24,
            23,
            49,
            45,
            19,
            38,
            39,
            11,
            1,
            32,
            25,
            35,
            8,
            17,
            7,
            9,
            4,
            2,
            34,
            10,
            3
    ).map(Long::new).collect(Collectors.toList());

    @Test
    public void testPart1Example1() {

        //given
        Day10 day10 = new Day10(EXAMPLE_DATA);

        //when
        Integer result = day10.solvePart1();

        //then
        Assertions.assertEquals(35, result);
    }

    @Test
    public void testPart1Example2() {

        //given
        Day10 day10 = new Day10(EXAMPLE_DATA2);

        //when
        Integer result = day10.solvePart1();

        //then
        Assertions.assertEquals(220, result);
    }

    @Test
    public void testPart1Solution() {

        //given
        Day10 day10 = new Day10(ResourcesService.getDay10PuzzleInput());

        //when
        Integer result = day10.solvePart1();

        //then
        Assertions.assertTrue(result > 0);

        //correct: 1625
        System.out.printf("Day10 Part1 result is %d%n", result);
    }

    @Test
    public void testPart1PostGraduateTest() {

        //given
        Day10 day10 = new Day10(ResourcesService.getDay10PuzzleInput());

        //when
        Integer result = day10.solvePart1();

        //then
        Assertions.assertEquals(1625, result);
    }

    @Test
    public void testPart2Example1() {

        //given
        Day10 day10 = new Day10(EXAMPLE_DATA);

        //when
        Long result = day10.solvePart2(19);

        //then
        Assertions.assertEquals(8L, result);
    }


    @Test
    public void testPart2Example2() {

        //given
        long max = EXAMPLE_DATA2.stream().max(Long::compareTo).get();
        Day10 day10 = new Day10(EXAMPLE_DATA2);

        //when
        Long result = day10.solvePart2(max);

        //then
        Assertions.assertEquals(19208L, result);
    }

    @Test
    public void testPart2Solution() {

        //given
        List<Long> DATA = ResourcesService.getDay10PuzzleInput();
        long max = DATA.stream().max(Long::compareTo).get();

        Day10 day10 = new Day10(DATA);

        //when
        Long result = day10.solvePart2(max);

        //then
        Assertions.assertNotNull(result);

        //correct: 3100448333024
        System.out.printf("Day10 Part2 result is %d%n", result);
    }

    @Test
    public void testPart2PostGraduateTest() {

        //given
        Day10 day10 = new Day10(ResourcesService.getDay10PuzzleInput());
        int lastAdapterValue = 137;

        //when
        Long result = day10.solvePart2(lastAdapterValue);

        //then
        Assertions.assertEquals(3100448333024L, result);
    }



}