package manager;

import commons.Constant;
import commons.RegularExpression;
import controllers.ControllerUtility;
import models.*;

import java.util.List;
import java.util.Scanner;

public class ManagerService {
    private Scanner scanner = new Scanner(System.in);
    ControllerUtility controllerUtility = new ControllerUtility();

    public ManagerService() {
    }

    private Services addNewServices(String type) {
        Services newService;
        String name = getName();
        String id = getId(type);
        double area = getArea();
        int cost = getCost();
        int quantityMax = getQuantityMax();
        String rentType = getRentType();
        switch (type) {
            case Constant.VILLA:
                newService = new Villa(name, id, area, cost, quantityMax, rentType);
                break;
            case Constant.HOUSE:
                newService = new House(name, id, area, cost, quantityMax, rentType);
                break;
            default:
                newService = new Room(name, id, area, cost, quantityMax, rentType);
        }
        return newService;
    }

    private String getRentType() {
        String rentType = "";
        do {
            System.out.println("1.Rent by day");
            System.out.println("2.Rent by week");
            System.out.println("3.Rent by month");
            System.out.println("===============");
            System.out.println("Enter Rent Type : ");
            int choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    rentType = "day";
                    break;
                case 2:
                    rentType = "week";
                    break;
                case 3:
                    rentType = "month";
                    break;
            }
        } while (rentType.equals(""));
        return rentType;
    }

    private int getQuantityMax() {
        int quantityMax;
        do {
            System.out.println("Enter Quantity Max : ");
            quantityMax = RegularExpression.inputInt();
        } while (!RegularExpression.checkQuantityMax(quantityMax));
        return quantityMax;
    }

    private int getCost() {
        int cost;
        do {
            System.out.println("Enter Cost per day : ");
            cost = RegularExpression.inputInt();
        } while (!RegularExpression.checkFloor(cost));
        return cost;
    }

    private double getArea() {
        double area;
        do {
            System.out.println("Enter Area :");
            area = RegularExpression.inputDouble();
        } while (!RegularExpression.checkArea(area));
        return area;
    }

    private String getId(String type) {
        String id;
        do {
            System.out.println("Enter ID : ");
            id = scanner.nextLine();
        } while (!RegularExpression.checkId(id, type));
        return id;
    }

    private String getName() {
        String name;
        do {
            System.out.println("Enter Name : ");
            name = scanner.nextLine();
        } while (!RegularExpression.checkNameService(name));
        return name;
    }

    public void addNewVilla() {
        Services newServices = addNewServices(Constant.VILLA);
        String standard = getStandard();
        String convenientDesciption = getConvenientDescription();
        double areaPool = getAreaPool();
        int numOfFloor = getNumOfFloor();
        Villa newVilla = ((Villa) newServices);
        newVilla.set(standard, convenientDesciption, areaPool, numOfFloor);
        controllerUtility.writeDataFromVilla(newVilla, true);
    }

    public void addNewHouse() {
        Services newServices = addNewServices(Constant.HOUSE);
        String standard = getStandard();
        String convenientDesciption = getConvenientDescription();
        int numOfFloor = getNumOfFloor();
        House newHouse = ((House) newServices);
        newHouse.set(standard, convenientDesciption, numOfFloor);
        controllerUtility.writeDataFromHouse(newHouse, true);
    }

    public void addNewRoom() {
        Services newServices = addNewServices(Constant.ROOM);
        Room newRoom = ((Room) newServices);
        controllerUtility.writeDataFromRoom(newRoom, true);
    }

    private double getAreaPool() {
        double areaPool;
        do {
            System.out.println("Enter Area Pool : ");
            areaPool = RegularExpression.inputDouble();
        } while (!RegularExpression.checkArea(areaPool));
        return areaPool;
    }

    private int getNumOfFloor() {
        int numOfFloor;
        do {
            System.out.println("Enter Num of Floor : ");
            numOfFloor = RegularExpression.inputInt();
        } while (!RegularExpression.checkFloor(numOfFloor));
        return numOfFloor;
    }

    private String getConvenientDescription() {
        System.out.println("Enter Convenient Description : ");
        return scanner.nextLine();
    }

    private String getStandard() {
        String standard = "";
        do {
            System.out.println("Enter Choose Standard : ");
            System.out.println("1.Vip");
            System.out.println("2.Normal");
            int choice = RegularExpression.inputInt();
            switch (choice) {
                case 1:
                    standard = "Vip";
                    break;
                case 2:
                    standard = "Normal";
                    break;
            }
        } while (standard.equals(""));
        return standard;
    }

    private int getIndex(String type) {

        switch (type) {
            case Constant.VILLA:
                for (int i = 0; i < getVillaList().size(); i++) {
                    System.out.println((i + 1) + "." + getVillaList().get(i).getName());
                }
                System.out.println("Enter Index Service to Edit (0 to Back) : ");
                break;
            case Constant.HOUSE:
                for (int i = 0; i < getHouseList().size(); i++) {
                    System.out.println((i + 1) + "." + getRoomList().get(i).getName());
                }
                System.out.println("Enter Index Service to Edit (0 to Back) : ");
                break;
            default:
                for (int i = 0; i < getRoomList().size(); i++) {
                    System.out.println((i + 1) + "." + getRoomList().get(i).getName());
                }
                System.out.println("Enter Index Service to Edit (0 to Back) : ");
        }
        return RegularExpression.inputInt() - 1;
    }

    public void editVilla(int index) {
        List<Villa> list = getVillaList();
        Villa villa = list.get(index);
        int choose;
        do {
            villa.showInfo();
            System.out.println("11.Back to Menu");
            System.out.println("0.Exit Program");
            System.out.println("Enter Index Property to Edit : ");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    String name = getName();
                    villa.setName(name);
                    break;
                case 2:
                    String id = getId(Constant.VILLA);
                    villa.setId(id);
                    break;
                case 3:
                    double area = getArea();
                    villa.setArea(area);
                    break;
                case 4:
                    int cost = getCost();
                    villa.setCost(cost);
                    break;
                case 5:
                    int quantityMax = getQuantityMax();
                    villa.setQuantityMax(quantityMax);
                    break;
                case 6:
                    String rentType = getRentType();
                    villa.setRentType(rentType);
                    break;
                case 7:
                    String standard = getStandard();
                    villa.setStandard(standard);
                    break;
                case 8:
                    String convenientDescription = getConvenientDescription();
                    villa.setConvenientDescription(convenientDescription);
                    break;
                case 9:
                    double areaPool = getAreaPool();
                    villa.setAreaPool(areaPool);
                    break;
                case 10:
                    int numOfFloor = getNumOfFloor();
                    villa.setNumOfFloor(numOfFloor);
                    break;
                case 11:
                    System.out.println();
                    break;
                case 0:
                    System.out.println(Constant.SEE_YOU_LATER);
                    System.exit(0);
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
            boolean isAdd = false;
            for (Villa value : list) {
                controllerUtility.writeDataFromVilla(value, isAdd);
                isAdd = true;
            }
        } while (choose != 11);
    }

    public void editHouse(int index) {
        List<House> list = getHouseList();
        House house = list.get(index);
        int choose;
        do {
            house.showInfo();
            System.out.println("10.Back to Menu");
            System.out.println("0.Exit Program");
            System.out.println("Enter Index Property to Edit : ");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    String name = getName();
                    house.setName(name);
                    break;
                case 2:
                    String id = getId(Constant.HOUSE);
                    house.setId(id);
                    break;
                case 3:
                    double area = getArea();
                    house.setArea(area);
                    break;
                case 4:
                    int cost = getCost();
                    house.setCost(cost);
                    break;
                case 5:
                    int quantityMax = getQuantityMax();
                    house.setQuantityMax(quantityMax);
                    break;
                case 6:
                    String rentType = getRentType();
                    house.setRentType(rentType);
                    break;
                case 7:
                    String standard = getStandard();
                    house.setStandard(standard);
                    break;
                case 8:
                    String convenientDescription = getConvenientDescription();
                    house.setConvenientDescription(convenientDescription);
                    break;
                case 9:
                    int numOfFloor = getNumOfFloor();
                    house.setNumOfFloor(numOfFloor);
                    break;
                case 10:
                    System.out.println();
                    break;
                case 0:
                    System.out.println(Constant.SEE_YOU_LATER);
                    System.exit(0);
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
            boolean isAdd = false;
            for (House value : list) {
                controllerUtility.writeDataFromHouse(value, isAdd);
                isAdd = true;
            }
        } while (choose != 10);
    }

    public void editRoom(int index) {
        List<Room> list = getRoomList();
        Room room = list.get(index);
        int choose;
        do {
            room.showInfo();
            System.out.println("7.Back to Menu");
            System.out.println("0.Exit Program");
            System.out.println("Enter Index Property to Edit : ");
            choose = RegularExpression.inputInt();
            switch (choose) {
                case 1:
                    String name = getName();
                    room.setName(name);
                    break;
                case 2:
                    String id = getId(Constant.ROOM);
                    room.setId(id);
                    break;
                case 3:
                    double area = getArea();
                    room.setArea(area);
                    break;
                case 4:
                    int cost = getCost();
                    room.setCost(cost);
                    break;
                case 5:
                    int quantityMax = getQuantityMax();
                    room.setQuantityMax(quantityMax);
                    break;
                case 6:
                    String rentType = getRentType();
                    room.setRentType(rentType);
                    break;
                case 7:
                    System.out.println();
                    break;
                case 0:
                    System.out.println(Constant.SEE_YOU_LATER);
                    System.exit(0);
                default:
                    System.err.println(Constant.CHOOSE_ERROR);
            }
            boolean isAdd = false;
            for (Room value : list) {
                controllerUtility.writeDataFromRoom(value, isAdd);
                isAdd = true;
            }
        } while (choose != 7);
    }

    public void showVillaName() {
        for (int i = 0; i < getVillaList().size(); i++) {
            System.out.println(i + 1 + "." + getVillaList().get(i).getName());
        }
    }

    public void showInformationVilla(int index) {
        System.out.println(getVillaList().get(index));
    }

    public void showHouseName() {
        for (int i = 0; i < getHouseList().size(); i++) {
            System.out.println(i + 1 + "." + getHouseList().get(i).getName());
        }
    }

    public void showInformationHouse(int index) {
        System.out.println(getHouseList().get(index));
    }

    public void showRoomName() {
        for (int i = 0; i < getRoomList().size(); i++) {
            System.out.println(i + 1 + "." + getRoomList().get(i).getName());
        }
    }

    public void showInformationRoom(int index) {
        System.out.println(getRoomList().get(index));
    }

    public List<Villa> getVillaList() {
        return controllerUtility.getVillaList();
    }

    public List<House> getHouseList() {
        return controllerUtility.getHouseList();
    }

    public List<Room> getRoomList() {
        return controllerUtility.getRoomList();
    }

}
