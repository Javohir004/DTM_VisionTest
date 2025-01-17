package uz.jvh.dtm_visiontest.domain.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.jvh.dtm_visiontest.domain.enums.UserRole;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private String token;
    private Long userId;
    private UserRole userRole;

}
