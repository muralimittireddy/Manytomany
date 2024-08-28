package com.manytomany.relation.Repositories;

import com.manytomany.relation.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
