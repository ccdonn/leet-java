package com.donn.leet;

import java.util.HashSet;
import java.util.Set;

public class P36 {
    public boolean isValidSudoku(char[][] board) {
        return row(board) && column(board) && ninenine(board);
    }

    private boolean row(char[][] board) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (s.contains(board[i][j])) {
                        return false;
                    }
                    s.add(board[i][j]);
                }
            }
            s.clear();
        }
        return true;
    }

    private boolean column(char[][] board) {
        Set<Character> s = new HashSet<>();
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    if (s.contains(board[i][j])) {
                        return false;
                    }
                    s.add(board[i][j]);
                }
            }
            s.clear();
        }
        return true;
    }

    private boolean ninenine(char[][] board) {
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        Set<Character> s3 = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                s1.clear();
                s2.clear();
                s3.clear();
            }
            for (int j = 0; j < board.length; j++) {
                switch (j / 3) {
                    case 0:
                        if (board[i][j] != '.') {
                            if (s1.contains(board[i][j])) {
                                return false;
                            }
                            s1.add(board[i][j]);
                        }
                        break;
                    case 1:
                        if (board[i][j] != '.') {
                            if (s2.contains(board[i][j])) {
                                return false;
                            }
                            s2.add(board[i][j]);
                        }
                        break;
                    case 2:
                        if (board[i][j] != '.') {
                            if (s3.contains(board[i][j])) {
                                return false;
                            }
                            s3.add(board[i][j]);
                        }
                        break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P36().isValidSudoku(new char[][] {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        }));

        System.out.println(new P36().isValidSudoku(new char[][] {
            { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        }));

    }
}
