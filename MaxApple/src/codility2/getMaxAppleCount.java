package codility2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class getMaxAppleCount {
    /**
     * @param A array denoting the number of apples on each apple tree in the row
     * @param K the number of trees that Alice can choose when collecting
     * @param L the number of trees that Alice can choose when collecting
     * @return maximum number of apples that can be collected by them
     */
    public static int getCount(Integer[] A, int K, int L) {
        int totalOfKAndL = 0;
        int max1, max2;
        // maximum sum for Alice
        Integer[] maxAndStartingIndex = getMaxSumFromArray(A, K);
        totalOfKAndL += maxAndStartingIndex[0];
        System.out.println(maxAndStartingIndex[0]);

        //create 2 arrays with leading and trailing elements and find the max sum for remaining
        Integer[] leadingElements = Arrays.copyOfRange(A, 0, maxAndStartingIndex[1]);
        List<Integer> LeadingElements = new ArrayList(Arrays.asList(leadingElements));
        Integer[] LeadingElementsArray = LeadingElements.toArray(new Integer[0]);
        max1 = getMaxSumFromArray(LeadingElementsArray, L)[0];
        Integer[] trailingElements = Arrays.copyOfRange(A, (maxAndStartingIndex[1] + K), A.length);
        List<Integer> TrailingElements = new ArrayList(Arrays.asList(trailingElements));
        Integer[] trailingElementsArray = TrailingElements.toArray(new Integer[0]);
        max2 = getMaxSumFromArray(trailingElementsArray, L)[0];
        if (max1 > max2) {
            maxAndStartingIndex[0] = max1;
        } else {
            maxAndStartingIndex[0] = max2;
        }

        System.out.println(maxAndStartingIndex[0]);
        totalOfKAndL += maxAndStartingIndex[0];

        //If no combination is possible
        if ((K + L) >= A.length) {
            return -1;
        }
        return totalOfKAndL;

    }

    //Finds the maximum sum of elements of an array
    static Integer[] getMaxSumFromArray(Integer[] a, int number) {
        int sumForFirst = 0;
        int sumForFirstPrev = 0; //sum of the previous set
        int startingIndex = 0; //starting index of the subset whose max sum is found

        //Creates an array of length 2 to store the maximum sum and the starting index
        Integer[] maxAndStartingIndex = new Integer[2];
        for (int i = 0; i < a.length; i++) {
            if (i <= a.length - number) {
                for (int j = i; j < i + number; j++) {
                    sumForFirst += a[j];
                }
            }
            if (sumForFirst > sumForFirstPrev) {
                sumForFirstPrev = sumForFirst;
                startingIndex = i;
            }
            sumForFirst = 0;
        }
        maxAndStartingIndex[0] = sumForFirstPrev;
        maxAndStartingIndex[1] = startingIndex;
        return maxAndStartingIndex;
    }

    public static void main(String[] args) {
        int total;
        getMaxAppleCount g = new getMaxAppleCount();
        Integer[] A = {6, 1, 4, 6, 3, 2, 7, 4};
        int K = 3;
        int L = 2;
        total = g.getCount(A, K, L);
        System.out.println(total);

    }
}