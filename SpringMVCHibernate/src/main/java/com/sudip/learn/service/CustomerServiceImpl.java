package com.sudip.learn.service;

import com.sudip.learn.dao.CustomerDao;
import com.sudip.learn.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Transactional
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerDao.getCustomers();

        if(customers != null){
            return customers;
        }

        return new ArrayList<Customer>();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        if(customer != null){
            customerDao.saveCustomer(customer);
        }
    }

    @Override
    @Transactional
    public Customer getCustomer(int theCustomerID) {
        Customer customer = customerDao.getCustomer(theCustomerID);
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int theCustomerID) {
        customerDao.deleteCustomerFromDataBase(theCustomerID);
    }
}
