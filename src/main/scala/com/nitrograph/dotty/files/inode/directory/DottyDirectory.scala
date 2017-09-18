package com.nitrograph.dotty.files.inode.directory

import com.nitrograph.dotty.files.inode._
import com.nitrograph.dotty.files.inode.path._
import java.nio.file.{Paths, Path}
import java.nio.file.{Files}
import scala.util.{Try, Failure}

case class DottyDirectory(override val path: INodePath)
    extends INode
{ directory =>
    require(
        directory.exists match {
            case exists: Boolean =>
                exists
            case _ =>
                false
        }
    )

    def exists: (Boolean | SecurityException) = {
        try {
            val path = directory.path.toJavaPath
            Files.exists(path) && Files.isDirectory(path)
        } catch {
            case exception: SecurityException =>
            exception
        }
    }

    def permission(kind: DirectoryPermissionKind): Boolean = {
        val path = directory.path.toJavaPath
        kind match {
            case DirectoryPermissionKind.Read =>
                Files.isReadable(path)
            case DirectoryPermissionKind.Write =>
                Files.isWritable(path)
            case DirectoryPermissionKind.List =>
                Files.isExecutable(path)
        }
    }
}
