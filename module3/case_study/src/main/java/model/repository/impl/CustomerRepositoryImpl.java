package model.repository.impl;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.bean.employee.Employee;
import model.repository.CustomerRepository;
import model.service.Validate;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    public static final String SQL_FIND_ALL_CUS = "select * from customer";
    public static final String SQL_FIND_ALL_CUS_TYPE = "select * from customer_type";
    public static final String SQL_FIND_TYPE_BY_ID = "select * from customer_type where customer_type_id = ?";
    public static final String SQL_FIND_CUS_FROM_ID = "select * from customer where customer_id = ?";
    public static final String SQL_CALL_DELETE_CUS = "call delete_customer(?)";
    public static final String SQL_FIND_CUSTOMER_NAME = "select * from customer where customer_name like ?";
    public static final String SQL_CREATE_CUS = "insert into customer(customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values(?,?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE_CUS = "update customer set customer_type_id = ?,customer_name = ?,customer_birthday = ?,customer_gender = ?,customer_id_card = ?,customer_phone = ?,customer_email = ?,customer_address = ? where customer_id = ?";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            try {
                PreparedStatement preparedStatement = getPreparedStatement(customer,SQL_CREATE_CUS);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement = getPreparedStatement(customer,SQL_UPDATE_CUS);
                preparedStatement.setString(9, String.valueOf(customer.getId()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private PreparedStatement getPreparedStatement(Customer customer,String sql) throws SQLException {
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(customer.getCustomerType().getId()));
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setString(3, Validate.changeDateToDB(customer.getDateOfBirth()));
        preparedStatement.setString(4, customer.getGender());
        preparedStatement.setString(5, customer.getIdCard());
        preparedStatement.setString(6, customer.getPhone());
        preparedStatement.setString(7, customer.getEmail());
        preparedStatement.setString(8, customer.getAddress());
        return preparedStatement;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_CUS);
            Customer customer = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = getCustomer(resultSet);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Customer getCustomer(ResultSet resultSet) throws SQLException {
        Customer customer;
        int id = Integer.parseInt(resultSet.getString("customer_id"));
        String name = resultSet.getString("customer_name");
        int typeId = Integer.parseInt(resultSet.getString("customer_type_id"));
        CustomerType customerType = findCustomerType(typeId);
        String birthday = resultSet.getString("customer_birthday");
        birthday = Validate.changeDateToView(birthday);
        String gender = resultSet.getString("customer_gender");
        String idCard = resultSet.getString("customer_id_card");
        String phone = resultSet.getString("customer_phone");
        String email = resultSet.getString("customer_email");
        String address = resultSet.getString("customer_address");
        customer = new Customer(id, name, customerType, birthday, gender, idCard, phone, email, address);
        return customer;
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        List<CustomerType> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_ALL_CUS_TYPE);
            CustomerType customerType = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("customer_type_id"));
                String name = resultSet.getString("customer_type_name");
                customerType = new CustomerType(id, name);
                list.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CustomerType findCustomerType(int id) {
        CustomerType customerType = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_TYPE_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("customer_type_name");
                customerType = new CustomerType(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerType;
    }

    @Override
    public Customer findByID(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_CUS_FROM_ID);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = getCustomer(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void delete(int id) {
        try {
            CallableStatement callableStatement = baseRepository.getConnection().prepareCall(SQL_CALL_DELETE_CUS);
            callableStatement.setString(1, String.valueOf(id));
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findByName(String key) {
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_CUSTOMER_NAME);
            preparedStatement.setString(1,"%"+key+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = null;
            while (resultSet.next()){
                customer = getCustomer(resultSet);
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
