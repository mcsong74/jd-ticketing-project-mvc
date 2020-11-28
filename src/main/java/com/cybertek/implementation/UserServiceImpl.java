package com.cybertek.implementation;

import com.cybertek.dto.UserDTO;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {


    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(String id, UserDTO object) {
        super.update(id, object);
    }

    @Override
    public void updateByObj(UserDTO object) {
        super.updateByObj(object.getUserName(), object);
    }

    @Override
    public void deleteById(String userId) {
        super.deleteById(userId);
    }

    @Override
    public void delete(UserDTO object) {
        super.delete(object);
    }

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public UserDTO findById(String userId) {
        return super.findById(userId);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream()
                .filter(user->user.getRole().getDescription().equals("Manager"))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return super.findAll().stream()
                .filter(user -> user.getRole().getDescription().equals("Employee"))
                .collect(Collectors.toList());
    }
}
