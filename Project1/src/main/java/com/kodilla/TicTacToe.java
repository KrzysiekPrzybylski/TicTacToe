package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class TicTacToe extends Application {


    private GameMechanics myGame;

    public static void main(String[] args) {
        launch(args);
    }

    private static void accept(ButtonType rs) {
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(createBoard());
        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createBoard() {
        GridPane grid = new GridPane();

        Label helloLabel = new Label("Kolko i Krzyzyk");
        helloLabel.setFont(new Font("Arial", 18));
        helloLabel.setPadding(new Insets(10,10,10,0));

        grid.add(helloLabel, 0, 0, 3,1);

        Label whoStartsLabel = new Label("Kto rozpoczyna?");
        whoStartsLabel.setFont(fontInApplication());

        RadioButton playerStarts = new RadioButton("Gracz");
        playerStarts.setFont(fontInApplication());

        RadioButton computerStarts = new RadioButton("Komputer");
        computerStarts.setFont(fontInApplication());


        ToggleGroup toggleGroupWhoStart = new ToggleGroup();
        playerStarts.setToggleGroup(toggleGroupWhoStart);
        computerStarts.setToggleGroup(toggleGroupWhoStart);


        grid.add(whoStartsLabel, 5,0,1,1);
        grid.add(playerStarts, 5, 1,1,1);
        grid.add(computerStarts,5,2,1,1);


        Label whatShape = new Label("Wybierz ksztalt: ");
        whatShape.setFont(fontInApplication());

        RadioButton chooseCross = new RadioButton("Krzyzyk");
        chooseCross.setFont(fontInApplication());

        RadioButton chooseCircle = new RadioButton("Kolko");
        chooseCircle.setFont(fontInApplication());

        ToggleGroup toggleGroupWhatShape = new ToggleGroup();
        chooseCircle.setToggleGroup(toggleGroupWhatShape);
        chooseCross.setToggleGroup(toggleGroupWhatShape);

        grid.add(whatShape, 6, 0,1,1);
        grid.add(chooseCircle, 6, 1,1, 1);
        grid.add(chooseCross, 6, 2,1,1);

        Label difficultyLevel = new Label("Poziom trudnosci");
        difficultyLevel.setFont(fontInApplication());

        RadioButton easyLevel = new RadioButton("3x3");
        easyLevel.setFont(fontInApplication());
        RadioButton hardLevel = new RadioButton("5x5");
        hardLevel.setFont(fontInApplication());

        ToggleGroup toggleWhichLevel = new ToggleGroup();
        easyLevel.setToggleGroup(toggleWhichLevel);
        hardLevel.setToggleGroup(toggleWhichLevel);

        grid.add(difficultyLevel, 7, 0,1,1);
        grid.add(easyLevel, 7, 1,1, 1);
        grid.add(hardLevel, 7, 2,1,1);

//        Button[] buttonsArray = new Button[9];
//
//        for(int i = 0; i < 9; i++) {
//            Button button = new Button(" ");
//            button.setMinSize(180, 180);
//            button.setId(String.valueOf(i+1));
//            button.setDisable(true);
//            buttonsArray[i] = button;
//        }
//
//        grid.add(buttonsArray[0], 0,3);
//        grid.add(buttonsArray[1], 1,3);
//        grid.add(buttonsArray[2], 2,3);
//        grid.add(buttonsArray[3], 0,4);
//        grid.add(buttonsArray[4], 1,4);
//        grid.add(buttonsArray[5], 2,4);
//        grid.add(buttonsArray[6], 0,5);
//        grid.add(buttonsArray[7], 1,5);
//        grid.add(buttonsArray[8], 2,5);
//
//        for(int i = 0; i < 9; i++) {
//            int finalI = i;
//            buttonsArray[i].setOnAction((event) -> {
//                myGame.clickButton(buttonsArray[finalI], grid);
//                buttonsArray[finalI].setDisable(true);
//            });
//        }

        Button[] buttonsArrayHard = new Button[25];

        for(int i = 0; i < 25; i++) {
            Button button = new Button("hard");
            button.setMinSize(160,160);
            button.setId(String.valueOf(i+1));
            button.setDisable(true);
            buttonsArrayHard[i] = button;
        }

        grid.add(buttonsArrayHard[0],0,1);
        grid.add(buttonsArrayHard[1],1,1);
        grid.add(buttonsArrayHard[2],2,1);
        grid.add(buttonsArrayHard[3],3,1);
        grid.add(buttonsArrayHard[4],4,1);
        grid.add(buttonsArrayHard[5],0,2);
        grid.add(buttonsArrayHard[6],1,2);
        grid.add(buttonsArrayHard[7],2,2);
        grid.add(buttonsArrayHard[8],3,2);
        grid.add(buttonsArrayHard[9],4,2);
        grid.add(buttonsArrayHard[10],0,3);
        grid.add(buttonsArrayHard[11],1,3);
        grid.add(buttonsArrayHard[12],2,3);
        grid.add(buttonsArrayHard[13],3,3);
        grid.add(buttonsArrayHard[14],4,3);
        grid.add(buttonsArrayHard[15],0,4);
        grid.add(buttonsArrayHard[16],1,4);
        grid.add(buttonsArrayHard[17],2,4);
        grid.add(buttonsArrayHard[18],3,4);
        grid.add(buttonsArrayHard[19],4,4);
        grid.add(buttonsArrayHard[20],0,5);
        grid.add(buttonsArrayHard[21],1,5);
        grid.add(buttonsArrayHard[22],2,5);
        grid.add(buttonsArrayHard[23],3,5);
        grid.add(buttonsArrayHard[24],4,5);

        for(int i = 0; i < 25; i++) {
            int finalI = i;
            buttonsArrayHard[i].setOnAction((event) -> {
                myGame.clickButtonHard(buttonsArrayHard[finalI], grid);
                buttonsArrayHard[finalI].setDisable(true);
            });
        }




        Button newGameButton = new Button("Rozpocznij");
        newGameButton.setFont(fontInApplication());
        newGameButton.setId("100");

        grid.add(newGameButton,3,0,2,1);

        newGameButton.setOnAction((event) ->{
            cleanup(buttonsArrayHard, (RadioButton) toggleGroupWhoStart.getSelectedToggle(),
                (RadioButton) toggleGroupWhatShape.getSelectedToggle(), grid);
                });

        createHelloBox();

        return grid;
    }
//    private void setWhichLevel(RadioButton selectedButtonWhichLevel) {
//
//        if(selectedButtonWhichLevel.getText().equals("3x3")) {
//            myGame = new GameMechanics(new Validator());
//
//        }


    private void cleanup(Button[] buttonsArrayHard, RadioButton selectedButtonWhoStart, RadioButton selectedButtonWhatShape, GridPane grid) {

        setWhoStart(selectedButtonWhoStart, selectedButtonWhatShape);

        for(int i = 0; i < 25; i ++) {
            buttonsArrayHard[i].setGraphic(null);
            buttonsArrayHard[i].setDisable(false);
        }

        if (myGame.getGameStatus().getActualPlayer() instanceof Computer) {
            myGame.computerClickButton(grid);
        }
    }

    private void setWhoStart(RadioButton selectedButtonWhoStart, RadioButton selectedButtonWhatShape) {

        if(selectedButtonWhoStart.getText().equals("Gracz")) {
            myGame = new GameMechanics(new User());
        } else if(selectedButtonWhoStart.getText().equals("Komputer")) {
            myGame = new GameMechanics(new Computer());
        }

        if(selectedButtonWhatShape.getText().equals("Kolko")) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Circle());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Cross());
        }else if(selectedButtonWhatShape.getText().equals("Krzyzyk")) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Cross());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Circle());
        }
    }

    public void createHelloBox() {
        Alert alert = new Alert(Alert.AlertType.NONE, "Hello", ButtonType.NEXT);
        alert.setTitle("Witaj!");
        alert.setHeaderText("Witaj w grze w kolko i krzyzyk");
        alert.setContentText("Przed rozpoczeciem gry wybierz gracza rozpoczynajacego oraz jego symbol. Nastepnie kliknij przycisk nowej gry.");
        alert.showAndWait().ifPresent(TicTacToe::accept);
    }




    private Font fontInApplication() {

        Font applicationFont = new Font("Arial", 13);
        return applicationFont;
    }
}