package uz.jvh.dtm_visiontest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.jvh.dtm_visiontest.domain.Response.UserResponse;
import uz.jvh.dtm_visiontest.domain.entity.User;
import uz.jvh.dtm_visiontest.domain.request.UserRequest;
import uz.jvh.dtm_visiontest.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private  PasswordEncoder passwordEncoder;


    public User findByUsername(String username) {
        return userRepo.findByUsernameAndIsActiveTrue(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }


    @Transactional
    public void save(User user) {
        userRepo.save(user);
    }

    public User mapRequestToEntity(UserRequest userRequest) {
        return User.builder()
                .username(userRequest.getUsername())
                .surname(userRequest.getSurname())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(userRequest.getRole())
                .email(userRequest.getEmail())
                .birthDate(userRequest.getBirthDate())
                .phoneNumber(userRequest.getPhoneNumber())
                .balance(userRequest.getBalance())
                .address(userRequest.getAddress())
                .build();
    }

    public UserResponse mapEntityToResponse(User user) {
        return UserResponse.builder()
                .uuid(user.getId())
                .username(user.getUsername())
                .surname(user.getSurname())
                .role(user.getRole())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .phoneNumber(user.getPhoneNumber())
                .balance(user.getBalance())
                .address(user.getAddress())
                .createDate(user.getCreated().toLocalDate())
                .build();
    }

}
