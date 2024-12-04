package pl.baluch.day4;

import org.junit.jupiter.api.Test;
import pl.baluch.base.SolutionBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4SolutionTests {

    private final static Day4Solution solution = new Day4Solution();

    @Test
    void part1ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day4/example.txt");
        // when
        var result = solution.solvePart1(data);
        // then
        assertEquals("18", result);
    }

    @Test
    void part2ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day4/example.txt");
        // when
        var result = solution.solvePart2(data);
        // then
        assertEquals("9", result);
    }
}
