package uz.jvh.dtm_visiontest.domain.Response;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import uz.jvh.dtm_visiontest.domain.enums.UserRole;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private Long uuid;
    private String username;
    private String surname;
    private String password;
    private UserRole role;
    private String email;
    private LocalDate birthDate;
    private String phoneNumber;
    private Double balance;
    private String address;
    private LocalDate createDate;

}