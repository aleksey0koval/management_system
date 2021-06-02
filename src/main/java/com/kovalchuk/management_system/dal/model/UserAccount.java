package com.kovalchuk.management_system.dal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

@Data
@Entity
@Table(name = "user_accounts")
public class UserAccount implements Serializable {
    private static final long serialVersionUID = -174946392217012757L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Не должно быть пустым")
//    @Size(min = 3, max = 16, message = "Длина username должна быть от 3 до 16 символов")
//    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Не должно быть пустым")
//    @Size(min = 3, max = 16, message = "Длина password должна быть от 3 до 16 символов")
//    @Pattern(regexp = "^[a-zA-Z0-9_-]$", message = "Только латинские символы и цифры, " +
//            "Минимум один символ и Минимум одна цифра")
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
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;
}
