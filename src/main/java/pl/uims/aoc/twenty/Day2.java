package pl.uims.aoc.twenty;

import pl.uims.aoc.twenty.support.Day2Validator;

import java.text.ParseException;
import java.util.List;

public class Day2 {
    private final List<String> data;

    public Day2(List<String> data) {
        this.data = data;
    }

    public long calculatePart1() {

        return data.stream().map(d -> {
            try {
                return new Day2Validator(d);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } ).filter( Day2Validator::isValidByCount).count();

    }

    public long calculatePart2() {

        return data.stream().map(d -> {
            try {
                return new Day2Validator(d);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } ).filter( Day2Validator::isValidByPositions).count();

    }


}
