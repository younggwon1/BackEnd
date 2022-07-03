# Dictionary

- 연관배열,해쉬
- key를 통해 value를 얻는다.
- 중괄호로 묶는다.
- 키 값이 같을 경우에는 마지막에 정의한 것만 출력된다.
- 순서가 없다.
- {키1:값1,키2:값2, .....}



```python
dict = {'a':'africa','b':'banana','c':'cat'}
print(dict)
결과
{'a': 'africa', 'b': 'banana', 'c': 'cat'}
```



- 키 값이 같을 경우에는 마지막에 정의한 것만 출력된다.

```python
dict = {'a':'africa','a':'banana','c':'cat'}
print(dict)
결과
{'a': 'banana', 'c': 'cat'}
```

# 딕셔너리 요소 호출

- 딕셔너리이름[키값]

```python
dict = {'a':'africa','b':'banana','c':'cat'}
print('dict1[\'a\'] = ',dict['a'])
결과
dict1['a'] =  africa
```

# 딕셔너리 요소 추가

- 딕셔너리이름[키값] = 값

```python
dict = {'a':'africa','b':'banana','c':'cat'}
dict['d'] = 'drive'
print(dict)
{'a': 'africa', 'b': 'banana', 'c': 'cat', 'd': 'drive'}
```

# 딕셔너리 요소 삭제

- del 딕셔너리이름[키값]

```python
dict = {'a':'africa','b':'banana','c':'cat'}
del dict['a']
print(dict)
{'b': 'banana', 'c': 'cat'}
```

# 딕셔너리 요소 모두 삭제하기

- 딕셔너리이름.clear()

```python
dict = {'a':'africa','b':'banana','c':'cat'}
dict.clear()
print(dict)
{}
```

# 딕셔너리 요소중에서 키값만 모아서 재정의하기

- 딕셔너리이름.keys()
- 키값만 재정의

```python
dict1 = {'name':'홍길동','address':'강남구','phone':'010-0000-0000'}
print(dict1.keys())
dict_keys(['name', 'address', 'phone'])
```

# 딕셔너리 요소중에서 값만 모아서 재정의하기

- 딕셔너리이름.values()

```python
dict1 = {'name':'홍길동','address':'강남구','phone':'010-0000-0000'}
print(dict1.values())
dict_values(['홍길동', '강남구', '010-0000-0000'])
```

# 딕셔너리 요소중에서 키값,값을 모아서 재정의하기

- 딕셔너리이름.items()

```python
dict1 = {'name':'홍길동','address':'강남구','phone':'010-0000-0000'}
print(dict1.items())
dict_items([('name', '홍길동'), ('address', '강남구'), ('phone', '010-0000-0000')])
```

# 딕셔너리 -> 문자열

- str(딕셔너리이름)

```python
dict1 = {'name':'홍길동','address':'강남구','phone':'010-0000-0000'}
print(str(dict1),type(str(dict1)))
{'name': '홍길동', 'address': '강남구', 'phone': '010-0000-0000'} <class 'str'>
```

# 키값만 모아서 문자열로 저장

- '구분자'.join(딕셔너리이름)

```python
dict1 = {'name':'홍길동','address':'강남구','phone':'010-0000-0000'}
myStr = ' '.join(dict1)
print(myStr)
name address phone
```

# 딕셔너리 -> 리스트

- list(딕셔너리이름)

```python
dict1 = {'name':'홍길동','address':'강남구','phone':'010-0000-0000'}
dict_list = list(dict1)
print(dict_list)
['name', 'address', 'phone']
```

# 딕셔너리 -> 튜플

- tuple(딕셔너리이름)

```python
dict1 = {'name':'홍길동','address':'강남구','phone':'010-0000-0000'}
t_list = tuple(dict1)
print(t_list)
('name', 'address', 'phone')
```

# 집합

### 정의 1

- 집합이름 = set(리스트)
- 중복값은 하나만 나온다.(중복허용x)
- 순서가 없다.

```python
set1 = set([1,2,3,3,5])
print(set1)
{1, 2, 3, 5}
```

### 정의 2

- 집합이름 = set(문자열)

```python
set2 = set('banana')
print(set2,type(set2))
{'a', 'n', 'b'} <class 'set'>
```

### 정의 3

- 집합이름 = set(튜플)

```
set3 = set((1,2,3,4,5,66))
print(set3, type(set3))
{1, 2, 3, 4, 5, 66} <class 'set'>
```

# 집합 연산

# 합집합

- 문법1 : 집합1 | 집합2
- 문법2 : 집합1.union(집합2)

```python
set1 = set(['a','b','c','d'])
set2 = set(['a','b','c','d','f','g','h','e'])
print('set1 + set2 = ',set1|set2)
print('set1 + set2 = ',set1.union(set2))
set1 + set2 =  {'f', 'c', 'b', 'e', 'a', 'd', 'h', 'g'}
set1 + set2 =  {'f', 'c', 'b', 'e', 'a', 'd', 'h', 'g'}
```

# 교집합

- 문법1 : 집합1 & 집합2
- 문법2 : 집합1.intersection(집합2)

```python
set1 = set(['a','b','c','d'])
set2 = set(['a','b','c','d','f','g','h','e'])
print('set1 & set2 = ',set1&set2)
print('set1 & set2 = ',set1.intersection(set2))
set1 & set2 =  {'a', 'd', 'b', 'c'}
set1 & set2 =  {'a', 'd', 'b', 'c'}
```

# 차집합

- 문법1 : 집합1 - 집합2
- 문법2 : 집합1.difference(집합2)

```python
set1 = set(['a','b','c','d','g'])
set2 = set(['a','b','c','d','f','h','e'])
print('set1 - set2 = ',set1-set2)
print('set1 - set2 = ',set1.difference(set2))
set1 - set2 =  {'g'}
set1 - set2 =  {'g'}
```

# 집합 요소 추가하기

- 집합이름.add(값)

```python
set_name = set(['김씨','이씨','박씨','홍씨'])
print(set_name)
set_name.add('황씨')
print(set_name)
{'김씨', '박씨', '이씨', '홍씨'}
{'이씨', '황씨', '박씨', '김씨', '홍씨'}
```

# 집합 요소 여러개 추가하기

- 집합이름.update([값1,값2,값3,....])

```python
set_name = set(['김씨','이씨','박씨','홍씨'])
print(set_name)
set_name.update(['황씨','선우씨','정씨'])
print(set_name)
{'김씨', '박씨', '이씨', '홍씨'}
{'이씨', '황씨', '선우씨', '정씨', '박씨', '김씨', '홍씨'}
```

# 집합 요소 삭제하기

- 집합이름.remove(값)

```python
set_name = set(['김씨','이씨','박씨','홍씨'])
print(set_name)
set_name.remove('박씨')
print(set_name)
{'김씨', '박씨', '이씨', '홍씨'}
{'김씨', '이씨', '홍씨'}
```

# 집합 -> 리스트

- list(집합이름)

```python
set_name = set(['김씨','이씨','박씨','홍씨'])
print(set_name)
list_set = list(set_name)
print(set_name,type(list_set))
{'김씨', '박씨', '이씨', '홍씨'}
{'김씨', '박씨', '이씨', '홍씨'} <class 'list'>
```

# if문

- 들여쓰기★★★
- if 조건문:
- 수행할 문장1
- 수행할 문장2
- 수행할 문장3



```python
if True:
    print('조건제어문')
조건제어문
```



```python
a = 11
b = 10

if a>b:
    print('a는b보다 큽니다')

if a<b:  
    print('a는b보다 작습니다')
    
a는b보다 큽니다
```



```python
a = 1
b = 10

if a>b:
    print('a는b보다 큽니다')

if a<b:  
    print('a는b보다 작습니다')
    
a는b보다 작습니다
```



# 조건식에서 False가 되는 조건 :0



```python
money = 0
if money:
    print('택시를 타고')
print('가자')

가자
```



# 조건식에서 True 되는 조건 : 1,0빼고 나머지 숫자



```python
money = 1
if money:
    print('택시를 타고')
print('가자')

택시를 타고
가자
```

# if else 문

- if 조건문:
- 수행할 문장1
- 수행할 문장2
- 수행할 문장3
- else:
- 수행할 문장1
- 수행할 문장2
- 수행할 문장3



```python
money = 1
if money:
    print('택시를 타고 가라')
else:
    print('걸어가라')
택시를 타고 가라
```



```python
money = 0
if money:
    print('택시를 타고 가라')
else:
    print('걸어가라')
걸어가라
```



# elif문(else if문과 동일)

- if 조건1:
- 조건1이 참일때 실행할 명령문
- elif 조건2:
- 조건2가 참일때 실행할 명령문
- else:
- 거짓일때 실행할 명령문



```python
num = input('숫자를 입력하세요')

num1 = int(num)

if num1%2==0:
    print('짝수입니다')
else:
    print('홀수입니다')
    
숫자를 입력하세요 123
홀수입니다
```



```python
myNum = -5

if myNum>0:
    print('양수입니다.')
elif myNum<0:
    print('음수입니다.')
else:
    print('0입니다.')
    
음수입니다.
```



```python
age = int(input('나이를 입력하세요'))


if age>=19:
    print('성인입니다.')
elif 17<=age<=19:
    print('고등학생입니다.')
elif 14<=age<=16:
    print('중학생입니다.')
elif 8<=age<=13:
    print('초등학생입니다.')
else:
    print('유아입니다.')
    
나이를 입력하세요 123
성인입니다.
```



# in 연산자

- 결과값이 True / False
- item in Group

# 문자가 문자열에 있는가?



```python
print('a' in 'banana')

print('a' in 'python')

True
False
```

# 아이템 리스트에 있는가?



```python
userName = ['홍길동','김삿갓','트와이스']
print('홍길동' in userName)

print('신데렐아' in userName)

True
False
```

# 아이템이 튜플에 있는가?



```python
userName = ('홍길동','김삿갓','트와이스')
print('홍길동' in userName)

print('신데렐아' in userName)

True
False
```

# 아이템이 집합에 있는가?



```python
userName = {'홍길동','김삿갓','트와이스'}
print('홍길동' in userName)
print('아이템' in userName)
True
False
```

# not in 연산자

- 결과값이 True / False
- item not in Group
- 그룹안에 없으면 true



```python
print('a' not in 'banana')

print('a' not in 'python')

False
True
```

# if문에 in 연산자 사용하기



```python
myList = ['바나나','포도','수박']

if '바나나' in myList:
    print('바나나가 리스트에 있다')
else:
    print('바나나가 리스트에 없다')
          
바나나가 리스트에 있다
```



# 시간과 관련된 모듈 임포트

- import datetime
  - 시간 전체에 관련된 변수 설정.
  - 현재 년도 월 일 시간이 표시됨.

```python
import datetime
now = datetime.datetime.now()
print(now)
2018-08-01 17:38:39.969000
```



# 요일찍기

- today = datetime.datetime.today().weekday()



# 반복문



```python
 while문
- while 조건:
-   실행할 명령문
```



```python
무한루프
while True:
    print('python')
```



```python
while 조건:
      실행할 명령문
      False 조건
```



```python
treeHit = 0
while treeHit<10:
    treeHit += 1
    print('나무를 %d 번 찍었다'%(treeHit))
    if treeHit == 10:
        print('나무가 넘어간다')
        
나무를 1 번 찍었다
나무를 2 번 찍었다
나무를 3 번 찍었다
나무를 4 번 찍었다
나무를 5 번 찍었다
나무를 6 번 찍었다
나무를 7 번 찍었다
나무를 8 번 찍었다
나무를 9 번 찍었다
나무를 10 번 찍었다
나무가 넘어간다
```

# break문

- 반복문의 블록을 탈출할때 쓰인다.(무한루프를 빠져나가야함)



```python
while True:
    if 블록을 빠져나갈 조건:
        break
```



```python
while True:
    ans = input('아무값이나 입력. 종료시 x')
    if ans == 'x':
        break
print('입력종료')
아무값이나 입력. 종료시 xx
입력종료
```



```python
coffee = 10
money = 300

while money:
    print('돈을 받았으니 커피를 줍니다.')
    coffee = coffee-1
    print("남은 커피의 양은 %d개 입니다"%(coffee))
    if coffee==0:
        print('커피가 다 떨어졌습니다.')
        break
print('입력종료')
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 9개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 8개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 7개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 6개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 5개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 4개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 3개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 2개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 1개 입니다
돈을 받았으니 커피를 줍니다.
남은 커피의 양은 0개 입니다
커피가 다 떨어졌습니다.
입력종료
```