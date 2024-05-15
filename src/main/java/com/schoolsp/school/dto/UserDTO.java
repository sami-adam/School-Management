package com.schoolsp.school.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schoolsp.school.models.Role;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    Set<Role> roles = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(String username, String email, String password, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
