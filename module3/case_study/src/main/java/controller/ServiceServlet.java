package controller;

import model.bean.services.*;
import model.service.ServiceService;
import model.service.Validate;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", urlPatterns = "/serviceServlet")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("types"));
        boolean isWrong = false;
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        String cost = request.getParameter("cost");
        String maxPeople = request.getParameter("maxPeople");
        RentType rentType = serviceService.findRentType(Integer.parseInt(request.getParameter("rentType")));
        ServiceType serviceType = serviceService.findServiceType(Integer.parseInt(request.getParameter("serviceType")));
        String standardRoom = null;
        String description = null;
        String numOfFloor = null;
        String poolArea = null;
        if (type <= 2){
            standardRoom = request.getParameter("standardRoom");
            description = request.getParameter("description");
            numOfFloor = request.getParameter("numOfFloor");
            request.setAttribute("standardRoom",standardRoom);
            request.setAttribute("description",description);
            if (!Validate.isPositive(numOfFloor)){
                request.setAttribute("numOfFloor","Wrong Format Ex : 5");
                isWrong = true;
            } else {
                request.setAttribute("numOfFloor",numOfFloor);
            }
            if (type == 1){
                poolArea = request.getParameter("poolArea");
                if (!Validate.isPositive(poolArea)){
                    request.setAttribute("poolArea","Wrong Format Ex : 100");
                    isWrong = true;
                } else {
                    request.setAttribute("poolArea",poolArea);
                }
            }
        }
        if (!Validate.isPositive(area)){
            request.setAttribute("area","Wrong Format Ex : 100");
            isWrong = true;
        } else {
            request.setAttribute("area",area);
        }
        if (!Validate.isPositive(cost)){
            request.setAttribute("cost","Wrong Format Ex : 100");
            isWrong = true;
        } else {
            request.setAttribute("cost",cost);
        }
        if (!Validate.isPositive(maxPeople)){
            request.setAttribute("maxPeople","Wrong Format Ex : 10");
            isWrong = true;
        } else {
            request.setAttribute("maxPeople",maxPeople);
        }
        if (!Validate.isPositive(maxPeople)){
            request.setAttribute("maxPeople","Wrong Format Ex : 10");
            isWrong = true;
        } else {
            request.setAttribute("maxPeople",maxPeople);
        }
        if (isWrong){
            request.setAttribute("name",name);
            request.setAttribute("rentType",rentType.getId());
            request.setAttribute("serviceType",serviceType.getId());
            request.getRequestDispatcher("save_service.jsp").forward(request,response);
        } else {
            switch (type){
                case 1:
                    serviceService.saveVilla(new Villa(name,Double.parseDouble(area),Integer.parseInt(cost),Integer.parseInt(maxPeople),
                            serviceType,rentType,standardRoom,description,Double.parseDouble(poolArea),Integer.parseInt(numOfFloor)));
                    goHome(request,response,"villa");
                    break;
                case 2:
                    serviceService.saveHouse(new House(name,Double.parseDouble(area),Integer.parseInt(cost),Integer.parseInt(maxPeople),
                            serviceType,rentType,standardRoom,description,Integer.parseInt(numOfFloor)));
                    goHome(request,response,"house");
                    break;
                case 3:
                    serviceService.saveRoom(new Room(name,Double.parseDouble(area),Integer.parseInt(cost),Integer.parseInt(maxPeople),
                            serviceType,rentType));
                    goHome(request,response,"room");
                    break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "viewVilla";
        }
        int page;
        switch (action) {
            case "createVilla":
                createService(request, response,1);
                break;
            case "createHouse":
                createService(request,response,2);
                break;
            case "createRoom":
                createService(request,response,3);
                break;
            case "viewVilla":
                goHome(request, response, "villa");
                break;
            case "viewHouse":
                goHome(request, response, "house");
                break;
            case "viewRoom":
                goHome(request,response,"room");
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response,int type) throws ServletException, IOException {
        request.setAttribute("serviceTypeList", serviceService.serviceTypeList());
        request.setAttribute("rentTypeList", serviceService.rentTypeList());
        request.setAttribute("types",type);
        request.setAttribute("typeName",serviceService.findServiceType(type).getName());
        request.getRequestDispatcher("save_service.jsp").forward(request,response);
    }

    private void goHome(HttpServletRequest request, HttpServletResponse response, String type) throws ServletException, IOException {
        int page;
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int size;
        switch (type) {
            case "villa":
                request.setAttribute("type",1);
                request.setAttribute("villas", serviceService.findAllVilla(page));
                size = serviceService.sizeVillaList();
                break;
            case "house":
                request.setAttribute("type",2);
                request.setAttribute("houses", serviceService.findAllHouse(page));
                size = serviceService.sizeHouseList();
                break;
            default:
                request.setAttribute("type",3);
                request.setAttribute("rooms", serviceService.findAllRoom(page));
                size = serviceService.sizeRoomList();
        }
        request.setAttribute("size", size);
        request.setAttribute("page", page);
        request.setAttribute("numPage", ((size - 1) / 7) + 1);
        request.getRequestDispatcher("service.jsp").forward(request,response);
    }
}
