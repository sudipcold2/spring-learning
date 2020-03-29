package com.sudip.learn.service;

import com.sudip.learn.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int theCustomerID);

    void deleteCustomer(int theCustomerID);
}
