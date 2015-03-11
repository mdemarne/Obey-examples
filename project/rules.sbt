val languageVersion = "2.11.6"
val metaVersion = "0.1.0-SNAPSHOT"

lazy val rules = (project in file("project/rules")).
  settings (
    name := "Custom rules",
    scalaVersion := languageVersion,
    resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    libraryDependencies ++= Seq(
      "com.github.mdemarne" % s"model_$languageVersion" % metaVersion,
      "com.github.mdemarne" % s"plugin_$languageVersion" % metaVersion
    )
  )

