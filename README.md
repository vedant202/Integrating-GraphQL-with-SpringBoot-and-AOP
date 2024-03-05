# Build API with GraphQL

GraphQL is a query language for your API, and a server-side runtime for executing queries using a type system you define for your data. GraphQL isn't tied to any specific database or storage engine and is instead backed by your existing code and data.

A GraphQL service is created by defining types and fields on those types, then providing functions for each field on each type. For example, a GraphQL service that tells you who the logged in user is (`me`) as well as that user's name might look like this:

type Query {

  me:  User

}

type User {

  id:  ID

  name:  String

}

## **Setting up the Service**
All we need for this to work is the correct dependencies:

    <dependency>  <groupId>org.springframework.boot</groupId>  <artifactId>spring-boot-starter-graphql</artifactId>  </dependency>  <dependency>  <groupId>org.springframework.boot</groupId>  <artifactId>spring-boot-starter-web</artifactId>  </dependency>

##  **Writing the Schema**
The GraphQL Boot starter works by processing GraphQL Schema files to build the correct structure and then wires special beans to this structure.  **The Spring Boot GraphQL starter automatically finds these schema files**.

We need to save these “_.graphqls_” or “_.gqls_” schema files under  _src/main/resources/graphql/**_  location, and Spring Boot will pick them up automatically. As usual, we can customize the locations with  _spring.graphql.schema.locations_  and the file extensions with  _spring.graphql.schema.file-extensions_  config properties.


##  **Root Query Resolver**
**The root query needs to have specially annotated methods to handle the various fields in this root query**.

##  How to Implement AOP in Spring Boot Application?

AOP(Aspect Oriented Programming) breaks the full program into different smaller units. In numerous situations, we need to log, and audit the details as well as need to pay importance to declarative transactions, security, caching, etc., Let us see the key terminologies of AOP

1.  **Aspect:** It has a set of APIs for cross-cutting requirements. Logging module is an example of the AOP aspect of logging.
2.  **Joint Point:** AOP aspect plug in place
3.  **Advice:** Via this, the actual implementation of code is taken care for the AOP approach. It can be either before/after/after returning/after throwing. In this article let us see the examples related to this.
4.  **Pointcut:** Set of one or more join points where an advice need to be executed.
5.  **Introduction:** This is the place where we can add new methods or attributes to the existing classes.
6.  **Target Object:** One or more aspects will be there to provide advice for the target object.
7.  **Weaving:** Linking aspects with other application types or objects. It can be done at compile-time/runtime/loadtime.


