package Array;



import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yuehu on 4/19/19.
 252. Meeting Rooms
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 determine if a person could attend all meetings.
 这道题目，要求重写comparator 还需要自己写unit test
 */
public class MeetingRooms {
    public static void main(String[] args) {
        Interval[] persons = new Interval[5];
        persons[0] =new Interval(8,8);
        persons[1] =new Interval(2,2);
        persons[2] =new Interval(3,3);
        persons[3] =new Interval(6,6);
        persons[4] =new Interval(4,4);
        System.out.println("排序前的数据：");
        for (Interval interval:persons) {
            System.out.println(interval);
        }
        //创建SortByNumber对象，将其作为参数传入Arrays.sort(persons,sortByNumber)方法中
        SortByStart sortByStart = new SortByStart();
        Arrays.sort(persons,sortByStart);


        System.out.println("根据学生编号由低到高排序：");
        for (Interval interval:persons) {
            System.out.println(interval);
        }
        for (int i = 1; i < persons.length; i++) {
        if (persons[i - 1].end > persons[i].start) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
    }

}

class Interval {
    public int start;
    public int end;

    public Interval(int start,int end){
        this.start = start;
        this.end = end;
    }
    //重写Student类的toString()方法，在输入对象时按照以下方式输出
    @Override
    public String toString() {
        return "Student[number:"+start+",score:"+end+"]";
    }

    public int getNumber() {
        return start;
    }

    public void setNumber(int start) {
        this.start = start;
    }

    public int getScore() {
        return end;
    }

    public void setScore(int end) {
        this.end = end;
    }

}
//按照学号由低到高排列,创建SortByNumber类，该类实现Comparator，重写该接口的compare()
class SortByStart implements Comparator<Interval>{
    //重写该接口的compare()使其按照学号由小到大排序（前者减去后者）
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.getNumber()-o2.getNumber();
    }
}

//实际问题的答案在下面
//public boolean canAttendMeetings(Interval[] intervals) {
//方法1
//    Arrays.sort(intervals, (x, y) -> x.start - y.start);
//方法2
//    Arrays.sort(intervals, new Comparator<Interval>(){
//    public int compare(Interval a, Interval b){
//        return a.start-b.start;
//    }
// });
//    for (int i = 1; i < intervals.length; i++) {
//        if (intervals[i - 1].end > intervals[i].start) {
//            return false;
//        }
//    }
//    return true;
//}