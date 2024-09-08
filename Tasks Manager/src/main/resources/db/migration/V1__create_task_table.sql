# CREATE TABLE task
# (
#     task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
#     task_title VARCHAR(255),
#     task_description VARCHAR(255),
#     task_status VARCHAR(255),
#     project_id BIGINT NOT NULL
# );

CREATE TABLE Task (
                      task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      task_title VARCHAR(255) NOT NULL,
                      task_description TEXT,
                      task_status VARCHAR(50),
                      project_id BIGINT
);
