package com.example.connection

import java.util.UUID

import slick.jdbc.{H2Profile, JdbcProfile, MySQLProfile, PostgresProfile}

/**
  * Created by knoldus on 15/3/17.
  */
trait DBComponent {
  val driver: JdbcProfile

  import driver.api._

  val db: Database
}

trait PostgresDBComponent extends DBComponent {
  val driver = PostgresProfile

  import driver.api._

  val db = Database.forConfig("myPostgresDB")
}

trait MySqlDBComponent extends DBComponent {
  val driver: JdbcProfile = MySQLProfile

  import driver.api._

  val db = Database.forConfig("mySqlDB")

}

trait H2DBComponent extends DBComponent {
  val driver: JdbcProfile = H2Profile

  import driver.api._

  val randomDB = "jdbc:h2:mem:test" +
    UUID.randomUUID().toString + ";"
  val h2Url = randomDB + "MODE=MySql;DATABASE_TO_UPPER=false;INIT=RUNSCRIPT FROM 'src/test/resources/schema.sql'\\;RUNSCRIPT FROM 'src/test/resources/initialdata.sql'"
  println(s"\n\n~~~~~~~~~~~~~~~~~~~~~             $h2Url         ~~~~~~~~~~~~~~~~~~~~~~~\n\n")
  val db: Database = Database.forURL(url = h2Url, driver = "org.h2.Driver")
}

