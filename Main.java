import java.io.File;
import java.util.Scanner;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};

    static int [][][] = new int[MONTHS][DAYS][COMMS];
    public static void loadData() {
        for (m=0;m<MONTHS;m++) {
            File file = new File (" Data_Files/ " + months[m] + ".txt");
            Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line= sc.nextLine();
            String[] parts= line.split(",");

            int day= Integer.parseInt (parts[0]-1);
            int cIndex= commodityIndex(parts[1]);
            int value = Integer.parseInt(parts[2]);
            if (day>0&&day<DAYS&&cIndex!=-1) {
                profit [m][day][cIndex]= value;
            }
            sc.close,
 }

    public static String mostProfitableCommodityInMonth(int month) {
        if (month<0||month>=MONTHS)
        return "INVAlLID_MONTH";

            int max= Integer.MIN_VALUE;

            for (int c=0;c<COMMS;c++) {
                int sum= 0;
                for (int d=0;d<DAYS;d++) sum+= profit[month][d][c];
                if (sum>max) {
                    max=sum;
                    best=c;
                }
            }
            return commodities[best] + " " + max;
        }

    public static int totalProfitOnDay(int month, int day) {
        return 1234;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        return 1234;
    }

    public static int bestDayOfMonth(int month) { 
        return 1234; 
    }
    
    public static String bestMonthForCommodity(String comm) { 
        return "DUMMY"; 
    }

    public static int consecutiveLossDays(String comm) { 
        return 1234; 
    }
    
    public static int daysAboveThreshold(String comm, int threshold) { 
        return 1234; 
    }

    public static int biggestDailySwing(int month) { 
        return 1234; 
    }
    
    public static String compareTwoCommodities(String c1, String c2) { 
        return "DUMMY is better by 1234"; 
    }
    
    public static String bestWeekOfMonth(int month) { 
        return "DUMMY"; 
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}
