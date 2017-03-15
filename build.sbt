name := """h2demo"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
//libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
// https://mvnrepository.com/artifact/org.scalatest/scalatest_2.11
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.1"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
  "org.postgresql" % "postgresql" % "9.4.1212",
  "mysql" % "mysql-connector-java" % "6.0.5"

)
// https://mvnrepository.com/artifact/org.scoverage/scalac-scoverage-plugin_2.11
libraryDependencies += "org.scoverage" % "scalac-scoverage-plugin_2.11" % "1.1.1"
// https://mvnrepository.com/artifact/com.h2database/h2
libraryDependencies += "com.h2database" % "h2" % "1.4.193"
// https://mvnrepository.com/artifact/com.google.inject/guice
libraryDependencies += "com.google.inject" % "guice" % "4.1.0"
