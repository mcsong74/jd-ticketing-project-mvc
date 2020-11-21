package com.cybertek.service;

import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;

import java.util.List;

public interface RoleService {
    RoleDTO save(RoleDTO role);
    RoleDTO findByUserID(Long id);
    List<RoleDTO> findAll();
    void delete(RoleDTO role);
    void deleteByUserId(Long id);
}
