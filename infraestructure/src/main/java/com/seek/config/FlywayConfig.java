package com.seek.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FlywayConfig {

  /*
   Existe otro metodo de configuracion el cual costa de un comando a ejecutarse al momento de iniciar la migracion de
   la base de datos ejemp: mvn flyway:migrate.
   Para esto se debe configurar plugins en la seccion de maven.
   Ref: https://medium.com/hprog99/set-up-flyway-with-spring-boot-1b24b8abe56e
  }*/

  @Bean
  public FlywayMigrationStrategy flywayMigrationStrategy() {
    return Flyway::migrate;
  }

}
