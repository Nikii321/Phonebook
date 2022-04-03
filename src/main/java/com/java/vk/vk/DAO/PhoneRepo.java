package com.java.vk.vk.DAO;

import com.java.vk.vk.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepo  extends JpaRepository<Phone, Long> {
    Phone findPhoneByNumber(String number);
    List<Phone> findAllByNumberIsLike(String string);
}
