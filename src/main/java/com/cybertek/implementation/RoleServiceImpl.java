package com.cybertek.implementation;

import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.RoleService;
import com.cybertek.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService {
    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(Long id, RoleDTO object) {
        super.update(id, object);
    }

    @Override
    public RoleDTO findById(Long userId) {
        return super.findById(userId);
    }

    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(RoleDTO object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long userId) {
        super.deleteById(userId);
    }
}
