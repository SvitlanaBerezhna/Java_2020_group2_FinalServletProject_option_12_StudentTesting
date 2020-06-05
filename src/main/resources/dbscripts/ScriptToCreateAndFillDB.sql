CREATE DATABASE  IF NOT EXISTS `testing_system` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `testing_system`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: testing_system
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answers` (
  `answer_id` int NOT NULL AUTO_INCREMENT,
  `question_id` int DEFAULT NULL,
  `answer_option` varchar(200) DEFAULT NULL,
  `answer_option_en` varchar(200) DEFAULT NULL,
  `is_correct` tinyint DEFAULT NULL,
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,1,'Це допомагає роз’єднувати об’єкти додатків один від одного.','It helps in decoupling application objects from each other.',1),(2,1,'Це допомагає у вирішенні залежностей об’єктів.','It helps in deciding the dependencies of objects.',0),(3,1,'Він зберігає стани об’єктів у базі даних.','It stores objects states in database.',0),(4,1,'Він зберігає стани об’єктів у файловій системі.','It stores object states in file system.',0),(5,2,'Файл конфігурації на основі XML.','XML Based configuration file.',0),(6,2,'Конфігурація на основі анотацій.','Annotation based configuration.',0),(7,2,'Конфігурація на базі Java.','Java based configuration.',0),(8,2,'Все вищеперераховане.','All of the above.',1),(9,3,'Це охоплює визначення bean до HTTP-запиту.','This scopes a bean definition to an HTTP request.',1),(10,3,'Це визначає визначення bean для контейнера Spring IoC.','This scopes the bean definition to Spring IoC container.',0),(11,3,'Це присвоює визначення bean HTTP-сесії.','This scopes the bean definition to HTTP Session.',0),(12,3,'Цей обсяг визначає HTTP Application / Global session.','This scopes the bean definition HTTP Application/ Global session.',0),(13,4,'Установка за замовчуванням, що означає відсутність autowiring, і ви повинні використовувати чіткі посилання на wiring.','Default setting which means no autowiring and you should use explicit bean reference for wiring.',0),(14,4,'Autowiring за властивості назви. Spring намагається співставити свої властивості з bean-ми, визначеними тими ж назвами у файлі конфігурації.','Autowiring by property name. Spring tries to match and wire its properties with the beans defined by the same names in the configuration file.',1),(15,4,'Spring спочатку намагається з’єднати autowire конструктором, якщо це не працює, Spring намагається виконати autowire byType.','Spring first tries to wire using autowire by constructor, if it does not work, Spring tries to autowire by byType.',0),(16,4,'Схожий на byType, але тип застосовується до аргументів конструктора.','Similar to byType, but type applies to constructor arguments.',0),(17,5,'Це являє собою точку у вашій програмі, яка об’єднує два об’єкти.','This represents a point in your application which joins two objects.',0),(18,5,'Це являє собою точку у вашому об’єкті, де ви приєднуєте значення.','This represents a point in your object where you join values.',0),(19,5,'Це являє собою точку у вашому об’єкті, де ви приєднуєте введені значення.','This represents a point in your object where you join injected values.',0),(20,5,'Це означає, що у вашій програмі ви можете підключити аспект AOP.','This represents a point in your application where you can plug-in AOP aspect.',1),(21,6,'Переплетення - це процес введення значень в об’єкти для створення об’єкта, що рекомендується.','Weaving is the process of injecting values in objects to create an advised object.',0),(22,6,'Переплетення - це процес зв’язку аспектів з іншими типами додатків або об’єктами для створення об’єкта, що рекомендується.','Weaving is the process of linking aspects with other application types or objects to create an advised object.',1),(23,6,'Це використовується для введення значень в об’єкти.','This is used to inject values in objects.',0),(24,6,'Переплетення використовується для перевірки залежності об’єктів.','Weaving is used to check object dependencies.',0),(25,7,'Використовуючи лише метод сеттера.','Using setter method only.',0),(26,7,'Використовуючи лише аргумент конструктора.','Using constructor argument only.',0),(27,7,'Використовуючи метод сеттера та аргумент конструктора і те, і інше.','Using setter method and constructor argument both.',1),(28,7,'Жоден з перерахованих вище.','None of the above.',0),(29,8,'singleton','singleton',1),(30,8,'глобальна сесія','global-session',0),(31,8,'прототип','prototype',0),(32,8,'запит','request',0),(33,9,'Використовуючи shutdownHook()','Using shutdownHook()',0),(34,9,'Використовуючи shutdownHandler()','Using shutdownHandler()',0),(35,9,'Використовуючи registerHook()','Using registerHook()',0),(36,9,'Використовуючи registerShutdownHook()','Using registerShutdownHook()',1),(37,10,'Інтерфейс, з якого розширюються списки, черги та набори','The interface from which lists, queues and sets extend',0),(38,10,'Фреймворк колекцій','The Collections framework',0),(39,10,'Утілітний клас для використання з колекціями','A utilility class for use with collections',1),(40,10,'Ми ніколи цього не згадуємо','We never mention this',0),(41,11,'Список','List',0),(42,11,'Мапа','Map',0),(43,11,'Черга','Queue',0),(44,11,'Сет','Set',1),(45,12,'Список','List',0),(46,12,'Мапа','Map',1),(47,12,'Черга','Queue',0),(48,12,'Сет','Set',0),(49,13,'HashMap','HashMap',0),(50,13,'LinkedHashMap','LinkedHashMap',0),(51,13,'Hashtable','Hashtable',1),(52,13,'Сет','Set',0),(53,14,'Обмежений тип','Bounded type',1),(54,14,'Generic тип','Generic type',0),(55,14,'Обмежений тип підстановки','Bounded wildcard type',0),(56,14,'Необмежений тип підстановки','Unbounded wildcard type',0),(57,15,'Асиметрія','Asymmetry',0),(58,15,'Стирання','Erasure',1),(59,15,'Реіфікація','Reification',0),(60,15,'Рефлексія','Reflection',0),(61,16,'Ніякий','None',0),(62,16,'ClassCastException','ClassCastException',1),(63,16,'RuntimeException','RuntimeException',0),(64,16,'OutOfBoundsException','OutOfBoundsException',0),(65,17,'HashMap','HashMap',0),(66,17,'Hashtable','Hashtable',0),(67,17,'LinkedHashMap','LinkedHashMap',1),(68,17,'TreeMap','TreeMap',0),(69,18,'HashMap','HashMap',0),(70,18,'Hashtable','Hashtable',0),(71,18,'LinkedHashMap','LinkedHashMap',0),(72,18,'TreeMap','TreeMap',1),(73,19,'Map.Entry','Map.Entry',1),(74,19,'Map.Iterator','Map.Iterator',0),(75,19,'Map.Pointer','Map.Pointer',0),(76,19,'Map.Root','Map.Root',0);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `theme_id` int NOT NULL,
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(200) DEFAULT NULL,
  `question_en` varchar(200) DEFAULT NULL,
  `explanation` varchar(300) DEFAULT NULL,
  `explanation_en` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `UK_eqibuctm8pce29k5gpuv3y5tu` (`theme_id`,`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'Що з наступного є правильним щодо введення залежності?','Which of the following is correct about dependency injection?','Ін’єкційна залежність допомагає в роз’єднанні предметів застосування один від одного.','Dependency injection helps in decoupling application objects from each other.'),(1,2,'Який спосіб надати метадані конфігурації spring?','Which is the way to provide configuration metadata to spring?','Всі перераховані вище твердження є правильними.','All of the above statements are correct.'),(1,3,'Що таке область запиту?','What is request scope?','Область запиту вказує контейнеру Spring IoC створити екземпляр на запит HTTP.','Request scope instructs Spring IoC container to create a instance per HTTP request.'),(1,4,'Що таке режим autowiring byName?','What is byName mode of autowiring?','Режим autowiring byName - це autowiring за назвою властивості. Spring намагається співставити свої властивості з bean-ми, визначеними тими ж назвами у файлі конфігурації.','byName mode of autowiring is autowiring by property name. Spring tries to match and wire its properties with the beans defined by the same names in the configuration file.'),(1,5,'Що таке точка з’єднання?','What is Join point?','Точка приєднання - це точка у вашій програмі, де ви можете підключити аспект AOP.','Join point represents a point in your application where you can plug-in AOP aspect.'),(1,6,'Що таке переплетення?','What is Weaving?','Переплетення - це процес зв’язку аспектів з іншими типами додатків або об’єктами для створення об’єкта, що рекомендується.','Weaving is the process of linking aspects with other application types or objects to create an advised object.'),(1,7,'Як використовувати ключове слово ref у beans.xml?','How to use ref keyword in beans.xml?','ref використовується для посилання на вже визначений bean, і його можна використовувати, як метод сеттера, так і аргумент конструктора.','ref is used to reference already defined bean and it can be used using both setter method and constructor argument.'),(1,8,'Якщо bean створена один раз на контейнер Ioc, область є','If a bean is created once per Ioc Container, scope is','Якщо bean створений один раз на контейнер Ioc, сфера дії є singleton.','If a bean is created once per Ioc Container, scope is singleton.'),(1,9,'Як поводитися із закриттям контейнера IoC?','How to handle shut down of IoC container?','Використовуючи метод registerShutdownHook(), можна відключити контейнер IoC. Інших методів не існує.','Using registerShutdownHook() method, shut down of IoC container can be handled. Other methods do not exists.'),(2,10,'Що ми маємо на увазі, згадуючи java.util.Collections?','What are we referring to when we mention java.util.Collections?','',''),(2,11,'Який тип колекції ми б використовували, якби не хотіли копій?','What type of collection would we use if we wanted no duplicates?','',''),(2,12,'Який тип колекції не розширює інтерфейс Collection <E>?','What type of collection does not extend the Collection<E> interface?',NULL,NULL),(2,13,'Який тип Мапи використовується із синхронізованим доступом?','What type of Map is used with synchronized access?',NULL,NULL),(2,14,'Що таке наведений нижче фрагмент коду - приклад <T extends Number>?','What is the following code snippet an example of <T extends Number>?',NULL,NULL),(2,15,'Як реалізовані дженерики?','How are generics implemented?',NULL,NULL),(2,16,'Який тип винятку виникає, коли ми запускаємо програму з об’єктами, які не є взаємно порівняними у відсортованому наборі?','What type of exception is raised when we run a program with objects that are not mutually comparable in a sorted set?',NULL,NULL),(2,17,'Який тип мапи Ви б використовували, якби Вам потрібна була б мапа швидкого доступу, але Ви б не турбувалися про сортування?','What type of map would you use if you wanted a fast access ordered map but didn’t care about sorting?',NULL,NULL),(2,18,'Який тип мапи Ви б використовували, якби хотіли її сортувати?','What type of map would you use if you wanted it sorted?',NULL,NULL),(2,19,'Який статичний вкладений клас Map<K,V> дозволяє отримати посилання на відображення за допомогою ітератора?','Which static nested class of Map<K,V> allows us to get a reference to a mapping via an iterator?',NULL,NULL);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statistics` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `theme_id` int DEFAULT NULL,
  `correct_answers` int DEFAULT NULL,
  `total_questions` int DEFAULT NULL,
  `grade` int DEFAULT NULL,
  `test_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistics`
--

LOCK TABLES `statistics` WRITE;
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
INSERT INTO `statistics` VALUES (1,1,1,3,9,33,'2020-05-12 10:15:05'),(2,1,2,4,10,40,'2020-05-12 11:25:15'),(3,2,2,8,10,80,'2020-05-12 12:30:08'),(4,3,1,7,9,78,'2020-05-12 14:40:52'),(5,3,2,9,10,90,'2020-05-12 15:15:50');
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `theme_id` int DEFAULT NULL,
  `question_id` int DEFAULT NULL,
  `answer` int DEFAULT '0',
  `question` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4879 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
/*!40000 ALTER TABLE `tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `themes`
--

DROP TABLE IF EXISTS `themes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `themes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `theme` varchar(60) NOT NULL,
  `theme_en` varchar(60) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `description_en` varchar(200) DEFAULT NULL,
  `time` int DEFAULT '0',
  `passing_grade` int DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themes`
--

LOCK TABLES `themes` WRITE;
/*!40000 ALTER TABLE `themes` DISABLE KEYS */;
INSERT INTO `themes` VALUES (1,'Spring фреймворк','Spring framework','Tест по Spring фреймворк','Spring framework test',5,60),(2,'Колекції/Generics','Collections/Generics','Тест по колекціям/Generics','Collections/Generics test',0,80);
/*!40000 ALTER TABLE `themes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `first_name_en` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `last_name_en` varchar(100) DEFAULT NULL,
  `activation_code` varchar(20) DEFAULT NULL,
  `grade` int DEFAULT '0',
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ivan.Ivanov11@ukr.net','1','Іван','Ivan','Іванов','Ivanov',NULL,37,'user'),(2,'Petro.Petrov@gmail.com','1','Петро','Petro','Петров','Petrov',NULL,80,'user'),(3,'Alina.Adminenko@ukr.net','1','Аліна','Alina','Адміненко','Adminenko',NULL,84,'admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `roles_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`roles_id`),
  KEY `FKa62j07k5mhgifpp955h37ponj` (`roles_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,2),(2,2),(3,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'testing_system'
--

--
-- Dumping routines for database 'testing_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-05 18:33:25
