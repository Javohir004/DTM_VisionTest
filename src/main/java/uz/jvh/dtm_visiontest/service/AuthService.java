package uz.jvh.dtm_visiontest.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import uz.jvh.dtm_visiontest.domain.Response.JwtResponse;
import uz.jvh.dtm_visiontest.domain.Response.UserResponse;
import uz.jvh.dtm_visiontest.domain.entity.User;
import uz.jvh.dtm_visiontest.domain.exceprion.DataNotFoundException;
import uz.jvh.dtm_visiontest.domain.request.LoginDto;
import uz.jvh.dtm_visiontest.domain.request.UserRequest;
import uz.jvh.dtm_visiontest.securtiy.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;


    public UserResponse save(UserRequest user) {
        User user1 = userService.mapRequestToEntity(user);
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user1);
        return userService.mapEntityToResponse(user1);
    }

    public JwtResponse login(LoginDto loginDto) {
        User user = userService.findByUsername(loginDto.getUsername());
        if (user == null) {
            throw new DataNotFoundException("Username or password is incorrect");
        }
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        String token = jwtTokenUtil.generateToken(user.getUsername());

        return new JwtResponse(token, user.getId(),user.getRole());
    }

}
