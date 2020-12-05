package xyz.neomtech.javafxmettle;

public class Players {
    boolean turn;
    int score;
    int termPlayed;

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTermPlayed() {
        return termPlayed;
    }

    public void setTermPlayed(int termPlayed) {
        this.termPlayed = termPlayed;
    }
}
