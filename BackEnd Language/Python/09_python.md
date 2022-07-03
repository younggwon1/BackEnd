```python
from urllib.request import urlopen
import urllib.request
from bs4 import BeautifulSoup
html = """
<html>
    <body>
        <h1 id='title'>hello python</h1>
        <p id="body">웹페이지 분석</p>
        <p>웹스크래핑</p>

        <ul>
            <li class ='fruit'>사과</li>
            <li>양파</li>
            <li>고구마</li>
            <li class ='fruit'>바나나</li>
        </ul>

        <ul id="linkbox">
            <li><a href="https://www.naver.com/">네이버</a></li>
            <li class ="nateclass"><a href="https://www.nate.com/">네이트</a></li>
            <li><a href="https://www.google.com/">구글</a></li>
            <li><a href="https://us.yahoo.com/">야후</a></li>
            <li><a href="https://www.daum.net/">다음</a></li>
        </ul>

        <div>
            <img src="image/naver.png" alt="네이버">
            <img src="image/google.png" alt="구글">
            <img src="image/coupang.png" alt="쿠팡">
            <img src="image/daum.png" alt="다음">
        </div>

    </body>
</html>
"""

# BeautifulSoup 객체 생성
bs = BeautifulSoup(html,"html.parser")
```



```python
# 전체 소스 출력
print(bs,type(bs))
<html>
<body>
<h1 id="title">hello python</h1>
<p id="body">웹페이지 분석</p>
<p>웹스크래핑</p>
<ul>
<li class="fruit">사과</li>
<li>양파</li>
<li>고구마</li>
<li class="fruit">바나나</li>
</ul>
<ul id="linkbox">
<li><a href="https://www.naver.com/">네이버</a></li>
<li class="nateclass"><a href="https://www.nate.com/">네이트</a></li>
<li><a href="https://www.google.com/">구글</a></li>
<li><a href="https://us.yahoo.com/">야후</a></li>
<li><a href="https://www.daum.net/">다음</a></li>
</ul>
<div>
<img alt="네이버" src="image/naver.png"/>
<img alt="구글" src="image/google.png"/>
<img alt="쿠팡" src="image/coupang.png"/>
<img alt="다음" src="image/daum.png"/>
</div>
</body>
</html>
 <class 'bs4.BeautifulSoup'>
```



```python
# 도트(.)으로 태그 찾아가기
# bs.태그명1.태그명2...  : 첫번째 태그 소스만 나온다.
print(bs.p)
print(bs.p.string) # 텍스트 문자 출력
print(bs.ul.li)  # 첫번째 태그 소스인 <li class="fruit">사과</li> 이 나온다.
<p id="body">웹페이지 분석</p>
웹페이지 분석
<li class="fruit">사과</li>
```



```python
# id로 찾기
# bs.find(id="아이디이름")
print(bs.find(id="title"))
print(bs.find(id="title").string) # 텍스트 문자 출력
<h1 id="title">hello python</h1>
hello python
```



```python
# class로 찾기 - 리스트 구조 (리스트 구조이기 떄문에 for문을 사용한다.)
# bs.find_all(class_="클래스이름")
result_list = bs.find_all(class_="fruit")
print(result_list)
# 하나씩 출력
for i in result_list:
    print(i)
    print(i.string) # 텍스트 문자 출력
[<li class="fruit">사과</li>, <li class="fruit">바나나</li>]
<li class="fruit">사과</li>
사과
<li class="fruit">바나나</li>
바나나
```



```python
# 문서에 삽입된 태그 여러개 찾아가기 - 리스트 구조
# bs.find_all("태그명")
li_list = bs.find_all("li")
print(li_list)
for i in li_list:
    print(i)
    print(i.string) # 텍스트 문자 출력
[<li class="fruit">사과</li>, <li>양파</li>, <li>고구마</li>, <li class="fruit">바나나</li>, <li><a href="https://www.naver.com/">네이버</a></li>, <li class="nateclass"><a href="https://www.nate.com/">네이트</a></li>, <li><a href="https://www.google.com/">구글</a></li>, <li><a href="https://us.yahoo.com/">야후</a></li>, <li><a href="https://www.daum.net/">다음</a></li>]
<li class="fruit">사과</li>
사과
<li>양파</li>
양파
<li>고구마</li>
고구마
<li class="fruit">바나나</li>
바나나
<li><a href="https://www.naver.com/">네이버</a></li>
네이버
<li class="nateclass"><a href="https://www.nate.com/">네이트</a></li>
네이트
<li><a href="https://www.google.com/">구글</a></li>
구글
<li><a href="https://us.yahoo.com/">야후</a></li>
야후
<li><a href="https://www.daum.net/">다음</a></li>
다음
```



```python
# 태그 내부의 속성 추출하기 (href 속성)
# 태그리스트변수.attrs["href"]
a_list = bs.find_all('a')
href_list = []
print(a_list)
for i in a_list:
    print(i.attrs["href"])
    h = i.attrs["href"]
    href_list.append(h)
print(href_list)
[<a href="https://www.naver.com/">네이버</a>, <a href="https://www.nate.com/">네이트</a>, <a href="https://www.google.com/">구글</a>, <a href="https://us.yahoo.com/">야후</a>, <a href="https://www.daum.net/">다음</a>]
https://www.naver.com/
https://www.nate.com/
https://www.google.com/
https://us.yahoo.com/
https://www.daum.net/
['https://www.naver.com/', 'https://www.nate.com/', 'https://www.google.com/', 'https://us.yahoo.com/', 'https://www.daum.net/']
```



```python
# img태그의 src 속성값을 추출해서 리스트로 만든다.
img_list = bs.find_all('img')
href_list = []
print(img_list)
for i in img_list:
    print(i.attrs["src"])
    h = i.attrs["src"]
    href_list.append(h)
print(href_list)
[<img alt="네이버" src="image/naver.png"/>, <img alt="구글" src="image/google.png"/>, <img alt="쿠팡" src="image/coupang.png"/>, <img alt="다음" src="image/daum.png"/>]
image/naver.png
image/google.png
image/coupang.png
image/daum.png
['image/naver.png', 'image/google.png', 'image/coupang.png', 'image/daum.png']
```



```python
# css 셀렉터로 추출 - 1개만 추출
# bs.select_one("css 셀렉터")
print(bs.select_one("ul li"))  # 문서에서 ul태그 아래있는 첫번째 li추출
print(bs.select_one("div img")) # 문서에서 div태그 아래있는 첫번째 img추출
# 문서에서 id가 linkbox 아래있는 li태그에서 다시 아래에 있는 첫번째 a추출
print(bs.select_one("#linkbox li a")) 
# 문서에서 id가 linkbox 아래있는 li태그에서 class가 nateclass 아래에 있는 첫번째 a추출
print(bs.select_one("#linkbox li.nateclass a")) 
<li class="fruit">사과</li>
<img alt="네이버" src="image/naver.png"/>
<a href="https://www.naver.com/">네이버</a>
<a href="https://www.nate.com/">네이트</a>
```



```python
from urllib.request import urlopen
import urllib.request
from bs4 import BeautifulSoup
html = """
<html>
    <body>
        <h1 id='title'>hello python</h1>
        <p id="body">웹페이지 분석</p>
        <p>웹스크래핑</p>

        <ul>
            <li class ='fruit'>사과</li>
            <li>양파</li>
            <li>고구마</li>
            <li class ='fruit'>바나나</li>
        </ul>

        <ul id="linkbox">
            <li><a href="https://www.naver.com/">네이버</a></li>
            <li class ="nateclass"><a href="https://www.nate.com/">네이트</a></li>
            <li><a href="https://www.google.com/">구글</a></li>
            <li><a href="https://us.yahoo.com/">야후</a></li>
            <li><a href="https://www.daum.net/">다음</a></li>
        </ul>

        <div class="imgbox">
            <img src="image/naver.png" alt="네이버">
            <img src="image/google.png" alt="구글" class="g">
            <img src="image/coupang.png" alt="쿠팡">
            <img src="image/daum.png" alt="다음" class="g">
        </div>

        <div>
            <img src="image/naver.png" alt="네이버" class="g">
            <img src="image/google.png" alt="구글">
            <img src="image/coupang.png" alt="쿠팡" class="g">
            <img src="image/daum.png" alt="다음">
        </div>

    </body>
</html>
"""

# BeautifulSoup 객체 생성
bs = BeautifulSoup(html,"html.parser")
```



```python
# bs.select('css 셀렉터')
# 리스트 구조로 결과값이 리턴
li_list = bs.select('ul li')
print(li_list)
print('li 태그는 몇번 사용되었나요?', len(li_list))

li_list2 = bs.select('#linkbox li')
print(li_list2)
print('li 태그는 몇번 사용되었나요?', len(li_list2))

# 모든 img 태그의 리스트 생성
img_list = bs.select('img')
print('img 태그는 몇번 사용되었나요?', len(img_list))

# imgbox 클래스가 적용된 태그 안의 img 리스트 생성
img_list2 = bs.select('.imgbox img')
print('img 태그는 몇번 사용되었나요?', len(img_list2))

# g 클래스가 적용된 태그 소스와 함께 숫자 카운팅 함께 출력
g_list = bs.select('.g')
print(g_list)
print('g 태그는 몇번 사용되었나요?', len(g_list))
[<li class="fruit">사과</li>, <li>양파</li>, <li>고구마</li>, <li class="fruit">바나나</li>, <li><a href="https://www.naver.com/">네이버</a></li>, <li class="nateclass"><a href="https://www.nate.com/">네이트</a></li>, <li><a href="https://www.google.com/">구글</a></li>, <li><a href="https://us.yahoo.com/">야후</a></li>, <li><a href="https://www.daum.net/">다음</a></li>]
li 태그는 몇번 사용되었나요? 9
[<li><a href="https://www.naver.com/">네이버</a></li>, <li class="nateclass"><a href="https://www.nate.com/">네이트</a></li>, <li><a href="https://www.google.com/">구글</a></li>, <li><a href="https://us.yahoo.com/">야후</a></li>, <li><a href="https://www.daum.net/">다음</a></li>]
li 태그는 몇번 사용되었나요? 5
img 태그는 몇번 사용되었나요? 8
img 태그는 몇번 사용되었나요? 4
[<img alt="구글" class="g" src="image/google.png"/>, <img alt="다음" class="g" src="image/daum.png"/>, <img alt="네이버" class="g" src="image/naver.png"/>, <img alt="쿠팡" class="g" src="image/coupang.png"/>]
g 태그는 몇번 사용되었나요? 4
```



```python
# 웹상에 있는 페이지 이용
# 웹상의 페이지를 변수로 저장
html1 = urlopen('http://www.pythonscraping.com/pages/warandpeace.html')
# BeautifulSoup 변수로 웹상의 태그 소스와 연결
bs = BeautifulSoup(html1.read(),'html.parser')
print(bs)
print('\n'*10)
<html>
<head>
<style>
.green{
	color:#55ff55;
}
.red{
	color:#ff5555;
}
#text{
	width:50%;
}
</style>
</head>
<body>
<h1>War and Peace</h1>
<h2>Chapter 1</h2>
<div id="text">
"<span class="red">Well, Prince, so Genoa and Lucca are now just family estates of the
Buonapartes. But I warn you, if you don't tell me that this means war,
if you still try to defend the infamies and horrors perpetrated by
that Antichrist- I really believe he is Antichrist- I will have
nothing more to do with you and you are no longer my friend, no longer
my 'faithful slave,' as you call yourself! But how do you do? I see
I have frightened you- sit down and tell me all the news.</span>"
<p></p>
It was in July, 1805, and the speaker was the well-known <span class="green">Anna
Pavlovna Scherer</span>, maid of honor and favorite of the <span class="green">Empress Marya
Fedorovna</span>. With these words she greeted <span class="green">Prince Vasili Kuragin</span>, a man
of high rank and importance, who was the first to arrive at her
reception. <span class="green">Anna Pavlovna</span> had had a cough for some days. She was, as
she said, suffering from la grippe; grippe being then a new word in
<span class="green">St. Petersburg</span>, used only by the elite.
<p></p>
All her invitations without exception, written in French, and
delivered by a scarlet-liveried footman that morning, ran as follows:
<p></p>
"<span class="red">If you have nothing better to do, Count [or Prince], and if the
prospect of spending an evening with a poor invalid is not too
terrible, I shall be very charmed to see you tonight between 7 and 10-
Annette Scherer.</span>"
<p></p>
"<span class="red">Heavens! what a virulent attack!</span>" replied <span class="green">the prince</span>, not in the
least disconcerted by this reception. He had just entered, wearing
an embroidered court uniform, knee breeches, and shoes, and had
stars on his breast and a serene expression on his flat face. He spoke
in that refined French in which our grandfathers not only spoke but
thought, and with the gentle, patronizing intonation natural to a
man of importance who had grown old in society and at court. He went
up to <span class="green">Anna Pavlovna</span>, kissed her hand, presenting to her his bald,
scented, and shining head, and complacently seated himself on the
sofa.
<p></p>
"<span class="red">First of all, dear friend, tell me how you are. Set your friend's
mind at rest,</span>" said he without altering his tone, beneath the
politeness and affected sympathy of which indifference and even
irony could be discerned.
<p></p>
"<span class="red">Can one be well while suffering morally? Can one be calm in times
like these if one has any feeling?</span>" said <span class="green">Anna Pavlovna</span>. "<span class="red">You are
staying the whole evening, I hope?</span>"
<p></p>
"<span class="red">And the fete at the English ambassador's? Today is Wednesday. I
must put in an appearance there,</span>" said <span class="green">the prince</span>. "<span class="red">My daughter is
coming for me to take me there.</span>"
<p></p>
"<span class="red">I thought today's fete had been canceled. I confess all these
festivities and fireworks are becoming wearisome.</span>"
<p></p>
"<span class="red">If they had known that you wished it, the entertainment would
have been put off,</span>" said <span class="green">the prince</span>, who, like a wound-up clock, by
force of habit said things he did not even wish to be believed.
<p></p>
"<span class="red">Don't tease! Well, and what has been decided about Novosiltsev's
dispatch? You know everything.</span>"
<p></p>
"<span class="red">What can one say about it?</span>" replied <span class="green">the prince</span> in a cold,
listless tone. "<span class="red">What has been decided? They have decided that
Buonaparte has burnt his boats, and I believe that we are ready to
burn ours.</span>"
<p></p>
<span class="green">Prince Vasili</span> always spoke languidly, like an actor repeating a
stale part. <span class="green">Anna Pavlovna</span> Scherer on the contrary, despite her forty
years, overflowed with animation and impulsiveness. To be an
enthusiast had become her social vocation and, sometimes even when she
did not feel like it, she became enthusiastic in order not to
disappoint the expectations of those who knew her. The subdued smile
which, though it did not suit her faded features, always played
round her lips expressed, as in a spoiled child, a continual
consciousness of her charming defect, which she neither wished, nor
could, nor considered it necessary, to correct.
<p></p>
In the midst of a conversation on political matters <span class="green">Anna Pavlovna</span>
burst out:
<p></p>
"<span class="red">Oh, don't speak to me of Austria. Perhaps I don't understand
things, but Austria never has wished, and does not wish, for war.
She is betraying us! Russia alone must save Europe. Our gracious
sovereign recognizes his high vocation and will be true to it. That is
the one thing I have faith in! Our good and wonderful sovereign has to
perform the noblest role on earth, and he is so virtuous and noble
that God will not forsake him. He will fulfill his vocation and
crush the hydra of revolution, which has become more terrible than
ever in the person of this murderer and villain! We alone must
avenge the blood of the just one.... Whom, I ask you, can we rely
on?... England with her commercial spirit will not and cannot
understand the Emperor Alexander's loftiness of soul. She has
refused to evacuate Malta. She wanted to find, and still seeks, some
secret motive in our actions. What answer did Novosiltsev get? None.
The English have not understood and cannot understand the
self-abnegation of our Emperor who wants nothing for himself, but only
desires the good of mankind. And what have they promised? Nothing! And
what little they have promised they will not perform! Prussia has
always declared that Buonaparte is invincible, and that all Europe
is powerless before him.... And I don't believe a word that Hardenburg
says, or Haugwitz either. This famous Prussian neutrality is just a
trap. I have faith only in God and the lofty destiny of our adored
monarch. He will save Europe!</span>"
<p></p>
She suddenly paused, smiling at her own impetuosity.
<p></p>
"<span class="red">I think,</span>" said <span class="green">the prince</span> with a smile, "<span class="red">that if you had been
sent instead of our dear <span class="green">Wintzingerode</span> you would have captured the
<span class="green">King of Prussia</span>'s consent by assault. You are so eloquent. Will you
give me a cup of tea?</span>"
<p></p>
"<span class="red">In a moment. A propos,</span>" she added, becoming calm again, "<span class="red">I am
expecting two very interesting men tonight, <span class="green">le Vicomte de Mortemart</span>,
who is connected with the <span class="green">Montmorencys</span> through the <span class="green">Rohans</span>, one of
the best French families. He is one of the genuine emigres, the good
ones. And also the <span class="green">Abbe Morio</span>. Do you know that profound thinker? He
has been received by <span class="green">the Emperor</span>. Had you heard?</span>"
<p></p>
"<span class="red">I shall be delighted to meet them,</span>" said <span class="green">the prince</span>. "<span class="red">But tell me,</span>"
he added with studied carelessness as if it had only just occurred
to him, though the question he was about to ask was the chief motive
of his visit, "<span class="red">is it true that the Dowager Empress wants Baron Funke
to be appointed first secretary at Vienna? The baron by all accounts
is a poor creature.</span>"
<p></p>
<span class="green">Prince Vasili</span> wished to obtain this post for his son, but others
were trying through the <span class="green">Dowager Empress Marya Fedorovna</span> to secure it
for <span class="green">the baron</span>.
<p></p>
<span class="green">Anna Pavlovna</span> almost closed her eyes to indicate that neither she
nor anyone else had a right to criticize what <span class="green">the Empress</span> desired or
was pleased with.
<p></p>
"<span class="red">Baron Funke has been recommended to the Dowager Empress by her
sister,</span>" was all she said, in a dry and mournful tone.
<p></p>
As she named <span class="green">the Empress</span>, <span class="green">Anna Pavlovna's</span> face suddenly assumed an
expression of profound and sincere devotion and respect mingled with
sadness, and this occurred every time she mentioned her illustrious
patroness. She added that <span class="green">Her Majesty</span> had deigned to show <span class="green">Baron
Funke</span>, and again her face clouded over with sadness.
<p></p>
<span class="green">The prince</span> was silent and looked indifferent. But, with the
womanly and courtierlike quickness and tact habitual to her, <span class="green">Anna
Pavlovna</span> wished both to rebuke him (for daring to speak he had done of
a man recommended to <span class="green">the Empress</span>) and at the same time to console him,
so she said:
<p></p>
"<span class="red">Now about your family. Do you know that since your daughter came
out everyone has been enraptured by her? They say she is amazingly
beautiful.</span>"
<p></p>
<span class="green">The prince</span> bowed to signify his respect and gratitude.
<p></p>
"<span class="red">I often think,</span>" she continued after a short pause, drawing nearer
to the prince and smiling amiably at him as if to show that
political and social topics were ended and the time had come for
intimate conversation- "<span class="red">I often think how unfairly sometimes the
joys of life are distributed. Why has fate given you two such splendid
children? I don't speak of <span class="green">Anatole</span>, your youngest. I don't like
him,</span>" she added in a tone admitting of no rejoinder and raising her
eyebrows. "<span class="red">Two such charming children. And really you appreciate
them less than anyone, and so you don't deserve to have them.</span>"
<p></p>
And she smiled her ecstatic smile.
<p></p>
"<span class="red">I can't help it,</span>" said <span class="green">the prince</span>. "<span class="red">Lavater would have said I
lack the bump of paternity.</span>"
<p></p>
"<span class="red">Don't joke; I mean to have a serious talk with you. Do you know I
am dissatisfied with your younger son? Between ourselves</span>" (and her
face assumed its melancholy expression), "<span class="red">he was mentioned at Her
Majesty's and you were pitied....</span>"
<p></p>
<span class="green">The prince</span> answered nothing, but she looked at him significantly,
awaiting a reply. He frowned.
<p></p>
"<span class="red">What would you have me do?</span>" he said at last. "<span class="red">You know I did all
a father could for their education, and they have both turned out
fools. Hippolyte is at least a quiet fool, but Anatole is an active
one. That is the only difference between them.</span>" He said this smiling
in a way more natural and animated than usual, so that the wrinkles
round his mouth very clearly revealed something unexpectedly coarse
and unpleasant.
<p></p>
"<span class="red">And why are children born to such men as you? If you were not a
father there would be nothing I could reproach you with,</span>" said <span class="green">Anna
Pavlovna</span>, looking up pensively.
<p></p>
"<span class="red">I am your faithful slave and to you alone I can confess that my
children are the bane of my life. It is the cross I have to bear. That
is how I explain it to myself. It can't be helped!</span>"
<p></p>
He said no more, but expressed his resignation to cruel fate by a
gesture. <span class="green">Anna Pavlovna</span> meditated.
</div>
</body>
</html>
```



```python
# 웹페이지에서 [copy selector] 기능으로 선택자 복사
#  #text > span
print('#text > span 소스 확인하기')
print(bs.select_one('#text > span'))
print(bs.select_one('#text > span').string)
#text > span 소스 확인하기
<span class="red">Well, Prince, so Genoa and Lucca are now just family estates of the
Buonapartes. But I warn you, if you don't tell me that this means war,
if you still try to defend the infamies and horrors perpetrated by
that Antichrist- I really believe he is Antichrist- I will have
nothing more to do with you and you are no longer my friend, no longer
my 'faithful slave,' as you call yourself! But how do you do? I see
I have frightened you- sit down and tell me all the news.</span>
Well, Prince, so Genoa and Lucca are now just family estates of the
Buonapartes. But I warn you, if you don't tell me that this means war,
if you still try to defend the infamies and horrors perpetrated by
that Antichrist- I really believe he is Antichrist- I will have
nothing more to do with you and you are no longer my friend, no longer
my 'faithful slave,' as you call yourself! But how do you do? I see
I have frightened you- sit down and tell me all the news.
```



```python
# BeautifulSoup 사용시 주의 사항
# nth-child(숫자)) , first-child() , last-child() 는 사용x
# #text > p:nth-child(2) > span:nth-child(1)
# #text span.green

print(bs.select_one('#text span.green'))
<span class="green">Anna
Pavlovna Scherer</span>
```



```python
# 아래 사이트 주소의 작품 부분만 데이터 추출하기

from urllib.request import urlopen
import urllib.request
from bs4 import BeautifulSoup
html = urlopen('https://namu.wiki/w/%EC%9C%A4%EB%8F%99%EC%A3%BC')
bs = BeautifulSoup(html,"html.parser")

# 작품 부분의 선택자
# body > div.content-wrapper > article > div.wiki-content.clearfix > div > div > ul > li > ul > li > p > a
print(bs.select('div.content-wrapper > article > div.wiki-content.clearfix > div > div > ul > li > ul > li > p > a'))
result_list = bs.select('div.content-wrapper > article > div.wiki-content.clearfix > div > div > ul > li > ul > li > p > a')

# .string 을 사용할려면 문자를 출력할 수 있도록 문자가 있는 태그를 복사한다.

for i in result_list:
    print(i)   # 소스 출력
print('\n'*10)
for i in result_list:
    print(i.string)  # 제목만 출력

print('\n'*10)


# body > div.content-wrapper > article > div.wiki-content.clearfix > div > div > blockquote > p
print(bs.select('div.content-wrapper > article > div.wiki-content.clearfix > div > div > blockquote > p'))
print('\n'*10)
print(bs.select('div.content-wrapper > article > h1 > a > span'))
list_title = bs.select('div.content-wrapper > article > h1 > a > span')
print(list_title[0].string)
[<a class="wiki-link-internal" href="/w/%EC%84%9C%EC%8B%9C(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="서시(윤동주)">서시(序詩)</a>, <a class="wiki-link-internal" href="/w/%EC%9E%90%ED%99%94%EC%83%81(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="자화상(윤동주)">자화상(윤동주)</a>, <a class="wiki-link-internal" href="/w/%EB%B3%91%EC%9B%90(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="병원(윤동주)">병원(윤동주)</a>, <a class="wiki-link-internal" href="/w/%EB%98%90%20%EB%8B%A4%EB%A5%B8%20%EA%B3%A0%ED%96%A5" title="또 다른 고향">또 다른 고향</a>, <a class="wiki-link-internal" href="/w/%EA%B8%B8(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="길(윤동주)">길(윤동주)</a>, <a class="wiki-link-internal" href="/w/%EB%B3%84%20%ED%97%A4%EB%8A%94%20%EB%B0%A4" title="별 헤는 밤">별 헤는 밤</a>, <a class="wiki-link-internal" href="/w/%EC%89%BD%EA%B2%8C%20%EC%94%8C%EC%96%B4%EC%A7%84%20%EC%8B%9C" title="쉽게 씌어진 시">쉽게 씌어진 시</a>, <a class="wiki-fn-content" href="#fn-15" title="현대의 맞춤법에 따른 표기로는 '쉽게 쓰인 시'. "><span class="target" id="rfn-15"></span>[15]</a>, <a class="wiki-link-internal" href="/w/%EC%B0%B8%ED%9A%8C%EB%A1%9D" title="참회록">참회록</a>, <a class="wiki-link-internal" href="/w/%EA%B0%84(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="간(윤동주)">간(윤동주)</a>]
<a class="wiki-link-internal" href="/w/%EC%84%9C%EC%8B%9C(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="서시(윤동주)">서시(序詩)</a>
<a class="wiki-link-internal" href="/w/%EC%9E%90%ED%99%94%EC%83%81(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="자화상(윤동주)">자화상(윤동주)</a>
<a class="wiki-link-internal" href="/w/%EB%B3%91%EC%9B%90(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="병원(윤동주)">병원(윤동주)</a>
<a class="wiki-link-internal" href="/w/%EB%98%90%20%EB%8B%A4%EB%A5%B8%20%EA%B3%A0%ED%96%A5" title="또 다른 고향">또 다른 고향</a>
<a class="wiki-link-internal" href="/w/%EA%B8%B8(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="길(윤동주)">길(윤동주)</a>
<a class="wiki-link-internal" href="/w/%EB%B3%84%20%ED%97%A4%EB%8A%94%20%EB%B0%A4" title="별 헤는 밤">별 헤는 밤</a>
<a class="wiki-link-internal" href="/w/%EC%89%BD%EA%B2%8C%20%EC%94%8C%EC%96%B4%EC%A7%84%20%EC%8B%9C" title="쉽게 씌어진 시">쉽게 씌어진 시</a>
<a class="wiki-fn-content" href="#fn-15" title="현대의 맞춤법에 따른 표기로는 '쉽게 쓰인 시'. "><span class="target" id="rfn-15"></span>[15]</a>
<a class="wiki-link-internal" href="/w/%EC%B0%B8%ED%9A%8C%EB%A1%9D" title="참회록">참회록</a>
<a class="wiki-link-internal" href="/w/%EA%B0%84(%EC%9C%A4%EB%8F%99%EC%A3%BC)" title="간(윤동주)">간(윤동주)</a>











서시(序詩)
자화상(윤동주)
병원(윤동주)
또 다른 고향
길(윤동주)
별 헤는 밤
쉽게 씌어진 시
None
참회록
간(윤동주)











[<p>동주야.<br/>너는 스물아홉에 영원이 되고 <br/>나는 어느새 일흔 고개에 올라섰구나 <br/>너는 분명 나보다 여섯달 먼저 났지만 <br/>나한텐 아직도 새파란 젊은이다 <br/>너의 영원한 젊음 앞에서 <br/>이렇게 구질구질 늙어 가는 게 억울하지 않느냐고 <br/>그냥 오기로 억울하긴 뭐가 억울해 할 수야 있다만 <br/>네가 나와 같이 늙어가지 않는다는 게 <br/>여간만 다행이 아니구나 <br/>너마저 늙어간다면 이 땅의 꽃잎들 <br/>누굴 쳐다보며 젊음을 불사르겠니 <br/>김상진 박래전만이 아니다 <br/>너의 '서시'를 뇌까리며 <br/>민족의 제단에 몸을 바치는 젊은이들은 <br/>후꾸오까 형무소 <br/>너를 통째로 집어삼킨 어둠 <br/>네 살 속에서 흐느끼며 빠져나간 꿈들 <br/>온몸 짓뭉개지던 노래들 <br/>화장터의 연기로 사라져 버린 줄 알았던 너의 피묻은 가락들 <br/>이제 하나 둘 젊은 시인들의 안테나에 잡히고 있다<br/>그 앞에서 '하늘과 바람과 별과 시'가 습작기 작품이 된단들<br/>그게 어떻단 말이냐<br/>넌 영원한 젊음으로 우리의 핏줄속에 살아 있으면 되는 거니까<br/>예수보다 더 젊은 영원으로<br/><br/>동주야 <br/>난 결코 널 형이라고 부르지 않을 것이니</p>, <p>1987년 <a class="wiki-link-internal" href="/w/%EB%AC%B8%EC%9D%B5%ED%99%98" title="문익환">문익환</a> 목사의 시 '동주야'</p>, <p>그립다고 써보니 차라리 말을 말자<br/>그냥 긴 세월이 지났노라고만 쓰자<br/>긴긴 사연을 줄줄이 이어<br/>진정 못 잊는다는 말을 말고<br/>어쩌다 생각이 났었노라고만 쓰자</p>, <p>그립다고 써보니 차라리 말을 말자<br/>그냥 긴 세월이 지났노라고만 쓰자<br/>긴긴 잠 못 이루는 밤이면<br/>행여 울었다는 말을 말고<br/>가다가 그리울 때도 있었노라고만 쓰자</p>, <p>누나<br/>이 겨울에도<br/>눈이 왔읍니다</p>, <p>흰 봉투에<br/>눈을 한 줌 넣고<br/>글씨도 쓰지말고<br/>우표도 붙이지 말고<br/>말쑥하게 그대로<br/>편지를 부칠까요?</p>, <p>누나 가신 나라엔<br/>눈이 아니온다기에</p>]











[<span class="wiki-document-title">윤동주</span>]
윤동주
```



```python
# 아래 사이트 주소의 작품 부분만 데이터 추출하기

from urllib.request import urlopen
import urllib.request
from bs4 import BeautifulSoup
html = urlopen('https://www.naver.com/')
bs = BeautifulSoup(html,"html.parser")

# 실시간 순위 소스 출력
print(bs.select('#PM_ID_ct > div.header > div.section_navbar > div.area_hotkeyword.PM_CL_realtimeKeyword_base > div.ah_roll.PM_CL_realtimeKeyword_rolling_base > div > ul > li > a > span.ah_k'))
print('\n'*10)

rank_list = bs.select('#PM_ID_ct > div.header > div.section_navbar > div.area_hotkeyword.PM_CL_realtimeKeyword_base > div.ah_roll.PM_CL_realtimeKeyword_rolling_base > div > ul > li > a > span.ah_k')
for i in rank_list:
    print(i)
print('\n'*10)

for i in rank_list:
    print(i.string)
print('\n'*10)
    
for i in range(0,6):
    print('{}위 {}'.format(i+1,rank_list[i].string))
[<span class="ah_k">에쿠스 화재</span>, <span class="ah_k">워마드</span>, <span class="ah_k">에쿠스</span>, <span class="ah_k">한서희</span>, <span class="ah_k">태풍 야기</span>, <span class="ah_k">김영민</span>, <span class="ah_k">현빈</span>, <span class="ah_k">피파온라인4</span>, <span class="ah_k">손예진</span>, <span class="ah_k">연애혁명</span>, <span class="ah_k">한전사이버지점</span>, <span class="ah_k">bmw</span>, <span class="ah_k">한전</span>, <span class="ah_k">명탐정코난 미궁의 십자로</span>, <span class="ah_k">정인선</span>, <span class="ah_k">페이퍼아트</span>, <span class="ah_k">태풍</span>, <span class="ah_k">김윤아</span>, <span class="ah_k">봉침</span>, <span class="ah_k">bmw 리콜 대상</span>]











<span class="ah_k">에쿠스 화재</span>
<span class="ah_k">워마드</span>
<span class="ah_k">에쿠스</span>
<span class="ah_k">한서희</span>
<span class="ah_k">태풍 야기</span>
<span class="ah_k">김영민</span>
<span class="ah_k">현빈</span>
<span class="ah_k">피파온라인4</span>
<span class="ah_k">손예진</span>
<span class="ah_k">연애혁명</span>
<span class="ah_k">한전사이버지점</span>
<span class="ah_k">bmw</span>
<span class="ah_k">한전</span>
<span class="ah_k">명탐정코난 미궁의 십자로</span>
<span class="ah_k">정인선</span>
<span class="ah_k">페이퍼아트</span>
<span class="ah_k">태풍</span>
<span class="ah_k">김윤아</span>
<span class="ah_k">봉침</span>
<span class="ah_k">bmw 리콜 대상</span>











에쿠스 화재
워마드
에쿠스
한서희
태풍 야기
김영민
현빈
피파온라인4
손예진
연애혁명
한전사이버지점
bmw
한전
명탐정코난 미궁의 십자로
정인선
페이퍼아트
태풍
김윤아
봉침
bmw 리콜 대상











1위 에쿠스 화재
2위 워마드
3위 에쿠스
4위 한서희
5위 태풍 야기
6위 김영민
```