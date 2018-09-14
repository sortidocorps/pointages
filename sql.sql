CREATE TABLE `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `projectname` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`projectname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `projectuser` (
  `userid` int(11) NOT NULL,
  `projectid` int(20) NOT NULL,
  `active` int(1) NOT NULL,
  PRIMARY KEY (`userid`,`projectid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;