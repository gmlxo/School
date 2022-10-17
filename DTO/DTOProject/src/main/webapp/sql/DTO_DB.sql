CREATE TABLE book(
book_id NUMBER(4) CONSTRAINT book_id_pk PRIMARY KEY,
book_name VARCHAR2(20),
book_loc VARCHAR2(20)
);

CREATE SEQUENCE book_seq;

INSERT INTO book VALUES (book_seq.NEXTVAL, 'book1', '001-00001');
INSERT INTO book VALUES (book_seq.NEXTVAL, 'book2', '002-00002');
INSERT INTO book VALUES (book_seq.NEXTVAL, 'book3', '003-00003');
INSERT INTO book VALUES (book_seq.NEXTVAL, 'book4', '004-00004');
INSERT INTO book VALUES (book_seq.NEXTVAL, 'book5', '005-00005');

commit;