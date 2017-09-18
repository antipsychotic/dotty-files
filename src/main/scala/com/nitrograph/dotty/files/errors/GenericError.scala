package com.nitrograph.dotty.errors

sealed trait GenericError
    extends Exception

object GenericError {
    case object NotDefined
        extends GenericError
}
