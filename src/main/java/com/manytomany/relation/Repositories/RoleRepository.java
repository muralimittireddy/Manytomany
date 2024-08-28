package com.manytomany.relation.Repositories;

import com.manytomany.relation.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
    boolean existsByRole(String role);
}
