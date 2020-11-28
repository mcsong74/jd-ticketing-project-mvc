package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.dto.TaskDTO;
import com.cybertek.service.CrudService;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, ProjectDTO> implements TaskService {

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO project, TaskDTO object) {
        super.update(project, object);
    }

    @Override
    public void deleteById(ProjectDTO project) {
        super.deleteById(project);
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getProject(), object);
    }

    @Override
    public void updateByObj(TaskDTO object) {
        updateByObj(object.getProject(), object);
    }

    @Override
    public TaskDTO findById(ProjectDTO project) {
        return findById(project);
    }
}
