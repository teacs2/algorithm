package com.algorithm.boot.other.HWod.od2026;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OD0830cTest {

    private final OD0830c solution = new OD0830c();

    @ParameterizedTest(name = "测试用例 {index}: board={board}, word={word}")
    @CsvSource({
            "[[A,B,C,E],[S,F,C,S],[A,D,E,E]],ABCCED,1",
            "[[A,A]],A,2",
            "[[A,B],[C,D]],ABCD,0",
            "[[A,A],[A,A]],AA,4",
            "[[A,A],[A,A]],AAA,8",
            "[[A,B,A],[B,A,B],[A,B,A]],ABA,6",
            "[[C,A,T],[A,T,A],[T,A,C]],CAT,6",
            "[[A,B,C],[D,E,F],[G,H,I]],AEI,0",
            "[[O,A,A,N],[E,T,A,E],[I,H,K,R],[I,F,L,V]],OATH,2",
            "[[A,B,C,D],[E,F,G,H],[I,J,K,L]],FGK,0"
    })
    void countWordPaths(String boardStr, String word, int expected) {
        char[][] board = parseBoard(boardStr);
        int result = solution.countWordPaths(board, word);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "空值测试 {index}")
    @CsvSource({
            "null,ABC,0",
            "[[A,B]],null,0",
            "[[A,B]],,0"
    })
    void testNullAndEmptyCases(String boardStr, String word, int expected) {
        if (boardStr == null) {
            assertEquals(expected, solution.countWordPaths(null, word));
        } else {
            char[][] board = parseBoard(boardStr);
            assertEquals(expected, solution.countWordPaths(board, word));
        }
    }

    @Test
    void testSingleCellGrid() {
        assertEquals(1, solution.countWordPaths(new char[][]{{'A'}}, "A"));
        assertEquals(0, solution.countWordPaths(new char[][]{{'A'}}, "B"));
        assertEquals(0, solution.countWordPaths(new char[][]{{'A'}}, "AB"));
    }

    private char[][] parseBoard(String input) {
        input = input.trim();
        String[] rows = input.substring(1, input.length() - 1).split("\\],\\[");
        char[][] board = new char[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].trim();
            String[] chars = row.split(",");
            board[i] = new char[chars.length];
            for (int j = 0; j < chars.length; j++) {
                board[i][j] = chars[j].trim().charAt(0);
            }
        }

        return board;
    }
}