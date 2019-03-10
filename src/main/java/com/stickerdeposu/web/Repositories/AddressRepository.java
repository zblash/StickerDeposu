package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
