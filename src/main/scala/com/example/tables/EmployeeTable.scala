package com.example.tables

import com.example.connection.{DBComponent, H2DBComponent, PostgresDBComponent}
import com.example.models.Employee

/**
  * Created by knoldus on 15/3/17.
  */
trait EmployeeTable extends DBComponent {
this:DBComponent=>
  import driver.api._

  class EmployeeTable(tag: Tag) extends Table[Employee](tag, "employee") {
    val id = column[Int]("id", O.PrimaryKey,O.AutoInc)

    val name = column[String]("name")

    def * = (id, name) <> (Employee.tupled, Employee.unapply)
  }

  val employeeQuery = TableQuery[EmployeeTable]
}


