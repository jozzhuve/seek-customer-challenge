CREATE TABLE `customer`
(
    `id`                int NOT NULL AUTO_INCREMENT,
    `nombre`            varchar(255) DEFAULT NULL,
    `apellido`          varchar(255) DEFAULT NULL,
    `edad`              int(11) DEFAULT NULL,
    `fecha_nacimiento`  datetime(6) DEFAULT NULL,
    `user_creation`     varchar(255) DEFAULT NULL,
    `creation_date`     datetime(6) DEFAULT NULL,
    `user_update`       varchar(255) DEFAULT NULL,
    `update_date`       datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
)
