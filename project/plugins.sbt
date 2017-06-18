logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.10")

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.1" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")