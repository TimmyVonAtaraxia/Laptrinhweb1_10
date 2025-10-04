package vohuutinn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import vohuutinn.config.JwtUtil;
import vohuutinn.entity.User;
import vohuutinn.repository.UserRepository;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    // 🔑 LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String passwd) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, passwd)
            );

            User user = (User) authentication.getPrincipal(); // entity implements UserDetails

            // cập nhật last_login
            user.setLast_login(new Date());
            userRepository.save(user);

            String token = jwtUtil.generateToken(user);

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "email", user.getEmail(),
                    "role", user.isAdmin() ? "ADMIN" : "USER"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", "Sai email hoặc mật khẩu!"));
        }
    }

    // 📝 REGISTER API
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String fullname,
                                      @RequestParam String email,
                                      @RequestParam String passwd) {
        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email đã tồn tại!"));
        }

        User newUser = new User();
        newUser.setFullname(fullname);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(passwd));
        newUser.setAdmin(false); // user thường
        newUser.setSignup_date(new Date());

        userRepository.save(newUser);

        return ResponseEntity.ok(Map.of("message", "Đăng ký thành công!"));
    }

    // 👑 CREATE ADMIN API
    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdmin(@RequestParam String fullname,
                                         @RequestParam String email,
                                         @RequestParam String passwd) {
        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.badRequest().body(Map.of("error", "Admin đã tồn tại!"));
        }

        User adminUser = new User();
        adminUser.setFullname(fullname);
        adminUser.setEmail(email);
        adminUser.setPassword(passwordEncoder.encode(passwd));
        adminUser.setAdmin(true); // admin
        adminUser.setSignup_date(new Date());

        userRepository.save(adminUser);

        return ResponseEntity.ok(Map.of("message", "Tạo admin thành công!", "email", email));
    }
}
