
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

lazy val root = (project in file(".")).
  settings (
    name := "Tests for Obey",
    scalaVersion := "2.11.6"
  ) enablePlugins(obeyplugin)

