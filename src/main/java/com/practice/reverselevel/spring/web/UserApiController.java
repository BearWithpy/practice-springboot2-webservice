package com.practice.reverselevel.spring.web;


import com.practice.reverselevel.spring.config.auth.LoginUser;
import com.practice.reverselevel.spring.config.auth.dto.SessionUser;
import com.practice.reverselevel.spring.service.user.UserService;
import com.practice.reverselevel.spring.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @GetMapping("/role")
    public UserResponseDto changeRole(@LoginUser SessionUser user) {
        String email = user.getEmail();
        return userService.changeRoleByEmail(email);
    }
}
