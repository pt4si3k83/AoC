package pl.uims.aoc.twenty;

import pl.uims.aoc.twenty.support.AocConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day6 {


    public long countGroups(List<String> data){

        List<String> merged = new ArrayList<>();

        StringBuilder bld = new StringBuilder();

        for (int j = 0; j < data.size(); j++) {

            bld.append(data.get(j));

            if((data.get(j).isBlank() || j+1 == data.size()) ){
                merged.add(bld.toString());
                bld = new StringBuilder();
            }

        }

        return merged.stream().map( s -> s.chars().distinct().count() ).reduce(Long::sum).orElse(AocConstants.NOT_FOUND);
    }

    public long countGroups2(List<String> data){

        StringBuilder bld = new StringBuilder();
        long groupSize = 0L;
        long count = 0L;

        for (int j = 0; j < data.size(); j++) {

            bld.append(data.get(j));

            if(!data.get(j).isBlank()){
                groupSize++;
            }

            if((data.get(j).isBlank() || j+1 == data.size())){

                final long filterByGroup = groupSize;

                count += bld.toString().chars().mapToObj(String::valueOf)
                                      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                      .entrySet().stream().filter( entry -> entry.getValue() == filterByGroup).count();

                bld = new StringBuilder();
                groupSize = 0;
            }

        }

        return count;
    }
}
