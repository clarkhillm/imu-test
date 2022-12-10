CREATE TABLE `dev_setting` (
    `id` CHAR(36) NOT NULL  ,
    `dev_id` VARCHAR(8) NULL DEFAULT NULL  ,
    `measurement` VARCHAR(8) NULL DEFAULT NULL  ,
    `position` CHAR(36) NULL DEFAULT ''  ,
    `wrist` CHAR(5) NULL DEFAULT 'LEFT' COMMENT 'LEFT,RIGHT'  ,
    `dt_created` DATETIME NULL DEFAULT NULL,
    `dt_updated` DATETIME NULL DEFAULT NULL,
    `description` VARCHAR(500) NULL DEFAULT ''  ,
    PRIMARY KEY (`id`) USING BTREE
)   ENGINE = InnoDB;

CREATE TABLE `position` (
    `id` CHAR(36) NOT NULL  ,
    `line_id` CHAR(36) NOT NULL  ,
    `name` VARCHAR(10) NOT NULL DEFAULT ''  ,
    `code` VARCHAR(50) NULL DEFAULT ''  ,
    `dt_created` DATETIME NULL DEFAULT NULL,
    `dt_updated` DATETIME NULL DEFAULT NULL,
    `comment` VARCHAR(200) NOT NULL DEFAULT ''  ,
    PRIMARY KEY (`id`) USING BTREE
)   ENGINE = InnoDB;

CREATE TABLE `position_setting` (
    `id` CHAR(36) NOT NULL  ,
    `position_id` CHAR(36) NOT NULL  ,
    `settings` VARCHAR(100) NOT NULL DEFAULT ''  ,
    PRIMARY KEY (`id`) USING BTREE
)   ENGINE = InnoDB;

CREATE TABLE `line` (
	`id` CHAR(36) NOT NULL COLLATE ,
	`name` VARCHAR(50) NOT NULL COLLATE ,
	PRIMARY KEY (`id`) USING BTREE
)
ENGINE=InnoDB
;