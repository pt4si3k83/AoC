package pl.uims.aoc.twenty;


import pl.uims.aoc.twenty.support.AocConstants;

import java.util.List;
import java.util.Optional;

public class Day9 {

    private final List<Long> data;

    public Day9(List<Long> data) {
        this.data = data;
    }

    public Long solvePart1(final int preambleLength) {

        for (int i = preambleLength; i < data.size(); i++) {

            if(!xmasValid(data.subList(i-preambleLength, i), data.get(i))){
                return data.get(i);
            }
        }

        return AocConstants.NOT_FOUND;
    }

    public Long solvePart2(final int preambleLength, final Long target) {

        int preambleCutOffIndex = -1;

        for (int i = preambleLength; i < data.size(); i++) {
            if(!xmasValid(data.subList(i-preambleLength, i), data.get(i)) && data.get(i).equals(target)){
                preambleCutOffIndex = i;
                break;
            }
        }

        if(preambleCutOffIndex!=-1){
            List<Long> preambleData = data.subList(0, preambleCutOffIndex);

            for (int i = 0; i < preambleData.size(); i++) {

                long result = 0;
                for (int j = i; j < preambleData.size(); j++) {
                    result += preambleData.get(j);
                    //if we've found a solution
                    if(target.equals(result)){
                        List<Long> contiguousSet = preambleData.subList(i,j+1);
                        Long min = contiguousSet.stream().min(Long::compareTo).get();
                        Long max = contiguousSet.stream().max(Long::compareTo).get();
                        return min + max;
                    }
                    //if the sum is already bigger than target, then it's no point to continue...
                    if(target.compareTo(result) < 0 ){
                         break;
                    }
                }
            }
        }

        return AocConstants.NOT_FOUND;
    }

    private boolean xmasValid(final List<Long> preamble, final Long intToValidate){
        Optional<Long> i = preamble.stream().filter(p -> preamble.contains(intToValidate - p) && intToValidate - p != p).findFirst();
        return i.isPresent();
    }

}
