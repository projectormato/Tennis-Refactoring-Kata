
public class TennisGame1 implements TennisGame {

    // これ消せない...？
    private int m_score1 = 0;
    private int m_score2 = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            m_score1 += 1;
        else if (playerName.equals(this.player2Name)) {
            m_score2 += 1;
        }
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) {
            score = getScoreNormal();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getScoreOver();
        } else {
            score = getScoreElse();
        }
        return score;
    }

    private String getScoreElse() {
        return convertScoreIntToString(m_score1) + "-" + convertScoreIntToString(m_score2);
    }

    private String convertScoreIntToString(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private String getScoreOver() {
        String result;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) result = "Advantage " + this.player1Name;
        else if (minusResult == -1) result = "Advantage " + this.player2Name;
        else if (minusResult >= 2) result = "Win for " + this.player1Name;
        else result = "Win for " + this.player2Name;
        return result;
    }

    private String getScoreNormal() {
        String result;
        switch (m_score1) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }
}
