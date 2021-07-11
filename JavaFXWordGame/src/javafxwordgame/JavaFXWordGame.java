/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxwordgame;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;


public class JavaFXWordGame extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        wordType word = new wordType();

        //Create background
        BackgroundFill mainBackgroundFill = new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        
        //Create Panes
        VBox root = new VBox();
        root.setSpacing(150);
        root.setBackground(new Background(mainBackgroundFill));
        HBox scorePane = new HBox();
        scorePane.setAlignment(Pos.CENTER);
        scorePane.setSpacing(200);
        scorePane.setStyle("-fx-font-size:24");
        HBox wordPane = new HBox();
        wordPane.setAlignment(Pos.CENTER);
        wordPane.setSpacing(25);
        VBox buttonsPane = new VBox();
        buttonsPane.setSpacing(25);
        HBox topButtons = new HBox();
        topButtons.setAlignment(Pos.CENTER);
        topButtons.setSpacing(25);
        topButtons.setStyle("-fx-font-size:24");
        HBox middleButtons = new HBox();
        middleButtons.setAlignment(Pos.CENTER);
        middleButtons.setSpacing(25);
        middleButtons.setStyle("-fx-font-size:24");
        HBox bottomButtons = new HBox();
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setSpacing(25);
        bottomButtons.setStyle("-fx-font-size:24");
        
        //Create initial score label
        Label scoreBox = new Label("Score: " + word.getScore());
        scoreBox.setFont(new Font("Arial", 64));
        
        //Create initial word labels
        for(int i = 0; i < word.getWordLength(); i++){
            String temp = Character.toString(word.getDecipherdIndex(i));
            Label wordBox = new Label(temp);
            wordBox.setFont(new Font("Arial", 64));
            wordPane.getChildren().add(wordBox);
        }

        //Create Scene
        Scene scene = new Scene(root, 1024, 768);
        
        //Create Stage
        primaryStage.setTitle("Adam's Word Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Create new game button
        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setAlignment(Pos.TOP_LEFT);
        
        //Create top row buttons
        Button qBtn = new Button();
        qBtn.setText("Q");
        qBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('q');
                word.addToGuessed('q');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('q')){
                    qBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button wBtn = new Button();
        wBtn.setText("W");
        wBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('w');
                word.addToGuessed('w');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('w')){
                    wBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button eBtn = new Button();
        eBtn.setText("E");
        eBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('e');
                word.addToGuessed('e');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('e')){
                    eBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button rBtn = new Button();
        rBtn.setText("R");
        rBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('r');
                word.addToGuessed('r');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('r')){
                    rBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button tBtn = new Button();
        tBtn.setText("T");
        tBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('t');
                word.addToGuessed('t');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('t')){
                    tBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button yBtn = new Button();
        yBtn.setText("Y");
        yBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('y');
                word.addToGuessed('y');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('y')){
                    yBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button uBtn = new Button();
        uBtn.setText("U");
        uBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('u');
                word.addToGuessed('u');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('u')){
                    uBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button iBtn = new Button();
        iBtn.setText("I");
        iBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('i');
                word.addToGuessed('i');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('i')){
                    iBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button oBtn = new Button();
        oBtn.setText("O");
        oBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('o');
                word.addToGuessed('o');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('o')){
                    oBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button pBtn = new Button();
        pBtn.setText("P");
        pBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('p');
                word.addToGuessed('p');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('p')){
                    pBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        //Create middle buttons
        Button aBtn = new Button();
        aBtn.setText("A");
        aBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('a');
                word.addToGuessed('a');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('a')){
                    aBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button sBtn = new Button();
        sBtn.setText("S");
        sBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('s');
                word.addToGuessed('s');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('s')){
                    sBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button dBtn = new Button();
        dBtn.setText("D");
        dBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('d');
                word.addToGuessed('d');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('d')){
                    dBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button fBtn = new Button();
        fBtn.setText("F");
        fBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('f');
                word.addToGuessed('f');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('f')){
                    fBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button gBtn = new Button();
        gBtn.setText("G");
        gBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('g');
                word.addToGuessed('g');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('g')){
                    gBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button hBtn = new Button();
        hBtn.setText("H");
        hBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('h');
                word.addToGuessed('h');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('h')){
                    hBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button jBtn = new Button();
        jBtn.setText("J");
        jBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('j');
                word.addToGuessed('j');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('j')){
                    jBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button kBtn = new Button();
        kBtn.setText("K");
        kBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('k');
                word.addToGuessed('k');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('k')){
                    kBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button lBtn = new Button();
        lBtn.setText("L");
        lBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('l');
                word.addToGuessed('l');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('l')){
                    lBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        //Create bottom buttons
        Button zBtn = new Button();
        zBtn.setText("Z");
        zBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('z');
                word.addToGuessed('z');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('z')){
                    zBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button xBtn = new Button();
        xBtn.setText("X");
        xBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('x');
                word.addToGuessed('x');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('x')){
                    xBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button cBtn = new Button();
        cBtn.setText("C");
        cBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('c');
                word.addToGuessed('c');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('c')){
                    cBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button vBtn = new Button();
        vBtn.setText("V");
        vBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('v');
                word.addToGuessed('v');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('v')){
                    vBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button bBtn = new Button();
        bBtn.setText("B");
        bBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('b');
                word.addToGuessed('b');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('b')){
                    bBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button nBtn = new Button();
        nBtn.setText("N");
        nBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('n');
                word.addToGuessed('n');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('n')){
                    nBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        Button mBtn = new Button();
        mBtn.setText("M");
        mBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                word.decipherWord('m');
                word.addToGuessed('m');
                for(int j = 0; j < word.getWordLength(); j++){
                    String temp = Character.toString(word.getDecipherdIndex(j));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);   
                }
                
                Label scoreBox = new Label("Score: " + word.getScore());
                scoreBox.setFont(new Font("Arial", 64));
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                if(word.isGuessed('m')){
                    mBtn.setDisable(true);
                }
                
                if (word.isSolved()){
                    buttonsPane.getChildren().clear();
                    Label winBox = new Label("WORD SOLVED!!!");
                    winBox.setFont(new Font("Arial", 72));
                    buttonsPane.setAlignment(Pos.CENTER);
                    buttonsPane.getChildren().add(winBox);
                }
            }
        });
        
        //new game button event handler
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                word.newGame();
                scorePane.getChildren().clear();
                wordPane.getChildren().clear();
                buttonsPane.getChildren().clear();
                for(int i = 0; i < word.getWordLength(); i++){
                    String temp = Character.toString(word.getDecipherdIndex(i));
                    Label wordBox = new Label(temp);
                    wordBox.setFont(new Font("Arial", 64));
                    wordPane.getChildren().add(wordBox);
                }
                
                buttonsPane.getChildren().addAll(topButtons, middleButtons, bottomButtons);
                scorePane.getChildren().addAll(newGame, scoreBox);
                
                qBtn.setDisable(false);
                wBtn.setDisable(false);
                eBtn.setDisable(false);
                rBtn.setDisable(false);
                tBtn.setDisable(false);
                yBtn.setDisable(false);
                uBtn.setDisable(false);
                iBtn.setDisable(false);
                oBtn.setDisable(false);
                pBtn.setDisable(false);
                aBtn.setDisable(false);
                sBtn.setDisable(false);
                dBtn.setDisable(false);
                fBtn.setDisable(false);
                gBtn.setDisable(false);
                hBtn.setDisable(false);
                jBtn.setDisable(false);
                kBtn.setDisable(false);
                lBtn.setDisable(false);
                zBtn.setDisable(false);
                xBtn.setDisable(false);
                cBtn.setDisable(false);
                vBtn.setDisable(false);
                bBtn.setDisable(false);
                nBtn.setDisable(false);
                mBtn.setDisable(false);
            }
        });

        //Add children panes and nodes to parent panes
        root.getChildren().addAll(scorePane, wordPane, buttonsPane);
        scorePane.getChildren().addAll(newGame, scoreBox);
        buttonsPane.getChildren().addAll(topButtons, middleButtons, bottomButtons);
        topButtons.getChildren().addAll(qBtn, wBtn, eBtn, rBtn, tBtn, yBtn, uBtn, iBtn, oBtn, pBtn);
        middleButtons.getChildren().addAll(aBtn, sBtn, dBtn, fBtn, gBtn, hBtn, jBtn, kBtn, lBtn);
        bottomButtons.getChildren().addAll(zBtn, xBtn, cBtn, vBtn, bBtn, nBtn, mBtn);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
