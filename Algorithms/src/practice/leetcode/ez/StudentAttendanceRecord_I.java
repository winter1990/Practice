package practice.leetcode.ez;

import practice.algorithmAndOOD.OOD.P;

/**
 * @string
 *
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 */
public class StudentAttendanceRecord_I {
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*"); // regex solution
    }

    public boolean checkRecord1(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
