USE rp_database;

CREATE TABLE IF NOT EXISTS Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    account_type ENUM('admin', 'regular') NOT NULL DEFAULT 'regular',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
    shop_name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(20),
    etransfer_email VARCHAR(255),
    shop_owner_name VARCHAR(255),
    labour_rate FLOAT,
    bestauto_part_supplier VARCHAR(255)
);
