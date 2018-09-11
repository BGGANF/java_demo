package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "girl", schema = "girl", catalog = "")
public class GirlEntity {
    private int id;
    private Integer age;
    private String cupSize;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "cup_size")
    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GirlEntity that = (GirlEntity) o;
        return id == that.id &&
                Objects.equals(age, that.age) &&
                Objects.equals(cupSize, that.cupSize);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, age, cupSize);
    }
}
