addSbtPlugin("com.codecommit" % "sbt-spiewak" % "0.21.0")
addSbtPlugin("com.codecommit" % "sbt-spiewak-sonatype" % "0.21.0")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.10.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.3")

addSbtPlugin("com.thesamet" % "sbt-protoc-gen-project" % "0.1.7")
libraryDependencies += "com.thesamet.scalapb" %% "compilerplugin" % "0.11.3"
