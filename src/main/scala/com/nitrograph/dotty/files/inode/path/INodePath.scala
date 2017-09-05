package com.nitrograph.dotty.files.inode.path

sealed trait INodePath

case object Root extends INodePath
case object WorkDirectory extends INodePath

case class Path(
    root: INodePath,
    directories: List[String]
) extends INodePath
