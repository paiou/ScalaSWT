name := "SWT_DSL"

version := "1.0.0"

scalaVersion := "2.10.1"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

resolvers += "Eclipse Repository" at "http://maven.eclipse.org/nexus/content/repositories/testing/"
 
libraryDependencies += {
  val os = (sys.props("os.name"), sys.props("os.arch")) match {
    case ("Linux", "amd64") => "gtk.linux.x86_64"
    case ("Linux", _) => "gtk.linux.x86"
    case ("Mac OS X", "amd64" | "x86_64") => "cocoa.macosx.x86_64"
    case ("Mac OS X", _) => "cocoa.macosx.x86"
    case (os, "amd64") if os.startsWith("Windows") => "win32.win32.x86_64"
    case (os, _) if os.startsWith("Windows") => "win32.win32.x86"
    case (os, arch) => sys.error("Cannot obtain lib for OS '" + os + "' and architecture '" + arch + "'")
  }
  val artifact = "org.eclipse.swt." + os
  "org.eclipse.swt" % artifact % "3.6.2"
}

libraryDependencies += "org.eclipse.core" % "org.eclipse.core.databinding" % "1.3.100"

libraryDependencies += "org.eclipse.core" % "org.eclipse.core.runtime" % "3.6.0"

libraryDependencies += "org.eclipse.core" % "org.eclipse.core.databinding.beans" % "1.2.100"

libraryDependencies += "com.ibm.icu" % "com.ibm.icu" % "4.2.1"

libraryDependencies += "org.eclipse.core" % "org.eclipse.core.databinding.property" % "1.3.0"

libraryDependencies += "org.eclipse.jface" % "org.eclipse.jface.databinding" % "1.4.0"

osgiSettings

OsgiKeys.exportPackage := Seq(".", "org.consultar.scala.swtdsl")

OsgiKeys.requireBundle := Seq("org.eclipse.core.databinding;bundle-version=\"1.3.100\"",
  "org.eclipse.core.runtime;bundle-version=\"3.6.0\"",
  "org.eclipse.core.databinding.beans;bundle-version=\"1.2.100\"",
  "com.ibm.icu;bundle-version=\"4.2.1\"",
  "org.eclipse.core.databinding.property;bundle-version=\"1.3.0\"",
  "org.eclipse.swt;bundle-version=\"3.6.2\"",
  "org.eclipse.jface.databinding;bundle-version=\"1.4.0\"")
