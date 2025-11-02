package com.menudigital.menuapi.auth;
import com.menudigital.menuapi.security.Role; import lombok.AllArgsConstructor; import lombok.Data; import java.util.UUID;
@Data @AllArgsConstructor public class AuthResponse { private String token; private UUID userId; private String email; private Role id_rol; private UUID companyId; }
