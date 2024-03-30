/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sudokusolver;

/**
 *
 * @author minh
 */
public class Game {

    int[][] game;

    public Game(int[][] game) {
        this.game = game;
    }

    public void set(int i, int j, int x) {
        game[i][j] = x;
    }

    public int get(int i, int j) {
        return game[i][j];
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
