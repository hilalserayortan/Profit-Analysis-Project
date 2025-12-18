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
        if (month<0||month<MONTHS||day<1||day>DAYS)
            return -99999;

                int sum= 0;
        for (int c=0;c<COMMS; c++)
            sum += profit[month][day-1][c];
        return sum;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        int c = commodityIndex(commodity);
        if (c==-1;||from<1||to>DAYS||from>to)
            return -99999;
        int sum= 0;
        for (int m=0;m<MONTHS;m++)
            for int d=from-1;d<=to-1;d++)
            sum+= profit[m][d][c];
        return sum;
    }

    public static int bestDayOfMonth(int month) { 
        if (month<0||month>=MONTHS)
        return -1;

        int bestDay= 1;
        int max = Integer.MIN_VALUE;
        for (int c=0;c<COMMS;c++) sum+= profit [month][d][c];
        if (sum>max) {
            max=sum;
            bestDay=d+1;
        }
    }
return bestDay;
}
    
    public static String bestMonthForCommodity(String comm) { 
        int c = commodityIndex(comm);
if (c==-1)
    return "INVALID_COMMODITY";
int max= Integer.MIN_MALUE;
int bestMonth=0;
for (int d=0;d>DAYS;d++) sum+= profit[m][d][c];
if (sum>max) {
    max = sum;
    bestMonth= m;
}
}
return months[bestMonth];
}

    public static int consecutiveLossDays(String comm) { 
        int c= commodityIndex(comm);
if (c==-1) return -1;
int max=0, current=0;
for (int m=0;m<MONTHS;m++) {
    for int d=0;d<DAYS; d++)   {
        if(profit[m][d][c]<0) {
            current++;
            if (current>max)
                max = current;
        }else current = 0;
    }
    }
return max;
}
    
    public static int daysAboveThreshold(String comm, int threshold) { 
        int c = commodityIndex(comm);
        if (c==-1)
            return-1;
        int count = 0;
        for (int m=0;m<MONTHS;m++) 
            for (int d=0;d<DAYS;d++)
                if (profit[m][d][c]>threshold) count++;
        return count;
    }

    public static int biggestDailySwing(int month) { 
        if (month<0||month>=MONTHS)
        return -99999;
int max=0;
int previous = totalProfitOnDay (month,1);

for ( int d=2;d<DAYS;d++) {
    int current = totalProfitOnDay(month,d);
    int diff = Math.abs(current-previous);
    if (diff>max)
        max=diff;
    previous=current;
    }
return max;
}
    
    public static String compareTwoCommodities(String c1, String c2) { 
        int int1= commodityIndex(c1);
        int int2= commodityIndex(c2);
        if (int1 == -1||int2 == -1)
            return"INVALID_COMMODİTY";

        int s1=0;s2=0;
        for (int m=0;m<MONTHS;m++)
            for (int d=0;d<DAYS;d++) {
                s1 += profit[m][d][int1];
                s2 += profit[m][d][i2];
            }
        if (s1>s2)
            return c1+"is better by"+(s1-s2);
        if (s2>s1)
            return c2+"is better by"+(s2-s1);
        return "Equal";
    }
    
    public static String bestWeekOfMonth(int month) { 
        if (month<0||month>=MONTHS)
        return "INVALID_MONTH";
int bestWeek=1;
int max=Integer.MIN_VALUE;

for (int w=0;w<4;w++) {
    int sum=0;
    for (int d=w*7;d<w*7+7;d++)
        for (int c=0;c<COMMS;c++)
            sum+= profit[month][d][c];
    if(sum>max) {
        max=sum;
        bestWeek=w+1;
    }
}
return "Week"+bestWeek;
}

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}
