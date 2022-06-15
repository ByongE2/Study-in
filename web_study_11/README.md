web_study_11

환경
1.windows
2.sts tool(Version: 3.9.17.RELEASE)
3.oracle 11g
4.jdk11
5.Encoding utf-8
6.git
7.jstl.jar
8.ojdbc6.jar
9.standard.jar
10.cos.jar
11.lombok-1.18.24.jar
*12. command pattern , factory pattern


MySql 테이블 생성 및 데이터 입력

create table board(
    num NUMBER(5)   primary key,
    pass varchar2(30),
    name varchar2(30),
    email varchar2(30),
    title varchar2(50),
    content varchar2(1000),
    readcount NUMBER(4)     default 0,
    writedate date  default sysdate
);

create SEQUENCE board_seq start with 1 increment by 1;

insert into board(num, pass, name, email, title, content)
values(board_seq.NEXTVAL, '성윤정', 'pinksung11@nate.com', '1234', '첫방문','반갑습니다.');
insert into board(num, pass, name, email, title, content)
values(board_seq.NEXTVAL, '성윤정', 'pinksung22@nate.com', '1234', '김밥','맛있어요');
insert into board(num, pass, name, email, title, content)
values(board_seq.NEXTVAL, '전수빈', 'pinksung33@nate.com', '1234', '테','테스트.');
insert into board(num, pass, name, email, title, content)
values(board_seq.NEXTVAL, '전원지', 'pinksung44@nate.com', '1234', '테22','테스트22.');


DBCP
<Resource name="jdbc/myoracle" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
              username="scott" password="tiger" maxTotal="20" maxIdle="10"
              maxWaitMillis="-1"/>
              


