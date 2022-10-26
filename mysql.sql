CREATE TABLE `dev_setting` (
    `id` CHAR(36) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `dev_id` VARCHAR(8) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `measurement` VARCHAR(8) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `position` CHAR(36) NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
    `wrist` CHAR(5) NULL DEFAULT 'LEFT' COMMENT 'LEFT,RIGHT' COLLATE 'utf8mb4_0900_ai_ci',
    `dt_created` DATETIME NULL DEFAULT NULL,
    `dt_updated` DATETIME NULL DEFAULT NULL,
    `description` VARCHAR(500) NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE
) COLLATE = 'utf8mb4_0900_ai_ci' ENGINE = InnoDB;

CREATE TABLE `position` (
	`id` CHAR(36) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`name` VARCHAR(10) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`code` VARCHAR(50) NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`dt_created` DATETIME NULL DEFAULT NULL,
	`dt_updated` DATETIME NULL DEFAULT NULL,
	`comment` VARCHAR(200) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
