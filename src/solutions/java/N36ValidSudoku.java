package solutions.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateColumns(board) && validateSquares(board);
    }

    private boolean validateRows(char[][] board) {
        return Arrays.stream(board)//
                .map(this::arrayToList)//
                .map(this::validatePart)//
                .reduce(true, Boolean::logicalAnd);
    }

    private boolean validateColumns(char[][] board) {
        return IntStream.range(0, board.length)//
                .mapToObj(i -> Arrays.stream(board)//
                        .map(a -> a[i])//
                        .collect(Collectors.toList())//
                )//
                .map(this::validatePart)//
                .reduce(true, Boolean::logicalAnd);
    }

    private boolean validateSquares(char[][] board) {
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                List<Character> part = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        part.add(board[(n % 3) * 3 + i][(m % 3) * 3 + j]);
                    }
                }
                if (!validatePart(part)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validatePart(Collection<Character> part) {
        List<Character> withoutDots = part.stream()//
                .filter(c -> !c.equals('.'))//
                .collect(Collectors.toList());
        return new HashSet<>(withoutDots).size() == withoutDots.size();
    }

    private List<Character> arrayToList(char[] arr) {
        return IntStream.range(0, arr.length)//
                .mapToObj(i -> arr[i])//
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        char[][] example1 = new char[][] { //
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, //
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, //
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, //
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, //
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, //
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, //
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, //
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, //
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } //
        };
        char[][] example2 = new char[][] { //
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' }, //
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, //
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, //
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, //
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, //
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, //
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, //
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, //
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } //
        };
        char[][] example3 = new char[][] { //
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' }, //
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, //
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' }, //
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, //
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' }, //
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, //
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' }, //
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, //
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' } //
        };
        N36ValidSudoku validator = new N36ValidSudoku();
        assert validator.isValidSudoku(example1);
        assert !validator.isValidSudoku(example2);
        assert !validator.isValidSudoku(example3);
    }
}
