package pl.uims.aoc.nineteen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class Day1Test {

    final Integer[] EXAMPLE_MASSES = new Integer[]{ 12, 14, 1969, 100756 };
    final Integer[] EXAMPLE_RESULTS = new Integer[]{ 2, 2, 654, 33583 };

    final List<Integer> PUZZLE_DATA = List.of(72713, 93795, 64596, 99366, 124304, 122702, 105674, 94104, 144795, 109412, 138753, 71738, 62172, 149671, 88232, 145707, 82617, 123357, 63980, 149016, 130921, 125863, 119405, 77839, 140354, 135213, 130550, 131981, 149301, 68884, 52555, 121036, 75237, 64339, 60612, 132912, 63164, 145198, 109252, 130024, 100738, 74890, 89784, 134474, 68815, 117283, 144774, 138017, 149989, 111506, 119737, 65330, 52388, 69698, 124990, 84232, 58016, 142321, 119731, 86914, 68524, 87708, 60776, 119259, 73429, 79486, 120369, 57007, 91514, 87226, 131770, 78170, 52871, 149060, 73804, 60034, 72519, 98065, 132526, 99660, 74854, 111912, 51232, 71499, 127629, 83807, 91061, 60988, 133493, 95170, 110661, 54486, 63241, 141111, 142244, 93120, 137257, 79822, 95849, 69878);

    @Test
    public void testStep1Examples() {

        //given
        final Day1 day1 = new Day1();

        //when-then
        Assertions.assertEquals(EXAMPLE_RESULTS[0], day1.calcFuel(EXAMPLE_MASSES[0]));
        Assertions.assertEquals(EXAMPLE_RESULTS[1], day1.calcFuel(EXAMPLE_MASSES[1]));
        Assertions.assertEquals(EXAMPLE_RESULTS[2], day1.calcFuel(EXAMPLE_MASSES[2]));
        Assertions.assertEquals(EXAMPLE_RESULTS[3], day1.calcFuel(EXAMPLE_MASSES[3]));

    }

    @Test
    public void testPart1Solution() {

        //given
        final Day1 day1 = new Day1();

        //when
        final Integer result = PUZZLE_DATA.stream().map( mass -> day1.calcFuel(mass) ).reduce(Integer::sum).get();

        //then
        Assertions.assertNotEquals(0, result);

        //expected: 3335787
        System.out.println(String.format("Day1 Part1 result is %d", result));


    }

    @Test
    public void testPart2Solution() {

        //given
        final Day1 day1 = new Day1();

        //when
        final Integer result = PUZZLE_DATA.stream().map( mass -> day1.calcFuel2(mass) ).reduce(Integer::sum).get();

        //then
        Assertions.assertNotEquals(0, result);

        //expected: 5000812
        System.out.println(String.format("Day1 Part1 result is %d", result));


    }

}