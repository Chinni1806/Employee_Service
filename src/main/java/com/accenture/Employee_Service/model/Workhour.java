package com.accenture.Employee_Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workhour {
    private String empId;
    private int yearMonth;
    private int count;//no of leaves
}
