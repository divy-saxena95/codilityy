package codility1;

import java.util.HashMap;
import java.util.Set;

public class ScoreCount {

    /**
     * @param T Test cases
     * @param R Result of each test case
     * @return the final score
     */
    public int ScoreCount1(String T[], String R[]) {

        //create a hash map for storing the scores
        HashMap<String, Integer> score = new HashMap<>();
        int noofdigits, pos;
        String prefix = "";
        //counting the occurences of a positive result
        for (int i = 0; i < T.length; i++) {
            noofdigits = 0;
            pos = 0;
            String number = T[i].replaceAll("[^0-9]", "");
            prefix = "test" + number;
            //checks if result is OK and if the prefix comes again to increment the value
            if (R[i].equals("OK")) {
                if (score.containsKey(prefix))
                    score.put(prefix, score.get(prefix) + 1);
                else {
                    score.put(prefix, 1);
                }
            } else
                score.put(prefix, -(score.size() + 1));

        }

        //counting the number of test cases passed
        int count = 0;
        Set<String> keys = score.keySet();
        for (String p : keys) {
            if (score.get(p) >= 1) {
                count++;
            }
        }

        //Exception handling if the denominator is zero
        if (score.size() == 0)
            throw new IllegalArgumentException("Argument 'divisor' is 0");

        //returns the final score

        return (int) (count * 100) / score.size();
    }


    public static void main(String[] args) {
        //sample example
        String T[] = {"test1a", "test2", "test1b", "test1c", "test3"};
        String R[] = {"Wrong answer", "OK", "Runtime Error", "OK", "Time Limit Exceeded"};

        ScoreCount sc = new ScoreCount();
        int score = sc.ScoreCount1(T, R);
        System.out.println(score);

    }
}





