package pl.baluch.day3;

import org.junit.jupiter.api.Test;
import pl.baluch.base.SolutionBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3SolutionTests {

    private final static Day3Solution solution = new Day3Solution();

    @Test
    void part1ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day3/example.txt");
        // when
        var result = solution.solvePart1(data);
        // then
        assertEquals("161", result);
    }

    @Test
    void part2ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day3/example2.txt");
        // when
        var result = solution.solvePart2(data);
        // then
        assertEquals("48", result);
    }
}
