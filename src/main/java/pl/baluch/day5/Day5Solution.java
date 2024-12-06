package pl.baluch.day5;

import pl.baluch.base.SolutionBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5Solution extends SolutionBase {

    public static void main(String[] args) {
        new Day5Solution().solve();
    }

    public Day5Solution() {
        super(5);
    }

    @Override
    protected String solvePart1(List<String> data) {
        var middleIdx = data.indexOf("");
        var rules = data.subList(0, middleIdx).stream()
                .map(line -> line.split("\\|"))
                .map(strings -> new Rule(Long.parseLong(strings[0]), Long.parseLong(strings[1])))
                .toList();
        var updates = data.subList(middleIdx + 1, data.size());
        var result = updates.stream()
                .map(line -> Arrays.stream(line.split(",")).map(Long::parseLong).toList())
                .filter(numbers -> rules.stream().allMatch(rule -> rule.match(numbers)))
                .mapToLong(numbers -> numbers.get(numbers.size() / 2))
                .sum();
        return String.valueOf(result);
    }

    @Override
    protected String solvePart2(List<String> data) {
        var middleIdx = data.indexOf("");
        var rules = data.subList(0, middleIdx).stream()
                .map(line -> line.split("\\|"))
                .map(strings -> new Rule(Long.parseLong(strings[0]), Long.parseLong(strings[1])))
                .toList();
        var updates = data.subList(middleIdx + 1, data.size());
        var result = updates.stream()
                .map(line -> Arrays.stream(line.split(",")).map(Long::parseLong).toList())
                .filter(numbers -> !rules.stream().allMatch(rule -> rule.match(numbers)))
                .map(numbers -> fixOrder(rules, numbers))
                .mapToLong(numbers -> numbers.get(numbers.size() / 2))
                .sum();
        return String.valueOf(result);
    }

    private List<Long> fixOrder(List<Rule> rules, List<Long> numbers) {
        var result = new ArrayList<Long>();
        for (var value : numbers) {
            var min = 0;
            var max = result.size();
            for (var rule : rules) {
                var aIdx = result.indexOf(rule.a);
                var bIdx = result.indexOf(rule.b);
                if (rule.a == value && bIdx != -1) {
                    max = Math.min(max, bIdx);
                }
                if (rule.b == value && aIdx != -1) {
                    min = Math.max(min, aIdx + 1);
                }
            }
            if (min > max) {
                throw new RuntimeException("Cannot place value: " + value);
            }
            result.add(min, value);
        }
        return result;
    }

    private record Rule(long a, long b) {
        public boolean match(List<Long> data) {
            if (!data.contains(a) || !data.contains(b)) {
                return true;
            }
            return data.indexOf(a) < data.indexOf(b);
        }
    }
}
