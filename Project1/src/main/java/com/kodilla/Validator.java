package com.kodilla;

public class Validator {

    public boolean checkDidYouWin(Shape[] gameBoard) {
        return checkFirstRow(gameBoard) || checkSecondRow(gameBoard) || checkThirdRow(gameBoard) ||
                checkFirstCol(gameBoard) || checkSecondCol(gameBoard) || checkThirdCol(gameBoard) ||
                checkFirstSlant(gameBoard) || checkSecondSlant(gameBoard);
    }
    private boolean checkFirstRow(Shape[] gameBoard) {
        return gameBoard[0] == gameBoard[1] && gameBoard[1] == gameBoard[2] && gameBoard[0] != null;
    }
    private boolean checkSecondRow(Shape[] gameBoard) {
        return gameBoard[3] == gameBoard[4] && gameBoard[4] == gameBoard[5] && gameBoard[3] != null;
    }
    private boolean checkThirdRow(Shape[] gameBoard) {
        return gameBoard[6] == gameBoard[7] && gameBoard[7] == gameBoard[8] && gameBoard[6] != null;
    }
    private boolean checkFirstCol(Shape[] gameBoard) {
        return  gameBoard[0] == gameBoard[3] && gameBoard[3] == gameBoard[6] && gameBoard[0] != null;
    }
    private boolean checkSecondCol(Shape[] gameBoard) {
        return gameBoard[1] == gameBoard[4] && gameBoard[4] == gameBoard[7] && gameBoard[1] != null;
    }
    private boolean checkThirdCol(Shape[] gameBoard) {
        return gameBoard[2] == gameBoard[5] && gameBoard[5] == gameBoard[8] && gameBoard[2] !=null;
    }
    private boolean checkFirstSlant(Shape[] gameBoard) {
        return gameBoard[0] == gameBoard[4] && gameBoard[4] == gameBoard[8] && gameBoard[0] !=null;
    }
    private boolean checkSecondSlant(Shape[] gameBoard) {
        return gameBoard[6] == gameBoard[4] && gameBoard[4] == gameBoard[2] && gameBoard[6] !=null;
    }
}

