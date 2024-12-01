package pl.baluch.day1;

import org.junit.jupiter.api.Test;
import pl.baluch.base.SolutionBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1SolutionTests {

    private final static Day1Solution solution = new Day1Solution();

    @Test
    void part1ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day1/example1.txt");
        // when
        var result = solution.solvePart1(data);
        // then
        assertEquals("11", result);
    }

    @Test
    void part2ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day1/example2.txt");
        // when
        var result = solution.solvePart2(data);
        // then
        assertEquals("31", result);
    }
}
