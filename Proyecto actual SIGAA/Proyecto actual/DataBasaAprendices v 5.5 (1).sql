drop database bdaprendices;
create database bdaprendices;

use bdaprendices;

create table State(
IdState int auto_increment primary key ,
NameState varchar (10)not null unique
);

create table Charge(
IdCharge int primary key auto_increment,
NameCharge varchar (15) not null unique,
IdState int not null
);

create table Person(
IdPerson int primary key,
NamePerson varchar(40) not null,
UserPerson varchar(30) not null,
PasswordPerson varchar(30) not null,
Email varchar(40) not null,
IdState int not null	
);

-- tabla para asignar un cargo a una persona.
create table ChargePerson(
IdChaPer int primary key auto_increment,
IdPerson int not null,
IdCharge int not null
);

create table news(
IdNote int primary key,
NameNote varchar(60),
Desciption varchar (220),
IdPerson int not null
);

create table Apprentice(
IdApprentice int primary key,
NameApprentice varchar (50) not null, 
IdState int  not null,
IdGroup int not null
);

create table GroupStudents(
IdGroup int primary key ,
IdState int not null,
IdProgram int not null
);

create table Program(
IdProgram int primary key,
NameProgram varchar (90) unique,
IdState int not null
);

create table ResultLearning(
IdResultLearning int primary key,
NameRelsultLearnig varchar (50) not null,
StartDate Date not null,
EndDate Date not null,
IdState int not null,
IdProgram int not null
);

create table task(
IdTask int primary key auto_increment,
NameTask varchar (50) unique,
IdState int not null
);

-- tabla para asignar una tarea a una persona
create table AssignamentTask(
IdAssTask int primary key auto_increment,
IdTask int not null,
IdPerson int not null
);

-- tabla detalle para asignar un programa a una persona
create table AssignamentPerson(
IdAssPer int primary key auto_increment,
IdProgram int not null,
IdPerson int not null
);
-- tabla detalle para la toma de asistencia
create table AssistanceApprentice (
IdChaPer int primary key auto_increment,
IdApprentice int not null,
IdAssistance int not null,
IdPerson int not null,
DateA date
);

-- Tabla tipos de asistencia 
Create table Assistance( 
IdAssistance int primary key,                                                
Kind varchar (15) unique
);

-- Inicio  Declaracion de Relaciones Fk 

alter table AssistanceApprentice  add constraint AssApp
foreign key (IdApprentice) references Apprentice (IdApprentice) on delete cascade  on update cascade;

alter table AssistanceApprentice  add constraint AssApp2
foreign key (IdAssistance) references Assistance (IdAssistance) on delete cascade  on update cascade;

alter table AssistanceApprentice  add constraint AssApp3
foreign key (IdPerson) references Person (IdPerson) on delete cascade  on update cascade;

alter table Program add constraint ProSta
foreign key (IdState) references State (IdState) on delete cascade  on update cascade;

alter table person add constraint Sta_Per
foreign key (IdState) references State (IdState) on delete cascade  on update cascade;

alter table ChargePerson add constraint Cha_Per
foreign key (IdPerson) references Person (IdPerson) on delete cascade  on update cascade;

alter table ChargePerson add constraint Cha_Per2
foreign key (IdCharge) references Charge (IdCharge) on delete cascade  on update cascade;

alter table Apprentice  add constraint AppSta
foreign key (IdState) references State (IdState) on delete cascade  on update cascade; 

alter table Apprentice add constraint AppGro
foreign key (IdGroup) references GroupStudents (IdGroup) on delete cascade  on update cascade;

alter table GroupStudents add constraint GroSta
foreign key (IdState) references State (IdState) on delete cascade  on update cascade; 

alter table GroupStudents add constraint Pro_Gro
foreign key (Idprogram) references program (IdProgram) on delete cascade  on update cascade;

alter table ResultLearning add constraint Pro_Res
foreign key (IdProgram) references Program (IdProgram) on delete cascade  on update cascade;

alter table  AssignamentPerson add constraint AssPro
foreign key (IdProgram) references Program (IdProgram) on delete cascade  on update cascade;

alter table  AssignamentPerson add constraint Assper2
foreign key (IdPerson) references Person (IdPerson) on delete cascade  on update cascade;

alter table ResultLearning  add constraint Res_Sta
foreign key (IdState) references State	(IdState) on delete cascade on update cascade;

alter table AssignamentTask add constraint AssTas
foreign key (IdTask) references Task (IdTask) on delete cascade on update cascade;

alter table AssignamentTask add constraint AssTas2
foreign key (Idperson) references person (IdPerson) on delete cascade on update cascade;

alter table news add constraint PerNew
foreign key (IdPerson) references Person (IdPerson) on delete cascade  on update cascade;

alter table charge add constraint charSta
foreign key (IdState) references State (IdState) on delete cascade  on update cascade;

alter table task add constraint taskSta
foreign key (IdState) references State (IdState) on delete cascade  on update cascade;

-- inserciones de datos  para inicio de aplicativo

INSERT INTO `bdaprendices`.`state` (`IdState`, `NameState`) VALUES ('1', 'Activo');
INSERT INTO `bdaprendices`.`state` (`IdState`, `NameState`) VALUES ('2', 'Inactivo');

INSERT INTO `bdaprendices`.`person` (`IdPerson`, `NamePerson`, `UserPerson`, `PasswordPerson`, `Email`, `IdState`) VALUES ('123123132', 'Jhohan Nieto ', 'jhawar', '123', 'jhohansndad@misena.edu.co', '1');


 select  NameCharge from Charge as l
  inner join State as e
  on l.IdState= e.IdState;
  
  select NameState from state as l inner join charge as ñ on l.IdState = ñ.IdState