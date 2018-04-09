package practice.interview.google;

import java.util.List;

public class DeleteDuplicatedInSecondList {
    public void deleteDuplicated(List<String> list1 , List<String> list2) {
        for (String s : list2) {
            if (list1.contains(s)) {
                list2.remove(s);
            }
        }
    }
}
