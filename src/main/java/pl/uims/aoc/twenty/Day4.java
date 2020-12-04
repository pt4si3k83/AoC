package pl.uims.aoc.twenty;

import java.util.Map;
import java.util.Set;

public class Day4 {


    public static final String KEY_BYR = "byr";
    public static final String KEY_IYR = "iyr";
    public static final String KEY_EYR = "eyr";
    public static final String KEY_HGT = "hgt";
    public static final String KEY_HCL = "hcl";
    public static final String KEY_ECL = "ecl";
    public static final String KEY_PID = "pid";
    public static final String KEY_CID = "cid";
    private static final Set<String> REQUIRED_KEYS = Set.of( KEY_BYR, KEY_IYR, KEY_EYR, KEY_HGT, KEY_HCL, KEY_ECL, KEY_PID);
    private static final Set<String> EYE_COLORS = Set.of( "amb", "blu", "brn", "gry", "grn", "hzl", "oth" );

    public boolean hasValidFields(final Map<String, String> passport) {
        return passport.keySet().containsAll(REQUIRED_KEYS);
    }

    public boolean hasValidFieldsAndValues(final Map<String, String> passport) {
        return hasValidFields(passport) && passport.entrySet().stream().allMatch( entry -> validateEntry(entry) );
    }

    private boolean validateEntry(final Map.Entry<String,String> entry) {

        //holding the result here to log it in case of value not passed validation
        boolean result = false;

        switch(entry.getKey()){
            case KEY_BYR:
                result = entry.getValue().matches("^[0-9]{4}$") && inRange(entry.getValue(), 1920, 2002);
                break;
            case KEY_IYR:
                result =entry.getValue().matches("^[0-9]{4}$") && inRange(entry.getValue(), 2010, 2020);
                break;
            case KEY_EYR:
                result = entry.getValue().matches("^[0-9]{4}$") && inRange(entry.getValue(), 2020, 2030);
                break;
            case KEY_HGT:
                result = entry.getValue().matches("^[0-9]+(cm|in)$") && ((entry.getValue().endsWith("cm") && inRange(entry.getValue().substring(0, entry.getValue().length() - 2), 150, 193))
                        || (entry.getValue().endsWith("in") && inRange(entry.getValue().substring(0, entry.getValue().length() - 2), 59, 76)));
                break;
            case KEY_HCL:
                result = entry.getValue().matches( "^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
                break;
            case KEY_ECL:
                result =  EYE_COLORS.contains(entry.getValue());
                break;
            case KEY_PID:
                result = entry.getValue().matches( "^[0-9]{9}$");
                break;
            case KEY_CID:
                result = true;
                break;
            default:
                break;
        }

        if(!result){
            System.out.println(String.format("Value not passed: '%s' = '%s'", entry.getKey(), entry.getValue()));
        }

        return result;

    }

    private boolean inRange(final String value, final long rangeFrom, final long rangeTo) {
        return inRange(Long.valueOf(value), rangeFrom, rangeTo);
    }

    private boolean inRange(final long value, final long rangeFrom, final long rangeTo) {
        return rangeFrom <= value && value <= rangeTo;
    }


}
