package com.github.zipcodewilmington;

//anna

import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    int phraseRandom = rand.nextInt(2);
    int numOfGuesses = 0;
    char[] randomWord;
    char[] arr;
    String[] phrase = {"sugar", "paper", "mills", "farms"}
    public static void main(String[] args) {
        Hangman letPlay = new Hangman();
        letPlay.runGame();
    }

    public void runGame() {
        intializeGameStat();
        announceGame();
    }

    public void announceGame() {
        System.out.println("let's play hangman!");
    }
    public void intializeGameStat() {
        arr = new char[] {'_', '_', '_','_'};
        randomWord = phrase[phraseRandom].toCharArray();
    }

    public Character nextGuess() {
        System.out.println("Guess a letter: ");
        return scanner.next().charAt(0);
    }




    public void endGame() {
        System.out.println("Game over");
    }

    public void playerWon() {
        System.out.println("You are a winner!");
    }

    public void playerLost() {
        System.out.println("You lose");
    }

}