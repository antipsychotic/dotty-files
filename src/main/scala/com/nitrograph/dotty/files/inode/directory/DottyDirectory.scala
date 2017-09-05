package com.nitrograph.dotty.files.inode.directory

import com.nitrograph.dotty.files.inode._

trait DottyDirectory {
    val name: String

    case class Permissions(
        read: Boolean,
        write: Boolean,
        list: Boolean
    )

    object Permissions
        extends GenericPermissions[
            DottyDirectory#Permissions
        ]
}
