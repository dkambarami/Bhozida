package com.bhozida.backend.controller;

import com.bhozida.backend.model.Customer;
import com.bhozida.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/customer/createCustomer", method = RequestMethod.POST)
    public String addUpdateCustomer(Customer customer, Model model) {
        customerService.addUpdate(customer);

        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @RequestMapping(path = {"/customer/edit", "/customer/edit/{id}"})
    public String editCustomerById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Customer customer = customerService.findById(id.get());
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("customer", new Customer());
        }
        return "customer/add-edit";
    }

    @RequestMapping("/customer/view/{id}")
    public String showCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/detail";
    }

    @RequestMapping(path = "/customer/delete/{id}")
    public String deleteCustomerById(Model model, @PathVariable("id") Long id) {
        customerService.deleteById(id);

        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

}
