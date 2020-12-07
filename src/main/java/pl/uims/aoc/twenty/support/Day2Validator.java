package pl.uims.aoc.twenty.support;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.uims.aoc.twenty.support.AocConstants.*;

public class Day2Validator {

    private int rangeFrom;
    private int rangeTo;
    private char character;
    private String password;

    public Day2Validator(String params) throws ParseException {
        parseString(params);
    }

    private void parseString(String params) throws ParseException {

        if(Objects.isNull(params) || params.isBlank()) {
            throw new ParseException("String params cannot be null or empty", 0);
        }

        final String[] args = params.split(SPACE);

        if(args.length != 3) {
            throw new ParseException("Incorrect amount of args after string was split.", 0);
        }

        List<Integer> range = null;

        try {
            range = Stream.of(args[0].split(MINUS) ).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        } finally {
            if(Objects.isNull(range) || range.size() != 2){
                throw new ParseException(String.format("Unable to parse 'rangeFrom' and 'rangeTo' from string '%s'", args[0]), 0);
            }
        }

        rangeFrom = range.get(0);
        rangeTo = range.get(1);
        character =  args[1].charAt(0);
        password = args[2];

    }

    public boolean isValidByCount() {

        long count = password.chars().filter(c -> character == c).count();

        return rangeFrom <= count && count <= rangeTo;

    }

    public boolean isValidByPositions() {

        boolean hasFirst = (password.length() >= rangeFrom && password.charAt(rangeFrom - 1) == character);

        boolean hasSecond = (password.length() >= rangeTo && password.charAt(rangeTo - 1) == character);

        return hasFirst | hasSecond && hasFirst!=hasSecond;

    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }

    public char getCharacter() {
        return character;
    }

    public String getPassword() {
        return password;
    }
}
