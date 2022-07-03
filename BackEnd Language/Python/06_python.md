# 모듈이란?

- 함수, 클래스의 집합
- 별도의 파일(*.py)로 제작

# 모듈의 종류

- 내부 모듈 - 기본적으로 제공
- 외부 모듈 - 설치 후 사용 가능
- 사용자 정의 모듈 - 직접 만든 후 사용 가능

# 모듈 불러오기[¶](#모듈-불러오기)

- import 모듈
- import 모듈 as 모듈변수
- from 모듈 import 모듈함수1,모듈함수2,....

# 내부모듈

```python
# math 모듈

# 모듈안에 함수를 사용할 때에는
# 모듈이름.함수(인자)
import math
print(math.pi)
print(math.sin(10))


import math as m
print(m.pi)

from math import pi,sin,cos
print(math.pi,sin(10),cos(10))
3.141592653589793
-0.5440211108893698
3.141592653589793
3.141592653589793 -0.5440211108893698 -0.8390715290764524
```



```python
# random 모듈

# 랜덤이란? : 난수. 무작위 수 추출
# 0~1 사이 소수점으로 표시
import random
print(random.random())


# 0~n 정수 추출
# random.randrange(n)
print(random.randrange(10))

# random.randrange(start,end,step)
print(random.randrange(51,100,2))
print(random.randrange(51,100,2))
0.7431822293010352
3
73
61
```



```python
# 리스트의 아이템 중 추출
# random.choice([리스트 형태])
print(random.choice(['a','b','c','d','e']))
b
```



```python
# 리스트를 재배열
# random.shuffle(리스트 변수)
list_a = [1,2,3,4,5,6,7]
random.shuffle(list_a)
print(list_a)
[2, 5, 4, 6, 1, 7, 3]
```



```python
# sys 모듈
import sys
print(sys.argv)  # 현재 문서 경로가 표시
print(sys.version)  # 컴퓨터 정보
['c:\\users\\student\\appdata\\local\\programs\\python\\python37\\lib\\site-packages\\ipykernel_launcher.py', '-f', 'C:\\Users\\student\\AppData\\Roaming\\jupyter\\runtime\\kernel-f2242579-9d1b-4d25-8ae6-c7b147dad3c9.json']
3.7.0 (v3.7.0:1bf9cc5093, Jun 27 2018, 04:59:51) [MSC v.1914 64 bit (AMD64)]
```



```python
# os 모듈
import os
print(os.name)
print(os.getcwd()) # 현재 작업 폴더
print(os.listdir()) # 현재 작업 폴더안의 모든 파일 목록
nt
C:\pyclass
['.ipynb_checkpoints', 'data', 'day1_정리.ipynb', 'day2_정리.ipynb', 'day3_정리.ipynb', 'day4_정리.ipynb', 'day5_정리.ipynb', 'day6_정리.ipynb', 'day_1.py', 'day_2.py', 'day_3.py', 'day_4.py', 'day_5.py', 'day_6.py', 'mySum.py', 'test.txt', '__pycache__']
```

# 사용자 정의 모듈

```python
# mySum.py 라는 것을 사용자가 정의함.
# 모듈이름.함수명(인자)
import mySum
print(mySum.sum(10,30))
print(mySum.minus(10,30))
print(mySum.mul(10,30))
print(mySum.div(10,30))
40
-20
300
0.3333333333333333
```



```python
#myYear.py. 라는 것을 사용자가 정의함
import myYear
year = int(input('태어난 년도를 입력하세요'))
myYear.Year(year)
태어난 년도를 입력하세요1994
개
```

# 예외처리

- 에러가 발생했을 시 어떻게 처리를 해야하는가?

```python
# ZeroDivisionError (0으로 나누는 경우 생기는 에러)
print(10/0)
---------------------------------------------------------------------------
ZeroDivisionError                         Traceback (most recent call last)
<ipython-input-12-afb62e08ab2d> in <module>()
      1 # ZeroDivisionError (0으로 나누는 경우 생기는 에러)
----> 2 print(10/0)

ZeroDivisionError: division by zero
```



```python
# 리스트,튜플 구조에서 인덱스가 없는 경우
# IndexError
mylist = [1,2,3]
print(mylist[3])
---------------------------------------------------------------------------
IndexError                                Traceback (most recent call last)
<ipython-input-15-d11bd9caba89> in <module>()
      2 # IndexError
      3 mylist = [1,2,3]
----> 4 print(mylist[3])

IndexError: list index out of range
```



```python
# 파일 오픈 에러
f = open('none.txt','r')
print(f.read())
---------------------------------------------------------------------------
FileNotFoundError                         Traceback (most recent call last)
<ipython-input-17-6d112e9f5a0b> in <module>()
      1 # 파일 오픈 에러
----> 2 f = open('none.txt','r')
      3 print(f.read())

FileNotFoundError: [Errno 2] No such file or directory: 'none.txt'
```

# 문법

# try ... except 문

- try:

- 실행할 명령 -except 에러코드 as e:
- 실행할 명령

```python
try:
    4/0
except ZeroDivisionError as e:
    print(e)
division by zero
```



```python
# 에러무시
# pass 명령 이용
try:
    4/0
except ZeroDivisionError:
    pass
print('오류무시')
오류무시
```



```python
mylist = [1,2,3]
try:
    print(mylist[3])
except IndexError as e:
    print(e)
list index out of range
```

# try ... else 문

try: 명령실행 except 오류 as e: 명령실행 (에러가 있으면) else: 명령실행 (에러가 없으면)

```python
try:
    f = open('foo.txt','r')
except FileNotFoundError as e:
    print(str(e))
else:
    data = f.read()
    f.close()
[Errno 2] No such file or directory: 'foo.txt'
```

# try ... finally 문

try: 명령실행 except 오류 as e: 명령실행 (에러가 있으면) else: 명령실행 (에러가 없으면) finally: 명령실행 (무조건 실행)

```python
try:
    4/0
except ZeroDivisionError as e:
    print(e)
finally:
    print('수행완료')
division by zero
수행완료
```



```python
a = int(input('숫자를 입력하세요'))
b = int(input('숫자를 입력하세요'))
try:
    a/b
except ZeroDivisionError as e:
   print(e) 
else:
    print('숫자1/숫자2 = ',a/b)
finally:
    print('수행완료')
숫자를 입력하세요8
숫자를 입력하세요4
숫자1/숫자2 =  2.0
수행완료
```



```python
a = int(input('숫자를 입력하세요'))
b = int(input('숫자를 입력하세요'))
try:
    a/b
except ZeroDivisionError as e:
   print(e) 
else:
    print('숫자1/숫자2 = ',a/b)
finally:
    print('수행완료')
숫자를 입력하세요4
숫자를 입력하세요0
division by zero
수행완료
```



```python
import csv
f = open('data/test.csv','r',encoding='cp949')
csv_data = csv.reader(f)
for line in csv_data:
    print(line)
f.close
['학번', '이름', '나이', '전공']
['2014000111', '홍길동', '20', '금융']
['2014020111', '김삿갓', '22', '통계']
['2015048223', '전현무', '27', '정통']
['2009238371', '이영희', '30', '언론']
['2013048711', '송아리', '25', '신소재']
```

```python
<function TextIOWrapper.close()>
```



```python
# with문으로 변경하기
import csv
with  open('data/test.csv','r',encoding='cp949') as f:
     csv_data = csv.reader(f)
     for line in csv_data:
          print(line)
f.close

  
['학번', '이름', '나이', '전공']
['2014000111', '홍길동', '20', '금융']
['2014020111', '김삿갓', '22', '통계']
['2015048223', '전현무', '27', '정통']
['2009238371', '이영희', '30', '언론']
['2013048711', '송아리', '25', '신소재']
```



```python
<function TextIOWrapper.close()>
```



```python
# csv 파일 출력
# 리스트 -> csv 파일로 출력
# 리스트 요소 아이템이 한행씩 입력된다
# csv 라인변수 = csv.writer(파일변수)
# csv 라인변수.writerow(데이터)
import csv
f = open('data/output.csv','w',encoding='cp949')
wr = csv.writer(f)
wr.writerow([1,'mkblog'])
wr.writerow([2,'co'])
wr.writerow([3,'kr'])
print('파일 출력이 완료되었습니다.')
f.close
파일 출력이 완료되었습니다.
```



```python
<function TextIOWrapper.close()>
```



```python
# for문을 이용하여 리스트에 정의된 아이템을 csv 파일로 저장하기
# 2차원 리스트로 정의
import csv
fruitlist = [[1,'사과','배'],[2,'토마토','방울 토마토'],[3,'바나나','귤']]
f = open('data/output_f.csv','w',encoding='cp949')
wr = csv.writer(f)
for line in fruitlist:
    wr.writerow(line)
f.close
```



```python
<function TextIOWrapper.close()>
```



```python
import csv
f = open('data/population.csv','r',encoding='cp949')
csv_data = csv.reader(f)
csvlist = list(csv_data)
for i in range(1,len(csvlist)):
    print(csvlist[i][0])
f.close
Alabama
Alaska
Arizona
Arkansas
California
Colorado
Connecticut
Delaware
District of Columbia
Florida
Georgia
Hawaii
Idaho
Illinois
Indiana
Iowa
Kansas
Kentucky
Louisiana
Maine
Maryland
Massachusetts
Michigan
Minnesota
Mississippi
Missouri
Montana
Nebraska
Nevada
New Hampshire
New Jersey
New Mexico
New York
North Carolina
North Dakota
Ohio
Oklahoma
Oregon
Pennsylvania
Rhode Island
South Carolina
South Dakota
Tennessee
Texas
Utah
Vermont
Virginia
Washington
West Virginia
Wisconsin
Wyoming
```



```python
<function TextIOWrapper.close()>
```



```python
import csv
f = open('data/population.csv','r',encoding='cp949')
csv_data = csv.reader(f)
csvlist = list(csv_data)
for i in range(1,len(csvlist)):
    print(csvlist[i][1])
f.close
4,780,131
710,249
6,392,301
2,916,025
37,254,522
5,029,324
3,574,114
897,936
601,766
18,804,592
9,688,680
1,360,301
1,567,650
12,831,574
6,484,136
3,046,869
2,853,129
4,339,344
4,533,479
1,328,364
5,773,786
6,547,813
9,884,129
5,303,924
2,968,103
5,988,928
989,414
1,826,334
2,700,691
1,316,461
8,791,953
2,059,198
19,378,110
9,535,688
672,591
11,536,727
3,751,615
3,831,072
12,702,857
1,052,940
4,625,410
814,195
6,346,298
25,146,100
2,763,888
625,741
8,001,041
6,724,545
1,853,011
5,687,289
563,767
```



```
<function TextIOWrapper.close()>
```

# html,css 연동 -> 스크래핑

# html,css 연동,데이터베이스 -> 웹사이트

# html



```python
웹페이지를 제작하는 마크업언어
구조
1. <태그명> 내용 </태그명>
2. <태그명>
   <태그명/> 
1.html 문서 만들기.
2.결과 확인하기 웹브라우저 : [ctrl] + [o]
3.vscode 에서 확인하는 방법 : 라이브러리 설치 Live HTML Previewer
```



```python
h1 ~ h6 : 제목
p : 문단
br : 줄바꿈
div : 블록생성
ul>li :블렛문단(순서 없는 목록 문단)
ol>li : 순서목록 문단(순서 있는 목록 문단)
dl>dt+dd : 정의문단
hr : 수평선
★★★★★ 
img : 이미지 삽입
<img src = "이미지 경로" alt = "대체 텍스트">
★★★
a : 하이퍼링크태그
하이퍼링크 태그안에 글자 삽입
<a href="연결 url target="_blank"></a>
하이퍼링크 태그안에 이미지 삽입
<a href="연결 url target="_blank"><img src="이미지경로"" alt="이미지설명"></a>
```



```python
table 만들기 
table>tr>td+th
tr의 개수에 따라서 행의 수가 결정
tr 안에 있는 td나th 수에 따라서 열의 수가 결정

table 태그안에 들어가는 속성
border는 테두리 굵기
cellpadding는 숫자값이 커질수록 셀안의 여백이 커진다.
cellspacing은 셀과 셀사이의 간격
bordercolor는 테두리 색상을 결정
```



```python
셀 합치기 - td,th 태그안에 속성 삽입
규칙 : 합친 후에 나머지 셀은 삭제나 주석처리
    colspan : 가로합치기
    rowspan : 세로합치기
```