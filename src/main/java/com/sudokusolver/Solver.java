/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sudokusolver;

/**
 *
 * @author minh
 */
public class Solver {
    
    public static boolean solve(Game game) {
        if (game.isSolved()) {
            return true;
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int num = 1; num <= 9; num++) {
                    if (game.isSafe(i, j, num)) {
                        game.set(i, j, num);
                        System.out.println("Setting " + i + ", " + j + " = " + num);
                        if (solve(game)) {
                            return true;
                        } else {
                            game.unset(i, j);
                        }
                    }
                }
            }
        }
        
        return false;
    }
}