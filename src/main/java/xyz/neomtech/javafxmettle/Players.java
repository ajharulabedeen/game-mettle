package xyz.neomtech.javafxmettle;

public class Players {
    boolean turn;
    int score;
    int termPlayed;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Players() {

    }

    public Players(String name) {
        this.name = name;
    }

    public Players(boolean turn, int score, int termPlayed, String name) {
        this.turn = turn;
        this.score = score;
        this.termPlayed = termPlayed;
        this.name = name;
    }

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
