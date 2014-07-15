# Fictional FSI-domain Demo

### Build

    mvn clean install
    
### Run locally

Each module can be run separately with separate terminal windows with:

    mvn camel:run

### Running Derby as an external DB:
By default, the local, standalone version uses Apache Derby.  You can download Apache Derby
and start the remote network listener with the following command:

    > $DERBY_HOME/bin/startNetworkServer -h localhost -p 1527 &

Then you can use the derby _ij_ command promopt to interact with the server and install the required tables.
The DB location must match that in the JDBC URI that's specified in _SqlMapConfig.xml_ 

So for example, on my machine, the filter-local.properties file looks like this:

    jdbc-driver=org.apache.derby.jdbc.ClientDriver
    jdbc-url=jdbc:derby://localhost:1527//Users/ceposta/dev/poc/fsi/workspace/fsi-poc/target/opp.db
    jdbc-username=app
    jdbc-password=app

So then the commands to run at the Derby ij console are:

    > $DERBY_HOME/bin/ij

    ij> connect 'jdbc:derby://localhost:1527//Users/ceposta/dev/poc/fsi/workspace/fsi-poc/target/opp.db;create=true';
    ij> run '/Users/ceposta/dev/poc/fsi/workspace/fsi-poc/fund-persister/src/main/resources/sql/tables.sql';
    ij> exit;
