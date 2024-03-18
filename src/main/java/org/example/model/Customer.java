package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String phoneNumber;
    private String name;
    private String petName;
    private String address;
    private String petSpecies;
    private String bornYear;
    private List<MedicalRecord> medicalRecords;

    public Customer() {
    }

    public Customer(String phoneNumber, String name, String petName, String address, String petSpecies, String bornYear) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.petName = petName;
        this.address = address;
        this.petSpecies = petSpecies;
        this.bornYear = bornYear;
        this.medicalRecords = new ArrayList<>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPetSpecies() {
        return petSpecies;
    }

    public void setPetSpecies(String petSpecies) {
        this.petSpecies = petSpecies;
    }

    public String getBornYear() {
        return bornYear;
    }

    public void setBornYear(String bornYear) {
        this.bornYear = bornYear;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(MedicalRecord medicalRecord) {
        this.medicalRecords.add(medicalRecord);
    }
}
