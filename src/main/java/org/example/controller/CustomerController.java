package org.example.controller;

import org.example.model.Customer;
import org.example.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private MedicalRecordController medicalRecordController;

    public CustomerController(MedicalRecordController medicalRecordController) {
        this.customers = new ArrayList<>();
        this.medicalRecordController = medicalRecordController;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(String phoneNumber) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPhoneNumber().equals(phoneNumber)) {
                customers.remove(i);
                medicalRecordController.removeMedicalRecord(phoneNumber);
                break;
            }
        }
    }

    public Customer findCustomer(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }

        return null;
    }

    public boolean isPhoneNumberExist(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }

        return false;
    }
}
