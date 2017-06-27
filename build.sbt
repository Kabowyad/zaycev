name := "serviceZaycev"

version := "1.0"

lazy val `servicezaycev` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq( jdbc , cache , ws  , anorm  )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

