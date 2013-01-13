This is SimpleDB 2.9 repackaged for CS422. The original package can be
downloaded from http://cs.bc.edu/~sciore/simpledb/intro.html.

The following changes are made:
. Removed all .class files.
. Moved /simpledb to /src/simpledb
. Removed the client code for Derby.
. Moved the SimpleDB client code to the simpledb.client package.
. Modified the following classes so the code can be compiled with JDK 1.7
  - simpledb.remote.ConnectionAdapter
  - simpledb.remote.DriverAdapter
  - simpledb.remote.ResultSetAdapter
  - simpledb.remote.StatementAdapter
. Modified the class simpledb.server.Startup so it starts its own RMI registry
  instead of relying on an external one.
. Added two Eclipse files .project and .classpath so the code can be imported
  directly into Eclipse.

csun@calstatela.edu, 5/13/2012
