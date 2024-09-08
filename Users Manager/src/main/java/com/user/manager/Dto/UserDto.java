package com.user.manager.Dto;

import com.user.manager.enums.Role;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private String password;
    private String email;
    private final Role role = Role.USER;
}
