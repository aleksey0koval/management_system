package com.kovalchuk.management_system.dal.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a UserAccount.
 *
 * @author Aleskey Kovalchuk
 */

//@Data
@Entity
@Table(name = "user_accounts")
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 3, max = 16, message = "Длина username должна быть от 3 до 16 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 3, max = 16, message = "Длина password должна быть от 3 до 16 символов")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,16}$", message = "Только латинские символы и цифры, " +
            "Минимум один символ и Минимум одна цифра")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 1, max = 16, message = "Длина first_name должна быть от 1 до 16 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 1, max = 16, message = "Длина last_name должна быть от 1 до 16 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date")
    private Date date;

    @Column(name = "enabled")
    private boolean enabled = true;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public UserAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
