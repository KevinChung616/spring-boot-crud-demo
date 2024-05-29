# Spring Boot 3 CRUD Application

## Description
This is a demo project of Spring Boot 3 realizing CRUD function.


## Tech Stack

+ Spring Boot 3
+ MySQL
+ Spring Data JPA


## Common Q&A

**Q: Database Naming Uppercase Issue?**

By default, Spring Data JPA (through Hibernate) uses a naming strategy that can indeed convert entity names and table names to lowercase, depending on the configured naming strategy. However, this behavior can be controlled and customized.

For example, following entity will convert to
```java
@Entity
public class ItemsToRegister implements Serializable{

@Id
@Column(name = "ID_ITEM_TO_REGISTER")
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
// ...
    
}
```

When inserting new record in database, the table name was translated in lowercase as : items_to_register.

Spring Boot uses Hibernate as the default JPA provider, and Hibernate applies its own naming strategies that can transform names into a certain case format unless explicitly told otherwise. The default naming strategies in Hibernate 5 are:

ImplicitNamingStrategy: Determines the default name for database objects when no explicit name is given.
PhysicalNamingStrategy: Translates the logical names to physical names.
Default Behavior
Implicit Naming: Converts camelCase to snake_case (e.g., Medicine to medicine).

---

If we need to use physical names, add following config in `application.properties`

```properties
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

```

reference: https://stackoverflow.com/questions/28571848/spring-boot-jpa-insert-in-table-with-uppercase-name-with-hibernate
