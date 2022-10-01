package baseball.global.random;

import baseball.global.random.exception.NotFoundRandomNumberFetchStrategy;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public abstract class RandomNumberGenerator {

    private static final List<Integer> NUMBER_RANGE;
    private static final int NUMBER_RANGE_MIN;
    private static final int NUMBER_RANGE_MAX;

    static {
        NUMBER_RANGE_MIN = 1;
        NUMBER_RANGE_MAX = 9;
        NUMBER_RANGE = new ArrayList<>();
        for (int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++) {
            NUMBER_RANGE.add(i);
        }
    }

    public static int createBy(final RandomNumberFetchStrategy strategy) {
        if(RandomNumberFetchStrategy.LIST.equals(strategy)) {
            return Randoms.pickNumberInList(NUMBER_RANGE);
        }

        if(RandomNumberFetchStrategy.RANGE.equals(strategy)) {
            return Randoms.pickNumberInRange(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
        }

        throw new NotFoundRandomNumberFetchStrategy();
    }
}
