package baseball.domain.umpire;

import java.util.HashMap;
import java.util.Map;

public class JudgmentResults {
    private final Map<JudgmentResult, Integer> results;

    public JudgmentResults() {
        this.results = new HashMap<>();
    }

    public boolean isAllStrike() {
        return getHitCount(JudgmentResult.STRIKE) == 3;
    }

    public boolean isAllNothing() {
        return getHitCount(JudgmentResult.NOTHING) == 3;
    }

    public void add(JudgmentResult result) {
        int hitCount = getHitCount(result);
        results.put(result, hitCount + 1);
    }

    @Override
    public String toString() {
        if(isAllStrike()) {
            return getHitCount(JudgmentResult.STRIKE) + JudgmentResult.STRIKE.getDetails();
        }

        if(isAllNothing()) {
            return JudgmentResult.NOTHING.getDetails();
        }
        return resultOutput();
    }

    private int getHitCount(JudgmentResult result) {
        return results.get(result) == null ? 0 : results.get(result);
    }

    private String resultOutput() {
        StringBuilder output = new StringBuilder();
        appendResultOutput(output, JudgmentResult.BALL);
        appendResultOutput(output, JudgmentResult.STRIKE);
        return output.toString();
    }

    private void appendResultOutput(StringBuilder output, JudgmentResult judgmentResult) {
        int hitCount = getHitCount(judgmentResult);
        if(hitCount == 0) {
            return;
        }
        if(output.length() > 0) {
            output.append(" ");
        }
        output.append(hitCount).append(judgmentResult.getDetails());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JudgmentResults that = (JudgmentResults) o;

        return results.equals(that.results);
    }

    @Override
    public int hashCode() {
        return results.hashCode();
    }
}
