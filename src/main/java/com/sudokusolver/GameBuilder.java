/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sudokusolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author minh
 */
public class GameBuilder {
    String rawGame;
    
    public GameBuilder(String path) {
        try {
            Scanner sc = new Scanner(new File(path));
            rawGame = sc.next();
        } catch (FileNotFoundException e) {
        }
        System.out.println(rawGame.length());
    }
    
    public int[][] build() {
        int[][] game = new int[9][9];
        int startIdx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                game[i][j] = rawGame.charAt(startIdx++) - '0';
            }
        }
        return game;
    }
}
