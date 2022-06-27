package com.jpa.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "User.selectByIdInUser",query = "select U from User U where id=:id"),
        @NamedQuery(name = "User.selectInProvidedId",query = "select U from User U where id IN(:ids)")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "User.selectByIdInUserNative",query = "select * from user where id=:id",
                            resultClass = User.class),
        @NamedNativeQuery(name = "User.selectInProvidedIdNative",query = "select * from user where id IN(:ids)",
                        resultClass = User.class)
})
@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String city;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
