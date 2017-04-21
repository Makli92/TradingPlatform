CREATE DATABASE accenture_trading
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
INSERT INTO `companies` VALUES (1,'Accenture'),(2,'Apple'),(3,'Microsoft'),(4,'Amazon');
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
INSERT INTO `roles` VALUES (1,'User'),(2,'Admin');
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
INSERT INTO `users` (id,email,password,username,enabled) VALUES (1,'email@gmail.com','123','Makli',1),(2,'email@gmail.com','321','Bill',1),(3,'email@gmail.com','132','Themis',1);
UNLOCK TABLES;

--
-- Dumping data for table `users_to_roles`
--

LOCK TABLES `users_to_roles` WRITE;
INSERT INTO `users_to_roles` VALUES (1,1), (2,1), (3,1);
UNLOCK TABLES;