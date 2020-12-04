package pl.uims.aoc.twenty.support;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2ValidatorTest {

    private final String EXAMPLE_INPUT1 = "1-3 a: abcde";
    private final String EXAMPLE_INPUT2 = "1-3 b: cdefg";
    private final String EXAMPLE_INPUT3 = "2-9 c: ccccccccc";

    @Test
    public void parsingTest1() throws Exception {

        //when
        Day2Validator param = new Day2Validator(EXAMPLE_INPUT1);

        //then
        assertEquals(1, param.getRangeFrom());
        assertEquals(3, param.getRangeTo());
        assertEquals('a', param.getCharacter());
        assertEquals("abcde", param.getPassword());
        assertTrue(param.isValidByCount());
    }

    @Test
    public void parsingTest2() throws Exception {

        //when
        Day2Validator param = new Day2Validator(EXAMPLE_INPUT2);

        //then
        assertEquals(1, param.getRangeFrom());
        assertEquals(3, param.getRangeTo());
        assertEquals('b', param.getCharacter());
        assertEquals("cdefg", param.getPassword());
        assertTrue(!param.isValidByCount());
    }

    @Test
    public void parsingTest3() throws Exception {

        //when
        Day2Validator param = new Day2Validator(EXAMPLE_INPUT3);

        //then
        assertEquals(2, param.getRangeFrom());
        assertEquals(9, param.getRangeTo());
        assertEquals('c', param.getCharacter());
        assertEquals("ccccccccc", param.getPassword());
        assertTrue(param.isValidByCount());
    }

    @Test
    public void parsingPart2Test1() throws Exception {

        //when
        Day2Validator param = new Day2Validator(EXAMPLE_INPUT1);

        //then
        assertTrue(param.isValidByPositions());
    }

    @Test
    public void parsingPart2Test2() throws Exception {

        //when
        Day2Validator param = new Day2Validator(EXAMPLE_INPUT2);

        //then
        assertTrue(!param.isValidByPositions());
    }

    @Test
    public void parsingPart2Test3() throws Exception {

        //when
        Day2Validator param = new Day2Validator(EXAMPLE_INPUT3);

        //then
        assertTrue(!param.isValidByPositions());
    }
}