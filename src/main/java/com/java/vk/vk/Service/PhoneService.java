package com.java.vk.vk.Service;

import com.java.vk.vk.DAO.PhoneRepo;

import com.java.vk.vk.Entity.Comment;
import com.java.vk.vk.Entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    PhoneRepo phoneRepository;



    public Phone findPhoneByNumber(String number){
        return phoneRepository.findPhoneByNumber(number);
    }
    public String PhonesCountry(String number){
        if(!(number.charAt(0) =='+') || number.charAt(1)=='7'){
            return "Russia";
        }
        else if(number.substring(0,5).equals("+1905") || number.substring(0,3).equals("+52")){
            return "Mexico";
        }
        else if(number.substring(0,3).equals("+86")){
            return "China";
        }
        else if(number.charAt(1)=='1'){
            return "USA";
        }
        else{
            return "Unknown";
        }
    }

    public boolean addPhone(Phone phone){
        Phone phoneByNumber = findPhoneByNumber(phone.getNumber());
        if(phoneByNumber!=null){
            return false;
        }

        phone.setCountry(PhonesCountry(phone.getNumber()));
        phoneRepository.save(phone);
        return true;
    }
    public boolean addPhone(String number){
        Phone phoneByNumber = findPhoneByNumber(number);
        if(phoneByNumber!=null){
            return false;
        }
        Phone phone = new Phone();
        phone.setNumber(number);

        phone.setCountry(PhonesCountry(phone.getNumber()));
        phoneRepository.save(phone);
        return true;
    }

    public boolean addComment(Comment comment,String number){

        Phone phone = findPhoneByNumber(number);
        List<Comment> list = phone.getList();
        list.add(comment);
        phone.setList(list);
        phoneRepository.save(phone);
        return true;
    }
    public List<Phone> findAllNumberStart(String start){
        return phoneRepository.findAllByNumberIsLike(start);
    }
}
