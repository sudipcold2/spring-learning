package com.sudip.rest.service;

import com.sudip.rest.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int theCustomerID);

    void deleteCustomer(int theCustomerID);
}
