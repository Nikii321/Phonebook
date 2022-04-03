package com.java.vk.vk.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToMany
    private List<Comment> list;
    @Column
    private String country;

    @Column
    private String number;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Comment> getList() {
        return list;
    }

    public void setList(List<Comment> list) {
        this.list = list;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", number='" + number + '\'' +

                '}';
    }
}
