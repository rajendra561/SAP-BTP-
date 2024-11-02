package com.anubhavtrainings.dbboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.dbboot.entities.Vendor;
import com.anubhavtrainings.dbboot.service.VendorService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class VendorController {

    @Autowired
    private VendorService myVendorSrv;

    // GET_ENTITY_SET
    // Test URL - http://localhost:8080/vendors

    @RequestMapping("/vendors")
    public List<Vendor> getAll() {
        System.out.println("RAJA RAJA");
        return myVendorSrv.getAllVendors();
    }

    @RequestMapping("/checkString")
    public String getAll1() {
        System.out.println("RAJA RAJA");
        return "HELLO HI BYE BYE";
    }

    // CREATE_ENTITY
    // POST - http://localhost:8080/vendors
    // {
    // "code": "",
    // "companyName": "Anubhav Trainings",
    // "contactPerson": "Anubhav",
    // "firstName": "Mianakshi",
    // "lastName": "Sen",
    // "website": "www.anubhavtrainings.com",
    // "email": "contact@anubhavtrainings.com",
    // "status": 1,
    // "regDate": "2024-01-01"
    // }
    @PostMapping("/postvendors")
    public Vendor createVendor(@RequestBody Vendor myVendor) {
        System.out.println(myVendor);
        return myVendorSrv.createVendor(myVendor);
    }

    // GET_ENTITY
    // GET - http://localhost:8080/vendor/---your own generated id
    // Exercise: Implement ReadSingleVendorData by Id, Update Vendor, Delete Vendor
    @RequestMapping("/vendor/{vendorCode}")
    public Optional<Vendor> getVendorById(@PathVariable("vendorCode") String code) {
        return myVendorSrv.getVendorById(code);
    }

    // UPDATE_ENTITY
    // PUT - http://localhost:8080/vendor/--your own vendor id
    // {
    // "companyName": "IBM incorporation",
    // "contactPerson": "Ananya",
    // "firstName": "Roger",
    // "lastName": "Morrison",
    // "website": "www.ibm.com",
    // "email": "roger@ibm.com",
    // "status": 1,
    // "regDate": "2024-02-01"
    // }

    @RequestMapping(method = RequestMethod.PUT, value = "/vendor/{vendorId}")
    public Vendor updateVendor(@PathVariable("vendorId") String vendorCode,
            @RequestBody Vendor vendor) {
        return myVendorSrv.updateVendorById(vendorCode, vendor);
    }

    // DELETE_ENTITY
    // DELETE http://localhost:8080/vendor/--own vendor id
    @RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.DELETE)
    public String requestMethodName(@PathVariable("vendorId") String vendorId) {
        return myVendorSrv.deleteVendor(vendorId);
    }

    // GET http://localhost:8080/vendor/search?company=SAP
    @RequestMapping("/vendor/search")
    public List<Vendor> searchByCompany(@RequestParam String company) {
        return myVendorSrv.getCustomerByCompanyName(company);
    }

    // GET http://localhost:8080/vendor/lookup/gmail
    @RequestMapping("/vendor/lookup/{emailId}")
    public List<Vendor> searchVendorByEmailId(@PathVariable("emailId") String emailId) {
        return myVendorSrv.searchCustomerByEmailId(emailId);
    }
}
