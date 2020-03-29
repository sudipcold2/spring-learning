package com.sudip.learn.controller;

import com.sudip.learn.entity.Customer;
import com.sudip.learn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String home(){
        return "list-customer";
    }

    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomer(Model model){

        List<Customer> customers = customerService.getAllCustomers();

        model.addAttribute("customers", customers);

        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddCustomer(Model model){

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int theCustomerID, Model theModel){
        Customer customer = customerService.getCustomer(theCustomerID);

        theModel.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/processDelete")
    public String deleteCustomer(@RequestParam("customerId") int theCustomerID, Model model){

        customerService.deleteCustomer(theCustomerID);

        return "redirect:/customer/list";
    }

}
