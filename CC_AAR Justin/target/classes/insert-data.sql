INSERT INTO PERSONNE (DISCR, ID, EMAIL, NOM, PRENOM) VALUES ('EMPLOYE', 1,  'employe@gmail.com', 'bob','bobi');

INSERT INTO ENTREPRISE (NOM, ID) VALUES ('ENT1', 1);
INSERT INTO ENTREPRISE_MOTSCLES(ENTREPRISE_ID, MOTSCLES) VALUES(1, 'HELLO');

INSERT INTO PERSONNE (DISCR, ID, EMAIL, NOM, PRENOM, NUMTELEPHONE, ENTREPRISE_ID) VALUES ('CONTACT', 2,  'employe@gmail.com', 'bob','bobi', 'jofif', 1);