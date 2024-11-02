package com.anubhavtrainings.dbboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anubhavtrainings.dbboot.entities.Address;

@Component
public class AddressService {
    @Autowired
    IAddressPersistence addressDB;

    public List<Address> getAddresses() {
        return addressDB.findAll();
    }

    public Optional<Address> getSingleAddress(String addressId) {
        return addressDB.findById(addressId);
    }

    public Address createAddress(Address addressData) {
        if (addressData.getCountry() == "USA") {
            throw new Error("The USA as country not allowed");
        }
        return addressDB.save(addressData);
    }

}
