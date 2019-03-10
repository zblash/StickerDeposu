package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.AddressRepository;
import com.stickerdeposu.web.Repositories.UserRepository;
import com.stickerdeposu.web.Service.Abstract.IAddressService;
import com.stickerdeposu.web.models.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Address Create(Address address) {
        address.setUser(userRepository.findById(address.getUserId()).orElseThrow(RuntimeException::new));
        return addressRepository.save(address);
    }

    @Override
    public Address Update(Address address, Address updatedAddress) {
        address.setAddressName(updatedAddress.getAddressName());
        address.setDetails(updatedAddress.getDetails());
        address.setCity(updatedAddress.getCity());
        address.setState(updatedAddress.getState());
        address.setUser(userRepository.findById(address.getUserId()).orElseThrow(RuntimeException::new));
        return addressRepository.save(address);
    }

    @Override
    public void Delete(Address address) {
        addressRepository.delete(address);
    }
}
