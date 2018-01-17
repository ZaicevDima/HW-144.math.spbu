import qbs

Project {
    minimumQbsVersion: "1.7.1"

    CppApplication {
        consoleApplication: true
        files: [
            "main.cpp",
            "stringsort.cpp",
            "stringsort.h",
        ]

        Group {     // Properties for the produced executable
            fileTagsFilter: product.type
            qbs.install: true
        }
    }
}
