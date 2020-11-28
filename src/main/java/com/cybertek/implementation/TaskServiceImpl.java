package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.service.CrudService;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, String> implements TaskService {

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(String taskId, TaskDTO object) {
        super.update(taskId, object);
    }

    @Override
    public void deleteById(String taskId) {
        super.deleteById(taskId);
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getTaskId(), object);
    }

    @Override
    public void updateByObj(TaskDTO object) {
        super.updateByObj(object.getTaskId(), object);
    }

    @Override
    public TaskDTO findById(String taskId) {
        return super.findById(taskId);
    }
}
