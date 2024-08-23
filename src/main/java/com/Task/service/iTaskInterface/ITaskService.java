package com.Task.service.iTaskInterface;

import com.Task.entity.Task;
import com.Task.service.CRUD.Destroy;
import com.Task.service.CRUD.ReadAll;
import com.Task.service.CRUD.ReadById;
import com.Task.service.CRUD.Save;

public interface ITaskService extends
        Destroy<String>,
        Save<Task>,
        ReadById<Task,String>,
        ReadAll<Task>{}
