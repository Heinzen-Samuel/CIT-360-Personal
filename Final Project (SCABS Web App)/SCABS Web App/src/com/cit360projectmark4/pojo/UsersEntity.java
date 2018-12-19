package com.cit360projectmark4.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "scabs_webapp", catalog = "")
public class UsersEntity {
    private String username;
    private String password;
    private int calories;

    @Id
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "calories", nullable = false)
    public int getcalories() {
        return calories;
    }

    public void setcalories(int calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public String toString() {
        return "username=" + username + ", password=" + password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
