INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES(nextval('smer_seq'), 'Inzenjerski menadzment', 'IM');
INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES(nextval('smer_seq'), 'Industrijsko inzenjerstvo', 'II');
INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES(nextval('smer_seq'), 'Inzenjerstvo informacionih sistema', 'IIS');
INSERT INTO "smer"("id", "naziv", "oznaka")
VALUES(nextval('smer_seq'), 'Primenjeno softversko inzenjerstvo', 'PSI');


INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '1', 1);
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '2', 1);
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '3', 1);

INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '4', 2);
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '5', 2);

INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '6', 3);
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '7', 3);

INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '8', 4);
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '9', 4);
INSERT INTO "grupa"("id", "oznaka", "smer")
VALUES(nextval('grupa_seq'), '10', 4);

INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(nextval('projekat_seq'),'Tehnicka_Dokumentacija_Bar', 'TD_Bar','Sema baze podataka informacionog sistema za podrsku rada koncept bara');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(nextval('projekat_seq'),'Tehnicka_Dokumentacija_Stamparija', 'TD_Stampa','Sema baze podataka informacionog sistema za podrsku rada stamparije');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(nextval('projekat_seq'),'Tehnicka_Dokumentacija_Apoteka', 'TD_Apoteka','Sema baze podataka informacionog sistema za podrsku rada apoteke');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(nextval('projekat_seq'),'Tehnicka_Dokumentacija_Pivara', 'TD_Pivara','Sema baze podataka informacionog sistema za podrsku rada pivare');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES(nextval('projekat_seq'),'Tehnicka_Dokumentacija_Kozmeticki_Salon', 'TD_Kozm_Sl','Sema baze podataka informacionog sistema za podrsku rada kozmetickog salona');

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Lazar', 'Kalajdzic', '61-2016', 1,1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Milos', 'Bakmaz', '76-2016', 2,2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Djordje', 'Alidjukic', '1-2016', 3,3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Nemanja', 'Djuretic', '176-2016', 4,4);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Zoran', 'Tucev', '35-2016', 4,5);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Dusan', 'Gacesa', '78-2016', 1,1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Teodora', 'Martic', '47-2016', 2,2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Zarije', 'Gojkovic', '3-2016', 3,3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Martina', 'Peic', '12-2016', 4,4);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Dragan', 'Pilipovic', '7-2016', 4,5);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Damjan', 'Gagovic', '52-2016', 1,2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Jovana', 'Malic', '88-2016', 1,2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Jelena', 'Peric', '13-2016', 2,3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Vukota', 'Bajat', '60-2016', 2,3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Milos', 'Malic', '112-2016', 2,5);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES(nextval('student_seq'), 'Aleksandar', 'Potic', '80-2016', 3,4);


























