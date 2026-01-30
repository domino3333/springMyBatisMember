# 📝 MyBatis 기반 회원관리 및 권한 데이터베이스 설계 (Oracle)

이 저장소는 Java와 Database를 연동하는 **MyBatis 실습을 위한 Oracle SQL 스크립트**를 포함하고 있습니다. 
컴퓨터 전공자 및 시니어 입문자분들이 DB 구축 원리를 쉽게 이해할 수 있도록 구성되었습니다.


# SpringBoot MyBatis 게시판

## 🖥️ 소개
MyBatis 방식으로 CURD 테스팅<br>

## 🕰️ 개발 기간
* 2026.01.29 - 2026.01.30

### ⚙️ 개발 환경
- 운영체제: Windows 11 home
- 개발 도구: SpringBoot 4.1.9
- JDK 버전: OpenJDK 21.0.6
- 프로그래밍 언어: Java 21
- 형상관리 도구: Git, GitHub

## 📌 주요 기능
#### 회원 관리
- 회원 입력
- 회원 수정 
- 회원 삭제
- 회원 리스트
- 회원 검색

## 🚀 데이타 베이스 정보
```sql

CREATE TABLE mybatismember(
no NUMBER,
id VARCHAR2(50) NOT NULL,
pw VARCHAR2(50) NOT NULL,
name VARCHAR2(100) NOT NULL,
coin NUMBER(10) DEFAULT 0,
regdate DATE DEFAULT SYSDATE,
moddate DATE DEFAULT SYSDATE,
enabled CHAR(1) DEFAULT '1',

PRIMARY KEY (no)
);

drop table mybatismemberAuth;
CREATE TABLE
mybatismemberAuth(
no NUMBER NOT NULL, 
auth VARCHAR2(50) NOT NULL,

constraint mybatismember_auth_fk foreign key (no) references mybatismember(no)
);


-- 시퀀스 생성 (1부터 시작)
drop sequence mybatismember_seq;
create sequence mybatismember_seq
start with 1
increment by 1;

⚠️ 주의사항실습 중 데이터가 잘못되었다면 ROLLBACK;
명령어로 되돌릴 수 있습니다.
데이터 확정을 위해서는 COMMIT;
