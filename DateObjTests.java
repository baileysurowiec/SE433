import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class DateObjTests {
@Test
    public void nextDayTest(){
    System.out.println("\n\nNext Day Test");
    System.out.println("----------");

    DateObj newDay = new DateObj(2000, 6, 20);
        String inputDate1 = newDay.toString();
        System.out.printf("Input Date: " + inputDate1);
        newDay.nextDate();
        String nextDate1 = newDay.toString();
        System.out.printf("\n Next Date: " + nextDate1);

        assertEquals(21, newDay.getDay() );
    }

@Test
    public void invalidDatesTest(){
    System.out.println("\n\nInvalid Dates Tests");
    System.out.println("----------");
        // Invalid date for given month
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateObj invalid1 = new DateObj(2000, 6, 31); });
        assertEquals("Invalid Day", exception.getMessage());
        // Day must be between 1 and valid end of month
        Exception exceptionD2 = assertThrows(IllegalArgumentException.class, () -> {
            DateObj invalidD2 = new DateObj(2000, 1, 0); });
        assertEquals("Invalid Day", exceptionD2.getMessage());
        Exception exceptionD3 = assertThrows(IllegalArgumentException.class, () -> {
            DateObj invalidD3 = new DateObj(2000, 1, 32); });
        assertEquals("Invalid Day", exceptionD3.getMessage());

        // month must be between 1 and 12
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            DateObj invalid2 = new DateObj(2022, -1, 31); });
        assertEquals("Invalid Month", exception2.getMessage());

        Exception exceptionM2 = assertThrows(IllegalArgumentException.class, () -> {
            DateObj invalidM2 = new DateObj(2022, 13, 31); });
        assertEquals("Invalid Month", exceptionM2.getMessage());

        // year must be between 1 and 999
        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
            DateObj invalid3 = new DateObj(0, 12, 31);
        });
        assertEquals("Invalid Year", exception3.getMessage());

        Exception exception4 = assertThrows(IllegalArgumentException.class, () -> {
            DateObj invalid4 = new DateObj(10000, 12, 31);
        });
        assertEquals("Invalid Year", exception4.getMessage());

        // not a leap year
        Exception exception5 = assertThrows(IllegalArgumentException.class, () -> {
            DateObj leapYear2 = new DateObj(2027, 2, 29); });
        assertEquals("Invalid Day", exception5.getMessage());
}

@Test
    public void nextYearTest(){
    System.out.println("\n\nNext Year Test");
    System.out.println("----------");

    DateObj newYear = new DateObj(2022, 12, 31);
        String inputDate2 = newYear.toString();
        System.out.printf("Input Date: " + inputDate2);
        newYear.nextDate();
        String nextDate2 = newYear.toString();
        System.out.printf("\n Next Date: " + nextDate2);

        assertEquals(2023, newYear.getYear());
    }

@Test
    public void nextMonthTest(){
    System.out.println("\n\nNext Month Test");
    System.out.println("----------");

    DateObj newMonth = new DateObj(1998, 3, 31);
    String inputDate3 = newMonth.toString();
    System.out.printf("Input Date: " + inputDate3);
    newMonth.nextDate();
    String nextDate3 = newMonth.toString();
    System.out.printf("\n Next Date: " + nextDate3);

    assertEquals(4, newMonth.getMonth());
}

@Test
    public void leapYearTest(){
    System.out.println("\n\nLeap Year Test");
    System.out.println("----------");

    DateObj leapYear = new DateObj(2028, 2, 28);
    String inputDate4 = leapYear.toString();
    System.out.printf("Input Date: " + inputDate4);
    leapYear.nextDate();
    String nextDate4 = leapYear.toString();
    System.out.printf("\n Next Date: " + nextDate4);
    assertEquals(29, leapYear.getDay());

    leapYear.nextDate();
    String nextDate44 = leapYear.toString();
    System.out.printf("\n Next Date: " + nextDate44);

    assertEquals(1, leapYear.getDay());
    assertEquals(3, leapYear.getMonth());

    System.out.println("\n\nCentury Leap Year");
    DateObj leapYear2 = new DateObj(2400, 2, 28);
    String inputDate5 = leapYear2.toString();
    System.out.printf("Input Date: " + inputDate5);
    leapYear2.nextDate();
    String nextDate5 = leapYear2.toString();
    System.out.printf("\n Next Date: " + nextDate5);
    assertEquals(29, leapYear2.getDay());

    leapYear2.nextDate();
    String nextDate55 = leapYear2.toString();
    System.out.printf("\n Next Date: " + nextDate55);

    assertEquals(1, leapYear2.getDay());
    assertEquals(3, leapYear2.getMonth());
}

@Test
    public void multiDatesTest(){
    System.out.println("\n\nMulti-dates Test");
    System.out.println("----------");

    DateObj dateObj = new DateObj(2022, 5, 31);
    String d1 = dateObj.toString();
    System.out.println(d1);

    dateObj.nextDate();
    String d2 = dateObj.toString();
    System.out.println(d2);

    dateObj.nextDate();
    String d3 = dateObj.toString();
    System.out.println(d3);
    }

}
