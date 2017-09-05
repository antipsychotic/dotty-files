package com.nitrograph.dotty.files.inode.file

import com.nitrograph.dotty.files.inode._

trait DottyFile {
    val name: String

    case class Permissions(
        read: Boolean,
        write: Boolean,
        execute: Boolean
    )

    object Permissions
        extends GenericPermissions[
            DottyFile#Permissions
        ]
}
