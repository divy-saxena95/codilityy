package Hawaicodility;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.lastInMonth;


/**
 *class to find the number of weeks spent in Hawaii given the start and end month of vacation and the year of vacation
 */
public class FindNoofWeeks {
    /**
     *
     * @param args
     */
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

    /**
     *
     * @param yearOfVacation the year of vacation
     * @param beginingMonth month when the vacation begins
     * @param endingMonth month when the vacation will end
     * @param firstDayOfYear First Day of the year i.e. first day of January
     * @return
     */
    private static int noOfWeeksInHuwai(int yearOfVacation, String beginingMonth, String endingMonth,
                                        String firstDayOfYear) {

        //calculate first monday of a month
        Month m = Month.valueOf(beginingMonth);
        LocalDate holidayStartDate = LocalDate.of(yearOfVacation, m.getValue(), 1);
        LocalDate firstMonday= holidayStartDate.with(firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMonday.toString());

        //last sunday of month
        Month m2 = Month.valueOf(endingMonth);
        LocalDate holidayEndDate = LocalDate.of(yearOfVacation,m2.getValue(),1);
        LocalDate lastSunday=holidayEndDate.with(lastInMonth(DayOfWeek.SUNDAY));
        System.out.println(lastSunday.toString());

        //calculating number of weeks
        long p2 = ChronoUnit.WEEKS.between(firstMonday, lastSunday);
        return (int) (p2+1);
    }
}








