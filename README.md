# Overivew 
This repository is **The first scenario of** a seriers of code templates(examples) to demonstrate how to use java Spring framework for data access (insert/update/delete/read) with Cassandra NoSQL database. This series contains the following scenarios:

**[Scenario 1]**:  Use ***Spring Boot*** and ***Spring Data for Cassandra (CassandraRepository)*** for basic CRUD operations (single-column primary key) on simple data types (text, int, etc.) through Rest APIs: https://github.com/yabinmeng/springbootcass-basic

For this scenario, there is NO special configuration for Cassandra such as user authentication or client-to-server SSL/TLS encyption, etc.

[Scnenario 2]: Use *Spring Boot* and *Spring Data for Cassandra* for more advanced CRUD operations (composite primary key) on more complex data types (UDTs, collections, blobs, etc.) through command line interface: https://github.com/yabinmeng/springbootcass-advanced 

For this scenario, user autentication is enabled for Cassandra.

[Scenario 3]: Use *Spring Boot* and *DataStax Enterprise Java Driver* to take full potentials of all advanced features as provided by the DataStax driver APIs that are not avaible through Spring Data for Cassandra (or at least in simple and straightforward way), such as flexible load balancing policy, retry policy, connection pooling, more robust object mapping, and a lot more: https://github.com/yabinmeng/springbootcass-dseent 

For this scenario, user authentication and client-to-server SSL/TLS encryption are both enabled for Cassandra.

---

Please **NOTE** that for all scenarios, 
1) DataStax Enterprise (DSE) version 5.1.11 is used as the Cassandra database.
2) Spring Boot version 2.1.o is used 

Among these scenarios, **Scenario 3 of using Spring Boot and DataStastx Enterprise Java Driver is the recommended approach**. The first 2 approaches, due to its usage with Spring Data for Cassandra, have some limititations that can't be easily addressed and may cause some issues (e.g. unnecessary tombstones) when interacting with Cassandra.

---

# More Notes

## Cassandra Schema

For this scenario, the following Cassandra keyspace and table are used (the keyspace replication strategy can be changed to whatever is needed), as defined in "schema.cql" file. 

## Cassandra Connetion and Rest API Port

As with many Spring Boot based applications, "application.propertities" file defins many Spring Boot application behavior related settings. For this scenario, it has the following properties:
* The first 3 propertities define how to connect to Cassandra
* The last property defines what is the Tomcat web server port for this application's Rest API.

```
spring.data.cassandra.keyspace-name = springbootcass
spring.data.cassandra.contact-points = 127.0.0.1
spring.data.cassandra.port = 9042
server.port=8088
```

## Rest API Definition

The following Rest APIs are defined in this scenario:

| Rest API Endpoint | Method | HTTP Payload | Description |
| --- | --- | --- | --- |
| /api/books | GET | None | Retrieve all saved books from Cassandra table |
| /api/book/{id} | GET | A long value (as book ID) | Retrieve a specific book from Cassandra table |
| /api/book | POST | A JSON document that defines a book | Insert a book into Cassandra table |
| /api/book/{id} | PUT | <ul> <li> A long value (as book ID) </li>  <li> A JSON document that defines a book </li> </ul> | Make an update to a book in Cassandra table |
| /api/book/{id} | DELETE | A long value (as book ID) | Delete a specific book from Cassandra table |
| /api/books | DELETE | None | Delete all books from Cassandra table |

### Testing Rest APIs with Postman

When starting to run this application (e.g. from the IntelliJ IDE), Spring Boot will start an embedded web server that listens on the port (8088) as configured in "application.properties" file. In order to test the Rest APIs, I'm using Postman (https://www.getpostman.com/). The screenshot below is an exmple of how to use Rest API to insert a book in Cassandra (pay attention to where the arrows point to, whcih defines Rest API endpoints, HTTP methods, payloads, and etc.).

<img src="https://github.com/yabinmeng/springbootcass-basic/blob/master/src/main/resources/rest_insert.png" width="800" height="300">
