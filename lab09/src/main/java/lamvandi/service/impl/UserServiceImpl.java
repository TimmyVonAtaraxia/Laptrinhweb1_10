package lamvandi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lamvandi.entity.User;
import lamvandi.repository.UserRepository;
import lamvandi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public User login(String email, String passwd) {
        // login thủ công (ít dùng nữa, thay bằng Spring Security + JWT)
        return repo.findByEmail(email)
                   .filter(u -> u.getPassword().equals(passwd))
                   .orElse(null);
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    // Quan trọng: dùng cho Spring Security
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repo.findByEmail(email)
                   .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }
}
