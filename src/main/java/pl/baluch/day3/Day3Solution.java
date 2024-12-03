package pl.baluch.day3;

import pl.baluch.base.SolutionBase;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Day3Solution extends SolutionBase {

    public static void main(String[] args) {
        new Day3Solution().solve();
    }

    public Day3Solution() {
        super(3);
    }

    @Override
    protected String solvePart1(List<String> data) {
        var input = String.join("", data);
        var pattern = Pattern.compile("mul\\(([0-9]+),([0-9]+)\\)");
        var matcher = pattern.matcher(input);
        var result = 0L;
        while (matcher.find()) {
            var a = Long.parseLong(matcher.group(1));
            var b = Long.parseLong(matcher.group(2));
            result += a * b;
        }
        return String.valueOf(result);
    }

    @Override
    protected String solvePart2(List<String> data) {
        var input = String.join("", data);
        var pattern = Pattern.compile("(?<mulOp>mul\\((?<mulA>[0-9]+),(?<mulB>[0-9]+)\\))|(?<doOp>do\\(\\))|(?<dontOp>don't\\(\\))");
        var matcher = pattern.matcher(input);

        var result = 0L;
        var enabled = true;
        while (matcher.find()) {
            if (Objects.nonNull(matcher.group("mulOp"))) {
                var a = Long.parseLong(matcher.group("mulA"));
                var b = Long.parseLong(matcher.group("mulB"));
                if (enabled) {
                    result += a * b;
                }
            } else if (Objects.nonNull(matcher.group("doOp"))) {
                enabled = true;
            } else if (Objects.nonNull(matcher.group("dontOp"))) {
                enabled = false;
            }
        }
        return String.valueOf(result);
    }
}
