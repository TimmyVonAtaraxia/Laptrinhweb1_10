package vohuutinn.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import vohuutinn.entity.User;

public interface UserService extends UserDetailsService {
    User login(String email, String passwd);
    void save(User user);
}
