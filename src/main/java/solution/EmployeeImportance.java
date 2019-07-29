package solution;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author huanfeng.xu
 * @date 2019-07-29 14:21
 * @see <a href="https://leetcode.com/problems/employee-importance/">690. Employee Importance</a>
 */
public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> data = new HashMap<>();
        for (Employee employee : employees) {
            data.put(employee.id, employee);
        }

        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            Employee employee = data.get(head);
            ans += employee.importance;
            List<Integer> subordinates = employee.subordinates;
            if (subordinates != null && subordinates.size() > 0) {
                for (Integer subordinate : subordinates) {
                    queue.offer(subordinate);
                }
            }
        }
        return ans;
    }

    @Test
    public void test01() {
        List<Employee> employeeList = new LinkedList<>();
        Employee employee = new Employee();
        employee.id = 1;
        employee.importance = 5;
        employee.subordinates = Arrays.asList(2, 3);
        employeeList.add(employee);

        employee = new Employee();
        employee.id = 2;
        employee.importance = 3;
        employee.subordinates = Collections.emptyList();
        employeeList.add(employee);

        employee = new Employee();
        employee.id = 3;
        employee.importance = 3;
        employee.subordinates = Collections.emptyList();
        employeeList.add(employee);

        assertEquals(11, getImportance(employeeList, 1));
    }
}
