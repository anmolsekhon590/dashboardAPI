package com.anmolsekhon.dashboardAPI.database;

import com.anmolsekhon.dashboardAPI.beans.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public List<Task> getAllTasks() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM TASKS";

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Task>(Task.class));
    }

    public void updateTask(Task task) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "UPDATE TASKS SET description=:description, isCompleted=:isCompleted WHERE taskId=:taskId";

        namedParameters.addValue("isCompleted", task.getIsCompleted())
                .addValue("description", task.getDescription())
                .addValue("taskId", task.getTaskId());

        jdbc.update(query, namedParameters);
    }

    public void addTask(Task task) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "INSERT INTO TASKS (description, isCompleted) VALUES (:description, :isCompleted)";

        namedParameters.addValue("description", task.getDescription());
        namedParameters.addValue("isCompleted", task.getIsCompleted());

        jdbc.update(query, namedParameters);
    }

}
