package com.nitrograph.dotty.files.inode.path

import java.nio.file.{Paths, Path}

sealed trait INodePathTrait {
    def toJavaPath: Path
}

case object Root extends INodePathTrait {
    def toJavaPath: Path = Paths.get("/")
}

case object WorkDirectory extends INodePathTrait {
    def toJavaPath: Path = Paths.get(".")
}

case class INodePath(
    root: INodePath,
    directories: List[String]
) extends INodePathTrait {
    def toJavaPath: Path = root.toJavaPath.resolve(
        directories.mkString("/")
    )
}
