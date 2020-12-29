package com.kodilla;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class GameStatus {

    private Player actualPlayer;
    private Player secondPlayer;
    private Shape[] gameBoard;
    private Shape[] gameBoardHard;
    private int roundNumber;
    private boolean endGame;

    public GameStatus(Player actualPlayer) {
        this.actualPlayer = actualPlayer;

        if (actualPlayer instanceof User) {
            this.secondPlayer = new Computer();
        } else if (actualPlayer instanceof Computer) {
            this.secondPlayer = new User();
        }
        roundNumber = 0;
        gameBoard = new Shape[9];
        gameBoardHard = new Shape[25];
        endGame = false;
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

    public void setActualPlayer(Player actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public Shape[] getGameBoard() {
        return gameBoard;
    }

    public Shape[] getGameBoardHard() {
        return gameBoardHard;
    }

    public void setGameBoardHard(Shape[] gameBoardHard) {
        this.gameBoardHard = gameBoardHard;
    }

    public void setGameBoard(Shape[] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public boolean getEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
}
