package com.kovalchuk.management_system.service.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Component
@Data
public class RequestDto {
    private Long id;

    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 3, max = 16, message = "Длина username должна быть от 3 до 16 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String username;

    @NotBlank(message = "Не должно быть пустым")
//    @Pattern(regexp = "^[a-zA-Z0-9_-]$", message = "Только латинские символы и цифры, " +
//            "Минимум один символ и Минимум одна цифра")
    private String password;

    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 1, max = 16, message = "Длина first_name должна быть от 1 до 16 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String firstName;

    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 1, max = 16, message = "Длина last_name должна быть от 1 до 16 символов")
    @Pattern(regexp = "[a-zA-Z]*", message = "Только латинские буквы")
    private String lastName;

    private String role;

    private Date date;

    private boolean enabled;
}


