# TriviaClash
A trivia quiz game client written in Java that uses opentdb.com API.
Currently, this game can be ran on any machine having jdk-17 installed.

## Instructions on building and running this game.
* Make sure to install `git` and `Java Develpoment Kit 17 ( jdk17)` on your machine.
* navigate to the directory where you want to save the project.
* Run these commands.
```bash
git clone https://github.com/narasimha00/TriviaClash.git
cd TriviaClash/
```
* Now there is already a script file `build.sh` in root project directory, which can be ran to build the project automatically ON LINUX MACHINES. But, you may need to follow the steps in the script manually for any other OS like windows, etc...
* After building the project, the script file also automatically copies the final jar file `app-all.jar` from `app/build/lib/` to `out/`.
* Now, just run the jar file using the following command while in root project directory.
```bash
java -jar out/jar/TriviaClash.jar
```
