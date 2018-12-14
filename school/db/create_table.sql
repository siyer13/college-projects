CREATE SCHEMA school;

USE school;

CREATE TABLE `student` (
  `student_id` varchar(12) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) NOT NULL,
  `college` varchar(45) DEFAULT NULL,
  `department` varchar(20) NOT NULL,
  `course` varchar(45) NOT NULL,
  `course_year` varchar(20) NOT NULL,
  `course_semester` varchar(20) NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='student details table'


CREATE TABLE `marks` (
  `student_id` varchar(20) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `type` varchar(3) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL,
  `grade` varchar(1) DEFAULT NULL,
  `course_semester` varchar(10) NOT NULL,
  `course_year` varchar(10) NOT NULL,
  `pass_month` varchar(10) DEFAULT NULL,
  `pass_year` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_id_UNIQUE` (`student_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8
