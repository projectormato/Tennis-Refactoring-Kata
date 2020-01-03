
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
        if (m_score1 == m_score2) {
            return getScoreTie();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreAdvantageOrWin();
        } else {
            return getScoreNormal();
        }
    }

    private String getScoreTie() {
        switch (m_score1) {
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

    private String getScoreAdvantageOrWin() {
        return getAdvantageOrWin() + getAdvantagePlayer();
    }

    private String getAdvantagePlayer() {
        return m_score1 - m_score2 >= 1 ? this.player1Name : this.player2Name;
    }

    private String getAdvantageOrWin() {
        return Math.abs(m_score1 - m_score2) > 1 ? "Win for " : "Advantage ";
    }

    private String getScoreNormal() {
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
}
