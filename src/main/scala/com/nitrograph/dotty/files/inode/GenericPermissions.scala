package com.nitrograph.dotty.files.inode

trait GenericPermissions[T] {
    val owner: Option[T] = None
    val group: Option[T] = None
    val others: Option[T] = None
}
