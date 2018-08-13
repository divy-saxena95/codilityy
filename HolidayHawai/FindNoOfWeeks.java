package HolidayHawai;


import java.time.LocalDate;
import java.util.Scanner;

public class FindNoOfWeeks {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the YEAR of vacation");
        int yearOfVacation = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the begining month");
        String beginingMonth = scanner.nextLine();
        System.out.println("Enter the ending month");
        String endingMonth = scanner.nextLine();
        System.out.println("Enter the first day of the year");
        String firstDayOfYear = scanner.nextLine();
        System.out.println("The number of weeks John will be in Huwai are : " + noOfWeeksInHuwai(
                yearOfVacation,beginingMonth,endingMonth,firstDayOfYear));
        scanner.close();
    }

    private static int noOfWeeksInHuwai(int yearOfVacation, String beginingMonth, String endingMonth,
                                        String firstDayOfYear) {
        int noOfWeeks = 0;
        LocalDate holidayStartDate = LocalDate.of(yearOfVacation, getMonth(beginingMonth), 1);
        int journeyStartDay = 1;
        if(!getDayOfWeek(holidayStartDate).equals("MONDAY")) {
            journeyStartDay = 1+(getValueOfDayOfWeek("MONDAY") -
                    getValueOfDayOfWeek(getDayOfWeek(holidayStartDate)) + 7)%7;
        }

        LocalDate journeyEndDate = holidayStartDate.withDayOfMonth(journeyStartDay + 6);
        LocalDate holidayEndDate = getHolidayEndDate(yearOfVacation,endingMonth);

        while(journeyEndDate.isBefore(holidayEndDate) || journeyEndDate.equals(holidayEndDate)) {
            noOfWeeks++;
            journeyEndDate = journeyEndDate.plusDays(7); }

        return noOfWeeks;
    }

    private static LocalDate getHolidayEndDate(int yearOfVacation, String endingMonth) {
        int holidayEndDay;
        if(getMonth(endingMonth) == 2) {
            if(yearOfVacation % 4 == 0) {
                holidayEndDay = 29;
            }
            else {
                holidayEndDay = 28;
            }
        }
        else if(getMonth(endingMonth) <= 7) {
            holidayEndDay = 30 + getMonth(endingMonth)%2;
        }
        else {
            holidayEndDay = 31 - getMonth(endingMonth)%2;
        }
        return LocalDate.of(yearOfVacation, getMonth(endingMonth), holidayEndDay);
    }

    private static int getMonth(String month) {
        switch (month) {
            case "January" : return 1;
            case "February" : return 2;
            case "March" : return 3;
            case "April" : return 4;
            case "May" : return 5;
            case "June" : return 6;
            case "July" : return 7;
            case "August" : return 8;
            case "September" : return 9;
            case "October" : return 10;
            case "November" : return 11;
            default : return 12;
        }
    }

    private static int getValueOfDayOfWeek(String day) {
        switch (day) {
            case "MONDAY" : return 1;
            case "TUESDAY" : return 2;
            case "WEDNESDAY" : return 3;
            case "THURSDAY" : return 4;
            case "FRIDAY" : return 5;
            case "SATURDAY" : return 6;
            default : return 7;
        }
    }

    private static String getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().toString();
    }

}


