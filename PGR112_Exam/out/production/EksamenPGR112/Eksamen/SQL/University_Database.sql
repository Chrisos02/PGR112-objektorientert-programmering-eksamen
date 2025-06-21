CREATE DATABASE universitydb;

CREATE USER 'universitydb'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON universitydb.*  TO  'universitydb'@'localhost' ;

FLUSH PRIVILEGES;

create table Staff (
   employee_id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(30),
   last_name VARCHAR(30),
   email VARCHAR(50),
   postion VARCHAR(50),
   PRIMARY KEY (employee_id)
);

create table Students (
   student_id INT NOT NULL AUTO_INCREMENT,
   studyProgram_id INT,
   registered_graduation_ceremony INT,
   first_name VARCHAR(30),
   last_name VARCHAR(30),
   PRIMARY KEY (student_id),
   FOREIGN KEY (studyProgram_id) REFERENCES StudyPrograms(program_id)
);


create table StudyPrograms(
   program_id INT NOT NULL AUTO_INCREMENT,
   program_name  VARCHAR (30),
   PRIMARY KEY (program_id)
);

insert into Staff (employee_id, first_name, last_name, postion, email)
values (01, 'Alice', 'Jensen','Teacher', 'Alicejohnsen@gmail.com');

insert into Staff (employee_id, first_name, last_name, postion, email)
values (02, 'Bob', 'Olsen','Teacher', 'BobOlsen@gmail.com');

insert into Staff (employee_id, first_name, last_name, postion, email)
values (03, 'Stian', 'Stiansen','Rektor', 'StianStiansen@gmail.com');

insert into StudyPrograms (program_id, program_name)
values (2100),("informasjonssikkerhet");

insert into StudyPrograms (program_id, program_name)
values (2200, "Database");

insert into StudyPrograms (program_id, program_name)
values (2300, "VisualAnalytics");

INSERT INTO StudyPrograms (program_id, program_name)
VALUES (2400, "OOP");

insert into Students (student_id, registered_graduation_ceremony,first_name, last_name)
values (01, 1, 'Kevin', 'Vaagenes' );

insert into Students (student_id, registered_graduation_ceremony,first_name, last_name)
values (02, 1, 'Bob', 'Bobsen' );

insert into Students (student_id, registered_graduation_ceremony,first_name, last_name)
values (03, 0, 'Karen', 'Olsen' );

insert into Students (student_id, registered_graduation_ceremony,first_name, last_name)
values (04, 1, 'Mina', 'Smista' );



