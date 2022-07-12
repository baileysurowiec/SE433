
public class DateObj {
    private int year;
    private int month;
    private int day;
    private int[] monthLengths = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public DateObj(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        validate();
    }

    public int getDay(){ return day; }
    public int getMonth(){ return month; }
    public int getYear(){ return year; }

    public boolean isLeapYear(){
        if(year %4 == 0){
            if (year %100 == 0){
                if(year %400 == 0){ return true; }
                return false;
            }
            return true;
        }
        return false;
    }

    public DateObj nextDate() {
        if(isLeapYear()){ monthLengths[1] = 29; }

        int d = day+1;
        int m = month;
        int y = year;

        if (d > monthLengths[month-1]){
            d = 1;
            m +=1;
        }

        if(m>12){
            m =1;
            y+=1;
        }

        day = d;
        month = m;
        year = y;
        DateObj nextDay = new DateObj(year, month, day);

        return nextDay;
    }

    @Override
    public String toString() { return String.format("Date[year: %d, month: %d, day: %d]", year, month, day); }

    private void validate() {
        validMonth();
        validYear();
        validDay();
    }


    private void validDay(){
        // check for leap year first
        if( isLeapYear() && month == 2){
            if(day<1 || day > 29){
                System.out.printf("Invalid day for given month: " + day);
                throw new IllegalArgumentException("Invalid Day"); }
        }
        else if( isLeapYear() && month != 2){
            if(day<1 || day > monthLengths[month-1]){
                if(day<1 || day >31){
                    System.out.printf("\nInvalid day: " + day);
                }
                else{ System.out.printf("\nInvalid day for given month: " + day);}
                throw new IllegalArgumentException("Invalid Day"); }
        }
        else if (day <1 || day > monthLengths[month-1]){
            if(day<1 || day >31){ System.out.printf("\nInvalid day: " + day); }
            else{ System.out.printf("\nInvalid day for given month: " + day);}
            throw new IllegalArgumentException("Invalid Day");
        }
    }
    private void validMonth(){
        if(month<1 || month>12){
            System.out.printf("\nMonth must be between 1 and 12: " + month);
            throw new IllegalArgumentException("Invalid Month"); }
    }
    private void validYear(){
        if(year<1 || year>9999){
            System.out.printf("\nYear must be between 1 and 9999: " + year);
            throw new IllegalArgumentException("Invalid Year"); }
    }


}
