
public class TennisGame2 implements TennisGame {
    private String player1Name;
    private String player2Name;
    private int p1Point;
    private int p2Point;
    private String p1Res;
    private String p2Res;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (p1Point == p2Point) {
            return tie();
        }
        if (p1Point >= 4 && p2Point >= 0 && (p1Point - p2Point) >= 2) {
            return "Win for " + player1Name;
        }
        if (p2Point >= 4 && p1Point >= 0 && (p2Point - p1Point) >= 2) {
            return "Win for " + player2Name;
        }
        
        if (p1Point > p2Point && p2Point >= 3) {
            return "Advantage " + player1Name;
        }

        if (p2Point > p1Point && p1Point >= 3) {
            return "Advantage " + player2Name;
        }


        if (p1Point > 0 && p2Point == 0) {
            if (p1Point == 1)
                p1Res = "Fifteen";
            if (p1Point == 2)
                p1Res = "Thirty";
            if (p1Point == 3)
                p1Res = "Forty";

            p2Res = "Love";
            score = p1Res + "-" + p2Res;
        }
        if (p2Point > 0 && p1Point == 0) {
            if (p2Point == 1)
                p2Res = "Fifteen";
            if (p2Point == 2)
                p2Res = "Thirty";
            if (p2Point == 3)
                p2Res = "Forty";

            p1Res = "Love";
            score = p1Res + "-" + p2Res;
        }

        if (p1Point > p2Point && p1Point < 4) {
            if (p1Point == 2)
                p1Res = "Thirty";
            if (p1Point == 3)
                p1Res = "Forty";
            if (p2Point == 1)
                p2Res = "Fifteen";
            if (p2Point == 2)
                p2Res = "Thirty";
            score = p1Res + "-" + p2Res;
        }
        if (p2Point > p1Point && p2Point < 4) {
            if (p2Point == 2)
                p2Res = "Thirty";
            if (p2Point == 3)
                p2Res = "Forty";
            if (p1Point == 1)
                p1Res = "Fifteen";
            if (p1Point == 2)
                p1Res = "Thirty";
            score = p1Res + "-" + p2Res;
        }

        return score;
    }

    private String tie() {
        switch (p1Point) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    public void setP1Score(int score) {
        p1Point = score;
    }

    public void setP2Score(int score) {
        p2Point = score;
    }

    public void wonPoint(String player) {
    }
}