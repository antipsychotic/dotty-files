package com.nitrograph.dotty.files.inode.file

import com.nitrograph.dotty.files.inode._
import com.nitrograph.dotty.files.inode.path._
import scala.util.{Try, Success, Failure}
import com.nitrograph.dotty.errors._
import java.nio.file.{Paths, Path}
import java.nio.file.{Files}

case class DottyFile(override val path: INodePath)
    extends INode
{ file =>
    require(file.exists)

    def exists: Boolean = {
        val path = file.path.toJavaPath
        Files.exists(path) && Files.isRegularFile(path)
    }

    def permission(kind: FilePermissionKind): Boolean = {
        val path = file.path.toJavaPath
        kind match {
            case FilePermissionKind.Read =>
                Files.isReadable(path)
            case FilePermissionKind.Write =>
                Files.isWritable(path)
            case FilePermissionKind.Execute =>
                Files.isExecutable(path)
        }
    }
}
