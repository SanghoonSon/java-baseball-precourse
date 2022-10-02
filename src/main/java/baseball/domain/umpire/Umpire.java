package baseball.domain.umpire;

import java.util.List;

public class Umpire {

    private Umpire() {
    }

    public static Umpire create() {
        return new Umpire();
    }

    public JudgmentResults judge(List<Integer> offensePlayerNumbers, List<Integer> defencePlayerNumbers) {
        JudgmentResults judgmentResults = new JudgmentResults();
        int offensePlayerNumberSize = offensePlayerNumbers.size();
        for (int i = 0; i < offensePlayerNumberSize; i++) {
            JudgmentResult result = match(defencePlayerNumbers, i, offensePlayerNumbers.get(i));
            judgmentResults.add(result);
        }

        return judgmentResults;
    }

    private JudgmentResult match(List<Integer> defencePlayerNumbers, int sequence, int offensePlayerNumber) {
        if(defencePlayerNumbers.get(sequence) == offensePlayerNumber) {
            return JudgmentResult.STRIKE;
        }

        if(defencePlayerNumbers.contains(offensePlayerNumber)) {
            return JudgmentResult.BALL;
        }

        return JudgmentResult.NOTHING;
    }
}
