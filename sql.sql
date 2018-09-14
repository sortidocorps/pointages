CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectname` varchar(20) NOT NULL,
  `active` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`projectname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;