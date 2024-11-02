package com.anubhavtrainings.dbboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.dbboot.entities.Address;
import com.anubhavtrainings.dbboot.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    AddressService addressSrv;

    // Ctrl + to ZOOM IN and - for ZOOM OUT
    // GET_ENTITYSET
    @RequestMapping("/addressess")
    public List<Address> getAddresses() {
        return addressSrv.getAddresses();
    }

    @RequestMapping("/address/{addressId}")
    public Optional<Address> getVendorById(@PathVariable("addressId") String addressId) {
        return addressSrv.getSingleAddress(addressId);
    }

    @PostMapping("/address")
    public Address createAddresses(@RequestBody Address payload) {
        return addressSrv.createAddress(payload);
    }

}
