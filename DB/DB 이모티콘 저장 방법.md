# DB 이모티콘 저장 방법

[MySQL에서 Emoji(이모지) 데이터 처리하기](http://devhyun.com/blog/post/2)



# 문제 해결

데이터베이스의 언어셋 변경!!

먼저 데이터베이스 설정 파일에서 아래의 내용을 추가 및 변경.

```
vi /etc/my.cnf
[mysqld]
collation-server=utf8mb4\_unicode\_ci
character-set-server=utf8mb4
skip-character-set-client-handshake
```

`skip-character-set-client-handshake`는 클라이언트의 시스템 인코딩을 사용하지 않게 하는 설정이다.

그 후에 기존에 만들어진 데이터베이스가 있다면 `alter database`명령어를 통해 언어셋과 collate를 변경할 수 있다.

````
ALTER DATABASE 데이터베이스이름 CHARACTER SET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
````