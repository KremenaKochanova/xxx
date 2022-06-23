import java.util.Scanner;
//public class KremiCalendar {
    public class Main {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter full year: ");
            int year = scan.nextInt();
            System.out.print("Enter month in number between 1 and 12: ");
            int month = scan.nextInt();
            System.out.print("Enter day: ");
            int day = scan.nextInt();
            if (month < 1 || month > 12 || year < 1900)
                System.out.println("Wrong input!");
            else
                printMonth(year, month, day);
        }
        static void printMonth(int year, int month, int day) {
            printMonthTitle (year, month, day);
            printMonthBody (year, month);
            dayofweek (day, month, year);
        }
        static void printMonthTitle(int year, int month, int day) {
            System.out.println("This is the selected day of the week: " + dayofweek(day, month, year));
            System.out.println("         " + getMonthName(month) + " " + year);
            System.out.println("–––––––––––––––––––––––––––––");
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
            System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
        }
        static String getMonthName(int month) {
            String monthName = null;
            switch (month) {
                case 1: monthName = "January";
                    break;
                case 2: monthName = "February";
                    break;
                case 3: monthName = "March";
                    break;
                case 4: monthName = "April";
                    break;
                case 5: monthName = "May";
                    break;
                case 6: monthName = "June";
                    break;
                case 7: monthName = "July";
                    break;
                case 8: monthName = "August";
                    break;
                case 9: monthName = "September";
                    break;
                case 10: monthName = "October";
                    break;
                case 11: monthName = "November";
                    break;
                case 12: monthName = "December";
            }
            return monthName;
        }
        static void printMonthBody(int year, int month) {
            // Get start day of the week for the first date in the month
            int startDay = getStartDay(year, month);
            // Get number of days in the month
            int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
            // Pad space before the first day of the month
            int i = 0;
            for (i = 0; i < startDay; i++)
                System.out.print("    ");
            for (i = 1; i <= numberOfDaysInMonth; i++) {
                if (i < 10)
                    System.out.print("   " + i);
                else
                    System.out.print("  " + i);
                if ((i + startDay) % 7 == 0)
                    System.out.println();
            }
            System.out.println();
            System.out.print("The startDay is:    " + startDay);
        }
        static int getStartDay(int year, int month) {
            int startDay1800 = 2;
            int totalNumberOfDays = getTotalNumberOfDays(year, month);
            //Return the start day
            return (totalNumberOfDays + startDay1800) % 7;
        }
        static int getTotalNumberOfDays(int year, int month) {
            int total = 0;
            //Get the total days from 1800 to year - 1
            for (int i = 1800; i < year; i++)
                if (isLeapYear(i))
                    total = total + 366;
                else
                    total = total + 365;
            //Add days from January to the month prior to the calendar month
            for (int i = 1; i < month; i++)
                total = total + getNumberOfDaysInMonth(year, i);
            return total;
        }
        static int getNumberOfDaysInMonth(int year, int month) {
            if (month == 1 || month == 3 || month == 5 || month == 7 ||
                    month == 8 || month == 10 || month == 12)
                return 31;
            if (month == 4 || month == 6 || month == 9 || month == 11)
                return 30;
            if (month == 2) return isLeapYear(year) ? 29 : 28;
            return 0; // If month is incorrect
        }
        static boolean isLeapYear(int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }
        //-------------------------------------------------------------------------------
        static int dayofweek(int day, int month, int year) {
            int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
            if (month < 3) {
                year = year - 1;
            }
            int searchDay = (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
            String dayName;
            switch (searchDay) {
                case 1: dayName = "mon";
                    break;
                case 2: dayName = "tue";
                    break;
                case 3: dayName = "wed";
                    break;
                case 4: dayName = "thu";
                    break;
                case 5: dayName = "fri";
                    break;
                case 6: dayName = "sat";
                    break;
                case 0: dayName = "sun";
                    break;
                default:
                    dayName = "Invalid day";
                    break;
            }
            String ordinaldayName[] = {"Тhe first", "Тhe second", "Тhe third", "Тhe fourth", "Тhe fifth"};
            String ordinaldayName1[] = {"Тhe first", "Тhe second", "Тhe third", "Тhe fourth", "Тhe fifth"};
            //+++++++++++++++++++++++++++++++++++++++ WEDNESDAY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (searchDay == 3  && day>0 && day<8)
            {
                System.out.println(ordinaldayName[0]+ " " + dayName + " of the month");
            }
            else if(searchDay == 3 && day>7 && day<15)
            {
                System.out.println(ordinaldayName[1] + " " + dayName + " of the month");
            }
            else if(searchDay == 3 && day>14 && day<21)
            {
                System.out.println(ordinaldayName[2] + " " + dayName + " of the month");
            }
            else if(searchDay == 3 && day>20 && day<28)
            {
                System.out.println(ordinaldayName[3] + " " + dayName + " of the month");
            }
            else if(searchDay == 3 && day>27 && day<32)
            {
                System.out.println(ordinaldayName[4] + " " + dayName + " of the month");
            }
//+++++++++++++++++++++++++++++++++++++++ SATURDAY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (searchDay == 6  && day>0 && day<8)
            {
                System.out.println(ordinaldayName[0]+ " " + dayName + " of the month");
            }
            else if(searchDay == 6 && day>7 && day<15)
            {
                System.out.println(ordinaldayName[1] + " " + dayName + " of the month");
            }
            else if(searchDay == 6 && day>14 && day<21)
            {
                System.out.println(ordinaldayName[2] + " " + dayName + " of the month");
            }
            else if(searchDay == 6 && day>20 && day<28)
            {
                System.out.println(ordinaldayName[3] + " " + dayName + " of the month");
            }
            else if(searchDay == 6 && day>27 && day<32)
            {
                System.out.println(ordinaldayName[4] + " " + dayName + " of the month");
            }
//+++++++++++++++++++++++++++++++++++++++ SUNDAY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (searchDay == 0  && day>0 && day<8)
            {
                System.out.println(ordinaldayName[0]+ " " + dayName + " of the month");
            }
            else if(searchDay == 0 && day>7 && day<15)
            {
                System.out.println(ordinaldayName[1] + " " + dayName + " of the month");
            }
            else if(searchDay == 0 && day>14 && day<21)
            {
                System.out.println(ordinaldayName[2] + " " + dayName + " of the month");
            }
            else if(searchDay == 0 && day>20 && day<28)
            {
                System.out.println(ordinaldayName[3] + " " + dayName + " of the month");
            }
            else if(searchDay == 0 && day>27 && day<32)
            {
                System.out.println(ordinaldayName[4] + " " + dayName + " of the month");
            }
//+++++++++++++++++++++++++++++++++++++++ MONDAY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (searchDay == 1  && day>0 && day<8)
            {
                System.out.println(ordinaldayName1[0]+ " " + dayName + " of the month");
            }
            else if(searchDay == 31 && day>7 && day<15)
            {
                System.out.println(ordinaldayName1[1] + " " + dayName + " of the month");
            }
            else if(searchDay == 1 && day>14 && day<21)
            {
                System.out.println(ordinaldayName1[2] + " " + dayName + " of the month");
            }
            else if(searchDay == 1 && day>20 && day<28)
            {
                System.out.println(ordinaldayName1[3] + " " + dayName + " of the month");
            }
            else if(searchDay == 1 && day>27 && day<32)
            {
                System.out.println(ordinaldayName1[4] + " " + dayName + " of the month");
            }
//+++++++++++++++++++++++++++++++++++++++ TUESDAY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (searchDay == 2  && day>0 && day<8)
            {
                System.out.println(ordinaldayName1[0]+ " " + dayName + " of the month");
            }
            else if(searchDay == 2 && day>7 && day<15)
            {
                System.out.println(ordinaldayName1[1] + " " + dayName + " of the month");
            }
            else if(searchDay == 2 && day>14 && day<21)
            {
                System.out.println(ordinaldayName1[2] + " " + dayName + " of the month");
            }
            else if(searchDay == 2 && day>20 && day<28)
            {
                System.out.println(ordinaldayName1[3] + " " + dayName + " of the month");
            }
            else if(searchDay == 2 && day>27 && day<32)
            {
                System.out.println(ordinaldayName1[4] + " " + dayName + " of the month");
            }
//+++++++++++++++++++++++++++++++++++++++ THURSDAY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (searchDay == 4  && day>0 && day<8)
            {
                System.out.println(ordinaldayName1[0]+ " " + dayName + " of the month");
            }
            else if(searchDay == 4 && day>7 && day<15)
            {
                System.out.println(ordinaldayName1[1] + " " + dayName + " of the month");
            }
            else if(searchDay == 4 && day>14 && day<21)
            {
                System.out.println(ordinaldayName1[2] + " " + dayName + " of the month");
            }
            else if(searchDay == 4 && day>20 && day<28)
            {
                System.out.println(ordinaldayName1[3] + " " + dayName + " of the month");
            }
            else if(searchDay == 4 && day>27 && day<32)
            {
                System.out.println(ordinaldayName1[4] + " " + dayName + " of the month");
            }
//+++++++++++++++++++++++++++++++++++++++ FRIDAY ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if (searchDay == 5  && day>0 && day<8)
            {
                System.out.println(ordinaldayName1[0]+ " " + dayName + " of the month");
            }
            else if(searchDay == 5 && day>7 && day<15)
            {
                System.out.println(ordinaldayName1[1] + " " + dayName + " of the month");
            }
            else if(searchDay == 5 && day>14 && day<21)
            {
                System.out.println(ordinaldayName1[2] + " " + dayName + " of the month");
            }
            else if(searchDay == 5 && day>20 && day<28)
            {
                System.out.println(ordinaldayName1[3] + " " + dayName + " of the month");
            }
            else if(searchDay == 5 && day>27 && day<32)
            {
                System.out.println(ordinaldayName1[4] + " " + dayName + " of the month");
            }
            System.out.println("This is the selected day of the week: " + dayName);
            return searchDay;
        } //END  of function
}