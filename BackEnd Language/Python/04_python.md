# continue문

- 실행문을 실행하지 않고 다음 명령문을 실행한다.

```python
a = 0
while a < 10:
    a = a+1
    if a % 2 == 0: continue
    print(a)
1
3
5
7
9
```

# end = ' ' 은 옆으로 출력되게 한다.

```python
a = 0
while a < 10:
    a = a+1
    if a % 2 == 0: continue
    print(a,end = '')
13579
```

# range함수

- range(초기값,마지막값,step)

```python
print(range(10))

range(0, 10)
```



```python
myList = list(range(3,10,3))

print(myList)
[3, 6, 9]
```

# 1~50까지 3의 배수만 출력

```python
myList = list(range(3,50,3))

print(myList)
[3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48]
```

# for문

- for 변수 in range(초기값,마지막값,step):

```python
sum = 0
for i in range(1, 11):
    sum = sum + i
   
    print(sum)
    
1
3
6
10
15
21
28
36
45
55
```

# for문과 list 내포

```python
mylist = [num*3 for num in range(1,6)]
print(mylist)
[3, 6, 9, 12, 15]
```



# for 변수 in 리스트,튜플,문자  열,range(start,end,step):

- 실행명령

```python
for i in range(3):
    print(i,'hello')
    
0 hello
1 hello
2 hello
```



```python
for i in range(1,4):
    print(i,'hello')
    
1 hello
2 hello
3 hello
```



```python
cnt = 1
for i in ['a','b','c']:
    print('요소 {}  :  {}'.format(cnt,i))
    cnt += 1
요소 1  :  a
요소 2  :  b
요소 3  :  c
```



```python
mytuple = ('과자','라면','김밥')
for t in mytuple:
    print(t,end = ' ')

print('\n','*'*40)
과자 라면 김밥 
 ****************************************
```



# 리스트에서 최대값 출력

```python
mylist = [50,44,100,30,1]
result = mylist[0]

for i in mylist:
    if result < i:
        result = i
print('최대값 : ',result)
최대값 :  100
```

# 리스트에서 최소값 출력

```python
mylist = [50,44,100,30,1]
result = mylist[0]

for i in mylist:
    if result > i:
        result = i
print('최소값 : ',result)
최소값 :  1
```

# 중첩 for문

```python
for i in range(5):
    print(i)
    for j in range(3):
        print(j,'****')
0
0 ****
1 ****
2 ****
1
0 ****
1 ****
2 ****
2
0 ****
1 ****
2 ****
3
0 ****
1 ****
2 ****
4
0 ****
1 ****
2 ****
```

# 함수

- 명령문의 조합
- 함수 < 클래스 < 모듈 < 패키지

# 함수정의 문법

- def 함수명(입력 인수):
- 수행할 명령문
- return 문

# 함수의 종류

# 1.입력 인수x,return x

```python
def printpy():
    print('python '*3)
printpy()

python python python 
```

# 2.입력 인수o,return x

```python
def sum(a,b):
    print('두 수의 합은 {}'.format(a+b))

sum(12,34)
두 수의 합은 46
```

# 3.입력 인수o,return o

```python
def minus(a,b):
    return a-b
result = minus(100,50)
print(result)
50
```

# 결과값이 여러개일 때

```python
def sum_mul1(a,b):
    return a+b, a*b
print(sum_mul1(3,5))
(8, 15)
```



```python
a = int(input('숫자를 입력하세요'))    

def gugudan(a):
    for i in range(1,10):
        print(a*i)
gugudan(a)
숫자를 입력하세요4
4
8
12
16
20
24
28
32
36
```



```python
a = str(input('값 입력하세요'))
b = int(input('숫자를 입력하세요'))
c = int(input('숫자를 입력하세요'))


def di(a,b,c):
    if a == 'c1':
        print(b+c)
    if a == 'c2':
        print(b-c)
    if a == 'c3':
        print(b*c)
    if a == 'c4':
        print(b/c)
di(a,b,c)
값 입력하세요c2
숫자를 입력하세요6
숫자를 입력하세요2
4
```

# 가변 인자 함수

# 가변인자 *인자명

- def 함수명(*인자):
- 명령문
- return

```python
def print_n(*value):
    for i in value:
        print(i,end = ' ')
print_n('python')
print_n(100,200,300)
print_n('victory','sunday')
python 100 200 300 victory sunday 
```



```python
def sum_many(*args):
    sum = 0
    for i in args:
        sum = sum+i
    return sum
print(sum_many(1))
print(sum_many(2,5,3))
1
10
```

# 전역변수 선언

- 함수안에 global 변수
- 함수 블록 밖에서도 같은 변수일때 영향을 끼친다.

```python
a = 5
print(a)
def test():
    global a
    a = 10
    print(a)
test()
print(a)
5
10
10
```

# lambda 함수

- 함수변수 = lambda 인자리스트:표현식

```python
f = lambda x,y:x+y
print(f(4,4))
8
```



```python
f = lambda x:x**2
print(f(8))
64
```

# 파일 읽기

- 파일변수 = open("파일경로",'r')

# 첫번째 줄만 출력하기

- 변수 = 파일변수.readline()

```python
f = open("data/yesterday.txt",'r')
data = f.readline()
print(data)
print(type(data))
Yesterday 

<class 'str'>
```

# 리스트로 변경하기

- 리스트이름 = 파일변수.read()

```python
f = open("data/yesterday.txt",'r')
data = f.read()
print(data)
print(type(data))
print(data[0:9])
Yesterday 
All my troubles seemed so far away
Now it looks as though they're here to stay
Oh, I believe in yesterday

Suddenly
I'm not half the man I used to be
There's a shadow hanging over me
Oh, yesterday came suddenly

Why she had to go,
I don't know She wouldn't say
I said something wrong
Now I long for yesterday

Yesterday
Love was such an easy game to play
Now I need a place to hide away
Oh, I believe in yesterday

Why she had to go,
I don't know She wouldn't say
I said something wrong
Now I long for yesterday

Yesterday
Love was such an easy game to play
Now I need a place to hide away
Oh, I believe in yesterday
Mm mm mm mm mm mm mm mm.....
<class 'str'>
Yesterday
```

# 길이

```python
f = open("data/yesterday.txt",'r')
data = f.read()
myList = data.split()
print(len(myList))
f.close()
134
```

# 리스트이름 = 파일변수.readlines()

- 한줄씩 읽어서 리스트 요소로 저장

```python
f = open("data/yesterday.txt",'r')
data = f.readlines()
print(data,type(data))
f.close()
['Yesterday \n', 'All my troubles seemed so far away\n', "Now it looks as though they're here to stay\n", 'Oh, I believe in yesterday\n', '\n', 'Suddenly\n', "I'm not half the man I used to be\n", "There's a shadow hanging over me\n", 'Oh, yesterday came suddenly\n', '\n', 'Why she had to go,\n', "I don't know She wouldn't say\n", 'I said something wrong\n', 'Now I long for yesterday\n', '\n', 'Yesterday\n', 'Love was such an easy game to play\n', 'Now I need a place to hide away\n', 'Oh, I believe in yesterday\n', '\n', 'Why she had to go,\n', "I don't know She wouldn't say\n", 'I said something wrong\n', 'Now I long for yesterday\n', '\n', 'Yesterday\n', 'Love was such an easy game to play\n', 'Now I need a place to hide away\n', 'Oh, I believe in yesterday\n', 'Mm mm mm mm mm mm mm mm.....'] <class 'list'>
```

# 리스트 요소 단위로 출력하기

```python
f = open("data/yesterday.txt",'r')
data = f.readlines()

for i in data:
    print(i)
f.close()
Yesterday 

All my troubles seemed so far away

Now it looks as though they're here to stay

Oh, I believe in yesterday



Suddenly

I'm not half the man I used to be

There's a shadow hanging over me

Oh, yesterday came suddenly



Why she had to go,

I don't know She wouldn't say

I said something wrong

Now I long for yesterday



Yesterday

Love was such an easy game to play

Now I need a place to hide away

Oh, I believe in yesterday



Why she had to go,

I don't know She wouldn't say

I said something wrong

Now I long for yesterday



Yesterday

Love was such an easy game to play

Now I need a place to hide away

Oh, I believe in yesterday

Mm mm mm mm mm mm mm mm.....
```



```python
# 총 몇줄있는지

f = open("data/yesterday.txt",'r')
data = f.readlines()

for i in data:
    print(i)
print(len(data))
f.close()
Yesterday 

All my troubles seemed so far away

Now it looks as though they're here to stay

Oh, I believe in yesterday



Suddenly

I'm not half the man I used to be

There's a shadow hanging over me

Oh, yesterday came suddenly



Why she had to go,

I don't know She wouldn't say

I said something wrong

Now I long for yesterday



Yesterday

Love was such an easy game to play

Now I need a place to hide away

Oh, I believe in yesterday



Why she had to go,

I don't know She wouldn't say

I said something wrong

Now I long for yesterday



Yesterday

Love was such an easy game to play

Now I need a place to hide away

Oh, I believe in yesterday

Mm mm mm mm mm mm mm mm.....
30
```



```python
# 첫번째줄에 몇개의 글자수가 있는지

f = open("data/yesterday.txt",'r')
data = f.readline()
data = data.replace(' ','')
data = data.replace('\n','')
print(len(data))
f.close()
9
```



```python
# 전체 문장에 단어가 몇개있는지

f = open("data/yesterday.txt",'r')
data = f.read()
myList = data.split()
print(len(myList))
f.close()
134
```

# 파일 생성하기

- 파일변수 = open('파일 경로 및 파일명','w')

```python
f = open("data/test.txt",'w')
f.close()
```

# 파일을 쓰기모드로 열어 출력값 적기

- 파일변수.write(data)
- print문이라고 생각하면 된다.

```python
f = open("data/test.txt",'w')
for i in range(1,11):
    data = "%d 번째 줄입니다.\n"%(i)
    f.write(data)
f.close()
```