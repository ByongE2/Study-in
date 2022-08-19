SQL설정(오라클)

create sequence seq_board;

create table tbl_board(
    bno NUMBER(10,0),
    title VARCHAR2(200) not null,
    content VARCHAR2(2000) not null,
    writer VARCHAR2(50) not null,
    regdate DATE default sysdate,
    updatedate date default sysdate
    );

alter table tbl_board add CONSTRAINT pk_board
PRIMARY key(bno);

insert into tbl_board(bno, title, content, writer)
values(seq_board.nextval, '홍길동전', '도둑이야기', '허균');

select * from tbl_board;
    

create table tbl_reply(
    rno number(10,0),
    bno NumBER(10,0) not null,
    reply varchar2(1000) not null,
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
);

create SEQUENCE seq_reply;

-- 기본키 설정
alter table tbl_reply add CONSTRAINT pk_reply PRIMARY key (rno);

--외래키 설정
alter table tbl_reply add CONSTRAINT fk_reply_board
foreign key (bno) references tbl_board(bno);

desc tbl_reply;   