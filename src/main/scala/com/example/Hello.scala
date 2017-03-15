package com.example

import com.example.models.Employee
import com.example.tables.EmployeeRepo

object Hello extends App{


    EmployeeRepo.insert(Employee(6,"eeeee"))
}
