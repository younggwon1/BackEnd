```python
# html에서 파이썬 연동 문법
- {{변수}}

- {% include '파일경로' %}

- {% if 조건 %}
        실행문1
  {% else %}
        실행문2
  {% endif %}

- {% for 변수 in range(시작값,끝) %}
        실행문
  {% endfor %}

- 상속 : 부모파일의 코딩소스를 그대로 복사 
{% extends '부모파일경로' %}
```



```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  if_else_main.html로 연결 
@app.route("/")
def home():
    return render_template('if_else_main.html')

# 라우팅 - score 값 전달하기
# http://127.0.0.1:5000/score/정수값
@app.route("/score/<score>")
def score(score):
    return score
    


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
```

# flask if문

```python
python

# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  if_else_main.html로 연결 
@app.route("/")
def home():
    return render_template('if_else_main.html')

# 라우팅 - score 값 전달하기
# http://127.0.0.1:5000/score/정수값
@app.route("/score/<score>")
def score(score):
    #return score
    return render_template('if_else_result.html',score=score)


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
    
html

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    
    <title>if_else_result.html</title>
</head>
<body>
    <p>
        score : {{ score }}
    </p>
    <p>
        <!-- score 값에 따라 조건문 실행 
        {% if 조건 %}
        실행문1
        {% else %}
        실행문2
        {% endif %}
        -->

        {% if score == '100' %}
        <span>100</span>
        {% else %}
        <span>100이 아닙니다.</span>
        {% endif %}


    </p>
</body>
</html>
```



```python
링크를 걸어서 창에 띄우기

# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  if_else_main.html로 연결 
@app.route("/")
def home():
    return render_template('if_else_main.html')

# 라우팅 - score 값 전달하기
# http://127.0.0.1:5000/score/정수값
@app.route("/score/<score>")
def score(score):
    #return score
    return render_template('if_else_result.html',score=score)


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
    

if_else_main.html
    
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">

    <title>if_else_main.html</title>
</head>
<body>
    <h1>
        if 조건문 이용하기
    </h1>
    <ul>
        <li><a href="/score/100">값이 100일 때</a></li>
        <li><a href="/score/50">값이 50일 때</a></li>
        <li><a href="/score/10">값이 10일 때</a></li>
    </ul>
</body>
</html>



if_else_result.html

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    
    <title>if_else_result.html</title>
</head>
<body>
    <p>
        score : {{ score }}
    </p>
    <p>
        <!-- score 값에 따라 조건문 실행 
        {% if 조건 %}
        실행문1
        {% else %}
        실행문2
        {% endif %}
        -->

        {% if score == '100' %}
        <span>100</span>
        {% elif score =='50' %}
        <span>50</span>
        {% else %}
        <span>50도 아니고 100도 아닙니다.</span>
        {% endif %}


    </p>
</body>
</html>
```



```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  if_else_main.html로 연결 
@app.route("/")
def home():
    return render_template('if_else_main.html')

# 라우팅 - score 값 전달하기

@app.route("/score2/<score2>")
def score2(score2):
    #return score
    return render_template('if_else_result2.html',score2=score2)


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
    
if_else_main.html

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">

    <title>if_else_main.html</title>
</head>
<body>
    <h1>
        if 조건문 이용하기
    </h1>
 

    <ul>
        <li>
            <a href="/score2/20">값이 20일 때</a>
        </li>
        <li>
            <a href="/score2/50">값이 50일 때</a>
        </li>
        <li>
            <a href="/score2/10">값이 10일 때</a>
        </li>
    </ul>



</body>
</html>



if_else_result2.html


<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    
    <title>if_else_result2.html</title>
</head>
<body>
    <p>
        score : {{ score }}
    </p>
    <p>
        

        {% if '0' < score2 < '20' %}
        <span>20보다 작습니다.</span>
        {% elif score2 > '20' %}
        <span>20보다 큽니다</span>
        {% else %}
        <span>20입니다</span>
        {% endif %}


    </p>
</body>
</html>
```

# flask for문

```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  for_main.html로 연결 
@app.route("/")
def home():
    return render_template('for_main.html')


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)

    
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    
    <title>for_main.html</title>
</head>
<body>
    <!-- 
        {% for 변수 in range(시작값,끝) %}
        실행문
        {% endfor %}
     -->
    <h1>for문 사용하기</h1>
    <h2>1부터 10까지 출력하기</h2>
    {% for i in range(1,11) %}
    <p>count : {{i}}</p>
    {% endfor %}
</body>
</html>
```



```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  for_main.html로 연결 
@app.route("/")
def home():
    return render_template('for_main.html')


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
    
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    
    <title>for_main.html</title>
</head>
<body>
   
    <hr>
    
    <h2>5단 출력하기</h2>
    {% for j in range(1,10) %}
    <p>5 x {{j}} = {{5*j}}</p>
    {% endfor %}


    <h2>중복 for문</h2>
    {% for i in range(1,6) %}
    <h3>{{i}}</h3>
        {% for j in range(1,4) %}
        <h3>{{j}}</h3>
        {% endfor %}
    {% endfor %}
</body>
</html>
```



```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  for_main.html로 연결 
@app.route("/")
def home():
    return render_template('for_main.html')


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
    
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    
    <title>for_main.html</title>
</head>
<body>
   
    <hr>
    
    <h2>구구단 출력하기</h2>
    {% for i in range(2,10) %}
    <h3>{{i}}단</h3>
        {% for j in range(1,10) %}
        <h3>{{i}}x{{j}} = {{i*j}}</h3>
        {% endfor %}
    {% endfor %}
</body>
</html>
```

# 리스트 출력하기

```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  for_list_main.html로 연결 
@app.route("/")
def home():
    foods = ['라면','삼계탕','떡국','참치회']
    return render_template('for_list_main.html',foods=foods)


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">

    <title>for_list_main.html</title>
</head>
<body>
    <h1>리스트 출력</h1>
    <h2>모든 리스트 출력하기</h2>
    {{ foods }}

    <h1>for문을 이용하여 리스트를 하나씩 출력하기</h1>
    {% for i in foods %}
    {{i}}
    {% endfor %}
</body>
</html>
```



```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  for_list_main.html로 연결 
@app.route("/")
def home():
    foods = ['라면','삼계탕','떡국','참치회']
    return render_template('for_list_main.html',foods=foods)

@app.route("/person/")
def person():
    person1 = ['오나라','여',25]
    person2 = ['김철수','남',26]
    return render_template('for_person_main.html',person1=person1,person2=person2)


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
    
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">

    <title>for_person_main.html</title>
</head>
<body>
    <h1>리스트 출력</h1>
    <h2>모든 리스트 출력하기</h2>
    {{ person1 }}
    {{ person2 }}

    <h1>for문을 이용하여 리스트를 하나씩 출력하기</h1>
    {% for j in person1 %}
    {{j}}
    {% endfor %}

    {% for k in person2 %}
    {{k}}
    {% endfor %}
</body>
</html>
```

# 딕셔너리 출력하기

```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

# templates 폴더 아래의  for_dict_main.html로 연결 
@app.route("/")
def home():
    mydict = {'name':'홍길동','age':20,'school':'서초고등학교'}
    return render_template('for_dict_main.html',mydict=mydict)

# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>for_dict_main.html</title>
</head>
<body>
    <h1>for_dict_main.html</h1>
    <h2>딕셔너리 리스트</h2>
    <p>{{ mydict }}</p>

    <hr>

    <h2>for문을 이용해서 출력하기</h2>
    {% for i in mydict.items() %}
    {{i}}
    {% endfor %}
</body>
</html>
```

# 상속

```python
# 관련모듈 불러오기
from flask import Flask, render_template, request

# app 객체 생성
app = Flask(__name__)

 
# 첫번째 자식호출
@app.route("/")
def home():
   return render_template('index_extends.html')

# 두번째 자식호출
@app.route("/about")
def about():
   return render_template('about_child.html')

# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
    
    
<!-- 상속받기 -->

{% extends 'parent.html' %}
{% block content %}
<h1>시작페이지</h1>
<p>첫번째 페이지입니다.</p>
{% endblock %}



{% extends 'parent.html' %}
{% block content %}
<h1>about 페이지</h1>
<p>두번째 페이지입니다.</p>
{% endblock %}



<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">

    <title>parent.html</title>
</head>
<body>
    <h1>템플릿 상속</h1>
    <ul>
        <li><a href="/">home</a></li>
        <li><a href="/about">about</a></li>
    </ul>
  

    <div id='container'>
        <!-- 상속을 받을 파일 등록 -->
        {% block content %}
        {% endblock %}
    </div>


</body>
</html>
```