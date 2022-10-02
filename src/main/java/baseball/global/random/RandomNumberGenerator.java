package baseball.global.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public abstract class RandomNumberGenerator {

    private static final int NUMBER_RANGE_MIN;
    private static final int NUMBER_RANGE_MAX;
    private static final int NUMBER_RANGE_COUNT;

    static {
        NUMBER_RANGE_MIN = 1;
        NUMBER_RANGE_MAX = 9;
        NUMBER_RANGE_COUNT = 3;
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < NUMBER_RANGE_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX);
            addRandomNumber(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private static void addRandomNumber(List<Integer> randomNumbers, int randomNumber) {
        if(!isContainsRandomNumber(randomNumbers, randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

    private static boolean isContainsRandomNumber(List<Integer> randomNumbers, int randomNumber) {
        return randomNumbers.contains(randomNumber);
    }
}
