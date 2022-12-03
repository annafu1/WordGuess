package com.github.zipcodewilmington;

//anna

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

    public Hangman () {

    }
    private static String[] phrase = {"Pear", "Dear", "Farm", "Corn"};
    Scanner scanner = new Scanner(System.in);
    Random randomWord = new Random();
    int randomWordGenerator = randomWord.nextInt(4);
    int guesses = 0;
    char[] word;
    char[] arr;

    public void main(String[] args) {
        Hangman game = new Hangman();
        game.runGame();
    }

    public void runGame() {
        announceGame();
        initializeGameState();
        while (!isWordGuessed()) {
            printCurrentStatus();
            process(getNextGuess());
            guesses++;
            if (guesses == 3) {
                System.exit(0);
            }
            winner();
            askToPlayAgain();
        }
        loser();
        gameOver();
        askToPlayAgain();
    }

    public void printArray(char[] charArr) {
        for (int i = 0; i < charArr.length ; i++) {
            System.out.println(charArr[i] + " ");
        }
    }

    public void announceGame() {
        System.out.println("Welcome to the game of hangman!");
    }

    public void gameOver() {
        System.out.println("Game over");
    }

    public void initializeGameState() {
        arr = new char[]{'_', '_', '_', '_'};
    }

    public Character getNextGuess() {
        System.out.println("Guess a letter: ");
        return scanner.next().charAt(0);
    }

    public boolean isWordGuessed() {
        return Arrays.equals(word, arr);
    }

    public boolean askToPlayAgain() {
        System.out.println("Would you like to play again?\n 1. y or 2.n");
        int playInput = scanner.nextInt();
        if (playInput == 1) {
            runGame();
        }
        System.exit(0);
        return true;
    }

    public void printCurrentStatus() {
        this.printArray(arr);
    }

    public void process(Character guess) {
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                arr[i] = word[i];
            }
        }
    }

//    public void randWordToArray() {
//        word = phrase[randomWordGenerator].toCharArray();
//    }

    public void winner() {
        System.out.println("You won!");
    }

    public void loser() {
        System.out.println("Sorry, try again!");
    }
}