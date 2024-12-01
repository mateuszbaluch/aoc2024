package pl.baluch.day1;

import pl.baluch.base.SolutionBase;

import java.util.*;
import java.util.stream.IntStream;

public class Day1Solution extends SolutionBase {

    public static void main(String[] args) {
        new Day1Solution().solve();
    }

    public Day1Solution() {
        super(1);
    }

    @Override
    protected String solvePart1(List<String> data) {
        var left = new ArrayList<Long>();
        var right = new ArrayList<Long>();
        data.forEach(line -> {
            var parts = line.split(" +");
            left.add(Long.parseLong(parts[0]));
            right.add(Long.parseLong(parts[1]));
        });
        Collections.sort(left);
        Collections.sort(right);

        var result = IntStream.range(0, left.size())
                .mapToLong(i -> Math.abs(left.get(i) - right.get(i)))
                .sum();
        return String.valueOf(result);
    }

    @Override
    protected String solvePart2(List<String> data) {
        var left = new ArrayList<Long>();
        var right = new HashMap<Long, Long>();
        data.forEach(line -> {
            var parts = line.split(" +");
            left.add(Long.parseLong(parts[0]));
            right.compute(Long.parseLong(parts[1]), (_, v) -> v == null ? 1 : v + 1);
        });

        var similarityCache = new HashMap<Long, Long>();
        var result = left.stream()
                .mapToLong(value -> similarityCache.computeIfAbsent(value, k -> k * right.getOrDefault(k, 0L)))
                .sum();
        return String.valueOf(result);
    }
}
