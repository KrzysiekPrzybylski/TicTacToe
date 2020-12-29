package com.kodilla;

public class ValidatorHarder {

    public boolean checkWhoWin(Shape[] gameBoardHard) {
        return checkFirstRow(gameBoardHard) || checkSecondRow(gameBoardHard) || checkThirdRow(gameBoardHard) ||
                checkFourthRow(gameBoardHard) || checkFifthRow(gameBoardHard) || checkFirstCol(gameBoardHard) || checkSecondCol(gameBoardHard) || checkThirdCol(gameBoardHard) ||
                checkFourthCol(gameBoardHard) || checkFifthCol(gameBoardHard) ||
                checkFirstSlant(gameBoardHard) || checkSecondSlant(gameBoardHard);
    }


    private boolean checkFirstRow(Shape[] gameBoardHard) {
        return gameBoardHard[0] == gameBoardHard[1] && gameBoardHard[1] == gameBoardHard[2] && gameBoardHard[2] == gameBoardHard[3] && gameBoardHard[3] == gameBoardHard[4] && gameBoardHard[0] != null;
    }
    private boolean checkSecondRow(Shape[] gameBoardHard) {
        return gameBoardHard[5] == gameBoardHard[6] && gameBoardHard[6] == gameBoardHard[7] && gameBoardHard[7] == gameBoardHard[8] && gameBoardHard[8] == gameBoardHard[9] && gameBoardHard[5] != null;
    }
    private boolean checkThirdRow(Shape[] gameBoardHard) {
        return gameBoardHard[10] == gameBoardHard[11] && gameBoardHard[11] == gameBoardHard[12] && gameBoardHard[12] == gameBoardHard[13] && gameBoardHard[13] == gameBoardHard[14] && gameBoardHard[10] != null;
    }
    private boolean checkFourthRow(Shape[] gameBoardHard) {
        return gameBoardHard[15] == gameBoardHard[16] && gameBoardHard[16] == gameBoardHard[17] && gameBoardHard[17] == gameBoardHard[18] && gameBoardHard[18] == gameBoardHard[19] && gameBoardHard[15] != null;
    }
    private boolean checkFifthRow(Shape[] gameBoardHard) {
        return gameBoardHard[20] == gameBoardHard[21] && gameBoardHard[21] == gameBoardHard[22] && gameBoardHard[22] == gameBoardHard[23] && gameBoardHard[23] == gameBoardHard[24] && gameBoardHard[20] != null;
    }
    private boolean checkFirstCol(Shape[] gameBoardHard) {
        return gameBoardHard[0] == gameBoardHard[5] && gameBoardHard[5] == gameBoardHard[10] && gameBoardHard[10] == gameBoardHard[15] && gameBoardHard[15] == gameBoardHard[20] && gameBoardHard[0] != null;
    }
    private boolean checkSecondCol(Shape[] gameBoardHard) {
        return gameBoardHard[1] == gameBoardHard[6] && gameBoardHard[6] == gameBoardHard[11] && gameBoardHard[11] == gameBoardHard[16] && gameBoardHard[16] == gameBoardHard[21] && gameBoardHard[1] != null;
    }
    private boolean checkThirdCol(Shape[] gameBoardHard) {
        return gameBoardHard[2] == gameBoardHard[7] && gameBoardHard[7] == gameBoardHard[12] && gameBoardHard[12] == gameBoardHard[17] && gameBoardHard[17] == gameBoardHard[22] && gameBoardHard[2] != null;
    }
    private boolean checkFourthCol(Shape[] gameBoardHard) {
        return gameBoardHard[3] == gameBoardHard[8] && gameBoardHard[8] == gameBoardHard[13] && gameBoardHard[13] == gameBoardHard[18] && gameBoardHard[18] == gameBoardHard[23] && gameBoardHard[3] != null;
    }
    private boolean checkFifthCol(Shape[] gameBoardHard) {
        return gameBoardHard[4] == gameBoardHard[9] && gameBoardHard[9] == gameBoardHard[14] && gameBoardHard[14] == gameBoardHard[19] && gameBoardHard[19] == gameBoardHard[24] && gameBoardHard[4] != null;
    }
    private boolean checkFirstSlant(Shape[] gameBoardHard) {
        return gameBoardHard[0] == gameBoardHard[6] && gameBoardHard[6] == gameBoardHard[12] && gameBoardHard[12] == gameBoardHard[18] && gameBoardHard[18] == gameBoardHard[24] && gameBoardHard[24] !=null;
    }
    private boolean checkSecondSlant(Shape[] gameBoardHard) {
        return gameBoardHard[20] == gameBoardHard[16] && gameBoardHard[16] == gameBoardHard[12] && gameBoardHard[12] == gameBoardHard[8] && gameBoardHard[8] == gameBoardHard[4] && gameBoardHard[4] !=null;
    }
}
