package chapter9;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
//        Testing a Match
        String regex = "[+-]?\\d+";
        String input = "+233";
        if (Pattern.matches(regex, input)) {
            System.out.println("match");
        }

//        Compile pattern for efficiency
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("match");
        }

//        Match Predicate
        Pattern digits = Pattern.compile("[0-9]+");
        List<String> strings = List.of("December", "31st", "1999");
        List<String> matchingStrings = strings.stream()
                .filter(digits.asMatchPredicate())
                .toList(); // ["1999"]


//        Finding All Matches
        Matcher matcher1 = pattern.matcher("+233");
        while (matcher1.find()) {
            String match = matcher1.group();
            int matchStart = matcher1.start();
            int matchEnd = matcher1.end();
            System.out.println(match);
            System.out.println(matchStart);
            System.out.println(matchEnd);
        }

//        MatchResult interface has methods group, start, and end, just like Matcher.
//        In fact, the Matcher class implements this interface.

        List<String> matches = pattern.matcher(input)
                .results()
                .map(MatchResult::group)
                .toList();

        System.out.println(matches);


//        *** Groups ***

//        Blackwell Toaster    USD29.95
//        (\p{Alnum}+(\s+\p{Alnum}+)*)\s+([A-Z]{3})([0-9.]*)

        Pattern pattern2 = Pattern.compile("(\\p{Alnum}+(\\s+\\p{Alnum}+)*)\\s+([A-Z]{3})([0-9.]*)");
        Matcher matcher2 = pattern2.matcher("Blackwell Toaster    USD29.95");
        String contents = matcher2.group();
        System.out.println(contents);

    }

}
