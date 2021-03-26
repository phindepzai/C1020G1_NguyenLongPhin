package models;

import controllers.ControllerUtility;

import java.util.List;
import java.util.Stack;

public class Profile {

    public Profile() {
    }

    public Stack<Employee> getAllProfile() {
        ControllerUtility controllerUtility = new ControllerUtility();
        List<Employee> list = controllerUtility.readEmployeeFromData();
        Stack<Employee> stack = new Stack<>();
        for (Employee employee : list) {
            stack.push(employee);
        }
        return stack;
    }

    public void search(String identity) {
        boolean isExist = false;
        for (Employee element : getAllProfile()) {
            if (identity.equals(element.getIdentityNumber())){
                System.out.println(element);
                isExist = true;
            }
        }
        if (!isExist){
            System.out.println("Nonexistent Employees");
        }
    }
}
