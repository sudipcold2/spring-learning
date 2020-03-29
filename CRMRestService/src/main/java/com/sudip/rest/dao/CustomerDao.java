package com.sudip.rest.dao;


import com.sudip.rest.entity.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int theCustomerID);

    void deleteCustomerFromDataBase(int theCustomerID);
}
