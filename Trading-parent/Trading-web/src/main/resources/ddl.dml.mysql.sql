CREATE DATABASE accenture_trading
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;


INSERT INTO `companies` VALUES (1,'Accenture'),(2,'Apple'),(3,'Microsoft'),(4,'Amazon');

INSERT INTO `roles` VALUES (1,'User'),(2,'Admin');

INSERT INTO `users` (id,email,password,username,enabled) VALUES (1,'email@gmail.com','123','Makli',1),(2,'email@gmail.com','321','Bill',1),(3,'email@gmail.com','132','Themis',1);

INSERT INTO `users_to_roles` VALUES (1,1), (2,1), (3,1);
