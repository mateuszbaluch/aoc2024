package pl.baluch.day4;

import lombok.RequiredArgsConstructor;
import pl.baluch.base.SolutionBase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Day4Solution extends SolutionBase {

    public static void main(String[] args) {
        new Day4Solution().solve();
    }

    public Day4Solution() {
        super(4);
    }

    @Override
    protected String solvePart1(List<String> data) {
        var width = data.getFirst().length();
        var height = data.size();
        var table = to2dArray(data);
        var result = 0L;
        for (var i = 0; i < width; i++) {
            for (var j = 0; j < height; j++) {
                result += countXmas(table, i, j);
            }
        }
        return String.valueOf(result);
    }

    private long countXmas(char[][] table, int x, int y) {
        return Arrays.stream(Direction.values())
                .filter(direction -> hasXmas(table, x, y, direction)).count();
    }

    @Override
    protected String solvePart2(List<String> data) {
        var width = data.getFirst().length();
        var height = data.size();
        var table = to2dArray(data);
        var result = 0L;
        for (var i = 1; i < width - 1; i++) {
            for (var j = 1; j < height - 1; j++) {
                if (isCentreOfMasCross(table, i, j)) {
                    result++;
                }
            }
        }
        return String.valueOf(result);
    }

    private boolean isCentreOfMasCross(char[][] table, int x, int y) {
        if (table[x][y] != 'A') {
            return false;
        }
        var validTexts = Set.of("MAS", "SAM");
        var firstDiagonal = String.valueOf(table[x - 1][y - 1]) + table[x][y] + table[x + 1][y + 1];
        var secondDiagonal = String.valueOf(table[x + 1][y - 1]) + table[x][y] + table[x - 1][y + 1];
        return validTexts.contains(firstDiagonal) && validTexts.contains(secondDiagonal);
    }

    private boolean hasXmas(char[][] table, int x, int y, Direction direction) {
        var text = "XMAS";
        for (var letterIdx = 0; letterIdx < text.length(); letterIdx++) {
            var letterX = x + letterIdx * direction.x;
            var letterY = y + letterIdx * direction.y;
            if (letterX < 0 || letterX >= table.length || letterY < 0 || letterY >= table[0].length) {
                return false;
            }
            if (table[letterX][letterY] != text.charAt(letterIdx)) {
                return false;
            }
        }
        return true;
    }

    private char[][] to2dArray(List<String> data) {
        return data.stream().map(String::toCharArray).toArray(char[][]::new);
    }

    @RequiredArgsConstructor
    enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        RIGHT(1, 0),
        LEFT(-1, 0),
        UP_RIGHT(1, -1),
        UP_LEFT(-1, -1),
        DOWN_RIGHT(1, 1),
        DOWN_LEFT(-1, 1);

        private final int x;
        private final int y;
    }
}
