package pl.baluch.day2;

import pl.baluch.base.SolutionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day2Solution extends SolutionBase {

    public static void main(String[] args) {
        new Day2Solution().solve();
    }

    public Day2Solution() {
        super(2);
    }

    @Override
    protected String solvePart1(List<String> data) {
        var result = data.stream().filter(this::isSafe).count();
        return String.valueOf(result);
    }

    private boolean isSafe(String line) {
        var numbers = Arrays.stream(line.split(" ")).map(Long::parseLong).toList();
        return isSafe(numbers);
    }

    private boolean isSafe(List<Long> numbers) {
        var diffs = getDiffs(numbers);
        if (diffs.stream().anyMatch(i -> i == 0 || Math.abs(i) > 3)) {
            return false;
        }
        var signCount = diffs.stream().map(Math::signum).distinct().count();
        return signCount == 1;
    }

    @Override
    protected String solvePart2(List<String> data) {
        var result = data.stream().filter(this::isSafeWithDumper).count();
        return String.valueOf(result);
    }

    private boolean isSafeWithDumper(String line) {
        var numbers = Arrays.stream(line.split(" ")).map(Long::parseLong).toList();
        return isSafeWithDumper(numbers);
    }

    private boolean isSafeWithDumper(List<Long> numbers) {
        // brute force
        for (int i = 0; i < numbers.size(); i++) {
            var copy = new ArrayList<>(numbers);
            copy.remove(i);
            if (isSafe(copy)) {
                return true;
            }
        }
        return false;
    }

    private List<Long> getDiffs(List<Long> numbers) {
        return IntStream.range(0, numbers.size() - 1).mapToObj(i -> numbers.get(i + 1) - numbers.get(i)).toList();
    }
}
