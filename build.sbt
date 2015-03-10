/* Defining general settings */

val languageVersion = "2.11.6"
val metaVersion = "0.1.0-SNAPSHOT"

scalaVersion := languageVersion

/* Defining general dependencies */

// Adding Sonatype snapshots for experimental tools (Obey, TQL) to resolvers.
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % languageVersion,
  "org.scala-lang" % "scala-compiler" % languageVersion,
  "org.scalameta" %% "scalameta" % metaVersion,
  "org.scalameta" %% "scalameta-foundation" % metaVersion,
  "org.scalameta" %% "interpreter" % metaVersion
)

scalacOptions += "-feature"

/* Defining projects */

/* Defining the root project. The only thing required is too specify that it 
 * depends on the rules project and must enable the obey plugin */
lazy val root = (project in file(".")).
  settings (
    name := "Test for obey",
    scalaVersion := languageVersion
  ) dependsOn(rules) enablePlugins(obeyplugin)

/* Define rules project - the rules will be built and automatically run on the
 * rest of the project */
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

