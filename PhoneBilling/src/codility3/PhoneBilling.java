package codility3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class PhoneBilling {
    public static int getPhoneBill(String calls) throws ParseException {
        //splits the String into different strings
        String individualCalls[] = calls.split("\n");

        int maxDuration = -1; //initialization of the maximum duration of call
        String contactWithMaxDuration = null; //it will contain the string with maximum duration

        //hash map containing contact and call duration
        HashMap<String, Integer> contactAndCallDurationMap = new HashMap<>();

        //hash map containing contact and the corresponding bill
        HashMap<String, Integer> contactAndCallBillMap = new HashMap<>();

        int totalBill = 0;

        //calculation of the total bill taking into consideration the call with the maximum duration
        for (String individualCall : individualCalls) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            Date date = sdf.parse(individualCall.split(",")[0]);
            int currHours = date.getHours();
            int currMins = date.getMinutes();
            int currSec = date.getSeconds();
            String currContact = individualCall.split(",")[1];

            //converting the entire duration into seconds
            int currDuration = currHours * 3600 + currMins * 60 + currSec;
            int currBill = getBill(currDuration);
            int currTotalDuration;
            int currTotalBill;

            //Finding the duration and bill for similar or dissimilar contacts
            if (contactAndCallDurationMap.containsKey(currContact)) {
                currTotalDuration = contactAndCallDurationMap.get(currContact) + currDuration;
                currTotalBill = contactAndCallBillMap.get(currContact) + currBill;
            }
            else {
                currTotalBill = currBill;
                currTotalDuration = currDuration;
            }

            //Calculating the final total bill depending on the maximum duration as well
            if (currTotalDuration < maxDuration) {
                totalBill += currBill;
            }
            else {

                if (contactWithMaxDuration != null) {
                    totalBill += contactAndCallBillMap.get(contactWithMaxDuration);
                }

                if (contactAndCallBillMap.containsKey(currContact))
                {
                    totalBill -= contactAndCallBillMap.get(currContact);
                }
                contactWithMaxDuration = currContact;
                maxDuration = currTotalDuration;
            }

            //putting the final values back into both the hash maps
            contactAndCallBillMap.put(currContact, currTotalBill);
            contactAndCallDurationMap.put(currContact, currTotalDuration);
        }
        return totalBill;
    }

    //function to calculate the bill depending on the duration time
    private static int getBill(int duration) {
        int mins = duration / 60;
        if (mins >= 5) {
            if (duration % 60 != 0) {
                mins++;
            }
            return mins * 150;
        }
        return duration * 3;
    }

    public static void main(String[] args) throws ParseException {
        String S = ("00:01:07,400-234-090" + "\n" +
                "00:05:01,701-080-080" + "\n" +
                "00:05:00,400-234-090");
        int l = PhoneBilling.getPhoneBill(S);
        System.out.println(l);
    }
}