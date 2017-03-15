package com.example.repos

import com.example.connection.{DBComponent, H2DBComponent}
import com.example.models.Project
import com.example.tables.ProjectTable

/**
  * Created by knoldus on 15/3/17.
  */
trait ProjectRepo extends ProjectTable {
  this: DBComponent =>

  import driver.api._

  def create = db.run(projectQuery.schema.create)

  def insert(project: Project) = db.run {
    projectQuery += project
  }

  def delete(id: Int) = db.run {
    projectQuery.filter(_.empid === id).delete
  }

  def update(id: Int, name: String) = db.run {
    projectQuery.filter(_.empid === id).update(Project(id, name))
  }

  def upsert(project: Project) = {
    val v = projectQuery.filter(_.empid === project.empId).to[List].result
    if (v == Nil) {
      insert(project)
    }
    else {
      update(project.empId, project.name)
    }
  }

  def innerJoinExample = {
    val result = for {
      (e, p) <- employeeQuery join projectQuery on (_.id === _.empid)
    } yield (e.name, p.name)
    db.run(result.to[List].result)
  }

  def rightJoinExample = {
    val result = for {
      (e, p) <- employeeQuery joinRight projectQuery on (_.id === _.empid)
    } yield (e.map(_.name), p.name)
    db.run(result.to[List].result)
  }
  def leftJoinExample = {
    val result = for {
      (e, p) <- employeeQuery joinLeft projectQuery on (_.id === _.empid)
    } yield (e.name, p.map(_.name))
    db.run(result.to[List].result)
  }


}

object ProjectRepo extends ProjectRepo with H2DBComponent
