USE `world`;
DROP procedure IF EXISTS `getRecord`;

DELIMITER $$
USE `world`$$
CREATE PROCEDURE `world`.`getRecord` (
IN in_id INTEGER,
OUT out_name VARCHAR(20),
OUT out_author  VARCHAR(20))
BEGIN
   SELECT name, author
   INTO out_name, out_author
   FROM book where id = in_id;
END ;$$

DELIMITER ;

