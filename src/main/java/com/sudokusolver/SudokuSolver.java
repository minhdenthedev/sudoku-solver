/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sudokusolver;
/**
 * ;
 *
 * @author minh
 */
public class SudokuSolver {

    public static void main(String[] args) {
        GameBuilder builder = new GameBuilder("/home/minh/datasets/1M_sudoku/easy_unsolved.csv");
        Game game = new Game(builder.build());
        System.out.println(game);
        Solver.solve(game);
        System.out.println(game);
    }
}
