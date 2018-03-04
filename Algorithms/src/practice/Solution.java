package practice;

import java.util.*;

class Solution
{
    /*
     **  Find the best average grade.
     */
    public static Integer bestAverageGrade(String[][] scores)
    {
        // TODO: implement this function
        if (scores == null || scores.length == 0) {
            return 0;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < scores.length; i++) {
            if (!map.containsKey(scores[i][0])) {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], list);
            } else {
                map.get(scores[i][0]).add(Integer.valueOf(scores[i][1]));
            }
        }

        int max = Integer.MIN_VALUE;
        for (String student : map.keySet()) {
            int sum = 0;
            for (Integer score : map.get(student)) {
                sum += score;
            }
            int average = sum / map.get(student).size();
            max = Math.max(max,average);

        }
        return max;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        // TODO: implement more test cases
        String[][] tc1 = { { "Bobby", "87" },
                { "Charles", "100" },
                { "Eric", "64" },
                { "Charles", "22" } };

        return bestAverageGrade(tc1) == 87;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}