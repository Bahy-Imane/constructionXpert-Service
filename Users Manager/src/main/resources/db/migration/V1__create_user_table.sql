CREATE TABLE user (
                                    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    user_name VARCHAR(255) NOT NULL UNIQUE,
                                    email VARCHAR(255) NOT NULL UNIQUE,
                                    password VARCHAR(255) NOT NULL,
                                    role ENUM('ADMIN', 'USER') NOT NULL
);