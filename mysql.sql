CREATE TABLE `dev_setting` (
    `id` CHAR(36) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `dev_id` VARCHAR(8) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `measurement` VARCHAR(8) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `zero_metric` DOUBLE NULL DEFAULT NULL,
    `positive_metric` DOUBLE NULL DEFAULT NULL,
    `negative_metric` DOUBLE NULL DEFAULT NULL
) COLLATE = 'utf8mb4_0900_ai_ci' ENGINE = InnoDB;

CREATE TABLE `dev_pair` (
    `id` CHAR(36) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `dev_left` CHAR(36) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `dev_right` CHAR(36) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `desc` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE
) COLLATE = 'utf8mb4_0900_ai_ci' ENGINE = InnoDB;