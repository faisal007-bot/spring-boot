package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    @Id
    @Column(name = "USER_ID", length = 10)
    @NotBlank(message = "user ID cannot be blank")
    private Long userId;
    @NotBlank(message = "username cannot be blank")
    private String userName;
    @NotBlank(message = "usercity cannot be blank")
    private String userCity;
    @Size(min = 1000, max = 1000000000,
            message = "usernumber should be between {min} and {max}")
    private Long userNumber;

    public User() {
    }

    public User(Long userId, String userName, String userCity, Long userNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userCity = userCity;
        this.userNumber = userNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userNumber=" + userNumber +
                '}';
    }
}
