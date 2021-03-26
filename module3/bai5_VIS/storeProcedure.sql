DELIMITER //

CREATE PROCEDURE findAllCustomers()

BEGIN

  SELECT * FROM customers;

END //

DELIMITER ;

call findAllCustomers();

DROP PROCEDURE IF EXISTS `findAllCustomers`;