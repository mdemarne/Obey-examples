resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

val sv = "2.11.6"

lazy val root = (project in file(".")).
  settings (
    name := "Tests for Obey",
    scalaVersion := sv,
    ObeyPlugin.obeyRules := "+ {Scala*} - {Completeness*} - {Mine*} - {Dotty*}",
    libraryDependencies += "com.github.mdemarne" % s"obey-rules_$sv"  % "0.1.0-SNAPSHOT"
  ) dependsOn(rules) enablePlugins(ObeyPlugin)
