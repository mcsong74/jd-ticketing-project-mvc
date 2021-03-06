package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.CrudService;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(Long id, TaskDTO object) {
        super.update(id, object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public TaskDTO save(TaskDTO object) {

        return super.save(object.getId(), object);
    }

    @Override
    public void updateByObj(TaskDTO object) {
        TaskDTO existingTask=findById(object.getId());
        object.setAssignedDate(existingTask.getAssignedDate());
        object.setStatus(existingTask.getStatus());
        object.setDetails(existingTask.getDetails());

        super.updateByObj(object.getId(), object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findTaskByManager(UserDTO manager) {
        return super.findAll().stream()
                .filter(t->t.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findTasksByEmployee(UserDTO employee) {
        return super.findAll().stream()
                .filter(t->t.getAssignedEmployee().equals(employee))
                .collect(Collectors.toList());
    }
}
