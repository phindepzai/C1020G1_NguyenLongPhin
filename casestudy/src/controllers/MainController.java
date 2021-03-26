package controllers;

import commons.Constant;
import commons.RegularExpression;
import manager.ManagerCinema4D;
import manager.ManagerCustomers;
import manager.ManagerEmployee;
import manager.ManagerService;
import models.Booking;
import models.Customer;

import java.util.List;


public class MainController {
    ManagerCinema4D managerCinema4D = new ManagerCinema4D();
    ManagerService managerService = new ManagerService();
    ManagerCustomers managerCustomers = new ManagerCustomers();
    ManagerEmployee managerEmployee = new ManagerEmployee();

    public void displayMainMenu() {
        int choose;
        do {
            System.out.println("1.Add New Services");
            System.out.println("2.Show Services");
            System.out.println("3.Add New Customer");
            System.out.println("4.Show Information of Customer");
            System.out.println("5.Edit Information of Customer");
            System.out.println("6.Delete Customer");
            System.out.println("7.Add New Booking");
            System.out.println("8.Add New Employee");
            System.out.println("9.Show Information of Employee");
            System.out.println("10.Search Employee by ID");
            System.out.println("11.Call ServiceExtend");
            System.out.println("12.Show All Payment");
            System.out.println("13.Cinema4D");
            System.out.println("14.Exit");
            System.out.println("================================");
            System.out.println("Enter Your Choose : ");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomers();
                    break;
                case 4:
                    showCustomer();
                    break;
                case 5:
                    editCustomer();
                    break;
                case 6:
                    delete();
                    break;
                case 7:
                    addNewBooking();
                    break;
                case 8:
                    addNewEmployees();
                    break;
                case 9:
                    showEmployee();
                    break;
                case 10:
                    searchEmployee();
                    break;
                case 11:
                    callServiceExtend();
                    break;
                case 12:
                    showPayment();
                    break;
                case 13:
                    cinema4d();
                    break;
                case 14:
                    System.out.println(Constant.SEE_YOU_LATER);
                    break;
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
        } while (choose != 13);
    }

    private void searchEmployee() {
        int choose;
        do {
            managerEmployee.searchEmployee();
            System.out.println("1.Search again");
            System.out.println("0.Back to Menu");
            choose = RegularExpression.inputInt();
        } while (choose != 0);
    }

    private void cinema4d() {
        int index;
        do {
            if (managerCinema4D.getNumTicket() == 0) {
                managerCinema4D.showAllBooking();
                break;
            } else {
                managerCustomers.showCustomersName(false);
                System.out.println("0.Back to Menu");
                System.out.println("Enter Index Customer : ");
                index = RegularExpression.inputInt() - 1;
                if (index == -1 || managerCinema4D.getNumTicket() == 0) {
                    break;
                } else if (index < -1 || index >= managerCustomers.getCustomerList().size()) {
                    continue;
                }
                int numTicket;
                do {
                    System.out.println("Enter number ticket you want buy (" + managerCinema4D.getNumTicket() + " ticket left) :");
                    numTicket = RegularExpression.inputInt();
                } while (numTicket > managerCinema4D.getNumTicket());
                managerCinema4D.bookingTicket(managerCustomers.getCustomerList().get(index), numTicket);
            }
        } while (true);
    }

    private void delete(){
        int index;
        do {
            int size = managerCustomers.getCustomerList().size();
            do {
                managerCustomers.showCustomersName(false);
                System.out.println(size + 1 +".  Back to Menu");
                System.out.println("Enter Index You Want to delete : ");
                index = RegularExpression.inputInt() - 1;
            } while (index < -1 || index > size);
            if (index == size){
                break;
            }
            if (size != 0){
                managerCustomers.delete(index);
            }
        } while (true);
    }

    private void callServiceExtend() {
        int index;
        do {
            List<Customer> customerList = managerCustomers.getCustomerList();
            do {
                managerCustomers.showCustomersName(false);
                System.out.println("0.Back to Menu");
                System.out.println("Enter Index Customer Call Service : ");
                index = RegularExpression.inputInt() - 1;
            } while (index < -1 || index >= customerList.size());
            if (index == -1){
                break;
            }
            List<Booking> bookingList = managerCustomers.getBookingList();
            for (Booking booking : bookingList) {
                if (customerList.get(index).getIdentityNumber().equals(booking.getIdCustomer())) {
                    managerCustomers.callServiceExtend(index);
                    break;
                }
            }
        } while (true);
    }

    private void showPayment() {
        managerCustomers.showAllPayment();
    }

    private void addNewBooking() {
        int index;
        int choose;
        do {
            managerCustomers.showCustomersName(false);
            System.out.println("Enter Index Customer to Booking : ");
            index = RegularExpression.inputInt() - 1;
        } while (index < 0 || index >= managerCustomers.getCustomerList().size());
        do {
            System.out.println("1.Booking a Villa");
            System.out.println("2.Booking a House");
            System.out.println("3.Booking a Room");
            System.out.println("4.Back to Menu");
            System.out.println("5.Exit Program");
            System.out.println("Enter Your Choose : ");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    managerService.showVillaName();
                    if (!(managerService.getVillaList().size() == 0)) {
                        System.out.println("Enter Index Villa : ");
                        int indexVilla = RegularExpression.inputInt() - 1;
                        managerCustomers.bookingVilla(index, indexVilla);
                    }
                    break;
                case 2:
                    managerService.showHouseName();
                    if (!(managerService.getHouseList().size() == 0)) {
                        System.out.println("Enter Index House : ");
                        int indexHouse = RegularExpression.inputInt() - 1;
                        managerCustomers.bookingHouse(index, indexHouse);
                    }
                    break;
                case 3:
                    managerService.showRoomName();
                    if (!(managerService.getRoomList().size() == 0)) {
                        System.out.println("Enter Index Room : ");
                        int indexRoom = RegularExpression.inputInt() - 1;
                        managerCustomers.bookingRoom(index, indexRoom);
                    }
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (choose != 4);
    }

    private void showEmployee() {
        int index;
        do {
            managerEmployee.showEmployeeName();
            index = getIndex();
            if (index == -1) {
                break;
            }
            int choose;
            do {
                String identityNumber = managerEmployee.getEmployeeList().get(index).getIdentityNumber();
                managerEmployee.showInformationEmployee(identityNumber);
                System.out.println("0.Back to Menu");
                choose = RegularExpression.inputInt();
            } while (choose != 0);
        } while (true);
    }

    private void addNewEmployees() {
        managerEmployee.addEmployee();
    }

    private void showCustomer() {
        int choice;
        do {
            managerCustomers.showCustomersName(true);
            System.out.println("0.Back to Menu");
            choice = RegularExpression.inputInt() - 1;
        } while (choice != -1);
    }

    private void editCustomer() {
        int index;
        do {
            managerCustomers.showCustomersName(false);
            index = getIndex();
            if (index == -1) {
                break;
            }
            managerCustomers.editCustomer(index);
        } while (true);
    }

    private void addNewCustomers() {
        managerCustomers.addCustomer();
    }

    private void showServices() {
        int choose;
        do {
            System.out.println("1.Show all Villa");
            System.out.println("2.Show all House");
            System.out.println("3.Show all Room");
            System.out.println("4.Back to Menu");
            System.out.println("5.Exit");
            System.out.println("================");
            System.out.println("Enter Your Choose : ");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    showVilla();
                    break;
                case 2:
                    showHouse();
                    break;
                case 3:
                    showRoom();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println(Constant.SEE_YOU_LATER);
                    System.exit(0);
            }
            System.out.println();
        } while (choose != 7);
    }

    private void showRoom() {
        int index;
        do {
            if (managerService.getRoomList().size() == 0) {
                System.out.println(Constant.NOTHING_TO_SHOW);
                break;
            }
            managerService.showRoomName();
            index = getIndex();
            if (index == -1) {
                break;
            }
            int choice = RegularExpression.inputInt();
            if (choice == 1) {
                managerService.editHouse(index);
            } else {
                int choose;
                do {
                    managerService.showInformationRoom(index);
                    System.out.println("0.Back to Menu");
                    choose = RegularExpression.inputInt();
                } while (choose != 0);
            }
        } while (true);
    }

    private void showHouse() {
        int index;
        do {
            if (managerService.getHouseList().size() == 0) {
                System.out.println(Constant.NOTHING_TO_SHOW);
                break;
            }
            managerService.showHouseName();
            index = getIndex();
            if (index == -1) {
                break;
            }
            System.out.println("Enter 1 to Edit");
            int choice = RegularExpression.inputInt();
            if (choice == 1) {
                managerService.editHouse(index);
            } else {
                int choose;
                do {
                    managerService.showInformationHouse(index);
                    System.out.println("0.Back to Menu");
                    choose = RegularExpression.inputInt();
                } while (choose != 0);
            }
        } while (true);
    }

    private void showVilla() {
        int index;
        do {
            if (managerService.getVillaList().size() == 0) {
                System.out.println(Constant.NOTHING_TO_SHOW);
                break;
            }
            managerService.showVillaName();
            index = getIndex();
            if (index == -1) {
                break;
            }
            System.out.println("Enter 1 to Edit");
            int choice = RegularExpression.inputInt();
            if (choice == 1) {
                managerService.editVilla(index);
            } else {
                int choose;
                do {
                    managerService.showInformationVilla(index);
                    System.out.println("0.Back to Menu");
                    choose = RegularExpression.inputInt();
                } while (choose != 0);
            }
        } while (true);
    }

    private int getIndex() {
        int index;
        System.out.println("0.Back to Menu");
        System.out.println("Enter Index to See Detail : ");
        index = RegularExpression.inputInt() - 1;
        return index;
    }

    private void addNewServices() {
        int choose;
        do {
            System.out.println("1.Add New Villa");
            System.out.println("2.Add New House");
            System.out.println("3.Add New Room");
            System.out.println("4.Back to Menu");
            System.out.println("5.Exit");
            System.out.println("================");
            System.out.println("Enter Your Choose : ");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    managerService.addNewVilla();
                    break;
                case 2:
                    managerService.addNewHouse();
                    break;
                case 3:
                    managerService.addNewRoom();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 5:
                    System.out.println(Constant.SEE_YOU_LATER);
                    System.exit(0);
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
        } while (choose != 4);
    }
}
