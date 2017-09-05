val dottyBook = (
    project in file(".")
).settings(
    scalaVersion := "0.3.0-RC1",
    name := "DottyFiles",
    version := "0.0.0",
    organization := "com.nitrograph",
    mainClass := Some("com.nitrograph.dotty.files.Files"),
    fork in Compile := true
)
