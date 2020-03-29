package com.sudip.learn.dao;

import com.sudip.learn.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> queryCustomer = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = queryCustomer.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        //if customer has an  id  then update or else insert in the database
        session.saveOrUpdate(customer);

        //session.save(customer);
    }

    @Override
    public Customer getCustomer(int theCustomerID) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, theCustomerID);
        return customer;
    }

    @Override
    public void deleteCustomerFromDataBase(int theCustomerID) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:theCustomerId");

        query.setParameter("theCustomerId", theCustomerID);

        query.executeUpdate();
    }
}
