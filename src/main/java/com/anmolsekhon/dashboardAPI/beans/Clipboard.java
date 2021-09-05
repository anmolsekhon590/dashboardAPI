package com.anmolsekhon.dashboardAPI.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clipboard implements Serializable {
    private Long id;
    private String text;
}
