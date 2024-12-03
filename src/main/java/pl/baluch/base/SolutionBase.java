package pl.baluch.base;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class SolutionBase {

    private final int dayNumber;

    protected void solve() {
        var data = readLines("/day" + dayNumber + "/input.txt");
        System.out.println("Part 1: " + solvePart1(data));
        System.out.println("Part 2: " + solvePart2(data));
    }

    abstract protected String solvePart1(List<String> data);

    abstract protected String solvePart2(List<String> data);

    public static List<String> readLines(String path) {
        var stream = SolutionBase.class.getResourceAsStream(path);
        if (Objects.isNull(stream)) {
            throw new RuntimeException("Input file not found: " + path);
        }
        try (var reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
