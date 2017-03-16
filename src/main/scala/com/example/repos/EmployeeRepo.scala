package com.example.repos

import com.example.connection.{DBComponent, H2DBComponent}
import com.example.models.{Employee, Project}
import com.example.tables.EmployeeTable

/**
  * Created by knoldus on 15/3/17.
  */
trait EmployeeRepo  extends EmployeeTable {
  this:DBComponent=>
  import driver.api._

  def create = db.run(employeeQuery.schema.create)

  def insert(emp: Employee) = db.run(employeeQuery returning employeeQuery.map(_.id) += emp)

  def delete(id: Int) = db.run {
    employeeQuery.filter(_.id === id).delete
  }

  def getAllEmployee = db.run {

    employeeQuery.to[List].result
  }

  def update(id: Int, name: String) = db.run {
    employeeQuery.filter(_.id === id).update(Employee(name,id))
  }

  def upsert(emp: Employee) = db.run{
    employeeQuery.insertOrUpdate(emp)
  }

}
object EmployeeRepo extends EmployeeRepo with H2DBComponent
