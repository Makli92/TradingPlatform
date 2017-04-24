CREATE DATABASE accenture_trading
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


INSERT INTO `companies` VALUES (1,'Accenture'),(2,'Apple'),(3,'Microsoft'),(4,'Amazon');

INSERT INTO `roles` VALUES (1,'User'),(2,'Admin');

INSERT INTO `users` (id,email,password,username,enabled) VALUES (1,'email@gmail.com','123','Makli',1),(2,'email@gmail.com','321','Bill',1),(3,'email@gmail.com','132','Themis',1);

INSERT INTO `users_to_roles` VALUES (1,1), (2,1), (3,1);

--
-- Dumping data for table `stocks`
--
LOCK TABLES `stocks` WRITE;
INSERT INTO `stocks` (`stock_id`, `creation_date`) VALUES ('1', '2017-04-23'), ('2', '2017-04-22');
UNLOCK TABLES;

--
-- Dumping data for table `stock_prices`
--

LOCK TABLES `stock_prices` WRITE;
INSERT INTO `stock_prices` (`stock_price_id`, `company_id`, `creation_date`, `stock_price`) VALUES ('1', '1', '2017-05-26', '1000') ,('2', '2', '2017-05-27', '2000'); 
UNLOCK TABLES;
