package com.zemoso.codility;

public class PhoneFormat {
    public String getFormattedContact(String num) {
        String formattednumber = " ";
        int count = 0;

        //Removes all the extra characters from the strings
        String RemovedExtraCharacters = num.replaceAll("[^\\d]", "");
        int length = RemovedExtraCharacters.length();

        //Finding the final formatted number depending on different conditions
        for (int i = 0; i < length; i++) {
            char ch = RemovedExtraCharacters.charAt(i);

            //Depending on the value of count,find the formatted number
            if (count < 3) {

                formattednumber = formattednumber + ch;
            } else if (count == 3) {
                formattednumber = formattednumber.concat("-") + ch;
                count = 0;
            }
            count++;

        }

        //check if the last section after a hyphen has a singe digit and accordingly swap
        if (formattednumber.charAt(formattednumber.length() - 2) == '-')
            formattednumber = swap(formattednumber, formattednumber.length() - 3, formattednumber.length() - 2);

        return formattednumber;
    }

    //function to swap 2 characters in a string
    static String swap(String str, int i, int j) {
        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j)
                    + str.substring(i + 1, j) + str.charAt(i);

        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1, str.length());
    }


    public static void main(String[] args) {
        PhoneFormat obj = new PhoneFormat();
        String S = "555372654";
        System.out.println(obj.getFormattedContact(S));
    }
}
