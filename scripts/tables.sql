CREATE DATABASE spring;

CREATE TABLE spring.COURSE ( id int unsigned not null auto_increment,
                             NAME varchar(20) not null,
                             DESCRIPTION varchar(1000),
                             CREDITS varchar(10) not null,
                             PROFESSOR varchar(100),
                             CREATED_TIME DATETIME DEFAULT CURRENT_TIMESTAMP,
                             UPDATED_TIME DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             constraint pk_example primary key (id) );


INSERT INTO spring.COURSE(NAME, DESCRIPTION, CREDITS, PROFESSOR) VALUES ('Machine Learning', 'Machine learning is a field of computer science that gives computers the ability to learn without being explicitly programmed.', '5.0', 'Andrew N G')
