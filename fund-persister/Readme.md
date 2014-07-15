# Fund Persister

A Fund persister listens to a stream of events for new funds created and then stores them to a relational database.

## Build with maven

You can build this project with maven:
    
    mvn clean install
    
## Deploy to Fabric8/JBoss Fuse
    
    mvn fabric8:deploy
    
See this documentation for more on the maven plugin: http://fabric8.io/gitbook/mavenPlugin.html


## How to use in JBoss Fuse: