# html,css ppt자료를 보고 공부

```python
 form
 <form action=""></form>
 input
 <input type="text" name="" id="">

 CSS
 css 적용방식

 inline 방식
 <html태그 style="css속성1:값1;css속성2:값2;css속성3:값3...">
 html 태그안에 style 속성을 이용하여 직접 css 속성과 값을 지정한다.
 예) h1 태그에 글자색상(color)과 배경색상(background)을 지정한다.
 <h1 style="color:red;background:black">제목</h1>

 인라인요소 (글자,이미지,한줄글상자)의 정렬
 text-align : center/right/left

 p태그에 전체상자 크기를 500px, 높이를 500px로 지정 
 <p style="width:숫자px;height:숫자px">, 100%이하의 숫자

 글자 폰트 지정
 font-family:폰트명
 글자 크기 지정
 font-size:숫자px/숫자pt

 ★★selector 방식
 "head"에 삽입
 <style type ='text/css'>
  selector{속성1:값1;속성2:값2;...}
 </style>

 selector 종류 : 태그 선택자, 클랙스 선택자, 아이디 선택자

 1.태그 선택자
 문서에서 태그선택자로 지정한 태그가 삽입되면 자동으로 정의한 디자인이 적용.
 <style type ='text/css'>
  태그명{속성1:값1;속성2:값2;...}
 </style>

 2.클래스 선택자 - 도트 선택자
 동일한 클래스 디자인을 적용
 페이지에서 원하는 부분만 적용가능
 클래스이름은 원하는 방식으로 한다.
 <style type ='text/css'>
  .클래스이름{속성1:값1;속성2:값2;...}
 </style>
 등록만 한 상태이다. 따라서 적용을 하려면
 <태그명 class="클래스이름">
   ...
 </태그명>

 3.아이디 선택자
 페이지에서 원하는 부분만 적용가능
 문서에서 한번만 적용가능
 <style type ='text/css'>
  #아이디이름{속성1:값1;속성2:값2;...}
 </style>
 등록만 한 상태이다. 따라서 적용을 하려면
 <태그명 id="아이디이름">
   ...
 </태그명>

 트리 선택자
 : 계층 구조
 1.부모요소가 '아이디'인 경우
 <style type ='text/css'>
 #선택자1 선택자2 ...{속성1:값1;속성2:값2;...}
 </style>
 2.부모요소가 '클래스'인 경우
 <style type ='text/css'>
  .선택자1 선택자2 ...{속성1:값1;속성2:값2;...}
 </style>

  하이퍼링크 관련 선택자
  a:link{속성1:값1;속성2:값2;...}  : 보통상태
  a:visited{속성1:값1;속성2:값2;...} : 방문상태
  a:hover{속성1:값1;속성2:값2;...} : 가져다대면
  a:active{속성1:값1;속성2:값2;...} : 클릭순간 활성상태

  그룹 선택자
  같은속성과 값을 가지고 있는 선택자끼리 쉼표를 이용해서 묶어준다.
  a:link,a:visited,... {속성1:값1;속성2:값2;...} 

  css 적용 전상태의 하이퍼링크 스타일
  <a href="url"target="_blank">글자</a>
  보통 : 파란색밑줄 글자, 방문 : 보라색밑줄 글자, 활성 : 빨간색밑줄 글자

  순서 선택자
  부모요소가 '아이디'인 경우
  #태그명:nth-child(숫자)
  ul1 li:nth-child(1){속성1:값1;속성2:값2;...}
  부모요소가 '클래스'인 경우
  .태그명:nth-child(숫자)
  .table4_4 tr:nth-child(2) td:nth-child(3){속성1:값1;속성2:값2;...}
        
  숫자 자리에 even을 넣으면 짝수번째,odd를 넣으면 홀수번째가 선택된다.
  #태그명:first-child - 첫번째
  #태그명:last-child - 마지막
```