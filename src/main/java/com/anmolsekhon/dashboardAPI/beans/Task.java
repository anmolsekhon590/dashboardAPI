package com.anmolsekhon.dashboardAPI.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {

    private Long taskId;
    private String description;
    private Boolean isCompleted;
}
