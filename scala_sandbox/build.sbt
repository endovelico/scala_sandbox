ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "nfl-player-service",
    libraryDependencies ++= Seq(
      "org.springframework.boot" % "spring-boot-starter-web" % "3.2.5",
      "org.springframework.boot" % "spring-boot-starter-test" % "3.2.5" % Test
    )
  )