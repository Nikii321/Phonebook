package com.java.vk.vk.Entity;


import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nameAuthor;
    @Column
    private String text;
    @Column
    private Double reting;
    @Column
    private Double sum;
    @Column
    private Long count;



    public void setReting(Double grade) {
        this.reting = grade;
    }

    public Double getReting() {
        return reting;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", text='" + text + '\'' +
                ", grade=" + reting +
                ", sum=" + sum +
                ", count=" + count +
                '}';
    }
}
