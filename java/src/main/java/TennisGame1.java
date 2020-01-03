
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
        StringBuilder score = new StringBuilder();
        if (m_score1 == m_score2) {
            score = getScoreNormal();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            int minusResult = m_score1 - m_score2;
            score = getScoreOver(minusResult);
        } else {
            getScoreElse(score);
        }
        return score.toString();
    }

    private void getScoreElse(StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_score1;
            else {
                score.append("-");
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
    }

    private StringBuilder getScoreOver(int minusResult) {
        StringBuilder score;
        if (minusResult == 1) score = new StringBuilder("Advantage " + this.player1Name);
        else if (minusResult == -1) score = new StringBuilder("Advantage " + this.player2Name);
        else if (minusResult >= 2) score = new StringBuilder("Win for " + this.player1Name);
        else score = new StringBuilder("Win for " + this.player2Name);
        return score;
    }

    private StringBuilder getScoreNormal() {
        StringBuilder score;
        switch (m_score1) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score;
    }
}
