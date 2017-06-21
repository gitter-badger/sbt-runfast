name := """sbt-runfast"""
organization := "pl.tues"
version := "0.1-SNAPSHOT"

scalaVersion := "2.11.11"

sbtPlugin := true

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

bintrayPackageLabels := Seq("sbt","plugin")
bintrayVcsUrl := Some("""git@github.com:pl.tues/sbt-runfast.git""")

initialCommands in console := """import pl.tues.sbt.runfast._"""

// set up 'scripted; sbt plugin for testing sbt plugins
ScriptedPlugin.scriptedSettings
scriptedLaunchOpts ++=
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + version.value)
