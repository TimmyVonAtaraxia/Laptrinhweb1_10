package lamvandi.service;

import lamvandi.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User login(String email, String passwd);
    void save(User user);
}
