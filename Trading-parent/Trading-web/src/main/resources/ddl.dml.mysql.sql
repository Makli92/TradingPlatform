CREATE DATABASE accenture_trading
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


INSERT INTO `companies` VALUES (1,'Accenture'),(2,'Apple'),(3,'Microsoft'),(4,'Amazon');

INSERT INTO `roles` VALUES (1,'User'),(2,'Admin');

INSERT INTO `users` (id,email,password,username,enabled) VALUES (1,'email@gmail.com','123','Makli',1),(2,'email@gmail.com','321','Bill',1),(3,'email@gmail.com','132','Themis',1);

INSERT INTO `users_to_roles` VALUES (1,1), (2,1), (3,1);

INSERT INTO `stocks` VALUES (1,'2017-04-24 19:44:19',1),(2,'2017-04-24 19:44:19',1),(3,'2017-04-24 19:44:19',1),(4,'2017-04-24 19:44:19',1),(5,'2017-04-24 19:44:19',1),(11,'2017-04-24 19:48:36',2),(12,'2017-04-24 19:48:36',2),(13,'2017-04-24 19:48:36',2),(14,'2017-04-24 19:48:36',2),(15,'2017-04-24 19:48:36',2),(16,'2017-04-24 19:48:36',2),(17,'2017-04-24 19:48:36',2),(18,'2017-04-24 19:48:36',2),(19,'2017-04-24 19:48:36',2),(20,'2017-04-24 19:48:36',2),(21,'2017-04-24 19:48:36',3),(22,'2017-04-24 19:48:36',3),(23,'2017-04-24 19:48:36',3),(24,'2017-04-24 19:48:36',3),(25,'2017-04-24 19:48:36',3),(26,'2017-04-24 19:48:36',3),(27,'2017-04-24 19:48:36',3),(28,'2017-04-24 19:48:36',3),(29,'2017-04-24 19:48:36',3),(30,'2017-04-24 19:48:36',3),(31,'2017-04-24 19:48:36',3),(32,'2017-04-24 19:48:36',3),(33,'2017-04-24 19:48:36',3),(34,'2017-04-24 19:48:36',3),(35,'2017-04-24 19:48:36',3),(36,'2017-04-24 19:48:36',4),(37,'2017-04-24 19:48:36',4),(38,'2017-04-24 19:48:36',4),(39,'2017-04-24 19:48:36',4),(40,'2017-04-24 19:48:36',4);

LOCK TABLES `stock_prices` WRITE;
INSERT INTO `stock_prices` (`stock_price_id`, `company_id`, `creation_date`, `stock_price`) VALUES ('1', '1', '2017-05-26', '1000') ,('2', '2', '2017-05-27', '2000'); 
UNLOCK TABLES;
