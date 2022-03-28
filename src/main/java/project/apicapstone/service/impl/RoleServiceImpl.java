package project.apicapstone.service.impl;

import org.springframework.stereotype.Service;
import project.apicapstone.dto.role.CreateRoleDto;
import project.apicapstone.dto.role.UpdateRoleDto;
import project.apicapstone.entity.Role;
import project.apicapstone.repository.RoleRepository;
import project.apicapstone.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(CreateRoleDto dto) {
        Role newRole = new Role();
        newRole.setRoleId(dto.getRoleId());
        newRole.setRoleName(dto.getRoleName());
        newRole.setRoleDescription(dto.getRoleDescription());
        return roleRepository.save(newRole);
    }

    @Override
    public boolean isExisted(String id) {
        return roleRepository.existsById(id);
    }

    @Override
    public boolean isExistedRoleName(String s) {
        return roleRepository.countByRoleName(s) >= 1;
    }

    @Override
    public Role findRoleById(String id) {
        return roleRepository.getById(id);
    }

    @Override
    public List<Role> findRoleByNameOrId(String paramSearch) {
        return roleRepository.findRolesByNameOrId(paramSearch);
    }

    @Override
    public void deleteById(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void updateRole(UpdateRoleDto dto, String roleId) {
        Role role = roleRepository.getById(roleId);
        role.setRoleName(dto.getRoleName());
        role.setRoleDescription(dto.getRoleDescription());
        roleRepository.save(role);
    }


}
