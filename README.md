# General Overivew 
This repository is **the first of** a seriers of code template(example) to demonstrate how to use java Spring framework for data access (insert/update/delete/read) with Cassandra NoSQL database. This series contains the following scenarios:
1. Use ***Spring Boot*** and ***Spring Data for Cassandra*** for basic CRUD operations (single-column primary key) on simple data types (text, int, etc.) through Rest APIs. 

   For this scenario, there is NO special configuration for Cassandra such as user authentication or client-to-server SSL/TLS encyption, etc.

2. Use ***Spring Boot*** and ***Spring Data for Cassandra*** for more advanced CRUD operations (composite primary key) on more complex data types (UDTs, collections, blobs, etc.) through command line interface. 

   For this scenario, user autentication is enabled for Cassandra.

3. Use ***Spring Boot*** and ***DataStax Enterprise Java Driver*** to take full potentials of all advanced features as provided by the DataStax driver APIs that are not avaible through Spring Data for Cassandra (or at least in simple and straightforward way), such as flexible load balancing policy, retry policy, connection pooling, more robust object mapping, and a lot more. 

   For this scenario, user authentication and client-to-server SSL/TLS encryption are both enabled for Cassandra.
---

For 
