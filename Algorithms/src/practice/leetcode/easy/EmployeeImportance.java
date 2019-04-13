package practice.leetcode.easy;

import java.util.*;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Integer> q = new LinkedList<>(); // store id
        q.offer(id);
        int val = 0;
        while (!q.isEmpty()) {
            Employee e = map.get(q.poll());
            val += e.importance;
            for (int i : e.subordinates) {
                q.offer(i);
            }
        }
        return val;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};