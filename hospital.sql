CREATE DATABASE SalaUrgencias;

USE salaurgencias;

create table paciente(
id int auto_increment primary key,
nombre varchar(16) not null,
apellido1 varchar(16) not null,
apellido2 varchar(16) not null,
sexo varchar(10) not null,
edad int not null,
tipo_sangre varchar(10) not null,
telefono VARCHAR(15))
ENGINE=InnoDB;

create table departamento(
id int auto_increment primary key,
nombre_departamento varchar(16) not null)
ENGINE=InnoDB;

create table especialista(
id int auto_increment primary key, 
id_departamento int not null,
nombre varchar(16) not null,
apellido1 varchar(16) not null,
apellido2 varchar(16) not null,
especialidad varchar(20) not null,
antiguedad_años int)
ENGINE=InnoDB;

create table urgenciologo(
id int auto_increment primary key,
nombre varchar(16) not null,
apellido1 varchar(16) not null,
apellido2 varchar(16) not null,
antiguedad_años int)
ENGINE=InnoDB;

create table enfermero(
id int auto_increment primary key,
nombre varchar(16) not null,
apellido1 varchar(16) not null,
apellido2 varchar(16) not null,
antiguedad int)
ENGINE=InnoDB;

create table diagnostico(
id int auto_increment primary key,
id_urgencia int not null,
id_urgenciologo int not null,
id_departamento int not null,
id_especialista int not null,
gravedad varchar(16) not null)
ENGINE=InnoDB;

create table urgencia(
id int auto_increment primary key,
id_paciente int not null,
id_urgenciologo int not null,
id_diagnostico int,
numero_cama varchar(16) not null,
fecha_ingreso datetime not null,
fecha_salida datetime,
causa varchar(50) not null)
ENGINE=InnoDB;

create table apoyo_enfermero(
id_enfermero int not null,
id_urgencia int not null)
ENGINE=InnoDB;

alter table especialista add foreign key (id_departamento) references departamento(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table diagnostico add foreign key (id_urgencia) references urgencia(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table diagnostico add foreign key (id_urgenciologo) references urgenciologo(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table diagnostico add foreign key (id_departamento) references departamento(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table diagnostico add foreign key (id_especialista) references especialista(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table urgencia add foreign key (id_paciente) references paciente(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table urgencia add foreign key (id_urgenciologo) references urgenciologo(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table urgencia add foreign key (id_diagnostico) references diagnostico(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table apoyo_enfermero add foreign key (id_enfermero) references enfermero(id) ON UPDATE CASCADE ON DELETE CASCADE;
alter table apoyo_enfermero add foreign key (id_urgencia) references urgencia(id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO `paciente` (`nombre`,`apellido1`,`apellido2`,`sexo`,`edad`,`tipo_sangre`,`telefono`) VALUES ("Raja","Shepherd","Barr","Mujer",86,"A-","58-3730-3491"),("Ulla","Bowen","Fox","Hombre",29,"AB+","22-7259-4713"),("Sarah","Herman","Estes","Hombre",54,"AB+","61-7636-8869"),("Jelani","Shelton","Ware","Mujer",45,"A+","09-6945-0239"),("Dorian","Hart","Ortiz","Mujer",69,"A-","20-7983-0301"),("Sybil","Wilkins","Dillard","Hombre",64,"B-","38-6606-5529"),("Ramona","Collier","Forbes","Mujer",10,"A+","25-4952-6092"),("Ezra","Brock","Hinton","Hombre",87,"AB+","30-8297-4656"),("Jocelyn","Bauer","Andrews","Mujer",78,"O+","28-5870-5670"),("Sara","Richard","Cummings","Hombre",67,"B+","14-9340-5370");
INSERT INTO `paciente` (`nombre`,`apellido1`,`apellido2`,`sexo`,`edad`,`tipo_sangre`,`telefono`) VALUES 
("Summer","Love","Paul","Mujer",98,"O+","43-1396-4209"),("Uriel","Booth","Mcleod","Hombre",64,"A+","93-7427-3475"),("Rose","Cash","Mejia","Mujer",78,"O-","02-1627-0154"),("Wilma","Floyd","Olson","Mujer",58,"O+","09-7436-1468"),("Whoopi","Russell","Kramer","Mujer",20,"O-","79-9603-3704"),("Justin","Hobbs","Wong","Mujer",54,"A+","96-1405-4293"),("Minerva","Ferguson","Slater","Mujer",50,"AB+","36-0274-9485"),("Blaine","Espinoza","Crosby","Mujer",79,"AB+","68-0072-1275"),("Illana","Castro","Gentry","Hombre",15,"B+","15-0254-5174"),("Blythe","Marsh","Griffith","Hombre",90,"AB-","95-5854-4085");
INSERT INTO `paciente` (`nombre`,`apellido1`,`apellido2`,`sexo`,`edad`,`tipo_sangre`,`telefono`) VALUES ("Harry","Styles","Harrison","Hombre",23,"A+","47-1346-4809"),("Frederick","auron","play","Hombre",28,"A-","44-1316-7689"),("Cozmmayan","Artur","Velaquez","Hombre",44,"O+","47-8546-2309");


INSERT INTO enfermero (nombre,apellido1,apellido2,antiguedad) VALUES ("Bevis","Hawkins","Bond",2),("Stacey","Lambert","York",4),("Noelle","Brown","Browning", 8),("Janna","Estrada","Klein",6),("Zia","Cohen","Whitehead",9),("Leilani","Pickett","Hawkins",3),("Amy","Barber","Clark",5),("Lewis","Holder","Bennett",20),("Samuel","Lowe","Barton",7),("Jermaine","Floyd","Frazier",9);
INSERT INTO enfermero (nombre,apellido1,apellido2,antiguedad) VALUES ("Octavius","Patel","William",5),("Mason","Ramirez","House",13),("Wade","Bailey","Sampson",6),("Piper","Crosby","Greene",1),("Mercedes","Schroeder","Campos",4),("Berk","Davis","Wilkins",10),("Robin","Flowers","Stephens",0),("Melodie","Brennan","Whitney",13),("Aubrey","Decker","Hancock",7),("Elvis","Roy","Reeves",3);

INSERT INTO `departamento` (`id`,`nombre_departamento`) VALUES (1,"Cirugía general"),(2,"Traumatología"),(3,"Dermatología");
INSERT INTO `especialista` (`id`,`id_departamento`,`nombre`,`apellido1`,`apellido2`,`especialidad`,`antiguedad_años`) VALUES (1,1,"Madonna","Huffman","Smith","Medico cirujana",8),(2,2,"Molly","Jenkins","Cantu","Traumatologa",9),(3,3,"Camille","Ochoa","Watkins","Dermatologa",6),(4,1,"Catherine","Bright","Wiggins","Medico cirujana",8),(5,2,"Kenyon","Gay","Irwin","Traumatologo",1),(6,3,"Deacon","Shields","Sandoval","Dermatologo",2),(7,1,"Colette","Hunter","Howell","Medico cirujana",4),(8,2,"Philip","Gilbert","Walls","Traumatologo",4),(9,3,"Sheila","Welch","Solomon","Dermatologa",11);
INSERT INTO `urgenciologo` (`id`,`nombre`,`apellido1`,`apellido2`,`antiguedad_años`) VALUES (1,"Ethan","Fischer","Head",16),(2,"Brenna","Marquez","Wheeler",5),(3,"Hakeem","Dotson","Gentry",9),(4,"Rebekah","Whitney","Stanley",8),(5,"Katell","Huffman","Church",3),(6,"Plato","Tate","Moses",2);

INSERT INTO `urgencia` (`id_paciente`,`id_urgenciologo`,`numero_cama`,`fecha_ingreso`,`fecha_salida`, `causa`) VALUES (1,5,"A520","2020-04-10 06:52:19","2020-09-21 12:34:10", "Lesion"),(2,6,"H307","2019-08-22 19:47:00","2020-04-12 18:55:59", "Quemadura 1er grado"),(3,2,"S603","2020-02-17 07:12:53","2019-04-01 17:38:43", "Choque"),(4,4,"P350","2019-12-31 20:21:13","2019-08-06 05:54:43", "Caida a gran altura"),(5,4,"I646","2020-01-10 12:45:46","2020-03-18 15:42:45", "Atropellamiento"),(6,4,"L760","2019-03-07 18:00:57","2020-11-03 03:33:45", "Herida de arma blanca"),(7,5,"T712","2020-04-24 04:39:57","2018-12-12 22:34:04", "Asfixiamiento"),(8,4,"L423","2020-10-05 01:23:18","2019-02-05 17:44:08", "Fractura"),(9,4,"H938","2018-12-23 07:07:41","2020-06-18 06:35:17", "Esguince"),(10,3,"L512","2020-03-16 13:14:12","2019-03-14 04:52:38", "Herida arma de fuego");
INSERT INTO `urgencia` (`id_paciente`,`id_urgenciologo`,`numero_cama`,`fecha_ingreso`,`fecha_salida`, `causa`) VALUES (11,1,"U828","2020-03-06 23:55:32","2019-06-27 10:43:50", "Costilla rota"),(12,6,"P131","2019-04-29 13:58:29","2020-09-18 07:52:22", "Accidente automovilistico"),(13,1,"W827","2019-12-07 07:52:24","2019-01-18 23:57:12", "Quemaduras 3er grado"),(14,1,"F481","2019-05-01 10:08:53","2020-03-23 13:35:14", "Intoxicacion"),(15,1,"W593","2019-09-06 18:25:10","2020-09-03 21:29:18", "Envenenamiento"),(16,5,"V974","2020-09-08 05:34:18","2020-05-15 08:46:06", "Estrangulamiento"),(17,4,"G472","2019-02-11 19:28:05","2019-12-03 07:40:04", "Fractura de cuello"),(18,4,"B275","2019-08-03 18:43:46","2019-11-17 14:05:48", "Dedo perdido"),(19,3,"R205","2019-05-15 14:57:35","2019-07-26 06:55:32", "Migraña"),(20,1,"D166","2020-10-05 06:38:53","2019-06-18 13:03:20", "Fractura de craneo");
INSERT INTO `urgencia` (`id_paciente`,`id_urgenciologo`,`numero_cama`,`fecha_ingreso`,`fecha_salida`, `causa`) VALUES (21,5,"F278","2020-01-01 20:27:01","2019-05-15 15:20:56", "Golpe de cabeza"),(22,4,"N208","2019-10-04 17:57:21","2020-09-24 06:33:19", "Hueso de brazo roto"),(23,5,"P462","2019-08-02 04:52:14","2019-05-02 01:23:42", "Alergias");

INSERT INTO `diagnostico` (`id_urgencia`,`id_urgenciologo`,`id_especialista`,`id_departamento`,`gravedad`) VALUES (1,1,1,1,"Grave"),(2,2,2,2,"Estable"),(3,3,3,3,"Grave"),(4,4,4,1,"Critico"),(5,5,5,2,"Estable"),(6,6,6,3,"Grave"),(7,1,7,1,"Critico"),(8,2,8,2,"Estable"),(9,3,9,3,"Grave"),(10,3,1,1,"Critico");
INSERT INTO `diagnostico` (`id_urgencia`,`id_urgenciologo`,`id_especialista`,`id_departamento`,`gravedad`) VALUES (11,4,2,2,"Critico"),(12,5,3,3,"Grave"),(13,6,4,1,"Estable"),(14,1,5,2,"Grave"),(15,2,6,3,"Critico"),(16,3,7,1,"Estable"),(17,4,8,2,"Estable"),(18,5,9,3,"Critico"),(19,6,1,1,"Grave"),(20,1,2,2,"Critico");
INSERT INTO `diagnostico` (`id_urgencia`,`id_urgenciologo`,`id_especialista`,`id_departamento`,`gravedad`) VALUES (21,2,3,3,"Critico"),(22,3,4,1,"Grave"),(23,4,5,2,"Estable");

INSERT INTO `apoyo_enfermero` (`id_urgencia`,`id_enfermero`) VALUES (1,5),(2,1),(3,12),(4,11),(5,8),(6,5),(7,6),(8,6),(9,4),(10,2);
INSERT INTO `apoyo_enfermero` (`id_urgencia`,`id_enfermero`) VALUES (11,3),(12,4),(13,11),(14,9),(15,6),(16,10),(17,6),(18,7),(19,5),(20,2);
INSERT INTO `apoyo_enfermero` (`id_urgencia`,`id_enfermero`) VALUES (21,1),(22,1),(23,2);