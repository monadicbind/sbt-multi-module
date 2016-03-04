lazy val commonSettings =  Seq(
  name := "sbt-multi-module",
  organization := "sathish.multi-module",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.7"
)

lazy val backend = Project(id = "backend",base=file("backend"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      "io.spray" %% "spray-json" % "1.3.2"
    )
  )

lazy val engine = Project(id = "engine",base=file("engine"))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-cluster" % "2.4.0",
      "com.typesafe.akka" %% "akka-cluster-sharding" % "2.4.0",
      "com.chuusai" %% "shapeless" % "2.2.5"
    )
  )

lazy val root = Project(id="root",base=file("."))
    .aggregate(backend, engine)