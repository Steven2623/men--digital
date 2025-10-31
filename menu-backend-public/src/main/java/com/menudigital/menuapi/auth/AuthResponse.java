package com.menudigital.menuapi.auth;
import com.menudigital.menuapi.security.Role; import lombok.AllArgsConstructor; import lombok.Data; import java.util.UUID;
@Data @AllArgsConstructor public class AuthResponse { private String token; private UUID userId; private String username; private String fullName; private Role role; private UUID companyId; }
