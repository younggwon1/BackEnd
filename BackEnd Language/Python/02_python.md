# 문자열 함수

- ' ' , " " , ''' ''' , """ """ <-이렇게 되어었으면 출력가능

```
myStr = 'python'

print(myStr)
print('{}'.format(myStr))
print('%s' %(myStr))

결과
python
python
python
```

# 문자열 변수

- 변수.count('찾는문자')
- 변수.find('찾는문자')
- 만약 없는 문자가 있다면 결과값은 -1이 나온다.

```
myStr = 'python'
print(myStr.count('y'))
print(myStr.find('o'))

결과
1
4
```

# 구분자 변수

- 변수.join(문자열이나 문자열 변수)

```
a = ","
print(a.join('abcd'))
결과
a,b,c,d

a = "/"
print(a.join('abcd'))
결과
a/b/c/d
```

# 문자열 조작

- 대문자를 소문자로 바꾸기 : 변수.lower()
- 소문자를 대문자로 바꾸기 : 변수.upper()

```
a = "HI"
print(a.lower())

a = "hi"
print(a.upper())
hi
HI
```



```
문자열 변수

myStr = 'python'

 변수.count('찾는문자')
print(myStr.count('y'))
결과 : 1
  


 변수.find('찾는문자')
print(myStr.find('o'))
결과 : 4

만약 없는 문자가 있다면 결과값은 -1이 나온다.


-구분자 변수
 변수.join(문자열이나 문자열 변수)

a = ","
print(a.join('abcd'))
결과 : a,b,c,d

a = "/"
print(a.join('abcd'))
결과 : a/b/c/d




-문자열 조작

대문자를 소문자로 바꾸기
 변수.lower()

a = "HI"
print(a.lower())
결과 : hi


소문자를 대문자로 바꾸기
 변수.upper()

a = "hi"
print(a.upper())
결과 : HI


★★★
양쪽공백지우기
변수.strip()

b = "  hi  "
print(b.strip())


왼쪽공백지우기(lstrip)
오른쪽공백지우기(rstrip)


-문자열 바꾸기
변수.replace(" 찾는문자 " , " 변경할 문자 ")

c = "Life is too short"
print(c.replace("Life","Your leg"))
결과 : Your leg is too short



-자료형
정수,실수,문자열
리스트,딕셔너리,튜플,집합

리스트
정의 : 리스트변수 = ['요소1' , '요소2' , ....]

fruits = ['사과','수박','망고','바나나']
print('fruits 목록 : {}'.format(fruits))
결과 : fruits 목록 : ['사과', '수박', '망고', '바나나']


-리스트 인덱싱

0부터 시작
음수일 때는 역순 , -1일 때 마지막 인덱싱 값

fruits = ['사과','수박','망고','바나나']
print('fruits[0] = {}'.format(fruits[0]))
결과 : 사과
print('fruits[3] = {}'.format(fruits[3]))
결과 : 바나나




-리스트요소의 교체

fruits = ['사과','수박','망고','바나나']
fruits[0] = '자두'
print('fruits 목록 : {}'.format(fruits))
결과 : fruits 목록 : ['자두', '수박', '망고', '바나나']



-리스트 전체 길이

len(리스트이름)

fruits = ['사과','수박','망고','바나나']
print('fruits 리스트 전체길이 : {}'.format(len(fruits)))
결과 : 4


-리스트의 슬라이싱

a = [1,2,3,4,5]

print(a[0:2])
결과 : [1, 2]

b=a[:2]
print(b)
결과 : [1, 2]

c=a[2:]
print(c)
결과 : [3, 4, 5]



-리스트 추가


리스트 이름.append(요소값)

fruits = ['사과','수박','망고','바나나']
fruits.append('복숭아')
결과 : ['사과', '수박', '망고', '바나나', '복숭아']

마지막 위치에 추가됨


입력문으로 리스트 추가

drama = []
data = input('최근 본 드라마 제목을 입력하세요')
drama.append(data)
print(drama)


★★★
정해진 위치에 리스트 추가

리스트 이름.insert(위치인덱스,요소값)
인덱스에서 지정한 위치에 요소 삽입

numbers = [100,200,300,400]
numbers.insert(2,10)
print(numbers)
결과 : [100, 200, 10, 300, 400]



-리스트 삭제

1.리스트 이름.remove(삭제할 요소값)


  numbers = [100,200,300,400]
  numbers.remove(100)
  print(numbers)
  결과 : [200, 300, 400]


2.리스트 이름.pop() -> 마지막 위치의 요소가 삭제
 
  numbers = [100,200,300,400]
  numbers.pop()
  print(numbers)
  결과 : [100, 200, 300]

 

3.리스트 이름.pop(삭제할 인덱스)

  numbers = [100,200,300,400]
  numbers.pop(1)
  print(numbers)
  결과 : [100, 300, 400]

  
4.del 리스트 이름[인덱스]
  
  numbers = [100,200,300,400]
  del numbers[1]
  print(numbers)
  결과 : [100, 300, 400]



-리스트 + 리스트
  a = [1,2,3]
  b = [4,5,6]
  print(a+b)
  결과 : [1, 2, 3, 4, 5, 6]


-리스트*반복횟수
  a = [1,2,3]
  print(a*3)
  결과 : [1, 2, 3, 1, 2, 3, 1, 2, 3]




-자료구조변환 - 캐스팅

.문자열 -> 리스트 1



문자열변수.split()

문자열의 공백을 기준으로 리스트 처리

myStr = '안녕 무궁화 미나리'
myList = myStr.split()
print(myList, type(myList))
결과 : ['안녕', '무궁화', '미나리'] <class 'list'>




문자열변수.split(구분자)

문자열의 구분자를 기준으로 리스트 처리

myStr = '안녕/무궁화/미나리'
myList = myStr.split('/')
print(myList, type(myList))
결과 : ['안녕', '무궁화', '미나리'] <class 'list'>



.문자열 -> 리스트 2

list(문자열)

문자열 안에 등록되어있는 글자,공백..등 모두 분리되어 요소로 등록

myStr = '안녕 무궁화 미나리'
myList = list(myStr)
print(myList, type(myList))
결과 : ['안', '녕', ' ', '무', '궁', '화', ' ', '미', '나', '리'] <class 'list'>




.리스트 -> 문자열 1

str(리스트이름)

myList = ['김','이','박']
print(str(myList),type(str(myList)))
결과 : ['김', '이', '박'] <class 'str'>



.리스트 -> 문자열 2

'구분자'.join(리스트)


myList = ['김','이','박']
result = ' '.join(myList)
print(result,type(result))
결과 : 김 이 박 <class 'str'>



-리스트 요소 정렬하기

조건 : 리스트요소의 데이터형이 같아야한다.

리스트 이름.sort()

myNumbers = [1,100,67,50,40]
myNumbers.sort()
print(myNumbers)
결과 : [1, 40, 50, 67, 100]


리스트 이름.reverse()

myNumbers = [1,100,67,50,40]
myNumbers.reverse()
print(myNumbers)
결과 : [40, 50, 67, 100, 1]





-요소값이 몇개 들어가 있는가?

리스트이름.count(요소의 값)

myNumbers = [1,100,67,50,40,67,67]
n = myNumbers.count(67)
print(n)
결과 : 3





-2차원 리스트 정의
1차원 리스트로 구성 -> 2차원으로 조합


userName = ['홍길동','춘향이','심청이']
userAge = [20,17,16]
userGender = ['남','여','여']

print(userName,userAge,userGender)

★ userList = [userName,userAge,userGender]

print(userList)

print(userList[0][1])
결과 : 춘향이
print(userList[1][2])
결과 : 16
print(userList[2][0])
결과 : 남






-튜플(Tuple)

튜플 구조 정의 1

  튜플이름 = ('아이템값1',....)

t1 = ('도','레','미','파','솔')
print(t1,type(t1))
결과 : ('도', '레', '미', '파', '솔') <class 'tuple'>


튜플 구조 정의 2
  
  튜플이름 = 아이템값1, 아이템값2 ....

t2 = 1,2,3,4,5
print(t2,type(t2))
결과 : (1, 2, 3, 4, 5) <class 'tuple'>



-튜플 인덱싱

  튜플이름[위치번호]

t1 = '도','레','미','파','솔'
print(t1[1])
결과 : 레



-튜플 슬라이싱

t1 = '도','레','미','파','솔'
print(t1[0:3])
결과 : ('도', '레', '미')



-튜플 편집방식
삭제,변경은 불가능

추가는 가능
튜플이름 += (값1,값2,...) ->문자도 가능

하나만 추가할 경우 (값1, ) -> , 무조건 있어야함



-튜플 함수 적용

1.요소의 반복값 확인
튜플이름.count()

t1 = (100,50,30,30,30)
print(t1.count(30))
결과 :3



2.튜플은 sort를 사용x
왜냐하면 변경이 불가하기 때문이다.



3.튜플 전체의 길이


t1 = (100,50,30,30,30)
print(len(t1))
결과 : 5




4.요소의 위치값

튜플변수.index(요소)





-자료구 변환

.문자열 -> 튜플


tuple(문자열 변수or값)


myStr = 'python'
myTuple = tuple(myStr)
print(myTuple,type(myTuple))
결과 : ('p', 'y', 't', 'h', 'o', 'n') <class 'tuple'>




.리스트 -> 튜플


tuple(리스트이름)

myList = ['수학','과학','영어','국어']
myTuple = tuple(myList)
print(myTuple,type(myTuple))
결과 : ('수학', '과학', '영어', '국어') <class 'tuple'>




.튜플 -> 리스트


list(튜플이름)

myTuple = (100,50,30,30,30)
myList = list(myTuple)
print(myList,type(myList))
결과 : [100, 50, 30, 30, 30] <class 'list'>




.튜플 -> 문자열 1

str(튜플이름)

myTuple = ('도','레','미','파','솔')
myStr = str(myTuple)
print(myStr,type(myStr))
결과 : ('도', '레', '미', '파', '솔') <class 'str'>





.튜플 -> 문자열 2

'구분자'.join(튜플이름)

myTuple = ('도','레','미','파','솔')
myStr = ','.join(myTuple)
print(myStr,type(myStr))
결과 : 도,레,미,파,솔 <class 'str'>
  File "<ipython-input-7-25c386094d47>", line 1
    문자열 변수
         ^
SyntaxError: invalid syntax
```