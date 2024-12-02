package uz.jvh.dtm_visiontest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.jvh.dtm_visiontest.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

}
