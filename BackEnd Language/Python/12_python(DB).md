# 마리아DB

```python
# 마리아 db와 python 연결 
import pymysql

# db 연결
conn = pymysql.connect(host='127.0.0.1', port=3306,user='root',passwd='dudrnjs',db='python')
print('연결완료')


# 커서 생성
cursor = conn.cursor()

# 접속된 db에 있는 테이블 조회
cursor.execute('select * from usertable')

# 리스트로 저장하기 
result_list = cursor.fetchall();
# 전체 출력
print(result_list)

# 하나씩 출력
for i in result_list:
    print(i)

print('-'*30)

# 1번째 레코드 찍기
print(result_list[0])

# 2번째 레코드 찍기
print(result_list[1])

conn.close()
연결완료
(('hood', '홍길동', 'gsa@google.com', 2004), ('hood1', '심봉사', 'sbs@naver.com', 2001))
('hood', '홍길동', 'gsa@google.com', 2004)
('hood1', '심봉사', 'sbs@naver.com', 2001)
------------------------------
('hood', '홍길동', 'gsa@google.com', 2004)
('hood1', '심봉사', 'sbs@naver.com', 2001)
```



```python
# 마리아 db와 python 연결 
import pymysql

# db 연결
conn = pymysql.connect(host='127.0.0.1', port=3306,user='root',passwd='dudrnjs',db='python')
print('연결완료')


# 커서 생성
cursor = conn.cursor()

# 테이블 생성
cursor.execute("create table if not exists bbs(id int, contents text, writes text);")

# 레코드 삽입
cursor.execute("insert into bbs(id,contents,writes) values(1000,'오늘도 좋은하루','관리자');")
cursor.execute("insert into bbs(id,contents,writes) values(2000,'수요일은 쉽니다','관리자');")
cursor.execute("insert into bbs(id,contents,writes) values(3000,'멀티캠퍼스','관리자');")

# 레코드 삭제
cursor.execute("delete from bbs where id = 1000;")

# 레코드 수정
cursor.execute("update bbs set writes = '회장님' where id = 3000;")


# db 반영
conn.commit()

# 테이블 조회
cursor.execute('select * from bbs;')
result_list = cursor.fetchall()
print(result_list)


conn.close()
연결완료
((2000, '수요일은 쉽니다', '관리자'), (3000, '멀티캠퍼스', '회장님'), (2000, '수요일은 쉽니다', '관리자'), (3000, '멀티캠퍼스', '회장님'), (2000, '수요일은 쉽니다', '관리자'), (3000, '멀티캠퍼스', '회장님'), (2000, '수요일은 쉽니다', '관리자'), (3000, '멀티캠퍼스', '회장님'))
c:\users\student\appdata\local\programs\python\python37\lib\site-packages\pymysql\cursors.py:170: Warning: (1050, "Table 'bbs' already exists")
  result = self._query(query)
```

# primary key

```python
# 테이블에 한개만 존재
# 테이블 생성시 컬럼명 옆에 입력한다
# create table 테이블명(컬럼명1 데이타타입1 primary key,컬럼명2 데이타타입2,.. )

# 마리아 db와 python 연결 
import pymysql

# db 연결
conn = pymysql.connect(host='127.0.0.1', port=3306,user='root',passwd='dudrnjs',db='python')
print('연결완료')


# 커서 생성
cursor = conn.cursor()

# 테이블 생성
cursor.execute("create table if not exists member(id int primary key, membername text, membergender text,memberage int);")

# 레코드 삽입
cursor.execute("insert into member(id,membername,membergender,memberage) values(1000,'홍길동','남자',24);")
cursor.execute("insert into member(id,membername,membergender,memberage) values(2000,'심봉사','남자',48);")
cursor.execute("insert into member(id,membername,membergender,memberage) values(3000,'심청이','여자',20);")


# db 반영
conn.commit()

# 테이블 조회
cursor.execute('select * from member;')
result_list = cursor.fetchall()
print(result_list)


conn.close()
```