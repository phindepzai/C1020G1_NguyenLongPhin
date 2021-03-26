package manager;

import commons.Constant;
import commons.RegularExpression;
import controllers.ControllerUtility;
import models.Employee;
import models.Profile;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ManagerEmployee {
    ControllerUtility controllerUtility = new ControllerUtility();
    ManagerCustomers managerCustomers = new ManagerCustomers();
    Scanner scanner = new Scanner(System.in);

    public ManagerEmployee() {
    }

    public void addEmployee() {
        String name = managerCustomers.getName();
        String birthday = managerCustomers.getDateOfBirth();
        String identityNumber = managerCustomers.getIdentity("Em");
        String phoneNumber = managerCustomers.getPhoneNumber();
        String email = managerCustomers.getEmail();
        String level = getLevel();
        String position = getPosition();
        int salary = getSalary();
        Employee newEmployee = new Employee(name, birthday, identityNumber, phoneNumber, email, level, position, salary);
        controllerUtility.writeDataFromEmployee(newEmployee, true);
    }

    public void searchEmployee() {
        Profile profile = new Profile();
        System.out.println("Enter Identity Employee You Want to Search : ");
        String id = scanner.nextLine();
        profile.search(id);
    }

    public void showEmployeeName() {
        for (int i = 0; i < getEmployeeMap().size(); i++) {
            String identityNumber = controllerUtility.readEmployeeFromData().get(i).getIdentityNumber();
            System.out.println(i + 1 + "." + getEmployeeMap().get(identityNumber).getName());
        }
    }

    public void showInformationEmployee(String key) {
        System.out.println(getEmployeeMap().get(key));
    }

//    public void editEmployee(int index) {
//        int choose;
//        List<Employee> list = controllerUtility.readEmployeeFromData();
//        Employee employee = list.get(index);
//        do {
//            System.out.println("1." + employee.getName());
//            System.out.println("2." + employee.getBirthDay());
//            System.out.println("3." + employee.getIdentityNumber());
//            System.out.println("4." + employee.getPhoneNumber());
//            System.out.println("5." + employee.getEmail());
//            System.out.println("6." + employee.getLevel());
//            System.out.println("7." + employee.getPosition());
//            System.out.println("8." + employee.getSalary());
//            System.out.println("9.Back to Menu");
//            System.out.println("0.Exit Program");
//            choose = RegularExpression.inputInt();
//            switch (choose) {
//                case 1:
//                    String name = managerCustomers.getName();
//                    employee.setName(name);
//                    break;
//                case 2:
//                    String birthday = managerCustomers.getDateOfBirth();
//                    employee.setBirthDay(birthday);
//                    break;
//                case 3:
//                    String identityNumber = managerCustomers.getIdentity();
//                    employee.setIdentityNumber(identityNumber);
//                    break;
//                case 4:
//                    String phoneNumber = managerCustomers.getPhoneNumber();
//                    employee.setPhoneNumber(phoneNumber);
//                    break;
//                case 5:
//                    String email = managerCustomers.getEmail();
//                    employee.setEmail(email);
//                    break;
//                case 6:
//                    String level = getLevel();
//                    employee.setLevel(level);
//                    break;
//                case 7:
//                    String position = getPosition();
//                    employee.setPosition(position);
//                    break;
//                case 8:
//                    int salary = getSalary();
//                    employee.setSalary(salary);
//                    break;
//                case 9:
//                    System.out.println();
//                    break;
//                case 0:
//                    System.out.println(Constant.SEE_YOU_LATER);
//                    System.exit(0);
//            }
//            boolean isAdd = false;
//            for (Employee value : list) {
//                controllerUtility.writeDataFromEmployee(value, isAdd);
//                isAdd = true;
//            }
//        } while (choose != 9);
//    }

    private int getSalary() {
        System.out.println("Enter Salary : ");
        return RegularExpression.inputInt();
    }

    private String getPosition() {
        String position = "";
        do {
            System.out.println("1." + Constant.LE_TAN);
            System.out.println("2." + Constant.PHUC_VU);
            System.out.println("3." + Constant.CHUYEN_VIEN);
            System.out.println("4." + Constant.GIAM_SAT);
            System.out.println("5." + Constant.QUAN_LY);
            System.out.println("6." + Constant.GIAM_DOC);
            int choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    position = Constant.LE_TAN;
                    break;
                case 2:
                    position = Constant.PHUC_VU;
                    break;
                case 3:
                    position = Constant.CHUYEN_VIEN;
                    break;
                case 4:
                    position = Constant.GIAM_SAT;
                    break;
                case 5:
                    position = Constant.QUAN_LY;
                    break;
                case 6:
                    position = Constant.GIAM_DOC;
                    break;
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
        } while (position.equals(""));
        return position;
    }

    private String getLevel() {
        String level = "";
        do {
            System.out.println("1." + Constant.TRUNG_CAP);
            System.out.println("2." + Constant.CAO_DANG);
            System.out.println("3." + Constant.DAI_HOC);
            System.out.println("4." + Constant.SAU_DAI_HOC);
            System.out.println("===============");
            System.out.println("Enter Level : ");
            int choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    level = Constant.TRUNG_CAP;
                    break;
                case 2:
                    level = Constant.CAO_DANG;
                    break;
                case 3:
                    level = Constant.DAI_HOC;
                    break;
                case 4:
                    level = Constant.SAU_DAI_HOC;
                    break;
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
        } while (level.equals(""));
        return level;
    }

    public Map<String, Employee> getEmployeeMap() {
        return controllerUtility.getEmployeeMap();
    }

    public List<Employee> getEmployeeList() {
        return controllerUtility.readEmployeeFromData();
    }
}
