## `com.nitrograph.lib(dotty.files)`
```scala
    for Dotty in Dotty
        yield lib(dotty ~: files)
```
## `lib(dotty.files).domain`
```scala
    for entity in lib(dotty.files).domain
        yield {
            _.(errors | inode)
        }
```

## `lib(dotty.files).dependencies.asGraph`
```mermaid
graph TD;
    classDef lib fill:#3fa,stroke:#fff,stroke-width:4px
    classDef error fill:#f34,stroke:#fff,stroke-width:4px
    classDef entity fill:#ff7,stroke:#fff,stroke-width:4px
    classDef method fill:#aaf,stroke:#fff,stroke-width:4px
    lib[com.nitrograph.dotty.files]; class lib lib;
        error[error]; class error error;
            lib --> error
                genericError[GenericError]; class genericError error;
                error --> genericError
        inode[inode]
            lib --> inode; class inode entity;
            path[path]; class path entity;
                inode --> path
                relativePath[RelativePath]; class relativePath entity;
                    path --> relativePath
                absolutePath[AbsolutePath]; class absolutePath entity;
                    path --> absolutePath
            directory[directory]; class directory entity;
                inode --> directory
                listable[listable]; class listable method;
                    directory --> listable
                list[list]; class list method;
                    directory --> list
            file[file]; class file entity;
                inode --> file
```

## `lib(dotty.files).dependencies.asStructuredText`
```scala
com.nitrograph {
    lib(dotty.files) {
        errors {
            GenericError
        }
        path {
            AbsolutePath {}
            RelativePath {}
        }
        inode {
            // file.write(File.Start)
            def write(
                from: FilePosition,
                to: FilePosition,
                what: (
                    Bytes | String | DottyINode
                )
            ): (
                Success | Failure
            )

            DottyDirectory {
                def list: DirectoryChildren
                def listable: Boolean
            }
            DottyFile {
                val readUtf8Text = Functor(
                )
            }
        }
    }
}
```
