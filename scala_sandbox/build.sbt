ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "scala_sandbox",
    libraryDependencies ++= Seq(
      // Spring Boot dependencies
      "org.springframework.boot" % "spring-boot-starter-web" % "3.2.5",
      "org.springframework.boot" % "spring-boot-starter-test" % "3.2.5" % Test,

      // Explicit JUnit Jupiter dependencies
      "org.junit.jupiter" % "junit-jupiter-api" % "5.10.0" % Test,
      "org.junit.jupiter" % "junit-jupiter-engine" % "5.10.0" % Test
    )
  )