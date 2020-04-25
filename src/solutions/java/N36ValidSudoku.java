package solutions.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class N36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<List<Character>> parts = IntStream.range(0, 3)//
                    .mapToObj(n -> new ArrayList<Character>())//
                    .collect(Collectors.toList());
            for (int j = 0; j < 9; j++) {
                parts.get(0).add(board[i][j]);
                parts.get(1).add(board[j][i]);
                parts.get(2).add(board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]);
            }
            if (parts.stream().anyMatch(p -> !isValidPart(p))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPart(Collection<Character> part) {
        List<Character> withoutDots = part.stream()//
                .filter(c -> !c.equals('.'))//
                .collect(Collectors.toList());
        return new HashSet<>(withoutDots).size() == withoutDots.size();
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
