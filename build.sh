#!/bin/sh

DIRS_PATH='out/jar/'
JAR_FILE_OUTPUT_PATH='app/build/libs/'

# Make a directory to store jar file
create_dirs() {
    if [ ! -d "$DIRS_PATH" ]; then 
        echo " Creating dirs at $DIRS_PATH ..."
        return $(mkdir -p "$DIRS_PATH"; echo $?)
    else 
        return 0
    fi
}


# Build the jar file 
build_jar() {
    echo ""
    echo " Generating the .jar file at $JAR_FILE_OUTPUT_PATH ..."
    ./gradlew assemble "$@"
    return $(echo $?)
}

# Copy the jar file to the created folder
copy_jar() {
    echo ""
    echo " Copying the jar file to $DIRS_PATH ..."
    return $(cp "$JAR_FILE_OUTPUT_PATH/app.jar" "$DIRS_PATH/TriviaClash.jar"; echo $?)
}

create_dirs && build_jar && copy_jar

echo ""
if [ ! $(echo $?) ]; then
    echo " Jar couldn't be generated !! "
else
    echo " The jar file can be found in $DIRS_PATH "
fi
