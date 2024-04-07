/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sudokusolver;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author minh
 */
public class Game {

    int[][] game;
    Set<Integer> buffer;

    public Game(int[][] game) {
        this.game = game;
        this.buffer = new HashSet<>();
    }

    public void set(int i, int j, int x) {
        game[i][j] = x;
    }

    public int get(int i, int j) {
        return game[i][j];
    }

    public void unset(int i, int j) {
        game[i][j] = 0;
    }

    public boolean isSafe(int i, int j, int num) {
        // Check if empty
        if (!isEmpty(i, j)) return false;
        
        // Check for rows
        for (int row = 0; row < 9; row++) {
            if (game[row][j] == num) {
                return false;
            }
        }

        // Check for columns
        for (int col = 0; col < 9; col++) {
            if (game[i][col] == num) {
                return false;
            }
        }

        // Check for boxes
        // The idea is to get the remainder and subtract
        int rowStart = i - i % 3;
        int colStart = j - j % 3;

        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if (game[row][col] == num) {
                    return false;
                }
            }
        }

        // If there are no conflicts, return true (safe).
        return true;
    }

    public boolean isFull() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (game[row][col] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSolved() {
        if (!isFull()) {
            return false;
        }

        // Check for rows 
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (!buffer.add(game[row][col])) {
                    System.out.println("False row");
                    System.out.println("False at row " + row + ", col " + col);
                    return false;
                }
            }

            // After each row, clear the buffer
            buffer.clear();
        }

        // Check for columns
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                if (!buffer.add(game[row][col])) {
                    System.out.println("False column");
                    System.out.println("False at row " + row + ", col " + col);

                    return false;
                }
            }

            // Clear the buffer after each columns
            buffer.clear();
        }

        // Check for boxes
        // Iterate through all boxes
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                // Iterate through all cells in a box
                for (int row = i * 3; row < i * 3 + 3; row++) {
                    for (int col = k * 3; col < k * 3 + 3; col++) {

                        if (!buffer.add(game[row][col])) {
                            System.out.println("False at row " + row + ", col " + col);

                            return false;
                        }
                    }
                }
                // Clear buffer after each box.
                buffer.clear();
            }
        }

        return true;
    }

    public boolean isEmpty(int i, int j) {
        return game[i][j] == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int countChar = 0;
        for (int i = 0; i < 9; i++) {
            countChar = 1;
            sb.append("|");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 2) {
                    sb.append(" ");
                    sb.append(game[i][j]);
                    sb.append(" ");
                    sb.append("|");
                    countChar += 4;
                } else {
                    sb.append(" ");
                    sb.append(game[i][j]);
                    sb.append(" ");
                    countChar += 3;
                }
            }
            sb.append("\n");
            if (i % 3 == 2) {
                for (int k = 0; k < countChar; k++) {
                    sb.append("-");
                }
                sb.append("\n");
            }
        }
        for (int k = 0; k < countChar; k++) {
            sb.insert(0, "-");
        }
        sb.insert(countChar, "\n");

        return sb.toString();
    }
}
