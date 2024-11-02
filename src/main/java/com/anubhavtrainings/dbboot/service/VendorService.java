package com.anubhavtrainings.dbboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.anubhavtrainings.dbboot.entities.*;

@Component
public class VendorService {

    @Autowired
    private IVendorPersistence vendorDB;

    // Read all vendors - Return a internal table
    public List<Vendor> getAllVendors() {
        // Fire SELECT * FROM dbtab
        return vendorDB.findAll();
    }

    // Read single vendor by KEY - READ TABLE itab WITH KEY
    public Optional<Vendor> readVendorById(String vendorId) {
        return vendorDB.findById(vendorId);
    }

    // Add new record to vendors - APPEND wa to ITAB
    public Vendor createVendor(Vendor newVendor) {
        // logic - if vendor is there update that else create
        return vendorDB.save(newVendor);
    }

    public Vendor updateVendorById(String vendorId, Vendor vendorData) {
        // Optional<Vendor> vendorFound = vendorDB.findById(vendorId);
        // vendorFound.setCompanyName(vendorData.getCompanyName());
        return vendorDB.save(vendorData);
    }

    public String deleteVendor(String vendorId) {
        vendorDB.deleteById(vendorId);
        return "Object was deleted";
    }

    public Optional<Vendor> getVendorById(String code) {
        return vendorDB.findById(code);
    }

    public List<Vendor> getCustomerByCompanyName(String companyName) {
        return vendorDB.findByCompanyName(companyName);
    }

    public List<Vendor> searchCustomerByEmailId(String emailId) {
        return vendorDB.lookupVendorByEmailId(emailId);
    }

}
