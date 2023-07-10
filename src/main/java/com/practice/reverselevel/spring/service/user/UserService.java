package com.practice.reverselevel.spring.service.user;


import com.practice.reverselevel.spring.domain.posts.Posts;
import com.practice.reverselevel.spring.domain.user.Role;
import com.practice.reverselevel.spring.domain.user.User;
import com.practice.reverselevel.spring.domain.user.UserRepository;
import com.practice.reverselevel.spring.web.dto.PostsResponseDto;
import com.practice.reverselevel.spring.web.dto.PostsUpdateRequestDto;
import com.practice.reverselevel.spring.web.dto.UserResponseDto;
import com.practice.reverselevel.spring.web.dto.UserRoleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto changeRoleByEmail(String email) {
        User entity = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 user 없음. ID=" + email));
        User updatedUser = entity.updateRole(Role.USER);
        userRepository.save(updatedUser);

        return new UserResponseDto(updatedUser);
    }

}
