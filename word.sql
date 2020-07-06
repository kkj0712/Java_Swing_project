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
VALUES (word_seq.NEXTVAL, 'apple', '사과');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'tree', '나무');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'car', '자동차');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'subway', '지하철');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'train', '기차');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'book', '책');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'face', '얼굴');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'shoes', '신발');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'floor', '바닥');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'light', '빛');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'rabbit', '토끼');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'cow', '소');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'dog', '개');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'straw', '빨대');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'chair', '의자');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'desk', '책상');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'sky', '하늘');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'note', '공책');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'monkey', '원숭이');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'cat', '고양이');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'road', '길');
INSERT INTO word (NUM,ENG,KOR)
VALUES (word_seq.NEXTVAL, 'baby', '아기');
commit;