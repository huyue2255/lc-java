package String;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashMap;

/**
 * Created by yuehu on 6/6/19.
 * 551. Student Attendance Record I
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).

 * You need to return whether the student could be rewarded according to his attendance record.

 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttenRecordI_551 {
    public boolean checkRecord(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') {
                count++;
            }
            if(count > 1) {
                return false;
            }

            if(i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i+1) == 'L'&& s.charAt(i+2) == 'L') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StudentAttenRecordI_551 s = new StudentAttenRecordI_551();
        Boolean result = s.checkRecord("LLLLL");
        System.out.println(result);
    }
}
