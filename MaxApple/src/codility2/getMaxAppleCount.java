package codility2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class getMaxAppleCount {
    /**
     *
     * @param A array denoting the number of apples on each apple tree in the row
     * @param K the number of trees that Alice can choose when collecting
     * @param L the number of trees that Alice can choose when collecting
     * @return maximum number of apples that can be collected by them
     */
    public static int getCount(Integer[] A, int K, int L) {
        int totalOfKAndL = 0;

        // maximum sum for Alice
        Integer[] maxAndStartingIndex = getMaxSumFromArray(A, K);
        totalOfKAndL+=maxAndStartingIndex[0];
        System.out.println(maxAndStartingIndex[0]);

        //create an array with the remaining elements after the one with the maximum sum has been found out
        Integer[] leadingElements = Arrays.copyOfRange(A, 0, maxAndStartingIndex[1]);
        Integer[] trailingElements = Arrays.copyOfRange(A, (maxAndStartingIndex[1]+K), A.length);
        List<Integer> mergedLeadingAndTrailingElements = new ArrayList(Arrays.asList(leadingElements));
        mergedLeadingAndTrailingElements.addAll(Arrays.asList(trailingElements));
        Integer[] mergedLeadingAndTrailingElementsArray =  mergedLeadingAndTrailingElements.toArray(new Integer[0]);

        //maximum sum for Bob
        maxAndStartingIndex = getMaxSumFromArray(mergedLeadingAndTrailingElementsArray, L);
        System.out.println(maxAndStartingIndex[0]);
        totalOfKAndL+=maxAndStartingIndex[0];

        //If no combination is possible
        if ((K + L) >=A.length)
            return -1;
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
        Integer[] A = {6, 1, 4, 6,3,2,7,4};
        int K = 3;
        int L = 2;
        total = g.getCount(A, K, L);
        System.out.println(total);

    }
}