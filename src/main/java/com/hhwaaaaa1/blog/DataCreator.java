package com.hhwaaaaa1.blog;

import com.hhwaaaaa1.blog.api.entity.com.Role;
import com.hhwaaaaa1.blog.api.entity.mem.User;
import com.hhwaaaaa1.blog.api.entity.mem.UserRole;
import com.hhwaaaaa1.blog.api.repository.com.RoleRepository;
import com.hhwaaaaa1.blog.api.repository.mem.UserRepository;
import com.hhwaaaaa1.blog.api.repository.mem.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataCreator implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setRoleCd("ADMIN");
        adminRole.setRoleNm("관리자");

        Role masterRole = new Role();
        masterRole.setRoleCd("MASTER");
        masterRole.setRoleNm("마스터");

        roleRepository.save(adminRole);
        roleRepository.save(masterRole);


        User hyunyunKim = new User();
        hyunyunKim.setUserId("zlagusdbs");
        hyunyunKim.setUserPwd(bCryptPasswordEncoder.encode("1111"));
        hyunyunKim.setUserNm("김현윤");

        User hwajungKim = new User();
        hwajungKim.setUserId("hhwaaaaa1");
        hwajungKim.setUserPwd(bCryptPasswordEncoder.encode("1111"));
        hwajungKim.setUserNm("기마정");

        userRepository.save(hyunyunKim);
        userRepository.save(hwajungKim);


        UserRole hyunyunKimUserRole = new UserRole();
        hyunyunKimUserRole.setUser(hyunyunKim);
        hyunyunKimUserRole.setRole(adminRole);

        UserRole hwajungKimUserRole = new UserRole();
        hwajungKimUserRole.setUser(hwajungKim);
        hwajungKimUserRole.setRole(masterRole);

        userRoleRepository.save(hyunyunKimUserRole);
        userRoleRepository.save(hwajungKimUserRole);
    }
}
