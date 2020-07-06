DROP TABLE WORD;

CREATE TABLE WORD(
    NUM NUMBER,
    ENG VARCHAR2(50),
    KOR VARCHAR2(50),
    PRIMARY KEY(NUM)
);

DESC WORD;

SELECT * FROM WORD ORDER BY NUM DESC;

DELETE FROM WORD;

CREATE SEQUENCE WORD_SEQ;

DROP SEQUENCE WORD_SEQ;

INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'apple', '���');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'tree', '����');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'car', '�ڵ���');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'subway', '����ö');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'train', '����');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'book', 'å');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'face', '��');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'shoes', '�Ź�');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'floor', '�ٴ�');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'light', '��');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'rabbit', '�䳢');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'cow', '��');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'dog', '��');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'straw', '����');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'chair', '����');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'desk', 'å��');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'sky', '�ϴ�');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'note', '��å');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'monkey', '������');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'cat', '�����');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'road', '��');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'baby', '�Ʊ�');
commit;