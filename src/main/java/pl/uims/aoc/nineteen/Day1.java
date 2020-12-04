package pl.uims.aoc.nineteen;

public class Day1 {

    public Integer calcFuel(final Integer mass) {
        return Math.floorDiv(mass, 3) - 2;
    }

    public Integer calcFuel2(final Integer mass) {

        Integer x = calcFuel(mass);
        Integer t = 0;

        while(x > 0) {
            t += x;
            x = calcFuel(x);
        }

        return t;

    }

}
