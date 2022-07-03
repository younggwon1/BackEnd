```python
# 파일 읽기
# 파일변수 = open('파일경로', 'r')
#  예) f = open('data/yesterday.txt','r')

# 파일에 관련된 함수 - 파일변수.함수()
# 파일변수.read() -> 문자열
# 파일변수.readline() -> 문자열
# 파일변수.readlines() -> 리스트
# 파일변수.write()

# 파일변수.write(데이터)

# with 문 - 별도의 close()를 사용하지 않아도 된다. 
# with 문안에 들여쓰기 주의
# with open(파일경로, 모드(r,w,a), (인코딩) ) as 파일변수:
#     명령문

'''
f = open('data/yesterday.txt','r')
data = f.read()
print(data)
f.close()
'''

# with 문으로 파일을 읽고 한줄만 출력하기
print('-'*30)
with open('data/yesterday.txt','r') as f:
    data = f.read()
    print(data)

# with 문으로 파일을 읽고 리스트로 변환하기
print('-'*30)
with open('data/yesterday.txt','r') as f:
    data_list = f.readlines()
    print(data_list, type(data_list))
    # 리스트 출력하기
    cnt = 1
    for line in data_list:
        print(cnt, '번째 라인', line, end='') # end = ''는 중간에 공백이 없어지게 하는 용어
        cnt += 1

# with 문으로 빈 파일 만들기
print('-'*30)
with open('data/result_0803.txt','w') as f:
    pass # pass는 명령문을 실행하지 않겠다는 뜻

# with 문으로 파일 생성 후 문자열 저장하기
print('-'*30)
fruits = ['바나나\n','사과\n','포도\n']
with open('data/result_0803.txt','w') as f:
    f.write('오늘은 금요일 ...\n 내일은 토요일')
    msg = '\n\n 모레는 일요일'
    f.write(msg)
    # 리스트 출력하기
    for line in fruits:
        f.write(line)
    
# 외부 텍스트 파일을 새로운 파일에 저장하기
print('-'*30)
# 데이터 읽기
with open('data/yesterday.txt','r') as f:
    data = f.read() # 문자열

# 데이터 쓰기
print('-'*30)
with open('data/result_ys.txt','w') as f:
    f.write(data)
# 복사 붙여넣기라고 생각하면 됨

# 퀴즈
'''
yesterday.txt 파일에서 1번째줄만 result.txt 
파일에 저장하여라
'''
# 첫번째 방법
# 데이터읽기
with open('data/yesterday.txt','r') as f:
      data = f.readline()
      print(data)
# 데이터쓰기
with open('data/result.txt','w') as f:
    f.write(data)

# 두번째 방법
# 데이터읽기
with open('data/yesterday.txt','r') as f:
    data = f.readlines() # 리스트
    print('첫번째 리스트 출력 : ', data[0])
# 데이터쓰기
with open('data/result.txt','w') as f:
    f.write(data[0])

# 기존 파일에 내용 추가하기
# open(파일경로.'a') - append
with open('data/result.txt','a') as f:
    f.write('\n\n 새로운 내용 추가 ')

f2 = open('data/result.txt','a')
f2.write('\n\n 새로운 내용 추가 ')
f2.close()

# 퀴즈
'''
구구단을 gugu.txt에 결과물 출력한다. 

알고리즘
f.write(바로int가 못들어가고
텍스트이여야 들아감 - >문자열변수, 문자열, 리스트요소(list[0]))

1) 빈 리스트 출력 - result = []
2) 구구단 출력 값 -> 리스트
   result.append() 
   - 데이터 값이 정수 -> str(데이터) -> 문자열
3) 파일 출력하기
   파일 생성 후
   for i in result:
       f.write(i) 
'''
print('-'*30)
with open('data/gugu.txt','w') as f:
    f.write('\n\n 파일이 생성되었습니다 \n\n' )
# 빈 리스트 출력
result = []

# 구구단
for i in range(2, 10):
    for j in range(1,10):
        # 리스트 요소 생성
        data = \
           str(i) + ' x '+ str(j)+' = ' \
           + str(i*j)+str('\n')
        # 리스트 추가
        result.append(data)

# 파일에 저장
with open('data/gugu.txt','a') as f:
    for line in result:
        f.write(line)
    print('파일 출력 완료')
```



```python
# 함수 < 클래스 < 모듈 < 패키지
# 함수안에는 실행문 + 변수 + 리스트 ... 
# 클래스안에는 변수 개념을 속성으로 지정
#             함수 개념을 메소드로 지정 
#             메소드의 집합 (함수의 집합)
# 모듈 파일간의 함수, 클래스 참조 가능
# 패키지는 모듈의 집합


# 클래스 생성
# 클래스 선언
# class 클래스이름:
#    명령문

# square 클래스 선언
# 가로와 새로 속성
# def __init__(self,속성1):
#    self.속성1 = 속성

class square:
    def __init__(self,width,height):
        self.width = width
        self.height = height

# 클래스 타입
print(type(square))

# 인스턴스 만들기
# 인스턴스에서 속성값 부여
# 인스턴스이름 = 클래스이름(속성값1,속성값2...)
s1 = square(100, 100)
s2 = square(300, 300)
print(type(s1))
# <class '__main__.square'>
print(' width : {}, height : {}' \
.format(s1.width,s1.height))
# width : 100, height : 100
print(' width : {}, height : {}' \
.format(s2.width,s2.height))
# width : 300, height : 300

# car 클래스 만들기
class car:
    # 속성 만들기
    def __init__(self,brand,name,color,year):
        self.brand = brand
        self.name = name
        self.color = color
        self.year = year
# 인스턴스 생성 및 속성값 부여
car1 = car('현대','스타렉스','회색','2010')
car2 = car('기아','레이','블랙','2016')
# 인스턴스이름.속성으로 값 표시
print('car1 : {}, {}, {}, {} ' \
.format(car1.brand,car1.name,car1.color,car1.year))
print('car2 : {}, {}, {}, {} ' \
.format(car2.brand,car2.name,car2.color,car2.year))

# 퀴즈
# 주변에서 볼 수 있는 사물로 클래스를 선언하고
# 인스턴스화 시켜서 출력한다

class phone:
    def __init__(self,brand,name,color,year):
        self.brand = brand
        self.name = name
        self.color = color
        self.year = year
phone1 = phone('애플','아이폰X','검은색','2017')
phone2 = phone('삼성','아이폰X','검은색','2017')
```

# method

- def 메소드이름(self,인자):
- 명령문
- return (있을 수도 없을 수도 있다.)

```python
# 사람 클래스
class Person:
    def __init__(self,name,gender,age,job):
        self.name = name
        self.gender = gender
        self.age = age
        self.job = job 
    # 메소드 정의
    def walk(self):
        print('걷는다.')
    def eat(self):
        print('먹는다.')
        


# 클래스 인스턴스화
p1 = Person('Robert','man',20,'student')
print('\n'*10,'인스턴스 속성 출력')
print('이름은 {}, 성별은 {}, 나이는 {}, 직업은 {}'.format(p1.name,p1.gender,p1.age,p1.job))

# 정의된 메소드 호출하기
# 인스턴스이름.메소드(인자)
p1.walk()
p1.eat()
 인스턴스 속성 출력
이름은 Robert, 성별은 man, 나이는 20, 직업은 student
걷는다.
먹는다.
```



```python
# 사람 클래스
class Person:
    def __init__(self,name,gender,age,job):
        self.name = name
        self.gender = gender
        self.age = age
        self.job = job 
    # 메소드 정의
    def walk(self):
        print('걷는다.')
    def eat(self):
        print('먹는다.')
    def info(self,name,gender,age,job):   
        print('이름은 {}, 성별은 {}, 나이는 {}, 직업은 {}'.format(p1.name,p1.gender,p1.age,p1.job))
    
p1 = Person('Robert','man',20,'student')

p1.info('Robert','man',20,'student')
이름은 Robert, 성별은 man, 나이는 20, 직업은 student
```



```python
# 사각형 클래스 생성 후 사각형의 속성을 출력하는 메소드
# 사각형의 넓이 값을 리턴하는 메소드 정의


class square:
    def __init__(self,width,height):
        self.width = width
        self.height = height
    def info(self,width,height):
        print('사각형의 넓이는 ',width)
        print('사각형의 높이는 ',height)
    def area(self,width,height):
        area = width*height
        return area
s = square(10,20)
s.info(10,20)
print(s.area(10,20))
사각형의 넓이는  10
사각형의 높이는  20
200
```



```python
# 원 클래스 생성 후 타원의 속성을 출력하는 메소드


class circle:
    def __init__(self,radius,diameter):
        self.radius = radius
        self.diameter = diameter
    def info(self,radius,diameter):
        print('원의 반지름은 ',radius)
        print('원의 지름은 ',diameter)
    def area(self,radius,diameter):
        area = radius*radius*3.14
        return area
s = circle(10,20)  #인스턴스화를 시킨다.
s.info(10,20)
print(s.area(10,20))
원의 반지름은  10
원의 지름은  20
314.0
```



```python
# 상속
# 부모 클래스의 속성이랑 메소드를 그대로 가진다.
# class 클래스이름(부모 클래스이름1,부모 클래스이름2,...)

# 부모 클래스 정의
class phone:
    # 속성 정의
    def __init__(self,kind):
        self.kind = kind
    def info(self,kind):
        print(' 종류  : ',kind)

# 부모 클래스를 상속받는 자식 클래스 정의
class mobile(phone):
    pass

# 자식 클래스 인스턴스화
m = mobile('모바일폰')
m.info('스마트폰') 
print(m.kind)
 종류  :  스마트폰
모바일폰
```



```python
# 부모 클래스 정의
class phone:
    # 속성 정의
    def __init__(self,kind):
        self.kind = kind
    def info(self,kind):
        print(' 종류  : ',kind)

class internet:
    # 속성 정의
    def __init__(self,wifi):
        self.wifi = wifi
    def info(self,wifi):
        print(' 인터넷 종류  : ',wifi)


# 부모 클래스를 상속받는 자식 클래스 정의
class mobile(phone,internet):
    def __init__(self,kind,wifi):
        self.kind = kind
        self.wifi = wifi

# 자식 클래스 인스턴스화
m = mobile('모바일폰','sk')
m.info('스마트폰') 
print(m.kind)
print(m.wifi)
 종류  :  스마트폰
모바일폰
sk
```



```python
# 부모 클래스 정의
class Inh1:
    # 속성 정의
    def __init__(self,kind1,kind2):
        self.kind1 = kind1
        self.kind2 = kind2
    def info(self,kind1,kind2):
        print(' 상속 받을 것의 종류  : ',kind1,kind2)

class Inh2:
    # 속성 정의
    def __init__(self,kind3,kind4):
        self.kind3 = kind3
        self.kind4 = kind4
    def info(self,kind3,kind4):
        print(' 상속 받을 것의 종류  : ',kind3,kind4)


# 부모 클래스를 상속받는 자식 클래스 정의
class accept(Inh1,Inh2):
    def __init__(self,kind1,kind2,kind3,kind4):
        self.kind1 = kind1
        self.kind2 = kind2
        self.kind3 = kind3
        self.kind4 = kind4

# 자식 클래스 인스턴스화
m = accept('아파트','차','오피스텔','전동스쿠터')
print(m.kind1,m.kind2,m.kind3,m.kind4)
아파트 차 오피스텔 전동스쿠터
```



```python
# 함수의 종류
# - 내장함수
#     : import 명령없이 사용할 수 있는 함수
#     : import 명령이 있어야 사용할 수 있는 함수
# - 사용자 정의 함수
#      def 명령으로 정의하는 함수

# abs(숫자) : 절대값 추출
# divmod(숫자1,숫자2) : 몫과 나머지값을 튜플구조로 추출
# eval(data) : 문자열을 수식으로 처리
data = input('계산식을 입력하세요')
result = eval(data)
print(data,result)

print('-'*40)
# max(data(리스트,튜플,....)) : data 중에서 최대값을 출력
print(max([3,5,6,8,201,230,32,1]))

print('-'*40)
# min(data(리스트,튜플,....)) : data 중에서 최소값을 출력
print(min([3,5,6,8,201,230,32,1]))

print('-'*40)
# enumerate(data(리스트,튜플,....),시작번호) : 색인을 부여한다.
mylist = ['apple','banana','pinapple','lemon']
for index, value in enumerate(mylist,1):
    print(index,value)

print('-'*40)
# map(정의된 함수,data(리스트,튜플,....)) : 각 원소마다 함수가 호출되어 리턴값이 변함
# map 오브젝트 생성 -> list화 시킨다.
def power_fn(value):
    return value**2
print(list(map(power_fn, [1,2,3,4,5])))

print('-'*40)
계산식을 입력하세요4*5
4*5 20
----------------------------------------
230
----------------------------------------
1
----------------------------------------
1 apple
2 banana
3 pinapple
4 lemon
----------------------------------------
[1, 4, 9, 16, 25]
----------------------------------------
```



```python
# isalpha() : 문자열안에 숫자가 아닌 글자가 들어가면 True
# isdigit() : 문자열안에 숫자만으로 되어있으면 True

str1 = '가나다'  #문자
str2 = '1234'   #숫자문자
print(str1.isalpha())
print(str1.isdigit())
print(str2.isalpha())
print(str2.isdigit())

print('-'*40)

# filter(함수명,data(리스트))) : 리스트 요소 중에서 함수 조건에 맞는 것만 필터링
# 리스트화 시킨다

def judge_fn(value):
    return value % 2 ==0    # 짝수만 출력
print(list(filter(judge_fn, [1,2,3,4,5])))

print('-'*40)

# zip() :여러개의 리스트나 튜플 또는 순차 자료형을 짝지음
actor = ['정우성','나나']
gender = ['남','여']
for i,j in zip(actor,gender):
    print(i,'-',j)
print(list(zip(actor,gender)))   #리스트 안에 튜플스타일로 저장

print('-'*40)
True
False
False
True
----------------------------------------
[2, 4]
----------------------------------------
정우성 - 남
나나 - 여
[('정우성', '남'), ('나나', '여')]
----------------------------------------
```