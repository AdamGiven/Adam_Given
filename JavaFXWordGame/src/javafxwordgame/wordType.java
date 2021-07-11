//Adam Given
//CSC 240 Java Programming
//Class to create word object and handle the word logic.

package javafxwordgame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class wordType {
    private String[] library;
    private char[] word;
    private char[] deciphered;
    private char[] guessed;
    private int guessedCount;
    private int selector;
    private int dictionaryLength;
    private int wordLength;
    private int score;
    private String temp;
    private java.io.File inFile;
    private Scanner input;
    
    
    //Constructor
    public wordType() throws FileNotFoundException {
        inFile = new java.io.File("C:\\Users\\Raven\\Documents\\NetBeansProjects\\JavaFXWordGame\\dictionary.txt");
        input = new Scanner(inFile);
        
        guessedCount = 1;
        score = 30;
        dictionaryLength = 194000;
        library = new String[dictionaryLength];
        
        System.out.println("LOADING LIBRARY...");
        
        for(int i = 0; i < dictionaryLength; i++){
           library[i] = input.next();
        }
        
        System.out.println("LIBRARY LOADED");
        
        selector = (int)(Math.random() * 194000);
        temp = library[selector];
        
        wordLength = temp.length();
        
        word = new char[wordLength];
        for (int j = 0; j < wordLength; j++){
            word[j] = temp.charAt(j);
        }
        
        deciphered = new char[wordLength];
        for (int k = 0; k < wordLength; k++){
            deciphered[k] = '_';
        }
    }
    
    //score getter
    public int getScore(){
        return score;
    }
    
    //word length getter
    public int getWordLength(){
        return wordLength;
    }
    
    //get the character at the requested index location from the deciphered array
    public char getDecipherdIndex(int i){
        return deciphered[i];
    }
    
    //deciphers the word and updates the score
    public void decipherWord(char g){
        score -= 10;
        int foundCount = 0;
        int points = 0;
     
        for(int i = 0; i < wordLength; i++){
           if(g == word[i]){
               deciphered[i] = word[i];
               foundCount++;
           }
       }
       
        points = foundCount * 15;
        score += points;
    }

    //add last guess to the guessed list 
    public void addToGuessed(char g){
        guessed = new char[guessedCount];
        guessed[guessedCount - 1] = g;
        guessedCount++;
    }
    
    //checks to see if the specified character has already been guessed
    public boolean isGuessed(char g){
        for(int i = 0; i < guessedCount; i++){
            if(g == guessed[i]){
                return true;
            }
        }
        
        return false;
    }
    
    //checks to see if the word is deciphered
    public boolean isSolved(){
        for(int i = 0; i < wordLength; i++){
            if(deciphered[i] == '_'){
                return false;
            }
        }
        
        return true;
    }
    
    //Creates new game
    public void newGame(){
        selector = (int)(Math.random() * 194000);
        temp = library[selector];
        
        wordLength = temp.length();
        
        word = new char[wordLength];
        for (int j = 0; j < wordLength; j++){
            word[j] = temp.charAt(j);
        }
        
        deciphered = new char[wordLength];
        for (int k = 0; k < wordLength; k++){
            deciphered[k] = '_';
        }
        
        score = 30;
        guessedCount = 1;
        guessed = new char[guessedCount];
        guessed[0] = '*';
    }
}