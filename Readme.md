# FSI Fund Processing Demo

In this demo, we look at some common scenarios that may arise at a FSI based customer although it's generic
enough that it could be demo'd for a broad audience too. The domain is loosely based around an event that
generates a new Fund that then needs to be broadcasted to a set of interested consumers where each can handle
the event separately.

There are three modules that make up this demo, each which can be deployed and demoed separately, but together
can make for a full-blown Fabric8/JBoss Fuse demo.

See the Readme.md for each module for more information, but at a very high level:

* _file-listener_ -- a microservice that monitors a file system for files. when a file is detected and its contents placed on a publish-subscribe JMS destination (topic)
* _fund-persister_ -- a microservce that consumers from a topic that represents a new fund being generated. this service is responsible for storing the Fund to a database
* _fund-processor_ -- a microservice that consumes from a topic that represents a new fund being generated. this service
transforms the data and stores to a different file location.

Please see the [Demo WriteUp](docs/index.md) for the steps to recreate.