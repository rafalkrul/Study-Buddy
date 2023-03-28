# Study-Buddy

## Technologie

- Java 17
- Spring Framework 2.7.4
- PostgreSql



## Jak Uruchomić
1. Zainstalować środowisko Javy oraz Dockera.
2. Pobrać repozytorium
    >https://github.com/rafalkrul/Study-Buddy.git
3. Stworzyć plik konfiguracyjny src/main/resources/application.properties
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.datasource.username=username
    spring.datasource.password=password
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jooq.sql-dialect=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.ddl-auto=update
    ```
4. cd Study-Buddy\docker && docker compose up -d
5. Otworzyć projekt z katalogu Study-Buddy w Intelij i uruchomić serwer
