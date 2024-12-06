package pl.baluch.day5;

import org.junit.jupiter.api.Test;
import pl.baluch.base.SolutionBase;
import pl.baluch.day4.Day4Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5SolutionTests {

    private final static Day5Solution solution = new Day5Solution();

    @Test
    void part1ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day5/example.txt");
        // when
        var result = solution.solvePart1(data);
        // then
        assertEquals("143", result);
    }

    @Test
    void part2ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day5/example.txt");
        // when
        var result = solution.solvePart2(data);
        // then
        assertEquals("123", result);
    }
}
