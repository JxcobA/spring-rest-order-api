
INSERT INTO jpa_order (quantity, price, status, order_email, date_created)
VALUES
    (2, 1500.00, true, 'john.doe@test.com', CURRENT_TIMESTAMP),

    (5, 7990.50, false, 'jane.smith@test.com', CURRENT_TIMESTAMP),

    (1, 2999.99, false, 'admin@test.com', CURRENT_TIMESTAMP);
