package com.menudigital.menuapi.config;

import com.menudigital.menuapi.menu.domain.Company;
import com.menudigital.menuapi.menu.repo.CompanyRepository;
import com.menudigital.menuapi.security.Role;
import com.menudigital.menuapi.security.UserEntity;
import com.menudigital.menuapi.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner seed(CompanyRepository cr, UserRepository ur) {
        return args -> {
            if (cr.count() == 0) {
                var c = Company.builder()
                        .taxId("0614-123456-001-9")
                        .businessName("Mi Restaurante, S.A. de C.V.")
                        .commercialName("Mi Restaurante")
                        .email1("info@resto.test")
                        .phone("+503 2222-2222")
                        .logoUrl(null)
                        .build();

                c = cr.save(c);

                if (ur.findByUsername("admin").isEmpty()) {
                    var admin = UserEntity.builder()
                            .username("admin")
                            .passwordHash(encoder.encode("admin123"))
                            .fullName("Administrador")
                            .role(Role.ADMIN)
                            .company(c)
                            .active(true)
                            .build();

                    ur.save(admin);
                }
            }
        };
    }
}
