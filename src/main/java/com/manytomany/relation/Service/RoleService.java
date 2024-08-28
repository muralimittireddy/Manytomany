package com.manytomany.relation.Service;
import com.manytomany.relation.Entities.Role;
import com.manytomany.relation.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(Long id, Role updatedRole) {
        return roleRepository.findById(id).map(role -> {
            role.setRole(updatedRole.getRole());
            return roleRepository.save(role);
        }).orElseGet(() -> {
            updatedRole.setRoleid(id);
            return roleRepository.save(updatedRole);
        });
    }
}
