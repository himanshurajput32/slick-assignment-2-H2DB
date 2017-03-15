package com.example.tables

import com.example.connection.DBComponent
import com.example.models.Project

/**
  * Created by knoldus on 15/3/17.
  */
trait ProjectTable extends DBComponent with EmployeeTable{
  this: DBComponent =>

  import driver.api._

  class ProjectTable(tag: Tag) extends Table[Project](tag, "project") {
    val empid = column[Int]("id", O.PrimaryKey)

    val name = column[String]("name")

    def project = foreignKey("empid_fk", empid, employeeQuery)(_.id, onUpdate = ForeignKeyAction.Restrict)
    def * = (empid, name) <> (Project.tupled, Project.unapply)
  }

  val projectQuery = TableQuery[ProjectTable]
}
