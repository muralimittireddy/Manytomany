package com.manytomany.relation.Service;

import com.manytomany.relation.Entities.User;
import com.manytomany.relation.Repositories.RoleRepository;
import com.manytomany.relation.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User createUser(User user) {
        // Save roles if they are new
        user.getRoles().forEach(role -> {
            if (!roleRepository.existsByRole(role.getRole())) {
                roleRepository.save(role);
            } else {
                role.setRoleid(roleRepository.findByRole(role.getRole()).getRoleid());
            }
        });

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUname(updatedUser.getUname());
            user.setPassword(updatedUser.getPassword());
            user.setRoles(updatedUser.getRoles());
            return userRepository.save(user);
        }).orElseGet(() -> {
            updatedUser.setUserid(id);
            return userRepository.save(updatedUser);
        });
    }
}

