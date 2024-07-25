package crm.service;

import crm.model.Role;
import crm.repository.RoleRepository;

import java.util.List;

public class RoleService {
    private RoleRepository roleRepository = new RoleRepository();
    public List<Role> getRoles() {
        return roleRepository.getRoles();
    }
}
