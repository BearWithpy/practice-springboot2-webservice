package com.practice.reverselevel.spring.web.dto;


import com.practice.reverselevel.spring.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRoleUpdateRequestDto {
    private Role role;

    @Builder
    public UserRoleUpdateRequestDto(Role role) {
        this.role = role;
    }
}
