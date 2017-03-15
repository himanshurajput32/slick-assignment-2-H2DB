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
    val id = column[Int]("id", O.PrimaryKey)

    val name = column[String]("name")

    def * = (id, name) <> (Employee.tupled, Employee.unapply)
  }

  val employeeQuery = TableQuery[EmployeeTable]
}

trait EmployeeRepo  extends EmployeeTable {
this:DBComponent=>
import driver.api._

  def create = db.run(employeeQuery.schema.create)

  def insert(emp: Employee) = db.run(employeeQuery += emp)

  def delete(id: Int) = db.run {
    employeeQuery.filter(_.id === id).delete
  }

  def getAllEmployee = db.run {

    employeeQuery.to[List].result
  }

  def update(id: Int, name: String) = db.run {
    employeeQuery.filter(_.id === id).update(Employee(id, name))
  }

//  def upsert(emp:Employee)={
//   if(employeeQuery.filter(_.id===emp.id).map())
//  }

}
object EmployeeRepo extends EmployeeRepo with H2DBComponent
