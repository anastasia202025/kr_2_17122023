CREATE DATABASE friends_of_man;

CREATE TABLE Animals
(
	Id INT PRIMARY KEY AUTO_INCREMENT, 
	Class_name VARCHAR(20)
);

INSERT INTO Animals (Class_name)
VALUES ('вьючные'),
('домашние'); 

CREATE TABLE Baggage_animals
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Species_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES Animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Baggage_animals (Species_name, Class_id)
VALUES ('Лошади', 1),
('Ослы', 1),  
('Верблюды', 1); 

CREATE TABLE Pets
(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Species_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES Animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Pets (Species_name, Class_id)
VALUES ('Кошки', 2),
('Собаки', 2),  
('Хомяки', 2); 

CREATE TABLE Cats 
(       
    Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(20), 
    Commands VARCHAR(50),
    Day_of_birth DATE,
    Species_id int,
    Foreign KEY (Species_id) REFERENCES Pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Dogs 
(       
    Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(20), 
    Commands VARCHAR(50),
    Day_of_birth DATE,
    Species_id int,
    Foreign KEY (Species_id) REFERENCES Pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Hamsters 
(       
    Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(20), 
    Commands VARCHAR(50),
    Day_of_birth DATE,
    Species_id int,
    Foreign KEY (Species_id) REFERENCES Pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Horses 
(       
    Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(20), 
    Commands VARCHAR(50),
    Day_of_birth DATE,
    Species_id int,
    Foreign KEY (Species_id) REFERENCES Baggage_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Donkeys 
(       
    Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(20), 
    Commands VARCHAR(50),
    Day_of_birth DATE,
    Species_id int,
    Foreign KEY (Species_id) REFERENCES Baggage_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Camels 
(       
    Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(20), 
    Commands VARCHAR(50),
    Day_of_birth DATE,
    Species_id int,
    Foreign KEY (Species_id) REFERENCES Baggage_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO Cats (Name, Commands, Day_of_birth, Species_id)
VALUES ('Фрося', 'мяу', '2022-01-01', 1),
('Симба', 'мяу, хвать', '2020-12-01', 1),  
('Коржик', 'мяу, прыг', '2021-01-06', 1); 

INSERT INTO Dogs (Name, Commands, Day_of_birth, Species_id)
VALUES ('Бэлла', 'сидеть, голос', '2020-03-03', 2),
('Ника', 'сидеть, лежать, дай лапу', '2015-06-11', 2),  
('Фунтик', 'сидеть, лежать, дай лапу, служить, голос', '2018-12-08', 2);

INSERT INTO Hamsters (Name, Commands, Day_of_birth, Species_id)
VALUES ('Хасбик', 'хрум', '2023-01-01', 3),
('Принцесса', '', '2022-11-09', 3), 
('Олег', 'хрум', '2023-02-02', 3);

INSERT INTO Horses (Name, Commands, Day_of_birth, Species_id)
VALUES ('Гордый', 'шаг, рысь, бег', '2012-10-12', 1),
('Звёздочка', 'шаг, рысь, бег, свечка', '2015-08-11', 1), 
('Секретариат', 'шаг, рысь, бег', '2019-03-01', 1);

INSERT INTO Donkeys (Name, Commands, Day_of_birth, Species_id)
VALUES ('Иа','иа', '2014-04-12', 2),
('Ваня','иа', '2018-10-02', 2), 
('Яша','иа', '2016-07-11', 2);

INSERT INTO Camels (Name, Commands, Day_of_birth, Species_id)
VALUES ('Лью','шаг, бег', '2019-08-08', 3),
('Ирис','шаг', '2018-07-07', 3), 
('Бек','шаг, бег', '2015-11-11', 3);

DROP TABLE Camels;

DELETE FROM Baggage_animals
WHERE Species_name = 'Верблюды';

INSERT INTO Horses (Name, Commands, Day_of_birth, Species_id)
SELECT Name, Commands, Day_of_birth, Species_id
FROM Donkeys;

DROP TABLE Donkeys;

ALTER TABLE Horses RENAME TO Horses_and_donkeys;


CREATE TEMPORARY TABLE temp AS 
SELECT * FROM Cats
UNION SELECT * FROM Dogs
UNION SELECT * FROM Hamsters
UNION SELECT * FROM Horses_and_donkeys;

CREATE TABLE Young_animals AS
SELECT Name, Commands, Day_of_Birth, CONCAT(CAST(TIMESTAMPDIFF(YEAR, Day_of_Birth, NOW()) AS CHAR), " год(а) ", 
	CAST(MOD(TIMESTAMPDIFF(MONTH, Day_of_Birth, NOW()), 12)  AS CHAR), " месяцев") AS Age 
FROM temp
WHERE TIMESTAMPDIFF(MONTH, Day_of_Birth, NOW()) BETWEEN 12 AND 36; 

SELECT * FROM Young_animals;

CREATE TABLE All_animals
(
	Id INT PRIMARY KEY AUTO_INCREMENT, 
    Name VARCHAR(20), 
    Commands VARCHAR(50),
    Day_of_birth DATE,
    Species VARCHAR(50)
);

INSERT INTO All_animals(Name, Commands, Day_of_Birth, Species)
SELECT Name, Commands, Day_of_Birth, 'кошка'
FROM Cats;

INSERT INTO All_animals(Name, Commands, Day_of_Birth, Species)
SELECT Name, Commands, Day_of_Birth, 'собака'
FROM Dogs;

INSERT INTO All_animals(Name, Commands, Day_of_Birth, Species)
SELECT Name, Commands, Day_of_Birth, 'хомяк'
FROM Hamsters;

INSERT INTO All_animals(Name, Commands, Day_of_Birth, Species)
SELECT Name, Commands, Day_of_Birth, 'лошадь/осёл'
FROM Horses_and_donkeys;

SELECT * FROM All_animals;