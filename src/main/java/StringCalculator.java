import java.util.Arrays;
import java.util.Objects;

public class StringCalculator {

    public int add(String input) {
        //TODO implement
        if(input.isEmpty()) { return 0; }

        String delimiter = parseDelimiter(input);
        String[] numbers = splitInput(input, delimiter);

        int sum = 0;
        for(String i: numbers) {
            if(Integer.parseInt(i) < 0) { throw new RuntimeException("Negatives not allowed: " + i); }
            sum += Integer.parseInt(i);
        }
        return sum;
    }

    private String[] splitInput(String input, String delimiter) {
        if(!Objects.equals(delimiter, "")) {
            input = input.substring(3)
                    .replace("\n", "")
                    .replace(",","");
            return input.split(delimiter);
        }
        input = input.replace("\n", ",");
        return input.split(",");
    }

    private String parseDelimiter(String input) {
        if(input.contains("//")) {
            return input.charAt(2) + "";
        }
        return "";
    }
}
