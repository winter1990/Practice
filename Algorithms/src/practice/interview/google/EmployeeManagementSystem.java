package practice.interview.google;

import java.util.*;

/**
 * tree like structure
 * each nodes has multiple children
 *
 */
public class EmployeeManagementSystem {
    // m1 is the direct manager of e1
    // on employee has at most 1 direct manager
    Map<String, Employee> map = new HashMap<>();
    void manages(String m1, String e1) {
        if (!map.containsKey(e1)) {
            Employee e = new Employee(e1);
            map.put(e1, e);
        }
        if (!map.containsKey(m1)) {
            Employee m = new Employee(m1);
            map.put(m1, m);
        }
        map.get(e1).manager = map.get(m1);
        map.get(m1).empl.add(map.get(e1));
    }

    // e1 and e2 same level
    // same manager
    void peer(String e1, String e2) {
        Employee m1 = map.get(e1).manager;
        Employee m2 = map.get(e2).manager;
        if (m1 != null) {
            m1.empl.add(map.get(e2));
            map.get(e2).manager = m1;
        } else if (m2 != null) {
            m2.empl.add(map.get(e1));
            map.get(e1).manager = m2;
        }
    }

    // can be direct or undirect
    boolean isManaging(String e1, String e2) {
        Queue<Employee> q = new LinkedList<>();
        Set<Employee> visited = new HashSet<>();
        q.offer(map.get(e1));
        while (!q.isEmpty()) {
            Employee cur = q.poll();
            if (cur == map.get(e2)) {
                return true;
            }
            if (cur.manager != null && !visited.contains(cur.manager)) {
                q.offer(cur.manager);
            }
            for (Employee e : cur.empl) {
                if (!visited.contains(e)) {
                    q.offer(e);
                }
            }
            visited.add(cur);
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.manages("a", "b");
        ems.manages("c", "a");
        ems.manages("y", "z");
        System.out.println(ems.isManaging("a", "c"));

        System.out.println();
    }
}

class Employee {
    List<Employee> empl;
    Employee manager;
    String id;
    public Employee(String id) {
        this.id = id;
        manager = null;
        empl = new ArrayList<>();
    }
}
