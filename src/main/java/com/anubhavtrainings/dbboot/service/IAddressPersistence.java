package com.anubhavtrainings.dbboot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anubhavtrainings.dbboot.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, String> {

}
