package bai8_cleancode.baitap;

public class TennisGame {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String ALL = "-All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Advantage ";
    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String WIN_FOR = "Win for ";

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            switch (m_score1) {
                case 0:
                    score = LOVE + ALL;
                    break;
                case 1:
                    score = FIFTEEN + ALL;
                    break;
                case 2:
                    score = THIRTY + ALL;
                    break;
                case 3:
                    score = FORTY + ALL;
                    break;
                default:
                    score = DEUCE;
                    break;

            }
        } else {
            boolean isScoreMoreThan4 = m_score1 >= 4 || m_score2 >= 4;
            if (isScoreMoreThan4) {
                int minusResult = m_score1 - m_score2;
                if (minusResult == 1) score = ADVANTAGE + PLAYER_1;
                else if (minusResult == -1) score = ADVANTAGE + PLAYER_2;
                else if (minusResult >= 2) score = WIN_FOR + PLAYER_1;
                else score = WIN_FOR + PLAYER_2;
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = m_score1;
                    else {
                        score += "-";
                        tempScore = m_score2;
                    }
                    switch (tempScore) {
                        case 0:
                            score += LOVE;
                            break;
                        case 1:
                            score += FIFTEEN;
                            break;
                        case 2:
                            score += THIRTY;
                            break;
                        case 3:
                            score += FORTY;
                            break;
                    }
                }
            }
        }
        return score;
    }
}
