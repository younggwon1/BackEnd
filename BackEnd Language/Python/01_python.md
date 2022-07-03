# 파이썬 day1

## 주석이란?

- 실행은 되지 않지만 코드애 대해서 설명할 때 사용한다.
- 문법은 #주석내용

## 출력문 print()

1. 결과를 출력한다.
2. 문법:print
3. 쉼표를 이용하여 연속으로 출력하려면?
   - print(값1,값2...)

```
print('hello world')

결과
hello world
```



```
print('-'*30)

결과
------------------------------
```

# 연산자

- 산술연산자
- 관계연산자
- 대입연산자
- 연산자 우선 순위



```
print(23>40)
print(23+40)

결과
False
63
```

# 입력문

- 문법 : input
- input('숫자를 입력하세요')
- 변수에 저장하려면?
- 변수명 = input('메세지')



```
userName = input('당신의 이름은 무엇입니까?')
print('나의 이름은',userName,'입니다')

결과
당신의 이름은 무엇입니까?홍길동
나의 이름은 홍길동 입니다
```

# 출력문 포맷 함수 - format()

- print('{ } { }'.format(값1,값2))

# 변수

- 값을 저장할 수 있는 공간
- 변수 이름 지정시 규칙
- 첫글자는 영문자
- 숫자,영문자,_ 가능
- 키워드 사용x

# 문자열 인덱싱(위치)

- 0부터 시작한다.
- 음수값 지정시 뒤에서 부터 위치가 지정된다.



```
myString = 'python'

print('0번째 위치의 문자 = ',myString[0])
print('4번째 위치의 문자 = ',myString[3])
print('6번째 위치의 문자 = ',myString[5])

결과
0번째 위치의 문자 =  p
4번째 위치의 문자 =  h
6번째 위치의 문자 =  n
```



```
myString = 'python'

print('6번째 위치의 문자 = ',myString[-1])
print('5번째 위치의 문자 = ',myString[-2])
print('4번째 위치의 문자 = ',myString[-3])

결과
6번째 위치의 문자 =  n
5번째 위치의 문자 =  o
4번째 위치의 문자 =  h
```

# 문자열 슬라이싱(부분 추출)

- 문자열 변수[start​ : end : ​step]
- print(myString[0:10:2])

# 이스케이프 문자

- \n :줄바꿈
- \t :탭. 왼쪽 여백
- \' ':인용부호 출력
- \" ":인용부호 출력

# 산술연산자 ,관계연산자 ,대입연산자

- 산술연산자
  - +,-,*
- / - 실수
- print(100/3)
- 결과
- 33.333333333333336

- // - 정수
- print(100//3)
- 결과
- 33

- % - 나머지

- 관계연산자

  - > , < , >= , <= , == ,!=

- 대입연산자
  - += : x+=5 -> x=x+5
  - -= : x-=5 -> x=x-5
  - *= : x*=5 -> x=x*5
  - /= : x/=5 -> x=x/5