package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Address;

import java.util.List;

public interface IAddressService {

    List<Address> findAll();

    Address findById(Long id);

    Address Create(Address address);

    Address Update(Address address, Address updatedAddress);

    void Delete(Address address);
}
