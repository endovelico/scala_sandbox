ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "scala_sandbox",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % "2.8.0",
      "com.typesafe.akka" %% "akka-stream" % "2.8.0",
      "org.springframework.boot" % "spring-boot-starter-web" % "3.2.5",
      "org.springframework.boot" % "spring-boot-starter-test" % "3.2.5" % Test,
      "org.junit.jupiter" % "junit-jupiter-api" % "5.10.0" % Test,
      "org.junit.jupiter" % "junit-jupiter-engine" % "5.10.0" % Test
    )
  )