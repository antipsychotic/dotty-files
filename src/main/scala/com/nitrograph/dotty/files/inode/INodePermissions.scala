package com.nitrograph.dotty.files.inode

import scala.collection.immutable.Map
import com.nitrograph.dotty.files.inode.path._

trait INode {
    val path: INodePath
}

sealed trait PermissionKind

enum class DirectoryPermissionKind extends PermissionKind

object DirectoryPermissionKind {
    case Read extends DirectoryPermissionKind
    case Write extends DirectoryPermissionKind
    case List extends DirectoryPermissionKind
}

enum class FilePermissionKind extends PermissionKind

object FilePermissionKind {
    case Read extends FilePermissionKind
    case Write extends FilePermissionKind
    case Execute extends FilePermissionKind
}