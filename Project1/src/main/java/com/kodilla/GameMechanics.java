package com.kodilla;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class GameMechanics {

    private GameStatus gameStatus;
    private Validator gameValidator;
    private ValidatorHarder gameValidatorHard;

    public GameMechanics(Player actualPlayer) {
        this.gameStatus = new GameStatus(actualPlayer);
        this.gameValidator = new Validator();
        this.gameValidatorHard = new ValidatorHarder();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void clickButton(Button button, GridPane gridPane) {

        if(!gameStatus.getEndGame()) {
            int id = Integer.parseInt(button.getId());
            button.setGraphic(new ImageView(gameStatus.getActualPlayer().getActualShape().getShape()));
            setCrossAndCircleInButtonsBasedId(id);
            gameStatus.setRoundNumber(gameStatus.getRoundNumber() + 1);

            if (gameValidator.checkDidYouWin(gameStatus.getGameBoard())) {
                gameStatus.setEndGame(true);
                createMessageBox();
            }


            changePlayer();
        }

        if (gameStatus.getRoundNumber() != 9 && !gameStatus.getEndGame()) {
            computerClickButton(gridPane);
        }

        if (gameStatus.getRoundNumber() == 9 && !gameStatus.getEndGame()) {
            createDrawBox();
        }

    }
    public void clickButtonHard(Button button, GridPane gridPane) {
        if(!gameStatus.getEndGame()) {
            int id = Integer.parseInt(button.getId());
            button.setGraphic(new ImageView(gameStatus.getActualPlayer().getActualShape().getShape()));
            setCrossAndCircleInButtonsBasedIdHard(id);
            gameStatus.setRoundNumber(gameStatus.getRoundNumber() + 1);

            if (gameValidatorHard.checkWhoWin(gameStatus.getGameBoardHard())) {
                gameStatus.setEndGame(true);
                createMessageBox();
            }

            changePlayer();
        }

        if (gameStatus.getRoundNumber() !=25 && !gameStatus.getEndGame()) {
            computerClickButtonHard(gridPane);
        }
        if (gameStatus.getRoundNumber() == 25 && !gameStatus.getEndGame()) {
            createDrawBox();
        }
    }


    private void setCrossAndCircleInButtonsBasedId(int buttonID) {

        Shape[] temporaryArray = gameStatus.getGameBoard();
        temporaryArray[buttonID-1] = gameStatus.getActualPlayer().getActualShape();
        gameStatus.setGameBoard(temporaryArray);
    }
    private void setCrossAndCircleInButtonsBasedIdHard(int buttonID) {

        Shape[] temporaryArray = gameStatus.getGameBoardHard();
        temporaryArray[buttonID - 1] = gameStatus.getActualPlayer().getActualShape();
        gameStatus.setGameBoardHard(temporaryArray);
    }

    private int computerMoveGenerator() {
        Random computerMoveGenerator = new Random();
        return computerMoveGenerator.nextInt(9) +1;
    }
    private int computerMoveGeneratorHard() {
        Random computerMoveGenerator = new Random();
        return computerMoveGenerator.nextInt(25) +1;
    }

    private String computerMoveInString() {

        boolean correctMove = false;
        Shape[] temporaryArray = gameStatus.getGameBoard();
        int computerMoveInInt = computerMoveGenerator();

        while(!correctMove) {
            if (temporaryArray[computerMoveInInt-1] != null) {
                computerMoveInInt = computerMoveGenerator();
            }else {
                correctMove = true;
            }
        }

        setCrossAndCircleInButtonsBasedId(computerMoveInInt);
        return "#" + computerMoveInInt;
    }

    private String computerMoveInStringHard() {

        boolean correctMove = false;
        Shape[] temporaryArray = gameStatus.getGameBoardHard();
        int computerMoveInInt = computerMoveGeneratorHard();

        while(!correctMove) {
            if (temporaryArray[computerMoveInInt-1] != null) {
                computerMoveInInt = computerMoveGeneratorHard();
            }else {
                correctMove = true;
            }
        }

        setCrossAndCircleInButtonsBasedIdHard(computerMoveInInt);
        return "#" + computerMoveInInt;
    }

    public void computerClickButton(GridPane gridPane) {
        Button computerButton = (Button) gridPane.lookup(computerMoveInString());
        computerButton.setGraphic(new ImageView(gameStatus.getActualPlayer().getActualShape().getShape()));
        computerButton.setDisable(true);

        gameStatus.setRoundNumber(gameStatus.getRoundNumber()+1);

        if(gameValidator.checkDidYouWin(gameStatus.getGameBoard())) {
            gameStatus.setEndGame(true);
            createMessageBox();
        }

        changePlayer();
    }

    public void computerClickButtonHard(GridPane gridPane) {
        Button computerButtonHard = (Button) gridPane.lookup(computerMoveInStringHard());
        computerButtonHard.setGraphic(new ImageView(gameStatus.getActualPlayer().getActualShape().getShape()));
        computerButtonHard.setDisable(true);

        gameStatus.setRoundNumber(gameStatus.getRoundNumber()+1);

        if(gameValidatorHard.checkWhoWin(gameStatus.getGameBoardHard())) {
            gameStatus.setEndGame(true);
            createMessageBox();
        }
        changePlayer();
    }

    private void changePlayer() {
        Player temporaryPlayer = gameStatus.getActualPlayer();

        gameStatus.setActualPlayer(gameStatus.getSecondPlayer());
        gameStatus.setSecondPlayer(temporaryPlayer);
    }

    public void createMessageBox() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Rozpocznij nowa gre", ButtonType.OK);
        alert.setTitle("Koniec gry");
        alert.setHeaderText("Koniec gry");
        alert.setContentText("Wygral " + gameStatus.getActualPlayer());
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }

    public void createDrawBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Draw", ButtonType.OK);
        alert.setTitle("Koniec gry");
        alert.setHeaderText("Koniec gry");
        alert.setContentText("Nikt nie wygral. Remis!");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }
}