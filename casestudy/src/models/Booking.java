package models;

import java.util.Date;

public class Booking {
    Date now = new Date();
    private String nameCustomer;
    private String idCustomer;
    private String nameService;
    private String idService;
    private String dateStart;
    private String dateEnd;

    public Booking(String nameCustomer, String idCustomer, String nameService, String idService) {
        this.nameCustomer = nameCustomer;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.idService = idService;
        dateStart = now.getDate() + "/" + now.getMonth() + "/" + now.getYear();
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
