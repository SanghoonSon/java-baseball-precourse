package baseball.domain.umpire;

public enum JudgmentResult {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String details;

    JudgmentResult(String details) {
        this.details = details;
    }

    public String getDetails() {
        return this.details;
    }
}
