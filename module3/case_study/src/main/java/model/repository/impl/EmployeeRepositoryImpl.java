package model.repository.impl;

import model.bean.employee.*;
import model.repository.EmployeeRepository;
import model.service.Validate;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    public static final String SQL_FIND_ALL_EMPLOYEE = "select * from employee";
    public static final String SQL_FIND_POSITION = "select * from `position` where position_id = ?";
    public static final String SQL_FIND_ED = "select * from education_degree where education_degree_id = ?";
    public static final String SQL_FIND_DIVISION = "select * from division where division_id = ?";
    public static final String SQL_FIND_EMPLOYEE = "select * from employee where employee_id = ?";
    public static final String SQL_FIND_EMPLOYEE_NAME = "select * from employee where employee_name like ?";
    public static final String SQL_SAVE_EMPLOYEE = "insert into employee(employee_name,employee_birthday,\n" +
            "employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username) values (" +
            "?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE_EMPLOYEE = "update employee set employee_name = ?,employee_birthday = ?,employee_id_card = ?\n" +
            ",employee_salary = ?,employee_phone = ?,employee_email = ?,employee_address = ?,position_id = ?,education_degree_id = ?,division_id = ?,username = ? where employee_id = ?";
    public static final String SQL_INSERT_USER = "insert into `user` values(?,?)";
    public static final String SQL_UPDATE_USER = "update `user` set password = ? where username = ?";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            try {
                PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_SAVE_EMPLOYEE);
                preparedStatement = setPrepared(employee, preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_UPDATE_EMPLOYEE);
                preparedStatement = setPrepared(employee,preparedStatement);
                preparedStatement.setString(12, String.valueOf(employee.getId()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private PreparedStatement setPrepared(Employee employee, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,Validate.changeDateToDB(employee.getDateOfBirth()));
        preparedStatement.setString(3,employee.getIdCard());
        preparedStatement.setString(4,String.valueOf(employee.getSalary()));
        preparedStatement.setString(5,employee.getPhone());
        preparedStatement.setString(6,employee.getEmail());
        preparedStatement.setString(7,employee.getAddress());
        preparedStatement.setString(8,String.valueOf(employee.getPosition().getId()));
        preparedStatement.setString(9,String.valueOf(employee.getEducationDegree().getId()));
        preparedStatement.setString(10,String.valueOf(employee.getDivision().getId()));
        preparedStatement.setString(11,employee.getUser().getUserName());
        return preparedStatement;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                employee = getEmployee(resultSet);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Employee getEmployee(ResultSet resultSet) throws SQLException {
        Employee employee;
        Integer id = Integer.parseInt(resultSet.getString("employee_id"));
        String name = resultSet.getString("employee_name");
        String birthday = resultSet.getString("employee_birthday");
        birthday = Validate.changeDateToView(birthday);
        String idCard = resultSet.getString("employee_id_card");
        double salary = Double.parseDouble(resultSet.getString("employee_salary"));
        String phone = resultSet.getString("employee_phone");
        String email = resultSet.getString("employee_email");
        String address = resultSet.getString("employee_address");
        int positionID = Integer.parseInt(resultSet.getString("position_id"));
        Position position = findPosition(positionID);
        int educationDegreeID = Integer.parseInt(resultSet.getString("education_degree_id"));
        EducationDegree educationDegree = findEducationDegree(educationDegreeID);
        int divisionID = Integer.parseInt(resultSet.getString("division_id"));
        Division division = findDivision(divisionID);
        String username = resultSet.getString("username");
        User user = findUser(username);
        employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,position,educationDegree,division,user);
        return employee;
    }

    @Override
    public Employee findByID(int id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_EMPLOYEE);
            preparedStatement.setString(1,String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                employee = getEmployee(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String key) {
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_EMPLOYEE_NAME);
            preparedStatement.setString(1,"%"+key+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = null;
            while (resultSet.next()){
                employee = getEmployee(resultSet);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveUser(User user) {
        if (findUser(user.getUserName()) == null){
            try {
                PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_INSERT_USER);
                preparedStatement.setString(1,user.getUserName());
                preparedStatement.setString(2,user.getPassWord());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_UPDATE_USER);
                preparedStatement.setString(1,user.getPassWord());
                preparedStatement.setString(2,user.getUserName());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall("call delete_employee(?)");
            callableStatement.setString(1,String.valueOf(id));
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Position findPosition(int id) {
        Position position = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_POSITION);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("position_name");
                position = new Position(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }

    @Override
    public EducationDegree findEducationDegree(int id) {
        EducationDegree educationDegree = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ED);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("education_degree_name");
                educationDegree = new EducationDegree(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegree;
    }

    @Override
    public Division findDivision(int id) {
        Division division = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_DIVISION);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("division_name");
                division = new Division(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }

    @Override
    public User findUser(String username) {
        User user = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from user where username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("password");
                user = new User(username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Position> listPosition() {
        List<Position> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from `position`");
            ResultSet resultSet = preparedStatement.executeQuery();
            Position position = null;
            while (resultSet.next()){
                position = new Position(Integer.parseInt(resultSet.getString("position_id")),
                        resultSet.getString("position_name"));
                list.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<EducationDegree> listED() {
        List<EducationDegree> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from education_degree");
            ResultSet resultSet = preparedStatement.executeQuery();
            EducationDegree educationDegree = null;
            while (resultSet.next()){
                educationDegree = new EducationDegree(Integer.parseInt(resultSet.getString("education_degree_id")),
                        resultSet.getString("education_degree_name"));
                list.add(educationDegree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Division> listDivion() {
        List<Division> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from division");
            ResultSet resultSet = preparedStatement.executeQuery();
            Division division = null;
            while (resultSet.next()){
                division = new Division(Integer.parseInt(resultSet.getString("division_id")),
                        resultSet.getString("division_name"));
                list.add(division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<User> listUser() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement("select * from `user`");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()){
                user = new User(resultSet.getString("username"),
                        resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
