package com.menudigital.menuapi.security;
import com.menudigital.menuapi.menu.domain.Company;
import jakarta.persistence.*; import lombok.*; import org.hibernate.annotations.CreationTimestamp; import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant; import java.util.UUID;
@Entity @Table(name="app_user") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserEntity {
  @Id @GeneratedValue(strategy=GenerationType.UUID) private UUID id;
  @Column(nullable=false,unique=true,length=60) private String username;
  @Column(nullable=false) private String passwordHash;
  @Column(nullable=false,length=120) private String fullName;
  @Enumerated(EnumType.STRING) @Column(nullable=false,length=10) private Role role;
  @ManyToOne(optional=false) private Company company;
  @Column(nullable=false) private boolean active=true;
  @CreationTimestamp private Instant createdAt; @UpdateTimestamp private Instant updatedAt;
}
