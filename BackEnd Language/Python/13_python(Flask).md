# Flask 웹프로그래밍

```python
# flask 모듈 불러오기

from flask import Flask

# app 객체 생성
app = Flask(__name__)

# 라우터데코레이터 - url 관리 (http://127.0.0.1:5000/) -> 무엇을 보여줄 것인가?
@app.route("/")

# 뷰함수 - 화면 표시 함수
# 텍스트, html 태그 가능 (return "<h1>Hello World!</h1>")
def helloworld():
    return "Hello World! <p><a href='/test'> test페이지로 이동</a> <a href='/gallery'> gallery페이지로 이동</a> </p>"
          
# http://127.0.0.1:5000/test
@app.route("/test/")
def test():
    return "test page"

# http://127.0.0.1:5000/gallery
@app.route("/gallery/")
def gallery():
    return "<h1>gallery page</h1> <img src='/static/p1.jpg'>"


# 앱 실행
if __name__=="__main__":
    app.run()
```



```python
# flask 모듈 불러오기

from flask import Flask

# app 객체 생성
app = Flask(__name__)

# 라우터데코레이터 - url 관리 (http://127.0.0.1:5000/) -> 무엇을 보여줄 것인가?
@app.route("/")

# 뷰함수 - 화면 표시 함수
# 텍스트, html 태그 가능 (return "<h1>Hello World!</h1>")
def home():
    return "welcome flask world"


# 동적 파라미터 전달하기
# 함수로 인자 전달
# http://127.0.0.1:5000/user/값 -> 뷰함수(인자) -> return 인자
@app.route("/user/<userid>")
def users(userid):
    return "user is %s" % (userid)

# 다수의 동적파라미터 전달
@app.route("/user2/<userid>/<username>")
def user2(userid,username):
    return "아이디 %s 이름 %s" % (userid,username)


# 값 제한
# 기본 데이터형이 string
# 데이터타입 - <int:데이타변수명>,<float:데이타변수명>
@app.route("/news/<int:newsid>/<int:start>")
def news(newsid,start):
    return "뉴스 %s %s" % (newsid,start)

          
# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
```



```python
# 특정 html 페이지연결
# 연결되는 html 페이지는 templates 폴더에 저장되어 있어야한다.

from flask import Flask, render_template

# app 객체 생성
app = Flask(__name__)

# 라우터데코레이터 - url 관리 (http://127.0.0.1:5000/) -> 무엇을 보여줄 것인가?
@app.route("/")

# 뷰함수 - 화면 표시 함수
# templates 폴더 아래의  index2.html로 연결 
def hello():
    return render_template('index2.html')

@app.route("/user")

# 뷰함수 - 화면 표시 함수
# templates 폴더 아래의  index.html로 연결 
def user():
    return render_template('user.html')

# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
```



```python
# 부트스트랩 페이지 연결

from flask import Flask, render_template

# app 객체 생성
app = Flask(__name__)

# 라우터데코레이터 - url 관리 (http://127.0.0.1:5000/) -> 무엇을 보여줄 것인가?
@app.route("/")

# 뷰함수 - 화면 표시 함수
# templates 폴더 아래의  index.html로 연결 
# index.html에서 /static/vendor/,/static/js/로 다 바꾼다

def home():
    return render_template('index.html')


# 앱 실행
if __name__=="__main__":
    app.run(debug=True)
```