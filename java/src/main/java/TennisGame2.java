
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
        if (p1Point == p2Point) {
            return tie();
        }
        // スモールステップで手が付けられない
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

        return convetScoreIntToString(p1Point) + "-" + convetScoreIntToString(p2Point);
    }

    private String convetScoreIntToString(int p1Point) {
        if (p1Point == 0)
            return "Love";
        if (p1Point == 1)
            return "Fifteen";
        if (p1Point == 2)
            return "Thirty";
        else
            return "Forty";
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