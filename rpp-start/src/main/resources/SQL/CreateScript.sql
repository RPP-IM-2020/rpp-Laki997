DROP TABLE IF EXISTS smer CASCADE;
DROP TABLE IF EXISTS grupa CASCADE;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS projekat CASCADE;

DROP SEQUENCE IF EXISTS smer_seq;
DROP SEQUENCE IF EXISTS grupa_seq;
DROP SEQUENCE IF EXISTS student_seq;
DROP SEQUENCE IF EXISTS projekat_seq;

CREATE TABLE smer(
	id integer NOT NULL,
    naziv varchar(100) NOT NULL,
    oznaka varchar(50) not null
);

CREATE TABLE grupa(
	id integer NOT NULL,
    oznaka varchar (10) NOT NULL,
    smer integer not null
   
);

CREATE TABLE projekat(
	id integer NOT NULL,
    naziv varchar(100) not null,
	oznaka varchar (10) not null,
	opis varchar (500) not null
);

CREATE TABLE student(
	id integer NOT NULL,
    ime varchar(50) NOT NULL,
    prezime varchar(50) NOT NULL,
    broj_indeksa VARCHAR(20) NOT NULL,
    grupa integer NOT NULL,
    projekat integer NOT NULL
    
);

ALTER TABLE smer ADD CONSTRAINT PK_Smer
	PRIMARY KEY(id);
ALTER TABLE grupa ADD CONSTRAINT PK_Grupa
	PRIMARY KEY(id);
ALTER TABLE projekat ADD CONSTRAINT PK_Projekat
	PRIMARY KEY(id);
ALTER TABLE student ADD CONSTRAINT PK_Student
	PRIMARY KEY(id);

ALTER TABLE grupa ADD CONSTRAINT FK_Grupa_Smer
	FOREIGN KEY (smer) REFERENCES smer (id);
ALTER TABLE student ADD CONSTRAINT FK_Student_Grupa
	FOREIGN KEY (grupa) REFERENCES grupa (id);
ALTER TABLE student ADD CONSTRAINT FK_Student_Projekat
	FOREIGN KEY (projekat) REFERENCES projekat (id);

CREATE INDEX IDXFK_Grupa_Smer
	ON grupa (smer);
CREATE INDEX IDXFK_Student_Grupa
	ON student (grupa);
CREATE INDEX IDXFK_Student_Projekat
	ON student (projekat);
	
CREATE SEQUENCE smer_seq
INCREMENT 1;
CREATE SEQUENCE grupa_seq
INCREMENT 1;
CREATE SEQUENCE projekat_seq
INCREMENT 1;
CREATE SEQUENCE student_seq
INCREMENT 1;












