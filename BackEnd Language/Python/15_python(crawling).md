- numpy - 수치계산,배열
- pandas - 데이터분석, ~.csv
- matplotlib , seaborn = 그래프 시각화



```python
import numpy as np
```



```python
np.__version__   #numpy 버젼 출력
```



```python
'1.15.0'
```



```python
import pandas as pd
```



```python
pd.__version__  #pandas 버젼 출력
```



```python
'0.23.4'
```

# 크롤링

```python
# 크롤링
from bs4 import BeautifulSoup
from urllib.request import urlopen
import urllib.request

html = urlopen('http://www.nlotto.co.kr/gameResult.do?method=byWin')
# 다른 함수를 사용할 수 있게 객체 생성
soup = BeautifulSoup(html.read(),'html.parser')

h3 = soup.find("h3",{"class":"result_title"})
hoi = h3.strong.string
print(hoi)


number = []
p = soup.find("p",{"class":"number"})
imgs = p.find_all("img")
# print(imgs)
for img in imgs:
    print(img)
    alt = img["alt"]
    number.append(alt)
print(number)
bonus = number.pop()  # 마지막값을 뽑기
print("보너스번호 = ",bonus)
820
<img alt="10" src="/img/common_new/ball_10.png"/>
<img alt="21" src="/img/common_new/ball_21.png"/>
<img alt="22" src="/img/common_new/ball_22.png"/>
<img alt="30" src="/img/common_new/ball_30.png"/>
<img alt="35" src="/img/common_new/ball_35.png"/>
<img alt="42" src="/img/common_new/ball_42.png"/>
<img alt="6" src="/img/common_new/ball_6.png"/>
['10', '21', '22', '30', '35', '42', '6']
보너스번호 =  6
```

