package com.menudigital.menuapi.auth;
import com.menudigital.menuapi.common.ApiResponse; import com.menudigital.menuapi.security.JwtService; import com.menudigital.menuapi.security.UserRepository;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity; import org.springframework.security.authentication.*; import org.springframework.security.core.userdetails.UserDetailsService; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor
public class AuthController {
  private final AuthenticationManager am; private final UserDetailsService uds; private final JwtService jwt; private final UserRepository ur;
  @PostMapping("/login") public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody AuthRequest req){
    am.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword()));
    var ud=uds.loadUserByUsername(req.getUsername()); var token=jwt.generateToken(ud); var u=ur.findByUsername(req.getUsername()).orElseThrow();
    return ResponseEntity.ok(ApiResponse.ok(new AuthResponse(token,u.getId(),u.getUsername(),u.getFullName(),u.getRole(),u.getCompany().getId())));
  }
}
