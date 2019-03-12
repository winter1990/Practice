package practice.leetcode.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @dp
 *
 * Input: maxChoosableInteger = 10, desiredTotal = 11, Output: false
 *
 * if player 1 can make some move, that for any move player 2 choose, player 1 can win
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        boolean[] isVisited = new boolean[maxChoosableInteger + 1];
        return canWin(maxChoosableInteger, desiredTotal, map, isVisited);
    }

    private boolean canWin(int maxChoosableInteger, int desiredTotal, Map<String, Boolean> map, boolean[] isVisited) {
        if (desiredTotal <= 0) {
            return false;
        }
        String chosenSerialization = Arrays.toString(isVisited);
        if (map.containsKey(chosenSerialization)) {
            return map.get(chosenSerialization);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            if (!canWin(maxChoosableInteger, desiredTotal - i, map, isVisited)) {
                map.put(chosenSerialization, true);
                isVisited[i] = false;
                return true;
            }
            isVisited[i] = false;
        }
        map.put(chosenSerialization, false);
        return false;
    }
}
