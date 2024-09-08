CREATE TABLE resource
(
    resource_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    resource_name VARCHAR(255),
    resource_type VARCHAR(255),
    resource_quantity VARCHAR(255),
    resource_provider VARCHAR(255),
    task_id BIGINT NOT NULL

)
