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
    UNIQUE KEY `student_id_UNIQUE` (`student_id`))
    ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=\'student details table\'';
