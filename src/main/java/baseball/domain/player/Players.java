package baseball.domain.player;

public class Players {

    private final Player offensePlayer;
    private final Player defencePlayer;

    private Players(Player offensePlayer, Player defencePlayer) {
        this.offensePlayer = offensePlayer;
        this.defencePlayer = defencePlayer;
    }

    public static Players of(Player offensePlayer, Player defencePlayer) {
        if(offensePlayer == null) {
            throw new IllegalArgumentException("공격수가 없습니다.");
        }

        if(defencePlayer == null) {
            throw new IllegalArgumentException("수비수가 없습니다.");
        }
        return new Players(offensePlayer, defencePlayer);
    }

    public Player getOffensePlayer() {
        return this.offensePlayer;
    }

    public Player getDefencePlayer() {
        return this.defencePlayer;
    }
}