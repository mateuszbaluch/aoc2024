package pl.baluch.day2;

import org.junit.jupiter.api.Test;
import pl.baluch.base.SolutionBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2SolutionTests {

    private final static Day2Solution solution = new Day2Solution();

    @Test
    void part1ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day2/example1.txt");
        // when
        var result = solution.solvePart1(data);
        // then
        assertEquals("2", result);
    }

    @Test
    void part2ExampleTest() {
        // given
        var data = SolutionBase.readLines("/day2/example2.txt");
        // when
        var result = solution.solvePart2(data);
        // then
        assertEquals("4", result);
    }

    @Test
    void part2ExampleTest1() {
        // given
        var data = List.of("10 8 9 10");
        // when
        var result = solution.solvePart2(data);
        // then
        assertEquals("1", result);
    }
}
