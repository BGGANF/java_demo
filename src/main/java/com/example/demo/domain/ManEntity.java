package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "man", schema = "girl", catalog = "")
public class ManEntity {
    private int id;
    private String name;
    private Integer age;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManEntity manEntity = (ManEntity) o;
        return id == manEntity.id &&
                Objects.equals(name, manEntity.name) &&
                Objects.equals(age, manEntity.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age);
    }
}
