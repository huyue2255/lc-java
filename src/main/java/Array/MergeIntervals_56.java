package Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yuehu on 7/31/19.
 */
public class MergeIntervals_56 {
   public static class Interval{
       public int start;
       public int end;
       public Interval(int start,int end){
           this.start = start;
           this.end = end;
       }
   }

   public List<Interval> merge(List<Interval> intervals) {
       if(intervals == null || intervals.size() <= 1) return intervals;
       Collections.sort(intervals, (a,b) -> a.start - b.start);
       int start = intervals.get(0).start;
       int end = intervals.get(0).end;
       List<Interval> res = new ArrayList<>();
       for(Interval interval : intervals) {
           if(interval.start <= end){
               end = Math.max(end,interval.end);
           }else{
               res.add(new Interval(start,end));
               start = interval.start;
               end = interval.end;
           }
       }
       res.add(new Interval(start,end));
       return res;
   }

    public static void main(String[] args) {
        Interval a = new Interval(1,3);
        Interval b = new Interval(2,6);
        Interval c = new Interval(8,10);
        Interval d = new Interval(15,18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(a);
        intervals.add(b);
        intervals.add(c);
        intervals.add(d);

        MergeIntervals_56 res = new MergeIntervals_56();
        System.out.println(res.merge(intervals).get(0).end);


    }

}
