
public class TennisGame2 implements TennisGame {
    private String player1Name;
    private String player2Name;
    private int P1point;
    private int P2point;
    private String P1res;
    private String P2res;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (P1point == P2point && P1point < 3) {
            return tie();
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point == 0) {
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage " + player1Name;
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage " + player2Name;
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for " + player1Name;
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for " + player2Name;
        }
        return score;
    }

    private String tie() {
        String score = "";
        if (P1point == 0)
            score = "Love";
        if (P1point == 1)
            score = "Fifteen";
        if (P1point == 2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    public void setP1Score(int score) {
        P1point = score;
    }

    public void setP2Score(int score) {
        P2point = score;
    }

    public void wonPoint(String player) {
    }
}