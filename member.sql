DROP TABLE member;

CREATE TABLE member(
    NUM NUMBER,
    name VARCHAR2(10) NOT NULL,
    id VARCHAR2(30),
    pw VARCHAR2(30) NOT NULL,
    email VARCHAR2(30),
    score NUMBER,
    PRIMARY KEY(id)
);

INSERT INTO member (num,name,id,pw,email,score)
VALUES (member_SEQ.NEXTVAL, 'tina', 'tina1', 'ttt', 'tina11', 0);

INSERT INTO member (num,name,id,pw,email,score)
VALUES (member_SEQ.NEXTVAL, 'aa', 'aa','aa','aa',0);

INSERT INTO member (num,name,id,pw,score)
VALUES (member_seq.nextval,'jina','jn','jn',60);

INSERT INTO member (num,name,id,pw,score)
VALUES (member_seq.nextval,'admin','admin','admin',0);


commit;


delete from member where id='admin';

select * from member order by score desc;

UPDATE member SET score=100 WHERE id='aa'; 

commit;
DESC member;

SELECT * FROM member ORDER BY NUM DESC;

DELETE FROM member;

CREATE SEQUENCE member_SEQ;

DROP SEQUENCE member_SEQ;