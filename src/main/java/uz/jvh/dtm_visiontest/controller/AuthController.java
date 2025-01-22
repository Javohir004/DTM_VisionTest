package uz.jvh.dtm_visiontest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.jvh.dtm_visiontest.domain.Response.JwtResponse;
import uz.jvh.dtm_visiontest.domain.Response.UserResponse;
import uz.jvh.dtm_visiontest.domain.request.LoginDto;
import uz.jvh.dtm_visiontest.domain.request.UserRequest;
import uz.jvh.dtm_visiontest.service.AuthService;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {


    private final AuthService authService;


    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest userRequest) {
        return authService.save(userRequest);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
}