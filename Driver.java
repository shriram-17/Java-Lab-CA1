import java.io.DataOutput;
import java.util.Scanner;

class Assignment
{
    private String Name;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private double score;
    private double totalPoints;
    private double totalWeight;
    Assignment(String name, int month, int day, int hour, int minute,int score,double totalPoints,double totalWeight)
    {
        Name = name;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.score=score;
        this.totalPoints=totalPoints;
        this.totalWeight=totalWeight;
    }
    Assignment(String name, int month, int day, int hour, int minute)
    {
        Name = name;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    public String getName() {
        return Name;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public double getScore() {
        return score;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public void Display()
    {
        System.out.println("Assignment:");
        System.out.println("Name:"+Name);
        System.out.println("Month"+month);
        System.out.println("day:"+day);
        System.out.println("Minute"+minute);
        System.out.println("hour"+hour);
        System.out.println("Score:"+score);
        System.out.println("totalPoints:"+totalPoints);
        System.out.println("totalWeight:"+totalWeight);
    }

    public void dispaly_1()
    {
        System.out.println("Assignment:");
        System.out.println("Name:"+Name);
        System.out.println("day:"+day);
        System.out.println("hour"+hour);
    }

    public void setName(String name) {
        this.Name=name;
    }

    public void setHour(int hour) {
        this.hour=hour;
    }

    public void setMonth(int month) {
        this.month=month;

    }

    public void setDay(int day) {
        this.day=day;
    }

    public void setMinute(int minute) {
        this.minute=minute;
    }
}
class Lab extends Assignment{
    private String specification;

    Lab(String name, int month, int day, int hour, int minute,String specification)
    {
        super(name, month, day, hour, minute);
        this.specification=specification;
    }

    @Override
    public void Display() {
        super.dispaly_1();
        System.out.println("Specification:"+specification);
    }
}

class Project extends Assignment{
    private String specification;
    private String dataFile;

    Project(String name, int month, int day, int hour, int minute,String specification,String dataFile)
    {
        super(name, month, day, hour, minute);
        this.specification=specification;
        this.dataFile=dataFile;
    }

    @Override
    public void Display() {
        super.dispaly_1();
        System.out.println("Specification:"+specification);
        System.out.println("Datafile:"+dataFile);
    }
}
class AssignmentList
{
    private Assignment ItemList[];
    static int index=0;
    public AssignmentList(int n)
    {
         ItemList =new Assignment[n];
    }
    public void addItem(Assignment item,int i)
    {
        ItemList[index]=item;
        index++;
    }

    double computeCourseGrade()
    {
        Double Grade=0.0;
        for(int i=0;i<index;i++)
        {
            Grade+=(ItemList[i].getTotalWeight()+ItemList[i].getScore()/ItemList[i].getTotalWeight())/ItemList[i].getTotalWeight();
        }

        return Grade;
    }
    public void search(int month,int day)
    {
        for(int i=0;i<index;i++)
        {
            if(ItemList[i].getMonth()==month && ItemList[i].getDay()==day)
            {
                System.out.println("For Assignment one"+(i+1));
                System.out.println("Name:"+ItemList[i].getName());
                System.out.println("day:"+ItemList[i].getDay());
                System.out.println("hour:"+ItemList[i].getHour());
                System.out.println("Score:"+ItemList[i].getScore());
                System.out.println("totalPoints:"+ItemList[i].getTotalPoints());
                System.out.println("totalWeight:"+ItemList[i].getTotalWeight());
            }
        }
    }

    public void Display()
    {
        for(int i=0;i<index;i++)
        {
            System.out.println("For Assignment one"+(i+1));
            System.out.println("Name:"+ItemList[i].getName());
            System.out.println("day:"+ItemList[i].getDay());
            System.out.println("hour:"+ItemList[i].getHour());
            System.out.println("Score:"+ItemList[i].getScore());
            System.out.println("totalPoints:"+ItemList[i].getTotalPoints());
            System.out.println("totalWeight:"+ItemList[i].getTotalWeight());
        }
        System.out.println("Grade of all Assignments:"+computeCourseGrade());
    }

}


public class Driver {
    public static void main(String Args[])
    {
        Scanner Scan=new Scanner(System.in);
        System.out.println("Enter the No of Assignmnets");
        int n =Scan.nextInt();
        AssignmentList c=new AssignmentList(n);
        for(int i=0;i<n;i++)
        {   System.out.println("Enter the Name:");
            Scan.nextLine();
            String name=Scan.nextLine();
            System.out.println("Enter the Month:");
            int month=Scan.nextInt();
            System.out.println("Enter the Day:");
            int day=Scan.nextInt();
            System.out.println("Enter the Hour:");
            int hour=Scan.nextInt();
            System.out.println("Enter the Minute:");
            int minute=Scan.nextInt();
            System.out.println("Enter the score:");
            int score=Scan.nextInt();
            System.out.println("Enter the TotalPoints");
            int totalPoints=Scan.nextInt();
            System.out.println("Enter the TotalWeight");
            int totalWeigth=Scan.nextInt();
            Assignment a=new Assignment(name,month,day,hour,minute,score,totalPoints,totalWeigth);
            c.addItem(a,i);
            System.out.println("Enter the Choice:");
            System.out.println("1.Lab");
            System.out.println("2.Project");
            System.out.println("3.Display the List ");
            System.out.println("4.Display The  ");
            System.out.println("3.Display the List ");
            int choice=Scan.nextInt();
            if(choice==1)
            {   System.out.println("Enter the Specfication:");
                Scan.nextLine();
                String Specfication=Scan.nextLine();
                Lab l=new Lab(name,month,day,hour,minute,Specfication);
                l.Display();
            }
            else if(choice==2)
            {
                System.out.println("Enter the Specfication:");
                Scan.nextLine();
                String Specfication=Scan.nextLine();
                System.out.println("Enter the dataFile:");
                Scan.nextLine();
                String dataFile=Scan.nextLine();
                Project P=new Project(name,month,day,hour,minute,Specfication,dataFile);
                P.Display();
            }
            else if(choice==3)
            {
              c.Display();
            }
            else if(choice==4)
            {
                System.out.println("Enter The Date and Month You Want to Search:");
                int Month=Scan.nextInt();
                int Day=Scan.nextInt();
                c.search(Month,Day);
            }
            else {
                System.out.println("Exited");
                break;
            }
        }
    }
}
