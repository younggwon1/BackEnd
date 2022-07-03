```python
css 외부 정의
별도의 css 파일 생성 예)style1.css
문법 (link)
head 영역
<link rel="stylesheet" href="style1.css">

직계 선택자
선택자>선택자

자손 선택자
box1 아이디 안의 모든 div
#box1 div {background: red;border:1px solid black}

직계 선택자 
box1 아이디 안의 바로 밑에있는 div
#box1>div {color: white;font-size: 30px}

box1 아이디 안의 두단계 밑에있는 div 
#box1>div>div {color: white;font-size: 30px}


태그요소 2가지 스타일
인라인 요소 - 같은 줄에 오는 형태 (이미지,글자,입력상자,..)
블록 요소 - 같은 줄에 오지 않는 형태 (div,p,table)

레이아웃 관련 속성
1.플로우트 방식 (float:left/right , clear:both float 해제)
 float란 부모요소를 기준으로 왼쪽과 오른쪽으로 배치

 padding - 안쪽여백
 margin - 바깥여백 (margin-left/right/top/bottom:)
 margin에서 좌우여백을 auto로 지정이 중앙정렬.
 ex) margin: 10px auto

2.display 방식

  none - 보이지 않게 지정한다.
         (display : none)
  inline - 블록요소를 인라인 요소로 변경한다.
           가로로 나열
           (display : inline)
  block - 인라인 요소를 블록 요소로 변경한다. 
          (display : block)

  블록요소의 중앙절렬 : margin 0 auto
  인라인요소의 중앙정렬 : text-align:center

3. position 방식

   absolute : top(y),left(x) 속성으로 위지 지정
   ex) position: absolute; top: 100px;left: 100px

   z-index:겹치기 순서, 숫자값이 높을 수록 위에 배치

   fixed:좌표속성 - bottom(y)/top(y),left(x)/right(x)
   스크롤바에 상관없이 그대로 유지
   ex) position: fixed;top: 0px;right: 0

   relative:좌표기준이 자기자신
   ex) position:relative;top:-40px;left:100px
            
```

# 웹스크래핑이란?

- html페이지에서 필요한 정보만 추출하는 기능 -> 파이썬처리

```python
# 웹상의 html 페이지 읽어오기
from urllib.request import urlopen

html = urlopen('http://google.com')
# html.read() : html 객체의 소스 내용을 출력
print(html.read())
print(type(html))
html_result = html.read()
print(type(html_result))
b'<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ko"><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="Y1rnzV44mcThLqVExO1ecw==">(function(){window.google={kEI:\'E5pqW47HIsf68gXygp6ACg\',kEXPI:\'0,1353746,58,1957,1018,281,838,875,636,294,437,325,425,34,510,2338628,270,157,32,329244,1344,12383,2349,2506,19009,13683,8161,7086,864,319,11847,5281,1954,9286,366,551,552,2214,113,1149,1052,3191,726,5,336,287,1079,139,130,5107,444,131,1119,2,1306,311,2121,1361,1712,1376,505,730,2096,1063,231,8,1569,774,194,1038,883,137,279,2,2825,1636,525,22,604,2,2299,117,2,75,3,773,859,614,283,509,955,677,251,1344,69,984,66,334,17,113,630,480,234,386,8,1003,81,7,28,463,620,29,107,904,252,132,451,7,63,228,340,917,276,551,81,748,897,416,491,112,123,239,189,97,204,17,208,159,69,77,308,146,86,226,25,1,600,557,31,48,177,423,156,41,77,30,143,19,147,196,44,2,197,2319898,3685997,13,2541,81,8797705,4,1572,549,332,445,1,2,1,1,78,1,900,583,5,308,1,8,1,2,1,1,2130,1,1,1,1,1,205,2,19,10,24,11,15,10,25,1,1,3,1,1,24,2\',authuser:0,kscs:\'c9c918f0_E5pqW47HIsf68gXygp6ACg\',kGL:\'KR\'};google.kHL=\'ko\';})();google.time=function(){return(new Date).getTime()};(function(){google.lc=[];google.li=0;google.getEI=function(a){for(var b;a&&(!a.getAttribute||!(b=a.getAttribute("eid")));)a=a.parentNode;return b||google.kEI};google.getLEI=function(a){for(var b=null;a&&(!a.getAttribute||!(b=a.getAttribute("leid")));)a=a.parentNode;return b};google.https=function(){return"https:"==window.location.protocol};google.ml=function(){return null};google.wl=function(a,b){try{google.ml(Error(a),!1,b)}catch(d){}};google.log=function(a,b,d,c,g){if(a=google.logUrl(a,b,d,c,g)){b=new Image;var e=google.lc,f=google.li;e[f]=b;b.onerror=b.onload=b.onabort=function(){delete e[f]};google.vel&&google.vel.lu&&google.vel.lu(a);b.src=a;google.li=f+1}};google.logUrl=function(a,b,d,c,g){var e="",f=google.ls||"";d||-1!=b.search("&ei=")||(e="&ei="+google.getEI(c),-1==b.search("&lei=")&&(c=google.getLEI(c))&&(e+="&lei="+c));c="";!d&&google.cshid&&-1==b.search("&cshid=")&&"slh"!=a&&(c="&cshid="+google.cshid);a=d||"/"+(g||"gen_204")+"?atyp=i&ct="+a+"&cad="+b+e+f+"&zx="+google.time()+c;/^http:/i.test(a)&&google.https()&&(google.ml(Error("a"),!1,{src:a,glmm:1}),a="");return a};}).call(this);(function(){google.y={};google.x=function(a,b){if(a)var c=a.id;else{do c=Math.random();while(google.y[c])}google.y[c]=[a,b];return!1};google.lm=[];google.plm=function(a){google.lm.push.apply(google.lm,a)};google.lq=[];google.load=function(a,b,c){google.lq.push([[a],b,c])};google.loadAll=function(a,b){google.lq.push([a,b])};}).call(this);google.f={};</script><script nonce="Y1rnzV44mcThLqVExO1ecw==">var a=window.location,b=a.href.indexOf("#");if(0<=b){var c=a.href.substring(b+1);/(^|&)q=/.test(c)&&-1==c.indexOf("#")&&a.replace("/search?"+c.replace(/(^|&)fp=[^&]*/g,"")+"&cad=h")};</script><style>#gbar,#guser{font-size:13px;padding-top:1px !important;}#gbar{height:22px}#guser{padding-bottom:7px !important;text-align:right}.gbh,.gbd{border-top:1px solid #c9d7f1;font-size:1px}.gbh{height:0;position:absolute;top:24px;width:100%}@media all{.gb1{height:22px;margin-right:.5em;vertical-align:top}#gbar{float:left}}a.gb1,a.gb4{text-decoration:underline !important}a.gb1,a.gb4{color:#00c !important}.gbi .gb4{color:#dd8e27 !important}.gbf .gb4{color:#900 !important}\n</style><style>body,td,a,p,.h{font-family:&#44404;&#47548;,&#46027;&#50880;,arial,sans-serif}.ko{font-size:9pt}body{margin:0;overflow-y:scroll}#gog{padding:3px 8px 0}td{line-height:.8em}.gac_m td{line-height:17px}form{margin-bottom:20px}.h{color:#36c}.q{color:#00c}.ts td{padding:0}.ts{border-collapse:collapse}em{font-weight:bold;font-style:normal}.lst{height:25px;width:496px}.gsfi,.lst{font:18px arial,sans-serif}.gsfs{font:17px arial,sans-serif}.ds{display:inline-box;display:inline-block;margin:3px 0 4px;margin-left:4px}input{font-family:inherit}a.gb1,a.gb2,a.gb3,a.gb4{color:#11c !important}body{background:#fff;color:black}a{color:#11c;text-decoration:none}a:hover,a:active{text-decoration:underline}.fl a{color:#36c}a:visited{color:#551a8b}a.gb1,a.gb4{text-decoration:underline}a.gb3:hover{text-decoration:none}#ghead a.gb2:hover{color:#fff !important}.sblc{padding-top:5px}.sblc a{display:block;margin:2px 0;margin-left:13px;font-size:11px}.lsbb{background:#eee;border:solid 1px;border-color:#ccc #999 #999 #ccc;height:30px}.lsbb{display:block}.ftl,#fll a{display:inline-block;margin:0 12px}.lsb{background:url(/images/nav_logo229.png) 0 -261px repeat-x;border:none;color:#000;cursor:pointer;height:30px;margin:0;outline:0;font:15px arial,sans-serif;vertical-align:top}.lsb:active{background:#ccc}.lst:focus{outline:none}.tiah{width:458px}</style><script nonce="Y1rnzV44mcThLqVExO1ecw=="></script><link href="/images/branding/product/ico/googleg_lodp.ico" rel="shortcut icon"></head><body bgcolor="#fff"><script nonce="Y1rnzV44mcThLqVExO1ecw==">(function(){var src=\'/images/nav_logo229.png\';var iesg=false;document.body.onload = function(){window.n && window.n();if (document.images){new Image().src=src;}\nif (!iesg){document.f&&document.f.q.focus();document.gbqf&&document.gbqf.q.focus();}\n}\n})();</script><div id="mngb"> <div id=gbar><nobr><b class=gb1>&#44160;&#49353;</b> <a class=gb1 href="http://www.google.co.kr/imghp?hl=ko&tab=wi">&#51060;&#48120;&#51648;</a> <a class=gb1 href="http://maps.google.co.kr/maps?hl=ko&tab=wl">&#51648;&#46020;</a> <a class=gb1 href="https://play.google.com/?hl=ko&tab=w8">Play</a> <a class=gb1 href="http://www.youtube.com/?gl=KR&tab=w1">YouTube</a> <a class=gb1 href="http://news.google.co.kr/nwshp?hl=ko&tab=wn">&#45684;&#49828;</a> <a class=gb1 href="https://mail.google.com/mail/?tab=wm">Gmail</a> <a class=gb1 href="https://drive.google.com/?tab=wo">&#46300;&#46972;&#51060;&#48652;</a> <a class=gb1 style="text-decoration:none" href="https://www.google.co.kr/intl/ko/options/"><u>&#45908;&#48372;&#44592;</u> &raquo;</a></nobr></div><div id=guser width=100%><nobr><span id=gbn class=gbi></span><span id=gbf class=gbf></span><span id=gbe></span><a href="http://www.google.co.kr/history/optout?hl=ko" class=gb4>&#50937; &#44592;&#47197;</a> | <a  href="/preferences?hl=ko" class=gb4>&#49444;&#51221;</a> | <a target=_top id=gb_70 href="https://accounts.google.com/ServiceLogin?hl=ko&passive=true&continue=http://www.google.com/" class=gb4>&#47196;&#44536;&#51064;</a></nobr></div><div class=gbh style=left:0></div><div class=gbh style=right:0></div> </div><center><br clear="all" id="lgpd"><div id="lga"><img alt="Google" height="92" src="/images/branding/googlelogo/1x/googlelogo_white_background_color_272x92dp.png" style="padding:28px 0 14px" width="272" id="hplogo" onload="window.lol&&lol()"><br><br></div><form action="/search" name="f"><table cellpadding="0" cellspacing="0"><tr valign="top"><td width="25%">&nbsp;</td><td align="center" nowrap=""><input name="ie" value="ISO-8859-1" type="hidden"><input value="ko" name="hl" type="hidden"><input name="source" type="hidden" value="hp"><input name="biw" type="hidden"><input name="bih" type="hidden"><div class="ds" style="height:32px;margin:4px 0"><div style="position:relative;zoom:1"><input style="color:#000;margin:0;padding:5px 8px 0 6px;vertical-align:top;padding-right:38px" autocomplete="off" class="lst tiah" value="" title="Google &#44160;&#49353;" maxlength="2048" name="q" size="57"><img src="/textinputassistant/tia.png" style="position:absolute;cursor:pointer;right:5px;top:4px;z-index:300" onclick="(function(){var src=\'/textinputassistant/11/ko_tia.js\';var s=document.createElement(\'script\');s.src=src;(document.getElementById(\'xjsc\')||document.body).appendChild(s);})();" alt="" height="23" width="27"></div></div><br style="line-height:0"><span class="ds"><span class="lsbb"><input class="lsb" value="Google &#44160;&#49353;" name="btnG" type="submit"></span></span><span class="ds"><span class="lsbb"><input class="lsb" value="I&#8217;m Feeling Lucky" name="btnI" onclick="if(this.form.q.value)this.checked=1; else top.location=\'/doodles/\'" type="submit"></span></span></td><td class="fl sblc" align="left" nowrap="" width="25%"><a href="/advanced_search?hl=ko&amp;authuser=0">&#44256;&#44553;&#44160;&#49353;</a><a href="/language_tools?hl=ko&amp;authuser=0">&#50616;&#50612;&#46020;&#44396;</a></td></tr></table><input id="gbv" name="gbv" type="hidden" value="1"></form><div id="gac_scont"></div><div style="font-size:83%;min-height:3.5em"><br></div><span id="footer"><div style="font-size:10pt"><div style="margin:19px auto;text-align:center" id="fll"><a href="/intl/ko/ads/">&#44305;&#44256; &#54532;&#47196;&#44536;&#47016;</a><a href="http://www.google.co.kr/intl/ko/services/">&#48708;&#51592;&#45768;&#49828; &#49556;&#47336;&#49496;</a><a href="https://plus.google.com/102197601262446632410" rel="publisher">+Google</a><a href="/intl/ko/about.html">Google &#51221;&#48372;</a><a href="http://www.google.com/setprefdomain?prefdom=KR&amp;prev=http://www.google.co.kr/&amp;sig=__nKFud-Fi0pdusuGguGmI6vTAmxY%3D">Google.co.kr</a></div></div><p style="color:#767676;font-size:8pt">&copy; 2018 - <a href="/intl/ko/policies/privacy/">&#44060;&#51064;&#51221;&#48372;&#52376;&#47532;&#48169;&#52840;</a> - <a href="/intl/ko/policies/terms/">&#50557;&#44288;</a></p></span></center><script nonce="Y1rnzV44mcThLqVExO1ecw==">(function(){window.google.cdo={height:0,width:0};(function(){var a=window.innerWidth,b=window.innerHeight;if(!a||!b){var c=window.document,d="CSS1Compat"==c.compatMode?c.documentElement:c.body;a=d.clientWidth;b=d.clientHeight}a&&b&&(a!=google.cdo.width||b!=google.cdo.height)&&google.log("","","/client_204?&atyp=i&biw="+a+"&bih="+b+"&ei="+google.kEI);}).call(this);})();</script><div id="xjsd"></div><div id="xjsi"><script nonce="Y1rnzV44mcThLqVExO1ecw==">(function(){function c(b){window.setTimeout(function(){var a=document.createElement("script");a.src=b;google.timers&&google.timers.load.t&&google.tick&&google.tick("load",{gen204:"xjsls",clearcut:31});document.getElementById("xjsd").appendChild(a)},0)}google.dljp=function(b,a){google.xjsu=b;c(a)};google.dlj=c;}).call(this);if(!google.xjs){window._=window._||{};window._DumpException=window._._DumpException=function(e){throw e};window._F_installCss=window._._F_installCss=function(c){};google.dljp(\'/xjs/_/js/k\\x3dxjs.hp.en.9bv7OYgIqhU.O/m\\x3dsb_he,d/am\\x3dhIKxAQ/rt\\x3dj/d\\x3d1/rs\\x3dACT90oFTVp75vV7ieET8xfYa7BARQt4ovA\',\'/xjs/_/js/k\\x3dxjs.hp.en.9bv7OYgIqhU.O/m\\x3dsb_he,d/am\\x3dhIKxAQ/rt\\x3dj/d\\x3d1/rs\\x3dACT90oFTVp75vV7ieET8xfYa7BARQt4ovA\');google.xjs=1;}google.pmc={"sb_he":{"agen":true,"cgen":true,"client":"heirloom-hp","dh":true,"dhqt":true,"ds":"","ffql":"ko","fl":true,"host":"google.com","isbh":28,"jsonp":true,"msgs":{"cibl":"&#44160;&#49353;&#50612; &#51648;&#50864;&#44592;","dym":"&#51060;&#44163;&#51012; &#52286;&#51004;&#49512;&#45208;&#50836;?","lcky":"I&#8217;m Feeling Lucky","lml":"&#51088;&#49464;&#55176; &#50508;&#50500;&#48372;&#44592;","oskt":"&#51077;&#47141; &#46020;&#44396;","psrc":"&#44160;&#49353;&#50612;&#44032; \\u003Ca href=\\"/history\\"\\u003E&#50937; &#44592;&#47197;\\u003C/a\\u003E&#50640;&#49436; &#49325;&#51228;&#46104;&#50632;&#49845;&#45768;&#45796;.","psrl":"&#49325;&#51228;","sbit":"&#51060;&#48120;&#51648;&#47196; &#44160;&#49353;","srch":"Google &#44160;&#49353;"},"nds":true,"ovr":{},"pq":"","refpd":true,"refspre":true,"rfs":[],"sbpl":24,"sbpr":24,"scd":10,"sce":5,"stok":"CaCGGrMYQFoQzlMsiNlHoQQluM8"},"d":{},"ZI/YVQ":{},"Qnk92g":{},"U5B21g":{},"DPBNMg":{},"YFCs/g":{}};google.x(null,function(){});(function(){var r=[];google.plm(r);})();(function(){var m=[]\n;google.jsc && google.jsc.m(m);})();</script></div></body></html>'
<class 'http.client.HTTPResponse'>
<class 'bytes'>
```



```python
from urllib.request import urlopen
import urllib.request
from bs4 import BeautifulSoup
html = urlopen('http://google.com')
# 다른 함수를 사용할 수 있게 객체 생성
bs = BeautifulSoup(html.read(),'html.parser')
print(bs)
print(type(bs))
<!DOCTYPE doctype html>
<html itemscope="" itemtype="http://schema.org/WebPage" lang="ko"><head><meta content="text/html; charset=utf-8" http-equiv="Content-Type"/><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"/><title>Google</title><script nonce="G92pm4o9R3hZ1iuNomm81Q==">(function(){window.google={kEI:'nJtqW5bvLobO8wWEla3YAw',kEXPI:'0,1353747,57,1653,304,1018,280,343,1371,636,195,99,364,73,75,262,413,33,2339139,221,206,32,329294,1294,12383,2349,2506,32691,15248,867,316,8615,3232,14325,2196,368,549,554,2212,113,2201,3191,726,5,336,287,1082,134,132,5107,444,131,1119,2,579,727,310,2121,1362,1712,1376,505,732,2094,1294,8,1569,774,1232,883,133,283,2,1038,1787,438,1198,525,22,604,2,2026,274,126,2,65,3,773,160,654,45,614,283,509,1587,296,1344,69,984,66,334,10,41,79,630,402,78,235,385,8,1003,81,7,28,465,241,222,155,29,1011,250,134,451,7,63,77,491,1746,77,750,125,1202,27,449,236,239,189,97,221,204,117,39,7,69,256,220,366,26,601,316,241,256,298,125,156,42,76,31,194,310,44,2,40,157,2319898,3685997,2554,81,8797705,4,1572,549,332,445,1,2,1,1,78,1,900,583,5,308,1,8,1,2,1,1,2130,1,1,1,1,1,202,32,2,2,33,15,10,25,1,1,3,1,1,21,5',authuser:0,kscs:'c9c918f0_nJtqW5bvLobO8wWEla3YAw',kGL:'KR'};google.kHL='ko';})();google.time=function(){return(new Date).getTime()};(function(){google.lc=[];google.li=0;google.getEI=function(a){for(var b;a&&(!a.getAttribute||!(b=a.getAttribute("eid")));)a=a.parentNode;return b||google.kEI};google.getLEI=function(a){for(var b=null;a&&(!a.getAttribute||!(b=a.getAttribute("leid")));)a=a.parentNode;return b};google.https=function(){return"https:"==window.location.protocol};google.ml=function(){return null};google.wl=function(a,b){try{google.ml(Error(a),!1,b)}catch(d){}};google.log=function(a,b,d,c,g){if(a=google.logUrl(a,b,d,c,g)){b=new Image;var e=google.lc,f=google.li;e[f]=b;b.onerror=b.onload=b.onabort=function(){delete e[f]};google.vel&&google.vel.lu&&google.vel.lu(a);b.src=a;google.li=f+1}};google.logUrl=function(a,b,d,c,g){var e="",f=google.ls||"";d||-1!=b.search("&ei=")||(e="&ei="+google.getEI(c),-1==b.search("&lei=")&&(c=google.getLEI(c))&&(e+="&lei="+c));c="";!d&&google.cshid&&-1==b.search("&cshid=")&&"slh"!=a&&(c="&cshid="+google.cshid);a=d||"/"+(g||"gen_204")+"?atyp=i&ct="+a+"&cad="+b+e+f+"&zx="+google.time()+c;/^http:/i.test(a)&&google.https()&&(google.ml(Error("a"),!1,{src:a,glmm:1}),a="");return a};}).call(this);(function(){google.y={};google.x=function(a,b){if(a)var c=a.id;else{do c=Math.random();while(google.y[c])}google.y[c]=[a,b];return!1};google.lm=[];google.plm=function(a){google.lm.push.apply(google.lm,a)};google.lq=[];google.load=function(a,b,c){google.lq.push([[a],b,c])};google.loadAll=function(a,b){google.lq.push([a,b])};}).call(this);google.f={};</script><script nonce="G92pm4o9R3hZ1iuNomm81Q==">var a=window.location,b=a.href.indexOf("#");if(0<=b){var c=a.href.substring(b+1);/(^|&)q=/.test(c)&&-1==c.indexOf("#")&&a.replace("/search?"+c.replace(/(^|&)fp=[^&]*/g,"")+"&cad=h")};</script><style>#gbar,#guser{font-size:13px;padding-top:1px !important;}#gbar{height:22px}#guser{padding-bottom:7px !important;text-align:right}.gbh,.gbd{border-top:1px solid #c9d7f1;font-size:1px}.gbh{height:0;position:absolute;top:24px;width:100%}@media all{.gb1{height:22px;margin-right:.5em;vertical-align:top}#gbar{float:left}}a.gb1,a.gb4{text-decoration:underline !important}a.gb1,a.gb4{color:#00c !important}.gbi .gb4{color:#dd8e27 !important}.gbf .gb4{color:#900 !important}
</style><style>body,td,a,p,.h{font-family:&#44404;&#47548;,&#46027;&#50880;,arial,sans-serif}.ko{font-size:9pt}body{margin:0;overflow-y:scroll}#gog{padding:3px 8px 0}td{line-height:.8em}.gac_m td{line-height:17px}form{margin-bottom:20px}.h{color:#36c}.q{color:#00c}.ts td{padding:0}.ts{border-collapse:collapse}em{font-weight:bold;font-style:normal}.lst{height:25px;width:496px}.gsfi,.lst{font:18px arial,sans-serif}.gsfs{font:17px arial,sans-serif}.ds{display:inline-box;display:inline-block;margin:3px 0 4px;margin-left:4px}input{font-family:inherit}a.gb1,a.gb2,a.gb3,a.gb4{color:#11c !important}body{background:#fff;color:black}a{color:#11c;text-decoration:none}a:hover,a:active{text-decoration:underline}.fl a{color:#36c}a:visited{color:#551a8b}a.gb1,a.gb4{text-decoration:underline}a.gb3:hover{text-decoration:none}#ghead a.gb2:hover{color:#fff !important}.sblc{padding-top:5px}.sblc a{display:block;margin:2px 0;margin-left:13px;font-size:11px}.lsbb{background:#eee;border:solid 1px;border-color:#ccc #999 #999 #ccc;height:30px}.lsbb{display:block}.ftl,#fll a{display:inline-block;margin:0 12px}.lsb{background:url(/images/nav_logo229.png) 0 -261px repeat-x;border:none;color:#000;cursor:pointer;height:30px;margin:0;outline:0;font:15px arial,sans-serif;vertical-align:top}.lsb:active{background:#ccc}.lst:focus{outline:none}.tiah{width:458px}</style><script nonce="G92pm4o9R3hZ1iuNomm81Q=="></script><link href="/images/branding/product/ico/googleg_lodp.ico" rel="shortcut icon"/></head><body bgcolor="#fff"><script nonce="G92pm4o9R3hZ1iuNomm81Q==">(function(){var src='/images/nav_logo229.png';var iesg=false;document.body.onload = function(){window.n && window.n();if (document.images){new Image().src=src;}
if (!iesg){document.f&&document.f.q.focus();document.gbqf&&document.gbqf.q.focus();}
}
})();</script><div id="mngb"> <div id="gbar"><nobr><b class="gb1">검색</b> <a class="gb1" href="http://www.google.co.kr/imghp?hl=ko&amp;tab=wi">이미지</a> <a class="gb1" href="http://maps.google.co.kr/maps?hl=ko&amp;tab=wl">지도</a> <a class="gb1" href="https://play.google.com/?hl=ko&amp;tab=w8">Play</a> <a class="gb1" href="http://www.youtube.com/?gl=KR&amp;tab=w1">YouTube</a> <a class="gb1" href="http://news.google.co.kr/nwshp?hl=ko&amp;tab=wn">뉴스</a> <a class="gb1" href="https://mail.google.com/mail/?tab=wm">Gmail</a> <a class="gb1" href="https://drive.google.com/?tab=wo">드라이브</a> <a class="gb1" href="https://www.google.co.kr/intl/ko/options/" style="text-decoration:none"><u>더보기</u> »</a></nobr></div><div id="guser" width="100%"><nobr><span class="gbi" id="gbn"></span><span class="gbf" id="gbf"></span><span id="gbe"></span><a class="gb4" href="http://www.google.co.kr/history/optout?hl=ko">웹 기록</a> | <a class="gb4" href="/preferences?hl=ko">설정</a> | <a class="gb4" href="https://accounts.google.com/ServiceLogin?hl=ko&amp;passive=true&amp;continue=http://www.google.com/" id="gb_70" target="_top">로그인</a></nobr></div><div class="gbh" style="left:0"></div><div class="gbh" style="right:0"></div> </div><center><br clear="all" id="lgpd"/><div id="lga"><img alt="Google" height="92" id="hplogo" onload="window.lol&amp;&amp;lol()" src="/images/branding/googlelogo/1x/googlelogo_white_background_color_272x92dp.png" style="padding:28px 0 14px" width="272"/><br/><br/></div><form action="/search" name="f"><table cellpadding="0" cellspacing="0"><tr valign="top"><td width="25%"> </td><td align="center" nowrap=""><input name="ie" type="hidden" value="ISO-8859-1"/><input name="hl" type="hidden" value="ko"/><input name="source" type="hidden" value="hp"/><input name="biw" type="hidden"/><input name="bih" type="hidden"/><div class="ds" style="height:32px;margin:4px 0"><div style="position:relative;zoom:1"><input autocomplete="off" class="lst tiah" maxlength="2048" name="q" size="57" style="color:#000;margin:0;padding:5px 8px 0 6px;vertical-align:top;padding-right:38px" title="Google 검색" value=""/><img alt="" height="23" onclick="(function(){var src='/textinputassistant/11/ko_tia.js';var s=document.createElement('script');s.src=src;(document.getElementById('xjsc')||document.body).appendChild(s);})();" src="/textinputassistant/tia.png" style="position:absolute;cursor:pointer;right:5px;top:4px;z-index:300" width="27"/></div></div><br style="line-height:0"/><span class="ds"><span class="lsbb"><input class="lsb" name="btnG" type="submit" value="Google 검색"/></span></span><span class="ds"><span class="lsbb"><input class="lsb" name="btnI" onclick="if(this.form.q.value)this.checked=1; else top.location='/doodles/'" type="submit" value="I’m Feeling Lucky"/></span></span></td><td align="left" class="fl sblc" nowrap="" width="25%"><a href="/advanced_search?hl=ko&amp;authuser=0">고급검색</a><a href="/language_tools?hl=ko&amp;authuser=0">언어도구</a></td></tr></table><input id="gbv" name="gbv" type="hidden" value="1"/></form><div id="gac_scont"></div><div style="font-size:83%;min-height:3.5em"><br/></div><span id="footer"><div style="font-size:10pt"><div id="fll" style="margin:19px auto;text-align:center"><a href="/intl/ko/ads/">광고 프로그램</a><a href="http://www.google.co.kr/intl/ko/services/">비즈니스 솔루션</a><a href="https://plus.google.com/102197601262446632410" rel="publisher">+Google</a><a href="/intl/ko/about.html">Google 정보</a><a href="http://www.google.com/setprefdomain?prefdom=KR&amp;prev=http://www.google.co.kr/&amp;sig=__dg-hJZL7UhUNiikirifObaTWbeM%3D">Google.co.kr</a></div></div><p style="color:#767676;font-size:8pt">© 2018 - <a href="/intl/ko/policies/privacy/">개인정보처리방침</a> - <a href="/intl/ko/policies/terms/">약관</a></p></span></center><script nonce="G92pm4o9R3hZ1iuNomm81Q==">(function(){window.google.cdo={height:0,width:0};(function(){var a=window.innerWidth,b=window.innerHeight;if(!a||!b){var c=window.document,d="CSS1Compat"==c.compatMode?c.documentElement:c.body;a=d.clientWidth;b=d.clientHeight}a&&b&&(a!=google.cdo.width||b!=google.cdo.height)&&google.log("","","/client_204?&atyp=i&biw="+a+"&bih="+b+"&ei="+google.kEI);}).call(this);})();</script><div id="xjsd"></div><div id="xjsi"><script nonce="G92pm4o9R3hZ1iuNomm81Q==">(function(){function c(b){window.setTimeout(function(){var a=document.createElement("script");a.src=b;google.timers&&google.timers.load.t&&google.tick&&google.tick("load",{gen204:"xjsls",clearcut:31});document.getElementById("xjsd").appendChild(a)},0)}google.dljp=function(b,a){google.xjsu=b;c(a)};google.dlj=c;}).call(this);if(!google.xjs){window._=window._||{};window._DumpException=window._._DumpException=function(e){throw e};window._F_installCss=window._._F_installCss=function(c){};google.dljp('/xjs/_/js/k\x3dxjs.hp.en.9bv7OYgIqhU.O/m\x3dsb_he,d/am\x3dhIKxAQ/rt\x3dj/d\x3d1/rs\x3dACT90oFTVp75vV7ieET8xfYa7BARQt4ovA','/xjs/_/js/k\x3dxjs.hp.en.9bv7OYgIqhU.O/m\x3dsb_he,d/am\x3dhIKxAQ/rt\x3dj/d\x3d1/rs\x3dACT90oFTVp75vV7ieET8xfYa7BARQt4ovA');google.xjs=1;}google.pmc={"sb_he":{"agen":true,"cgen":true,"client":"heirloom-hp","dh":true,"dhqt":true,"ds":"","ffql":"ko","fl":true,"host":"google.com","isbh":28,"jsonp":true,"msgs":{"cibl":"&#44160;&#49353;&#50612; &#51648;&#50864;&#44592;","dym":"&#51060;&#44163;&#51012; &#52286;&#51004;&#49512;&#45208;&#50836;?","lcky":"I&#8217;m Feeling Lucky","lml":"&#51088;&#49464;&#55176; &#50508;&#50500;&#48372;&#44592;","oskt":"&#51077;&#47141; &#46020;&#44396;","psrc":"&#44160;&#49353;&#50612;&#44032; \u003Ca href=\"/history\"\u003E&#50937; &#44592;&#47197;\u003C/a\u003E&#50640;&#49436; &#49325;&#51228;&#46104;&#50632;&#49845;&#45768;&#45796;.","psrl":"&#49325;&#51228;","sbit":"&#51060;&#48120;&#51648;&#47196; &#44160;&#49353;","srch":"Google &#44160;&#49353;"},"nds":true,"ovr":{},"pq":"","refpd":true,"refspre":true,"rfs":[],"sbpl":24,"sbpr":24,"scd":10,"sce":5,"stok":"2HzmvWGnW6al1vDNZTJHwyp3d9k"},"d":{},"ZI/YVQ":{},"Qnk92g":{},"U5B21g":{},"DPBNMg":{},"YFCs/g":{}};google.x(null,function(){});(function(){var r=[];google.plm(r);})();(function(){var m=[]
;google.jsc && google.jsc.m(m);})();</script></div></body></html>
<class 'bs4.BeautifulSoup'>
```



```python
# http://www.naver.com 페이지에서 h1,div 태그만 추출해라
# 첫번째 태그만 출력된다.
# bs.태그이름

from urllib.request import urlopen
import urllib.request
from bs4 import BeautifulSoup
html = urlopen('http://www.naver.com')
# 다른 함수를 사용할 수 있게 객체 생성
bs = BeautifulSoup(html.read(),'html.parser')
print('h1태그출력\n',bs.h1)
print('div태그출력\n',bs.div)
h1태그출력
 <h1>
<a data-clk="top.logo" href="/"><span class="naver_logo">네이버</span></a>
</h1>
div태그출력
 <div class="u_skip">
<a href="#news_cast" onclick="document.getElementById('news_cast2').tabIndex = -1;document.getElementById('news_cast2').focus();return false;"><span>뉴스스탠드 바로가기</span></a>
<a href="#themecast" onclick="document.getElementById('themecast').tabIndex = -1;document.getElementById('themecast').focus();return false;"><span>주제별캐스트 바로가기</span></a>
<a href="#time_square" onclick="document.getElementById('time_square').tabIndex = -1;document.getElementById('time_square').focus();return false;"><span>타임스퀘어 바로가기</span></a>
<a href="#shp_cst" onclick="document.getElementById('shp_cst').tabIndex = -1;document.getElementById('shp_cst').focus();return false;"><span>쇼핑캐스트 바로가기</span></a>
<a href="#account" onclick="document.getElementById('account').tabIndex = -1;document.getElementById('account').focus();return false;"><span>로그인 바로가기</span></a>
</div>
```



```python
# 전체 출력
print(bs)
<!DOCTYPE doctype html>

<html class="svgless" lang="ko">
<head>
<meta charset="utf-8"/>
<meta content="origin" name="Referrer"/>
<meta content="text/javascript" http-equiv="Content-Script-Type"/>
<meta content="text/css" http-equiv="Content-Style-Type"/>
<meta content="IE=edge" http-equiv="X-UA-Compatible"/>
<meta content="width=1100" name="viewport"/>
<meta content="NAVER" name="apple-mobile-web-app-title">
<meta content="index,nofollow" name="robots">
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" name="description">
<meta content="네이버" property="og:title"/>
<meta content="https://www.naver.com/" property="og:url"/>
<meta content="https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png" property="og:image"/>
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" property="og:description">
<meta content="summary" name="twitter:card"/>
<meta content="" name="twitter:title"/>
<meta content="https://www.naver.com/" name="twitter:url"/>
<meta content="https://s.pstatic.net/static/www/mobile/edit/2016/0705/mobile_212852414260.png" name="twitter:image"/>
<meta content="네이버 메인에서 다양한 정보와 유용한 컨텐츠를 만나 보세요" name="twitter:description">
<link href="/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
<link href="https://pm.pstatic.net/css/main_v180802.css" rel="stylesheet" type="text/css"/>
<link href="https://pm.pstatic.net/css/webfont_v170623.css" rel="stylesheet" type="text/css"/>
<link href="https://ssl.pstatic.net/sstatic/search/pc/css/api_atcmp_170914.css" rel="stylesheet" type="text/css"/>
<script src="https://pm.pstatic.net/js/c/nlog_v180615.js" type="text/javascript"></script>
<script src="https://ssl.pstatic.net/tveta/libs/assets/js/common/min/probe.min.js" type="text/javascript"></script>
<script type="text/javascript">
var nsc = "navertop.v3";
document.domain = "naver.com";
var jindoAll = "";

if (!!!window.console) {window.console={};window.console["log"]=function(){}}
var isLogin = false; 
function refreshLcs(etc) {etc = etc ? etc : {};if(document.cookie.indexOf("nrefreshx=1") != -1) {etc["mrf"]="1";} else {etc["pan"]="tec";}return etc;}

lcs_do(refreshLcs());

</script>
<title>NAVER</title>
</meta></meta></meta></meta></meta></head>
<body class="">
<!-- 스킵 내비게이션 -->
<div class="u_skip">
<a href="#news_cast" onclick="document.getElementById('news_cast2').tabIndex = -1;document.getElementById('news_cast2').focus();return false;"><span>뉴스스탠드 바로가기</span></a>
<a href="#themecast" onclick="document.getElementById('themecast').tabIndex = -1;document.getElementById('themecast').focus();return false;"><span>주제별캐스트 바로가기</span></a>
<a href="#time_square" onclick="document.getElementById('time_square').tabIndex = -1;document.getElementById('time_square').focus();return false;"><span>타임스퀘어 바로가기</span></a>
<a href="#shp_cst" onclick="document.getElementById('shp_cst').tabIndex = -1;document.getElementById('shp_cst').focus();return false;"><span>쇼핑캐스트 바로가기</span></a>
<a href="#account" onclick="document.getElementById('account').tabIndex = -1;document.getElementById('account').focus();return false;"><span>로그인 바로가기</span></a>
</div>
<!-- //스킵 내비게이션 -->
<div class="wrap" id="PM_ID_ct">
<!-- 헤더 -->
<div class="header" role="banner">
<div class="special_bg">
<div class="area_flex">
<div class="area_logo">
<h1>
<a data-clk="top.logo" href="/"><span class="naver_logo">네이버</span></a>
</h1>
</div>
<div class="area_links">
<a class="al_favorite" data-clk="top.mkhome" href="http://help.naver.com/support/alias/contents2/naverhome/naverhome_1.naver">네이버를 시작페이지로<span class="al_ico_link"></span></a>
<span class="al_bar"></span>
<a class="al_jr" data-clk="top.jrnaver" href="http://jr.naver.com"><span class="blind">쥬니어네이버</span><span class="al_ico"></span></a>
<a class="al_happybean" data-clk="top.happybean" href="http://happybean.naver.com/main/SectionMain.nhn"><span class="blind">해피빈</span><span class="al_ico"></span></a>
</div>
<div class="search" id="search">
<!--자동완성 입력창-->
<form action="https://search.naver.com/search.naver" id="sform" method="get" name="sform">
<fieldset>
<legend class="blind">검색</legend>
<select class="blind" id="where" name="where" title="검색 범위 선택">
<option selected="selected" value="nexearch">통합검색</option><option value="post">블로그</option><option value="cafeblog">카페</option><option value="cafe">- 카페명</option><option value="article">- 카페글</option><option value="kin">지식iN</option><option value="news">뉴스</option><option value="web">사이트</option><option value="category">- 카테고리</option><option value="site">- 사이트</option><option value="movie">영화</option><option value="webkr">웹문서</option><option value="dic">사전</option><option value="100">- 백과사전</option><option value="endic">- 영어사전</option><option value="eedic">- 영영사전</option><option value="krdic">- 국어사전</option><option value="jpdic">- 일본어사전</option><option value="hanja">- 한자사전</option><option value="terms">- 용어사전</option><option value="book">책</option><option value="music">음악</option><option value="doc">전문자료</option><option value="shop">쇼핑</option><option value="local">지역</option><option value="video">동영상</option><option value="image">이미지</option><option value="mypc">내PC</option><optgroup label="스마트 파인더"><option value="movie">영화</option><option value="auto">자동차</option><option value="game">게임</option><option value="health">건강</option><option value="people">인물</option></optgroup><optgroup label="네이버 랩"><option>긍정부정검색</option></optgroup>
</select>
<input id="sm" name="sm" type="hidden" value="top_hty"/>
<input id="fbm" name="fbm" type="hidden" value="0"/>
<input disabled="disabled" id="acr" name="acr" type="hidden" value=""/>
<input disabled="disabled" id="acq" name="acq" type="hidden" value=""/>
<input disabled="disabled" id="qdt" name="qdt" type="hidden" value=""/>
<input id="ie" name="ie" type="hidden" value="utf8"/>
<input disabled="disabled" id="acir" name="acir" type="hidden" value=""/>
<input disabled="disabled" id="os" name="os" type="hidden" value=""/>
<input disabled="disabled" id="bid" name="bid" type="hidden" value=""/>
<input disabled="disabled" id="pkid" name="pkid" type="hidden" value=""/>
<input disabled="disabled" id="eid" name="eid" type="hidden" value=""/>
<input disabled="disabled" id="mra" name="mra" type="hidden" value=""/>
<span class="green_window">
<input accesskey="s" autocomplete="off" class="input_text" id="query" maxlength="255" name="query" onclick="document.getElementById('fbm').value=1;" style="ime-mode:active;" tabindex="1" title="검색어 입력" type="text" value=""/>
</span>
<div class="autocomplete" id="nautocomplete">
<!-- 자동완성 열린 경우 fold 클래스 추가, 딤드인 경우 dim 추가 -->
<a class="btn_arw _btn_arw fold" href="javascript:;" role="button" tabindex="2"><span class="blind _text">자동완성 펼치기</span><span class="ico_arr"></span></a>
</div>
<button class="sch_smit" id="search_btn" onclick="clickcr(this,'sch.action','','',event);" onmousedown="this.className='sch_smit down'" onmouseout="this.className='sch_smit'" onmouseover="this.className='sch_smit over'" tabindex="3" title="검색" type="submit"><span class="blind">검색</span><span class="ico_search_submit"></span></button>
</fieldset>
</form>
<!--자동완성 입력창-->
<!--한글입력기 -->
<a class="btn_keyboard" data-clk="sch.ime" href="javascript:;" id="ke_kbd_btn" onclick="nx_ime_load(this)" role="button"><span class="blind">한글 입력기</span><span class="ico_keyboard"></span></a>
<style id="_nx_kbd_style" type="text/css"></style>
<div id="_nx_kbd" style="display:none;"></div>
<!--한글입력기 -->
<!--자동완성 레이어 -->
<div class="reatcmp" id="autoFrame" style="background-color:rgb(255, 255, 255);display:none;">
<div class="api_atcmp_wrap _atcmp" style="display:none;">
<div class="words nature">
<h3 class="tit">생각한대로 검색해 보세요 <span class="beta">Beta</span></h3>
<ul class="_nature">
<li class="_item"><a href="#" onclick="return false;">@txt@</a><span id="rank@rank@" style="display:none">@txt@</span></li>
</ul>
</div>
<div class="words _words">
<div class="_atcmp_result_wrap">
<ul class="_resultBox"></ul>
<ul class="_resultBox"></ul>
<ul class="_resultBox"></ul>
<ul class="_resultBox"></ul>
</div>
<!-- 우측 정답형 영역 -->
<div class="add_group _atcmp_answer_wrap"></div>
</div>
<!-- 컨텍스트 자동완성 플러스 -->
<!-- [AU] _plus -->
<div class="atcmp_plus _plus">
<span class="desc">
<span class="plus_txt _plusTxt">시간대와 관심사에 맞춘 <em class="txt">컨텍스트 자동완성</em></span>
<a class="spat ico_info" href="https://help.naver.com/support/alias/search/word/word_16.naver" onclick="__atcmpCR(event, this, 'plus.help', '','','');" target="_blank"><span class="blind">도움말 보기</span></a>
</span>
<!-- [AU] _plus_btn -->
<span class="switch _plus_btn">
<a class="btn_turnon active" href="#" onclick="__atcmpCR(event, this, 'plus.use', '','','');">ON<span class="blind">선택됨</span></a>
<a class="btn_turnoff" href="#" onclick="__atcmpCR(event, this, 'plus.unuse', '','','');">OFF</a>
</span>
<div class="layer_plus _plusAlert">
<strong class="tit">컨텍스트 자동완성</strong>
<div class="_logout" style="display:block;">
<p class="dsc"><em class="txt">동일한 시간대/연령/남녀별</em> 사용자 그룹의<br/>관심사에 맞춰 자동완성을 제공합니다.</p>
<div class="btn_area">
<a class="btn btn_login" href="https://nid.naver.com/nidlogin.login" onclick="__atcmpCR(event, this, 'plus.login', '','','');">로그인</a>
<a class="btn btn_view" href="https://help.naver.com/support/alias/search/word/word_16.naver" onclick="__atcmpCR(event, this, 'plus.detail', '','','');" target="_blank">자세히</a>
</div>
</div>
<div class="_login" style="display:none;">
<p class="dsc">ON/OFF설정은<br/>해당 기기(브라우저)에 저장됩니다.</p>
<div class="btn_area">
<a class="btn btn_view" href="https://help.naver.com/support/contents/contents.nhn?serviceNo=606&amp;categoryNo=16659" onclick="__atcmpCR(event, this, 'plus.detail', '','','');" target="_blank">자세히</a>
</div>
</div>
<button class="btn_close _close" onclick="__atcmpCR(event, this, 'plus.close', '','','');" type="button"><i class="spat ico_close">컨텍스트 자동완성 레이어 닫기</i></button>
</div>
</div>
<!-- //컨텍스트 자동완성 플러스 -->
<p class="func"><span class="fl"><a href="https://help.naver.com/support/alias/search/word/word_17.naver" onclick="__atcmpCR(event, this, 'help', '','','');" target="_blank">도움말</a><span class="atcmp_bar"></span><a href="https://help.naver.com/support/alias/search/word/word_18.naver" onclick="__atcmpCR(event, this, 'report', '','','');" target="_blank">신고</a></span><span><em><a class="hisoff" href="javascript:;">검색어저장 켜기</a><span class="atcmp_bar"></span></em><a class="funoff" href="javascript:;">자동완성 끄기</a></span></p>
<span class="atcmp_helper _help_tooltip1">기능을 다시 켤 때는 <em class="ico_search spat">자동완성 펼치기</em>을 클릭하세요</span>
</div>
<div class="api_atcmp_wrap _atcmpIng" style="display:none;">
<div class="words"><p class="info_words">현재 자동완성 기능을 사용하고 계십니다.</p></div>
<p class="func"><span class="fl"><a href="https://help.naver.com/support/alias/search/word/word_17.naver" onclick="__atcmpCR(event, this, 'help', '','','');" target="_blank">도움말</a><span class="atcmp_bar"></span><a href="https://help.naver.com/support/alias/search/word/word_18.naver" onclick="__atcmpCR(event, this, 'report', '','','');" target="_blank">신고</a></span><span><em><a class="hisoff" href="javascript:;">검색어저장 켜기</a><span class="atcmp_bar"></span></em><a class="funoff" href="javascript:;">자동완성 끄기</a></span></p>
<span class="atcmp_helper _help_tooltip2">기능을 다시 켤 때는 <em class="ico_search spat">자동완성 펼치기</em>을 클릭하세요</span>
</div>
<div class="api_atcmp_wrap _atcmpStart" style="display:none;">
<div class="words"><p class="info_words">자동완성 기능이 활성화되었습니다.</p></div>
<p class="func"><span class="fl"><a href="https://help.naver.com/support/alias/search/word/word_17.naver" onclick="__atcmpCR(event, this, 'help', '','','');" target="_blank">도움말</a><span class="atcmp_bar"></span><a href="https://help.naver.com/support/alias/search/word/word_18.naver" onclick="__atcmpCR(event, this, 'report', '','','');" target="_blank">신고</a></span><span><em><a class="hisoff" href="javascript:;">검색어저장 켜기</a><span class="atcmp_bar"></span></em><a class="funoff" href="javascript:;">자동완성 끄기</a></span></p>
<span class="atcmp_helper _help_tooltip3">기능을 다시 켤 때는 <em class="ico_search spat">자동완성 펼치기</em>을 클릭하세요</span>
</div>
<div class="api_atcmp_wrap _atcmpOff" style="display:none;">
<div class="words"><p class="info_words">자동완성 기능이 꺼져 있습니다.</p></div>
<p class="func"><span class="fl"><a href="https://help.naver.com/support/alias/search/word/word_17.naver" onclick="__atcmpCR(event, this, 'help', '','','');" target="_blank">도움말</a><span class="atcmp_bar"></span><a href="https://help.naver.com/support/alias/search/word/word_18.naver" onclick="__atcmpCR(event, this, 'report', '','','');" target="_blank">신고</a></span><span><em><a class="hisoff" href="javascript:;">검색어저장 켜기</a><span class="atcmp_bar"></span></em><a class="funoff" href="javascript:;">자동완성 켜기</a></span></p>
</div>
<!-- 최근검색어 & 내검색어 -->
<div class="api_atcmp_wrap _keywords" style="display:none;">
<div class="my_words">
<div class="lst_tab">
<ul><li class="on _recentTab"><a href="javascript:;">최근검색어</a></li><li class="_myTab"><a href="javascript:;">내 검색어</a></li></ul>
</div>
<div class="words _recent">
<ul><li data-rank="@rank@"><a class="t@my@ _star _myBtn" href="javascript:;" title="내 검색어 등록"><em class="spat">내 검색어 등록</em></a><a class="keyword" href="javascript:;">@txt@</a><em class="keyword_date">@date@.</em><a class="btn_delete spat _del" href="javascript:;" title="검색어삭제">삭제</a><span style="display:none">@in_txt@</span></li></ul>
<div class="info_words _recentNone" style="display:none">최근검색어 내역이 없습니다.</div>
<p class="info_words _offMsg" style="display:none">검색어 저장 기능이 꺼져 있습니다.</p>
</div>
<div class="words _my" style="display:none">
<ul><li data-rank="@rank@"><a class="ton _star _myBtn" href="javascript:;" title="내 검색어 해제"><em class="spat">내 검색어 해제</em></a><a class="keyword" href="javascript:;">@txt@</a></li></ul>
<div class="info_words _myNone" style="display:none">설정된 내 검색어가 없습니다.<br>최근검색어에서 <span class="star spat">내 검색어 등록</span>를 선택하여 자주 찾는 검색어를<br>내 검색어로 저장해 보세요.</br></br></div>
<p class="info_words _offMsg" style="display:none">검색어 저장 기능이 꺼져 있습니다.</p>
</div>
<p class="noti _noti" style="display:none"><em class="ico_noti spat"><span class="blind">알림</span></em>공용 PC에서는 개인정보 보호를 위하여 반드시 로그아웃을 해 주세요.</p>
<p class="func _recentBtnGroup"><span class="fl"><a class="_delMode" href="javascript:;">기록 삭제</a></span><span><a class="_keywordOff" href="javascript:;">검색어저장 끄기</a><span class="atcmp_bar"></span><a class="_acOff" href="javascript:;">자동완성 끄기</a></span></p>
<p class="func _recentDelBtnGroup" style="display:none"><span class="fl"><a class="_delAll" href="javascript:;" title="최근 검색어 기록을 모두 삭제합니다.">기록 전체 삭제</a></span><span><a class="_delDone" href="javascript:;">완료</a></span></p>
<p class="func _myBtnGroup" style="display:none"><span class="fl"><a class="_delAll" href="javascript:;" title="설정된 내 검색어를 모두 삭제합니다.">기록 전체 삭제</a></span><span><a class="_keywordOff" href="javascript:;">검색어저장 끄기</a><span class="atcmp_bar"></span><a class="_acOff" href="javascript:;">자동완성 끄기</a></span></p>
<span class="atcmp_helper _help2">기능을 다시 켤 때는 <em class="ico_search spat">자동완성 펼치기</em>을 클릭하세요</span>
<div class="ly_noti _maxLayer" style="display:none">
<span class="mask"></span>
<p><span class="ico_alert spat"></span>내 검색어는 <em>최대 10</em>개 까지 저장할 수 있습니다.<br/>추가하시려면 기존 내 검색어를 지워주세요. <a class="btn_close _close" href="javascript:;"><i class="spat ico_close">닫기</i></a></p>
</div>
</div>
</div>
<!-- 자동완성 안내문구 (선거) -->
<div class="api_atcmp_wrap _alert" style="display:none;">
<div class="api_atcmp_alert">
<span class="ico_alert spat"></span>
<p class="dsc_txt">6.13 지방선거·국회의원선거 투표종료시까지 후보자명에 대한 자동완성검색어 노출이 중단됩니다.<br/>
<a href="http://naver_diary.blog.me/221280929734" onclick="clickcr(this,'sug.vote','','',event);" target="_blank">자세히보기</a></p>
</div>
</div>
<!-- //자동완성 안내문구 (선거) -->
<!-- [D] IE 계열, wmode="window" flash와 겹치지 않기 위함 -->
<iframe border="0" hspace="0" style="display:none;display:block\9;display:block\0/;position:absolute;left:0;top:0;width:100%;height:100%;z-index:-1;" title="빈 프레임" vspace="0"></iframe>
</div>
<!--자동완성 레이어 -->
<!--자동완성 템플릿 추가-->
<!-- 신규 공통 템플릿 -->
<script id="_atcmp_answer_0" type="text/template">
    <div class="add_opt _item" data-sm="@2@" data-keyword="@1@" data-template_id="@0@" data-acir="@rank@" data-os="@8@" data-bid="@9@" data-eid="@3@" data-pkid="@10@" data-mra="@11@" >
        <a href="#" class="opt_dsc">
            <span class="dsc_thmb" style="@style7@">@image7@</span>
            <span class="dsc_group">
                <span class="dsc_cate">@6@</span>
                <strong class="dsc_word">@1@</strong>
                <span class="dsc_sub" style="@style12@">@12@</span>
            </span>
        </a>
    </div>
</script>
<!-- 로또당첨번호 -->
<script id="_atcmp_answer_3" type="text/template">
    <div class="add_opt _item" data-sm="@2@" data-keyword="@1@" data-template_id="@0@" data-acir="@rank@">
        <a href="javascript:;" class="opt_lotto">
            <span class="lotto_num_area">
                <span class="spat lotto_num lotto_num@6@">@6@</span><span class="spat lotto_num lotto_num@7@">@7@</span><span class="spat lotto_num lotto_num@8@">@8@</span><span class="spat lotto_num lotto_num@9@">@9@</span><span class="spat lotto_num lotto_num@10@">@10@</span><span class="spat lotto_num lotto_num@11@">@11@</span><span class="spat lotto_bonus">+</span><span class="spat lotto_num lotto_num@12@">@12@</span>
            </span>
            <span class="lotto_sub">@5@회차<em class="lotto_date">(@13@.)</em></span>
        </a>
    </div>
</script>
<!-- 환율:엔화환율 -->
<script id="_atcmp_answer_9" type="text/template">
    <div class="add_opt _item" data-sm="@2@" data-keyword="@1@" data-template_id="@0@" data-acir="@rank@">
        <a href="javascript:;" class="opt_exchange opt_exchange_@11@">
            <span class="opt_nation">
                <img src="https://ssl.pstatic.net/sstatic/keypage/lifesrch/exchange/ico_@12@1.gif" alt="" />
                @14@<span class="tx_nation">@money@</span>
            </span>
            <span class="opt_amount">
                <span class="amount"><strong>@6@</strong>원</span><span class="changes"><i class="bullet">@10@</i> @8@ (@9@%)<span class="opt_time"><time datetime="@fulldate@">@7@</time></span></span>
            </span>
        </a>
    </div>
</script>
<!-- 해외날씨 : 파리날씨 -->
<script id="_atcmp_answer_10" type="text/template">
    <div class="add_opt _item" data-sm="@2@" data-keyword="@1@" data-template_id="@0@" data-acir="@rank@">
        <a href="javascript:;" class="opt_weather">
            <span class="opt_weather_thmb">
                <img src="https://ssl.pstatic.net/sstatic/search/pc/img/wt_@6@.png" width="56" height="56" alt="@7@">
            </span>
            <span class="opt_weather_group">
                <span class="opt_weather_state">@7@</span>
                <span class="opt_weather_state">기온 <em class="opt_deg">@8@</em><span class="opt_unit">℃</span></span>
                <span class="opt_weather_state">@9@ <em>@10@</em><span class="opt_unit">@11@</span></span>
				<span class="opt_weather_state"><span class="opt_time"><time datetime="@fulldate@">@5@</time></span></span>
            </span>
        </a>
    </div>
</script>
<!-- 국내날씨 : 서울날씨 -->
<script id="_atcmp_answer_11" type="text/template">
    <div class="add_opt _item" data-sm="@2@" data-keyword="@1@" data-template_id="@0@" data-acir="@rank@">
        <a href="javascript:;" class="opt_weather">
            <span class="opt_weather_thmb">
                <img src="https://ssl.pstatic.net/sstatic/search/pc/img/wt_@6@.png" width="56" height="56" alt="@7@">
            </span>
            <span class="opt_weather_group">
                <span class="opt_weather_state">@7@</span>
                <span class="opt_weather_state">기온 <em class="opt_deg">@8@</em><span class="opt_unit">℃</span></span>
                <span class="opt_weather_state">@9@ <em>@10@</em><span class="opt_unit">@11@</span></span>
				<span class="opt_weather_state"><span class="opt_time"><time datetime="@fulldate@">@5@</time></span></span>
            </span>
        </a>
    </div>
</script>
<!-- 바로가기 -->
<script id="_atcmp_answer_17" type="text/template">
    <div class="add_opt _item" data-sm="@2@" data-keyword="@1@" data-template_id="@0@" data-acir="@rank@">
        <a href="@5@" target="_blank" class="opt_shortcut">
            <span class="opt_url">@display_link@</span>
            <span class="opt_txt">사이트로 바로 이동</span>
        </a>
    </div>
</script>
<!-- 해외날씨 : 국내날씨 형태로 제공하기 위한 새로운 템플릿(10번으로 ID변경됨) -->
<script id="_atcmp_answer_20" type="text/template"></script>
<!-- 문맥검색 -->
<script id="_atcmp_intend" type="text/template">
    <div class="add_opt type_context _item" data-sm="asct" data-keyword="@transquery@" data-acir="@rank@">
        <a href="#" class="opt_context">
            <span class="opt_tit"><strong>@query@</strong></span>
            <span class="opt_sub">@intend@</span>
        </a>
    </div>
</script>
<!-- 결과 키워드 템플릿 (좌측 결과목록 템플릿:정답형 템플릿 아님) -->
<script id="_atcmp_result_item_tpl" type="text/template">
    <li class="_item @url_class@" data-acr="@rank@">
        <a href="#" class="atcmp_keyword" onclick="return false;" title=""><span class="atcmp_keyword_txt">@txt@<span class="spat ic_expand"></span></span></a>
        <a href="@url@" target="_blank" class="mquick">바로이동</a>
        <span style="display:none">@in_txt@</span>
    </li>
</script>
<!-- 일반 자동완성 하이라이팅 템플릿 -->
<script id="_atcmp_keyword_highlight_tpl" type="text/template">
    @mismatch_before@<strong>@match@</strong>@mismatch_after@
</script>
<!-- 부분 자동완성 하이라이팅 템플릿 -->
<script id="_atcmp_keyword_partial_match_highlight_tpl" type="text/template">
    @mismatch_before@<strong>@match@</strong>@mismatch_after@
</script>
<!--자동완성 템플릿 추가-->
</div>
<!-- EMPTY --></div>
</div>
<div class="section_navbar">
<div class="area_navigation" role="navigation">
<ul class="an_l">
<li class="an_item">
<a class="an_a mn_mail" data-clk="svc.mail" href="http://mail.naver.com/">
<span class="an_icon"></span><span class="an_txt">메일</span>
</a>
</li>
<li class="an_item">
<a class="an_a mn_cafe" data-clk="svc.cafe" href="http://section.cafe.naver.com/">
<span class="an_icon"></span><span class="an_txt">카페</span>
</a>
</li>
<li class="an_item">
<a class="an_a mn_blog" data-clk="svc.blog" href="http://section.blog.naver.com/">
<span class="an_icon"></span><span class="an_txt">블로그</span>
</a>
</li>
<li class="an_item">
<a class="an_a mn_kin" data-clk="svc.kin" href="http://kin.naver.com/">
<span class="an_icon"></span><span class="an_txt">지식인</span>
</a>
</li>
<li class="an_item">
<a class="an_a mn_shopping" data-clk="svc.shopping" href="http://shopping2.naver.com/">
<span class="an_icon"></span><span class="an_txt">쇼핑</span>
</a>
</li>
<li class="an_item">
<a class="an_a mn_checkout" data-clk="svc.pay" href="http://pay.naver.com/">
<span class="an_icon"></span><span class="an_txt">네이버페이</span>
</a>
</li>
<li class="an_item">
<a class="an_a mn_tvcast" data-clk="svc.tvcast" href="http://tv.naver.com/">
<span class="an_icon"></span><span class="an_txt">네이버TV</span>
</a>
</li>
</ul>
<ul class="an_l" id="PM_ID_serviceNavi">
<li class="an_item"><a class="an_a mn_dic" data-clk="svc.dic" href="http://dic.naver.com/"><span class="an_icon"></span><span class="an_txt">사전</span></a></li>
<li class="an_item"><a class="an_a mn_news" data-clk="svc.news" href="http://news.naver.com/"><span class="an_icon"></span><span class="an_txt">뉴스</span></a></li>
<li class="an_item"><a class="an_a mn_stock" data-clk="svc.stock" href="http://finance.naver.com/"><span class="an_icon"></span><span class="an_txt">증권(금융)</span></a></li>
<li class="an_item"><a class="an_a mn_land" data-clk="svc.land" href="http://land.naver.com/"><span class="an_icon"></span><span class="an_txt">부동산</span></a></li>
<li class="an_item"><a class="an_a mn_map" data-clk="svc.map" href="https://map.naver.com/"><span class="an_icon"></span><span class="an_txt">지도</span></a></li>
<li class="an_item"><a class="an_a mn_movie" data-clk="svc.movie" href="http://movie.naver.com/"><span class="an_icon"></span><span class="an_txt">영화</span></a></li>
<li class="an_item"><a class="an_a mn_music" data-clk="svc.music" href="http://music.naver.com"><span class="an_icon"></span><span class="an_txt">뮤직</span></a></li>
<li class="an_item"><a class="an_a mn_book" data-clk="svc.book" href="http://book.naver.com/"><span class="an_icon"></span><span class="an_txt">책</span></a></li>
<li class="an_item"><a class="an_a mn_comic" data-clk="svc.webtoon" href="http://comic.naver.com/"><span class="an_icon"></span><span class="an_txt">만화 / 웹툰</span></a></li>
</ul>
<ul class="an_l an_custom" id="PM_ID_serviceNaviEmpty" style="display:none">
<li class="an_item an_pointer"><span class="an_empty"></span></li>
<li class="an_item"><span class="an_empty"></span></li>
<li class="an_item"><span class="an_empty"></span></li>
<li class="an_item"><span class="an_empty"></span></li>
<li class="an_item"><span class="an_empty"></span></li>
</ul>
<div class="an_bar"></div>
<a class="PM_CL_btnServiceMore an_btn_more" data-clk="svc.more" href="#" id="PM_ID_btnServiceMore" role="button"><span class="an_mtxt"><span class="blind">더보기</span></span><span class="ico_an_more"></span></a>
</div>
<div class="area_hotkeyword PM_CL_realtimeKeyword_base">
<div aria-hidden="false" class="ah_roll PM_CL_realtimeKeyword_rolling_base">
<h3 class="blind">실시간 급상승 검색어</h3>
<div class="ah_roll_area PM_CL_realtimeKeyword_rolling">
<ul class="ah_l">
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">1</span>
<span class="ah_k">나혜미</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">2</span>
<span class="ah_k">설민석</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">3</span>
<span class="ah_k">에릭</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">4</span>
<span class="ah_k">내계좌한눈에</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">5</span>
<span class="ah_k">진주날씨</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">6</span>
<span class="ah_k">이팔성</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">7</span>
<span class="ah_k">공작</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">8</span>
<span class="ah_k">하나티켓</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">9</span>
<span class="ah_k">김기덕</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">10</span>
<span class="ah_k">삼성sds</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">11</span>
<span class="ah_k">조재현</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">12</span>
<span class="ah_k">이미자</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">13</span>
<span class="ah_k">안보현</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">14</span>
<span class="ah_k">목격자</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">15</span>
<span class="ah_k">예림</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">16</span>
<span class="ah_k">정인선</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">17</span>
<span class="ah_k">한전</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">18</span>
<span class="ah_k">정준영</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">19</span>
<span class="ah_k">삼성바이오로직스</span>
</a>
</li>
<li class="ah_item">
<a class="ah_a" data-clk="lve.keyword" href="#">
<span class="ah_r">20</span>
<span class="ah_k">배틀그라운드</span>
</a>
</li>
</ul>
</div>
</div>
<span class="ah_ico_open"></span>
<div aria-hidden="true" class="ah_list PM_CL_realtimeKeyword_list_base">
<h3 class="ah_ltit">실시간 급상승</h3>
<a class="ah_ha" data-clk="lve.rankhistory" href="http://datalab.naver.com/keyword/realtimeList.naver?where=main"><span class="ah_ico_datalab">DataLab.</span>급상승 트래킹<span class="ah_ico_hlink"></span></a>
<div class="ah_tab">
<a class="ah_tab_btn ah_tab_on" data-clk="lve.tab1" data-tab="1to10" href="#" role="tab">1~10위</a>
<a class="ah_tab_btn" data-clk="lve.tab2" data-tab="11to20" href="#" role="tab">11~20위</a>
</div>
<h4 class="blind PM_CL_realtimeKeyword_sublist_heading">실시간 급상승 1~10위</h4>
<ul class="ah_l" data-list="1to10">
<li class="ah_item" data-order="1">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EB%82%98%ED%98%9C%EB%AF%B8&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EB%82%98%ED%98%9C%EB%AF%B8&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">1</span>
<span class="ah_k">나혜미</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EB%82%98%ED%98%9C%EB%AF%B8&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="2">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%84%A4%EB%AF%BC%EC%84%9D&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%84%A4%EB%AF%BC%EC%84%9D&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">2</span>
<span class="ah_k">설민석</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%84%A4%EB%AF%BC%EC%84%9D&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="3">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%97%90%EB%A6%AD&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%97%90%EB%A6%AD&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">3</span>
<span class="ah_k">에릭</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%97%90%EB%A6%AD&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="4">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EB%82%B4%EA%B3%84%EC%A2%8C%ED%95%9C%EB%88%88%EC%97%90&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EB%82%B4%EA%B3%84%EC%A2%8C%ED%95%9C%EB%88%88%EC%97%90&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">4</span>
<span class="ah_k">내계좌한눈에</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EB%82%B4%EA%B3%84%EC%A2%8C%ED%95%9C%EB%88%88%EC%97%90&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="5">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A7%84%EC%A3%BC%EB%82%A0%EC%94%A8&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A7%84%EC%A3%BC%EB%82%A0%EC%94%A8&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">5</span>
<span class="ah_k">진주날씨</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%A7%84%EC%A3%BC%EB%82%A0%EC%94%A8&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="6">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%9D%B4%ED%8C%94%EC%84%B1&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%9D%B4%ED%8C%94%EC%84%B1&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">6</span>
<span class="ah_k">이팔성</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%9D%B4%ED%8C%94%EC%84%B1&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="7">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EA%B3%B5%EC%9E%91&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EA%B3%B5%EC%9E%91&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">7</span>
<span class="ah_k">공작</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EA%B3%B5%EC%9E%91&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="8">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%ED%95%98%EB%82%98%ED%8B%B0%EC%BC%93&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%ED%95%98%EB%82%98%ED%8B%B0%EC%BC%93&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">8</span>
<span class="ah_k">하나티켓</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%ED%95%98%EB%82%98%ED%8B%B0%EC%BC%93&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="9">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EA%B9%80%EA%B8%B0%EB%8D%95&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EA%B9%80%EA%B8%B0%EB%8D%95&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">9</span>
<span class="ah_k">김기덕</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EA%B9%80%EA%B8%B0%EB%8D%95&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="10">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%82%BC%EC%84%B1sds&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%82%BC%EC%84%B1sds&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">10</span>
<span class="ah_k">삼성sds</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%82%BC%EC%84%B1sds&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
</ul>
<ul class="ah_l" data-list="11to20" style="display:none;">
<li class="ah_item" data-order="11">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A1%B0%EC%9E%AC%ED%98%84&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A1%B0%EC%9E%AC%ED%98%84&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">11</span>
<span class="ah_k">조재현</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%A1%B0%EC%9E%AC%ED%98%84&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="12">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%9D%B4%EB%AF%B8%EC%9E%90&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%9D%B4%EB%AF%B8%EC%9E%90&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">12</span>
<span class="ah_k">이미자</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%9D%B4%EB%AF%B8%EC%9E%90&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="13">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%95%88%EB%B3%B4%ED%98%84&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%95%88%EB%B3%B4%ED%98%84&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">13</span>
<span class="ah_k">안보현</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%95%88%EB%B3%B4%ED%98%84&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="14">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EB%AA%A9%EA%B2%A9%EC%9E%90&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EB%AA%A9%EA%B2%A9%EC%9E%90&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">14</span>
<span class="ah_k">목격자</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EB%AA%A9%EA%B2%A9%EC%9E%90&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="15">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%98%88%EB%A6%BC&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%98%88%EB%A6%BC&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">15</span>
<span class="ah_k">예림</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%98%88%EB%A6%BC&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="16">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A0%95%EC%9D%B8%EC%84%A0&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A0%95%EC%9D%B8%EC%84%A0&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">16</span>
<span class="ah_k">정인선</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%A0%95%EC%9D%B8%EC%84%A0&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="17">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%ED%95%9C%EC%A0%84&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%ED%95%9C%EC%A0%84&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">17</span>
<span class="ah_k">한전</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%ED%95%9C%EC%A0%84&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="18">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A0%95%EC%A4%80%EC%98%81&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%A0%95%EC%A4%80%EC%98%81&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">18</span>
<span class="ah_k">정준영</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%A0%95%EC%A4%80%EC%98%81&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="19">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EC%82%BC%EC%84%B1%EB%B0%94%EC%9D%B4%EC%98%A4%EB%A1%9C%EC%A7%81%EC%8A%A4&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EC%82%BC%EC%84%B1%EB%B0%94%EC%9D%B4%EC%98%A4%EB%A1%9C%EC%A7%81%EC%8A%A4&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">19</span>
<span class="ah_k">삼성바이오로직스</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EC%82%BC%EC%84%B1%EB%B0%94%EC%9D%B4%EC%98%A4%EB%A1%9C%EC%A7%81%EC%8A%A4&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
<li class="ah_item" data-order="20">
<a class="ah_a" data-clk="lve.keyword" data-ssl="https://search.naver.com/search.naver?where=nexearch&amp;query=%EB%B0%B0%ED%8B%80%EA%B7%B8%EB%9D%BC%EC%9A%B4%EB%93%9C&amp;sm=top_lve&amp;ie=utf8" href="http://search.naver.com/search.naver?where=nexearch&amp;query=%EB%B0%B0%ED%8B%80%EA%B7%B8%EB%9D%BC%EC%9A%B4%EB%93%9C&amp;sm=top_lve&amp;ie=utf8">
<span class="ah_r">20</span>
<span class="ah_k">배틀그라운드</span>
</a>
<a class="ah_da" data-clk="lve.kwdhistory" href="http://datalab.naver.com/keyword/realtimeDetail.naver?datetime=2018-08-08T16:34:30&amp;query=%EB%B0%B0%ED%8B%80%EA%B7%B8%EB%9D%BC%EC%9A%B4%EB%93%9C&amp;where=main">
<span class="blind">데이터랩 그래프 보기</span>
<span class="ah_ico_datagraph"></span>
</a>
</li>
</ul>
<p class="ah_time" data-time="20180808163430">2018.08.08. 16:34:30 기준 <a class="ah_btn_help" data-clk="lve.help" data-ssl="https://help.naver.com/support/alias/search/word/word_5.naver" href="http://help.naver.com/support/alias/search/word/word_5.naver">도움말</a></p>
</div>
</div>
</div>
</div>
<!-- //헤더 -->
<div style="position:relative;width:1080px;margin:0 auto;z-index:11">
<div id="da_top"></div>
<div id="da_brand"></div>
<div id="da_stake"></div>
<div id="da_expwide"></div>
</div>
<div class="container" role="main">
<div class="column_left">
<!-- AD TOP -->
<div id="veta_top">
<iframe data-veta-preview="main_time" frameborder="0" height="120" id="da_iframe_time" marginheight="0" marginwidth="0" name="da_iframe_time" scrolling="no" src="https://nv.veta.naver.com/fxshow?su=SU10079&amp;nrefreshx=0" title="광고" width="740"></iframe>
<div class="veta_bdt"></div><div class="veta_bdr"></div><div class="veta_bdb"></div><div class="veta_bdl"></div>
</div>
<!-- //AD TOP -->
<!-- 뉴스캐스트 -->
<div class="section_newscast" id="news_cast">
<div class="area_newstop">
<div class="cast_flash">
<h3 class="cf_tit">
<a class="cf_ta" data-clk="ncy.newsflash" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y">연합뉴스<span class="cf_ico_link"></span></a>
</h3>
<div class="cast_atc _PM_newsstand_rolling">
<ol class="ca_l">
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258322">삼성, 3년간 180조원 투자·4만명 채용…국내 투자만 130조</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258870">정부 "안전진단 안 받은 BMW 차량 운행중지 검토"</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258519">전국 곳곳에 '미세먼지 차단 숲' 조성…생활SOC 7조＋α투자</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258496">7∼8월 누진제 완화 혜택도 검침일 따라 '복불복'</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258242">靑 "美, 북한산 석탄문제 대응 클레임 無…'韓 신뢰' 밝혀"</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258535">"내가 노회찬 의원 죽인 놈 돼"…드루킹 최측근 '격정' 진술</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258617">폭염이 낳은 베레모 불만…육군 "전투모 연구개발 중"</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258200">편의점 판매 상비약 '겔포스 추가' 결론 또 못 냈다</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258752">"지하철 9호선 공영화" 서울메트로9호선지부 27일 파업</a></li>
<li class="ca_item"><a class="ca_a" data-clk="ncy.quickarticle" href="http://news.naver.com/main/list.nhn?mode=LPOD&amp;mid=sec&amp;sid1=001&amp;sid2=140&amp;oid=001&amp;isYeonhapFlash=Y&amp;aid=0010258620">여야, 은산분리 완화법 처리 합의…'영수증 처리' 특활비 양성화</a></li>
</ol>
</div>
</div>
<ul class="cast_link">
<li class="cl_item">
<a class="cl_a cl_news" data-clk="ncy.newshome" href="http://news.naver.com/">
네이버뉴스</a>
</li>
<li class="cl_item">
<a class="cl_a cl_ent" data-clk="ncy.entertainment" href="http://entertain.naver.com/home">
연예</a>
</li>
<li class="cl_item">
<a class="cl_a cl_sports" data-clk="ncy.sports" href="http://sports.news.naver.com/">
스포츠</a>
</li>
<li class="cl_item">
<a class="cl_a cl_finance" data-clk="ncy.economy" href="http://news.naver.com/main/main.nhn?mode=LSD&amp;mid=shm&amp;sid1=101">
경제</a>
</li>
</ul>
</div>
<div class="area_newsstand">
<div class="an_menulist">
<h3 class="an_tit">
<a class="an_ta" data-clk="nsd.title" href="http://newsstand.naver.com/" target="_blank">뉴스스탠드<span class="an_ico_link"></span></a>
</h3>
<div class="an_menulist_section1">
<div class="an_sort" role="tablist">
<a aria-selected="true" class="as_btn_press _PM_newsstand_total_type is_selected" data-clk="nsd.all" href="#" role="tab">전체 언론사</a>
<span class="as_bar" role="presentation"></span>
<a aria-selected="false" class="as_btn_my _PM_newsstand_my_type" data-clk="nsd.my" href="#" role="tab">MY 뉴스</a>
</div>
</div>
<div class="an_menulist_section2">
<div class="an_sort2" role="tablist">
<a aria-selected="true" class="as2_btn _PM_newsstand_thumb_type is_selected" data-clk="nsd.pressview" href="#" role="tab"><i class="as2_btn_ico ico_image"></i><span class="blind">이미지형</span></a>
<a aria-selected="false" class="as2_btn _PM_newsstand_list_type" data-clk="nsd.articleview" href="#" role="tab"><i class="as2_btn_ico ico_list"></i><span class="blind">리스트형</span></a>
<a class="as2_btn" data-clk="nsd.set" href="http://newsstand.naver.com/config.html" target="_blank"><i class="as2_btn_ico ico_setting"></i><span class="blind">설정</span></a>
</div>
<ul class="an_paging">
<li class="ap_list"><a class="ap_btn _PM_newsstand_prev" data-clk="nsd.prev" href="#"><i class="ap_btn_ico ico_left"></i><span class="blind">이전 페이지</span></a></li>
<li class="ap_list"><a class="ap_btn _PM_newsstand_next" data-clk="nsd.next" href="#"><i class="ap_btn_ico ico_right"></i><span class="blind">다음 페이지</span></a></li>
</ul>
</div>
</div>
<div class="an_panel_image _PM_newsstand_thumb" role="tabpanel">
<div class="api_list_wrap">
<h3><span class="blind">언론사 목록</span></h3>
<div class="flick-view">
<div class="flick-container">
<div class="flick-panel">
<ul class="api_list">
<li class="api_item" data-pid="139" id="NS_139">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=139" target="_blank">
<img alt="스포탈코리아" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd151840663.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="139" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="139" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=139" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="079" id="NS_079">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=079" target="_blank">
<img alt="노컷뉴스" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143958887.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="079" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="079" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=079" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="044" id="NS_044">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=044" target="_blank">
<img alt="코리아헤럴드" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17341942.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="044" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="044" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=044" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="277" id="NS_277">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=277" target="_blank">
<img alt="아시아경제" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153432228.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="277" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="277" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=277" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="006" id="NS_006">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=006" target="_blank">
<img alt="미디어오늘" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145346617.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="006" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="006" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=006" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="076" id="NS_076">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=076" target="_blank">
<img alt="스포츠조선" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd183553864.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="076" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="076" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=076" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="038" id="NS_038">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=038" target="_blank">
<img alt="한국일보" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172837200.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="038" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="038" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=038" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="376" id="NS_376">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=376" target="_blank">
<img alt="지지통신" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16432873.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="376" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="376" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=376" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="052" id="NS_052">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=052" target="_blank">
<img alt="YTN" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173559874.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="052" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="052" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=052" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="031" id="NS_031">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=031" target="_blank">
<img alt="아이뉴스24" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153955864.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="031" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="031" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=031" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="009" id="NS_009">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=009" target="_blank">
<img alt="매일경제" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145032565.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="009" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="009" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=009" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="326" id="NS_326">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct1&amp;pcode=326" target="_blank">
<img alt="KBS World" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173138949.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="326" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="326" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct1&amp;pcode=326" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="477" id="NS_477">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct6&amp;pcode=477" target="_blank">
<img alt="스포티비뉴스" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/1221/nsd134325318.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="477" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="477" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct6&amp;pcode=477" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="364" id="NS_364">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct7&amp;pcode=364" target="_blank">
<img alt="PC사랑" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173322105.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="364" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="364" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct7&amp;pcode=364" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="917" id="NS_917">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct4&amp;pcode=917" target="_blank">
<img alt="IT조선" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173057968.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="917" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="917" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct4&amp;pcode=917" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="966" id="NS_966">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct7&amp;pcode=966" target="_blank">
<img alt="정신의학신문" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161847464.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="966" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="966" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct7&amp;pcode=966" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="932" id="NS_932">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct2&amp;pcode=932" target="_blank">
<img alt="CEO스코어데일리" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2018/0627/nsd124328796.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="932" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="932" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct2&amp;pcode=932" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
<li class="api_item" data-pid="923" id="NS_923">
<a aria-haspopup="true" class="api_link" href="http://newsstand.naver.com/?list=ct2&amp;pcode=923" target="_blank">
<img alt="인민망" class="api_logo" height="24" src="https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154522345.png"/>
</a>
<div class="api_popup_btn_set" role="alertdialog">
<div class="api_pbs_inner">
<a class="api_pbs_btn _PM_newsstand_subscribe" data-clk="nsd_all*p.sub" data-pid="923" href="#" role="button">구독</a>
<a class="api_pbs_btn _PM_newsstand_unsubscribe" data-clk="nsd_all*p.sub" data-pid="923" href="#" role="button" style="display:none">해지</a>
<a class="api_pbs_btn api_pbs_lb" data-all-clk="nsd_all*p.logo" data-my-clk="nsd_myn*p.logo" href="http://newsstand.naver.com/?list=ct2&amp;pcode=923" role="button" target="_blank">기사보기</a>
</div>
</div>
</li>
</ul>
</div>
</div>
</div>
<i aria-hidden="true" class="api_list_border_right" role="presentation"></i>
<i aria-hidden="true" class="api_list_border_horizontal1" role="presentation"></i>
<i aria-hidden="true" class="api_list_border_horizontal2" role="presentation"></i>
</div>
</div>
<div aria-hidden="false" class="an_panel_list _PM_newsstand_list" role="tabpanel" style="display:none;">
<div class="apl_category_wrap">
<h3><span class="blind">언론사 목록</span></h3>
<ul class="aplc_list" data-tab="total">
<li class="aplc_item"><a class="aplc_link is_selected" data-category="ct2" data-clk="nsd_all.daei" href="#"><span class="aplc_name">종합/경제</span><span class="aplc_paging"></span></a></li>
<li class="aplc_item"><a class="aplc_link" data-category="ct3" data-clk="nsd_all.dtvcom" href="#"><span class="aplc_name">방송/통신</span><span class="aplc_paging"></span></a></li>
<li class="aplc_item"><a class="aplc_link" data-category="ct4" data-clk="nsd_all.dit" href="#"><span class="aplc_name">IT</span><span class="aplc_paging"></span></a></li>
<li class="aplc_item"><a class="aplc_link" data-category="ct5" data-clk="nsd_all.deng" href="#"><span class="aplc_name">영자지</span><span class="aplc_paging"></span></a></li>
<li class="aplc_item"><a class="aplc_link" data-category="ct6" data-clk="nsd_all.dsporent" href="#"><span class="aplc_name">스포츠/연예</span><span class="aplc_paging"></span></a></li>
<li class="aplc_item"><a class="aplc_link" data-category="ct7" data-clk="nsd_all.dmagtec" href="#"><span class="aplc_name">매거진/전문지</span><span class="aplc_paging"></span></a></li>
<li class="aplc_item"><a class="aplc_link" data-category="ct8" data-clk="nsd_all.dloc" href="#"><span class="aplc_name">지역</span><span class="aplc_paging"></span></a></li>
</ul>
<ul class="aplc_list" data-tab="my" style="display:none;">
<!-- nvpaperlist:empty -->
</ul>
</div>
<div class="flick-view">
<div class="flick-container">
<div class="flick-panel">
</div>
</div>
</div>
</div>
<div aria-hidden="false" class="an_panel_list _PM_newsstand_info" role="tabpanel" style="display:none;">
<div class="flick-view">
<div class="flick-container">
<div class="flick-panel">
<div class="an_nopress_view">
<div class="anv_wrap">
<em class="anv_tit">설정한 언론사가 없습니다.</em><p class="anv_text">언론사 구독 설정에서 MY언론사를 추가하면</p><p class="anv_text">설정한 언론사의 기사들을 네이버 홈에서 바로 보실 수 있습니다.</p>
<a class="anv_btn" data-clk="nsd_myn*a.thum" href="http://newsstand.naver.com/config.html" role="button" target="_blank">언론사 추가</a>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="PM_CL_newsstand_layer">
</div>
</div>
</div>
<!-- //뉴스캐스트 -->
</div>
<div class="column_right">
<!-- 로그인 -->
<div class="section_login" id="account">
<h2 class="blind">Sign in</h2>
<div class="lg_global">
<p class="lg_global_text">Connect with people</p>
<a class="lg_global_btn" data-clk="log_off.login" href="https://nid.naver.com/nidlogin.login?mode=form&amp;url=https%3A%2F%2Fwww.naver.com" role="button">
<i class="ico_global_login lang_en_v1"><span class="blind">NAVER Sign in</span></i>
</a>
<div class="lg_links">
<a class="lg_link_join" data-clk="log_off.registration" href="https://nid.naver.com/nidregister.form?url=https%3A%2F%2Fwww.naver.com">Sign up</a>
<span class="lg_link_find">Forgot <a class="lg_find_text_en" data-clk="log_off.searchid" href="https://nid.naver.com/user/help.nhn?todo=idinquiry">Username</a> or <a class="lg_find_text_en" data-clk="log_off.searchpass" href="https://nid.naver.com/nidreminder.form">Password?</a></span>
</div>
</div>
</div>
<!-- //로그인 -->
<div id="ad_branding_hide"></div>
<!-- 타임스퀘어 -->
<div class="_PM_timesquare_wrapper" id="time_square">
<div class="section_timesquare _PM_timesquare_base" data-code="conversation">
<h2 class="blind">타임스퀘어</h2>
<div class="area_header">
<div class="header_info _PM_timesquare_info">
<a class="hi_date" data-clk="squ.date" href="https://calendar.naver.com"><span class="hi_dnum">08.08.</span><span class="hi_day">(수)</span></a><i aria-hidden="true" class="hi_slash" role="presentation">|</i>
<a class="hi_tit _PM_timesquare_lang_type" data-clk="squ_lan.set" href="#">영어회화<i aria-hidden="true" class="ico_btn_arrow"></i></a>
</div>
<div class="header_paging _PM_timesquare_navi">
</div>
<div class="header_btns">
<a class="header_btn_prev" data-clk="squ.pre" href="#"><i aria-hidden="true" class="ico_btn_prev"></i><span class="blind">앞의 목록으로 이동</span></a>
<a class="header_btn_next" data-clk="squ.next" href="#"><i aria-hidden="true" class="ico_btn_next"></i><span class="blind">뒤의 목록으로 이동</span></a>
</div>
</div>
<div class="area_ct">
<div class="flick-view">
<div class="flick-container">
<div class="flick-panel _PM_timesquare_list" data-code="conversation">
<div class="type_conv">
<a class="tc_link" data-clk="squ_lan.con" href="http://phrasebook.naver.com/detail.nhn?bigCategoryNo=6&amp;middleCategoryNo=54&amp;smallCategoryNo=259&amp;targetLanguage=en">
<div class="tc_content">
<p class="tc_tt">좀 <em class="tc_accent">둘러봐도</em> 될까요?</p>
<p class="tc_st">Can I <em class="tc_accent">look around</em>? </p>
<p class="tc_pronounce">캔 아이 <em class="tc_accent">룩 어라운드</em>?</p>
</div>
</a>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<!-- //타임스퀘어 -->
<!-- 광고 -->
<div id="veta_branding">
<iframe data-veta-preview="main_rolling" frameborder="0" height="150" id="da_iframe_rolling" marginheight="0" marginwidth="0" name="da_iframe_rolling" scrolling="no" src="https://nv.veta.naver.com/fxshow?su=SU10078&amp;nrefreshx=0" title="광고" width="332"></iframe>
<div class="veta_bdt"></div><div class="veta_bdr"></div><div class="veta_bdb"></div><div class="veta_bdl"></div>
</div>
<!-- //광고 -->
</div>
<!-- EMPTY -->
<div class="column_bottom">
<!-- 주제형캐스트 -->
<div class="section_themecast" id="themecast">
<h2 class="blind">주제형 캐스트</h2>
<div class="themecast_category" id="PM_ID_themecastNavi">
<div class="area_category">
<h3 class="blind">관심 주제 선택</h3>
<div class="ac_scroll" role="tablist">
<div class="scroll-area" role="presentation">
<!-- style="width:xxxxPX" -->
<div class="rolling-container" id="PM_ID_themelist" role="presentation" style="width:587;overflow:hidden;">
<ul style="width:2000px">
<li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_livinghome" data-clk="tct.lif" data-id="LIVINGHOME" data-nclick="lif" href="#LIVINGHOME" role="tab">리빙</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_living" data-clk="tct.fod" data-id="LIVING" data-nclick="fod" href="#LIVING" role="tab">푸드</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_sports" data-clk="tct.spo" data-id="SPORTS" data-nclick="spo" href="#SPORTS" role="tab">스포츠</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_cargame" data-clk="tct.aut" data-id="CARGAME" data-nclick="aut" href="#CARGAME" role="tab">자동차</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_beauty" data-clk="tct.bty" data-id="BEAUTY" data-nclick="bty" href="#BEAUTY" role="tab">패션뷰티</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_momkids" data-clk="tct.mom" data-id="MOMKIDS" data-nclick="mom" href="#MOMKIDS" role="tab">부모i</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_health" data-clk="tct.hea" data-id="HEALTH" data-nclick="hea" href="#HEALTH" role="tab">건강</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_bboom" data-clk="tct.web" data-id="BBOOM" data-nclick="web" href="#BBOOM" role="tab">웹툰</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_gameapp" data-clk="tct.gam" data-id="GAMEAPP" data-nclick="gam" href="#GAMEAPP" role="tab">게임</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_video" data-clk="tct.tvc" data-id="VIDEO" data-nclick="tvc" href="#VIDEO" role="tab">TV연예</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_music" data-clk="tct.muc" data-id="MUSIC" data-nclick="muc" href="#MUSIC" role="tab">뮤직</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_movie" data-clk="tct.mov" data-id="MOVIE" data-nclick="mov" href="#MOVIE" role="tab">영화</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_culture" data-clk="tct.bok" data-id="CULTURE" data-nclick="bok" href="#CULTURE" role="tab">책문화</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_with" data-clk="tct.pub" data-id="WITH" data-nclick="pub" href="#WITH" role="tab">함께N</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_travel" data-clk="tct.tra" data-id="TRAVEL" data-nclick="tra" href="#TRAVEL" role="tab">여행+</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_design" data-clk="tct.des" data-id="DESIGN" data-nclick="des" href="#DESIGN" role="tab">디자인</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_finance" data-clk="tct.fin" data-id="FINANCE" data-nclick="fin" href="#FINANCE" role="tab">경제M</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_job" data-clk="tct.job" data-id="JOB" data-nclick="job" href="#JOB" role="tab">JOB&amp;</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_science" data-clk="tct.sci" data-id="SCIENCE" data-nclick="sci" href="#SCIENCE" role="tab">과학</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_china" data-clk="tct.chn" data-id="CHINA" data-nclick="chn" href="#CHINA" role="tab">중국</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_business" data-clk="tct.bsn" data-id="BUSINESS" data-nclick="bsn" href="#BUSINESS" role="tab">비즈니스</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_farm" data-clk="tct.far" data-id="FARM" data-nclick="far" href="#FARM" role="tab">FARM</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_school" data-clk="tct.scl" data-id="SCHOOL" data-nclick="scl" href="#SCHOOL" role="tab">스쿨잼</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_show" data-clk="tct.sow" data-id="SHOW" data-nclick="sow" href="#SHOW" role="tab">공연전시</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_law" data-clk="tct.law" data-id="LAW" data-nclick="law" href="#LAW" role="tab">법률</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_animal" data-clk="tct.ani" data-id="ANIMAL" data-nclick="ani" href="#ANIMAL" role="tab">동물공감</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_wedding" data-clk="tct.wed" data-id="WEDDING" data-nclick="wed" href="#WEDDING" role="tab">연애·결혼</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="true" class="PM_CL_themeItem ac_a tcc_ittech" data-clk="tct.tec" data-id="ITTECH" data-nclick="tec" href="#ITTECH" role="tab">테크</a>
</li><li class="rolling-panel" role="presentation">
<a aria-selected="false" class="PM_CL_themeItem ac_a tcc_emotion" data-clk="tct.emo" data-id="EMOTION" data-nclick="emo" href="#EMOTION" role="tab">감성충전</a>
</li>
</ul>
</div>
</div>
</div>
</div>
<div class="area_catebtns">
<a class="ac_btn_prev PM_CL_btnThemePrev" data-clk="tct.prev" href="#" role="button"><span class="blind">이전 주제</span><span class="ac_bicon"></span></a>
<a class="ac_btn_next PM_CL_btnThemeNext" data-clk="tct.next" href="#" role="button"><span class="blind">다음 주제</span><span class="ac_bicon"></span></a>
<a class="ac_btn_cate PM_CL_btnThemeEdit" data-clk="tct.menu" href="#" role="button"><span class="blind">전체 주제 열기</span><span class="ac_bicon"></span></a>
<div class="ac_bgl" id="PM_ID_themeNaviLeft" style="display:none"></div>
<div class="ac_bgr" id="PM_ID_themeNaviRight" style="display:none"></div>
</div>
</div>
<div aria-hidden="true" class="area_themesetting" id="PM_ID_themeEdit">
<h3 class="blind">관심 주제 설정</h3>
<script id="PM_ID_themeEditItem" type="text/template">
		<li class="at_item PM_CL_themeEditItem" data-clk="tca*l.{=nclick}">
			<div class="at_iw" role="checkbox" aria-checked="{if subscribed}true{/if}" >
				<span class="at_iradio">
					<span data-id="{=code}" class="PM_CL_themeItemCheck radio-mark{if subscribed} radio-checked{/if}"></span>
					<input type="checkbox" id="config_tcc_{=css}" class="at_ipt">
				</span>
				<label for="config_tcc_{=css}">{=name}</label>
			</div>
		</li>
	</script>
<script id="PM_ID_themeSelectItem" type="text/template">
		<li class="at_item" role="presentation" data-clk="tca.{=nclick}"{if subscribed} data-nclick="{=nclick}"{/if}>
			<a href="#{=code}" data-id="{=code}" role="tab" aria-selected="{if subscribed}true{else}false{/if}" class="PM_CL_themeItemSelect at_a tcc_{=css}">
				<span class="at_icon"></span>{=name}
				{if isNewPanel }<span class="at_ico_new">NEW</span>{/if}
			</a>
		</li>
	</script>
<script id="PM_ID_themeNaviItem" type="text/template">
		<li class="rolling-panel" role="presentation">
			<span href="#{=code}" data-id="{=code}" role="tab" aria-selected="false" class="ac_a tcc_{=css}">{=name}</span>
		</li>	
	</script>
<script id="PM_ID_themeNaviEmptyItem" type="text/template">
		<li class="rolling-panel{if first} ac_pointer {/if}" role="presentation">
			<span class="ac_empty"></span>
		</li>
	</script>
<script id="PM_ID_themeSubscribePopup" type="text/template">
		<div class="area_alert_confirm" style="top:{=top}px;left:{=left}px">
			<div class="aa_wrap">
				<p class="aa_txt"><strong class="aa_st tcc_{=css}">'{=name}'</strong>를 관심주제로 <br>설정하시겠습니까?</p>
				<div class="aa_btns">
					<a href="#" data-id="{=code}" data-nclick="{=nclick}" role="button" class="PM_CL_themeAddOk aa_btn_confirm" data-clk="tca.likeok">확인</a>
					<a href="#" role="button" class="PM_CL_themeAddCancel aa_btn_cancel" data-clk="tca.likecancel">취소</a>
				</div>
			</div>
		</div>
	</script>
<script id="PM_ID_themeImportPopup" type="text/template">
		<div class="area_alert_confirm">
			<div class="aa_wrap">
			<p class="aa_txt"><strong class="aa_st">모바일에서 설정한 주제</strong>를 <br>가져오시겠습니까?</p>
			<div class="aa_btns">
				<a href="#" role="button" class="PM_CL_themeImportOk aa_btn_confirm" data-clk="tca.mobileok">확인</a>
				<a href="#" role="button" class="PM_CL_themeImportCancel aa_btn_cancel" data-clk="tca.mobilecancel">취소</a>
				</div>
			</div>
		</div>	
	</script>
<ul class="at_all" id="PM_ID_themeEditItemList" role="tablist">
</ul>
<a class="at_btn_close PM_CL_btnThemeEdit" data-clk="tca.close" href="#" role="button"><span class="blind">전체 주제 목록 닫기</span><span class="at_bicon"></span></a>
<div class="at_btns" id="PM_ID_btnBoxShortcut">
<a class="at_btn_setting PM_CL_btnThemeEditShow" data-clk="tca.like" href="#" role="button"><span class="at_bicon"></span>관심주제 설정</a>
<span class="at_bar"></span>
<a class="at_btn_import PM_CL_btnThemeImport" data-clk="tca.mobile" data-login-url="https://nid.naver.com/nidlogin.login?url=http%3A%2F%2Fwww.naver.com" href="#" role="button"><span class="at_bicon"></span>모바일 관심 주제 가져오기</a>
<span class="at_import_login PM_CL_importMessage2" style="display:none">
<span class="at_lt" data-clk="tca.tip" href="https://nid.naver.com/nidlogin.login?url=http%3A%2F%2Fwww.naver.com">
<strong class="at_ls">로그인</strong>후 사용 가능합니다
	</span>
</span>
</div>
<div class="at_btns" id="PM_ID_btnBoxEdit" style="display:none" v="">
<a class="at_btn_cancel PM_CL_btnThemeEditCancel" data-clk="tca*l.cancel" href="#" role="button">취소</a>
<a class="at_btn_confirm PM_CL_btnThemeEditOk" data-clk="tca*l.ok" href="#" role="button">확인</a>
<a class="at_btn_reset PM_CL_btnThemeEditInit" data-clk="tca*l.reset" href="#" role="button"><span class="at_bicon"></span>초기화</a>
<a class="at_btn_all PM_CL_btnThemeSelectAll" data-clk="" href="#" role="button">전체선택</a>
<span class="at_bar"></span>
<a class="at_btn_import PM_CL_btnThemeImport" data-clk="tca.mobile" data-login-url="https://nid.naver.com/nidlogin.login?url=http%3A%2F%2Fwww.naver.com" href="#" role="button"><span class="at_bicon"></span>모바일 관심 주제 가져오기</a>
<span class="at_import_login PM_CL_importMessage2" style="display:none">
<span class="at_lt" data-clk="tca.tip" href="https://nid.naver.com/nidlogin.login?url=http%3A%2F%2Fwww.naver.com">
<strong class="at_ls">로그인</strong>후 사용 가능합니다
	</span>
</span>
</div>
</div>
<div class="themecast_flick" id="PM_ID_themecastBody">
<div class="flick-container">
<div class="flick-panel">
<div class="area_themecast id_ittech">
<!--EMPTY-->
<ul class="themecast_list">
<li class="tl_title" data-seq="56875">
<div class="tt_mw">
<img alt="" class="tt_m" height="185" src="https://s.pstatic.net/static/www/mobile/edit/2017/0919/mobile_162350203660.jpg" width="166"/>
</div>
<h3 class="tt_tit">테크</h3>
<div class="tt_bar"></div>
<a class="tt_d" data-clk="tcc_tec.link" data-gdid="UAT_1756313" href="http://blog.naver.com/tech-plus">상상, <br> 그 이상의 <br/>테크 스토리</br></a>
<a class="tt_o" href="http://blog.naver.com/tech-plus">(주)테크플러스</a>
</li><li class="tl_default" data-expsendymdt="2018-08-11 23:59" data-expsstartymdt="2018-08-08 16:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="197233" data-title="군사용으로 시작된 기술 - 인터넷">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3025523" href="https://blog.naver.com/PostView.nhn?blogId=dapapr&amp;logNo=221332076888&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Fdapapr%2F221332076888">
<span class="td_mw">
<img alt="" class="td_m" height="108" src="https://s.pstatic.net/static/www/mobile/edit/2018/0807/mobile_175514970714.PNG" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">군사용으로 시작된 기술 - 인터넷</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">알쏭달쏭 : 기술백서</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-11 23:59" data-expsstartymdt="2018-08-08 14:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="197209" data-title="5G를 둘러싼 다양한 산업들">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3025245" href="https://post.naver.com/viewer/postView.nhn?volumeNo=16430095&amp;memberNo=36410102">
<span class="td_mw">
<img alt="" class="td_m" height="108" src="https://s.pstatic.net/static/www/mobile/edit/2018/0807/mobile_173636536331.PNG" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">5G를 둘러싼 다양한 산업들</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">에디터 초이스</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-11 23:59" data-expsstartymdt="2018-08-08 12:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="197211" data-title='"페북, 인스타 하루 1시간만 봐야지" 셀프조절 가능'>
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3025454" href="https://blog.naver.com/PostView.nhn?blogId=tech-plus&amp;logNo=221331281296&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Ftech-plus%2F221331281296">
<span class="td_mw">
<img alt="" class="td_m" height="108" src="https://s.pstatic.net/static/www/mobile/edit/2018/0807/cropImg_166x108_134098942014658476.jpeg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">"페북, 인스타 하루 1시간만 봐야지" 셀프조절 가능</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">기획 : 방송통신이야기</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-11 23:59" data-expsstartymdt="2018-08-08 10:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="197230" data-title="순토9 나의 새로운 운동파트너 스포츠 스마트워치">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3025493" href="https://blog.naver.com/PostView.nhn?blogId=gangsinjin&amp;logNo=221329699123&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Fgangsinjin%2F221329699123">
<span class="td_mw">
<img alt="" class="td_m" height="108" src="https://s.pstatic.net/static/www/mobile/edit/2018/0807/mobile_175033917180.PNG" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">순토9 나의 새로운 운동파트너 스포츠 스마트워치</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">디바이스 탐구생활</span>
</span>
</li>
<script data-veta-type="empty" id="p_main_ittech_00_script" type="text/template">
(function() {
    var isUnderIE9 = AgentDetect.IS_IE && AgentDetect.searchBrowserVersion() < 9.0;

    if (isUnderIE9 === true) {
        String.prototype.trim = function () {
            return this.replace(/^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g, "");
        };
    }
	var naver_corp_da = window.naver_corp_da || {};
	var da_dom_id = 'p_main_ittech_00'.trim();
	var uId = (da_dom_id.length > 0) ? da_dom_id : (typeof nbp_ad !== 'undefined') ? nbp_ad.mobilenetwork.ad_div_id : 'adw_da';
	var tarEl = NBP_CORP.$(uId);
	
	var util = naver_corp_da.Util ? new naver_corp_da.Util() : new NBP_CORP.Nimp();

	if(tarEl) {
		/* ActiveView */
		var ac_end_date = "20301231235959";
		var ad_end_date = "20301231235959";

		var scroll_target = (typeof da_scroll_target !== 'undefined') ? da_scroll_target.targetEl : window;
		var orientation_change_time = 500;

		var callback = function () {
			var url = "https://nv.veta.naver.com/fxview?eu=EU10030105&calp=-&ac=7560751&src=3184385&evtcd=C1073&x_ti=944&tb=ITTECH_1&oid=&sid1=&sid2=&rk=7d178538a1e91f187975eb9f56fade85&eltts=JRHHJbX8wmwWuMtw%2BjOvZg%3D%3D&brs=Y&&eid=V900&x_ev=";
			var x_ev = '';
			try {
				var target = NBP_CORP.$(uId);
				x_ev = (target) ? ((parseInt(target.getBoundingClientRect().height || target.offsetHeight, 10) === 0) ? '000' : '111') : '000';
			} catch(e) {
				x_ev = '000';
			} finally {
				url += x_ev;
				util.log(url);
			}
		};

		var callbackForInValid = function () {};

		naver_corp_da.activeViews[uId] = naver_corp_da.activeViews[uId] || null;

		if(naver_corp_da.activeViews[uId]) {
			naver_corp_da.activeViews[uId].clearActiveView();
			naver_corp_da.activeViews[uId] = null;
		} 

		naver_corp_da.activeViews[uId] = new naver_corp_da.ActiveView({
			adDivId : uId,
			acEndDate : ac_end_date,
			adEndDate : ad_end_date,
			scrollTarget : scroll_target,
			activeViewTime : 1000,
			activeViewPercentage : 0.5,
			orientationChangeTime : orientation_change_time,
			callback : callback,
			callbackForInValid : callbackForInValid
		});

		naver_corp_da.activeViews[uId].checkActiveView();
	}
})();
</script>
<li class="tl_default" data-expsendymdt="2018-08-11 23:59" data-expsstartymdt="2018-08-08 08:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="197208" data-title="블록체인 섬으로 거듭나는 몰타(Malta)">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3025215" href="https://blog.naver.com/PostView.nhn?blogId=tech-plus&amp;logNo=221332067453&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Ftech-plus%2F221332067453">
<span class="td_mw">
<img alt="" class="td_m" height="108" src="https://s.pstatic.net/static/www/mobile/edit/2018/0807/mobile_173536635759.PNG" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">블록체인 섬으로 거듭나는 몰타(Malta)</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">에디터 초이스</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-11 23:59" data-expsstartymdt="2018-08-08 06:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="197235" data-title="뽀송뽀송하게 만들어주는 제습기! 제습기의 원리는?">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3025530" href="https://blog.naver.com/PostView.nhn?blogId=kma_131&amp;logNo=221329838474&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Fkma_131%2F221329838474">
<span class="td_mw">
<img alt="" class="td_m" height="108" src="https://s.pstatic.net/static/www/mobile/edit/2018/0807/mobile_175702992275.PNG" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">뽀송뽀송하게 만들어주는 제습기! 제습기의 원리는?</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">알쏭달쏭 : 기술백서</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-10 23:59" data-expsstartymdt="2018-08-07 20:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196637" data-title="대화면, 고성능 울트라북이 필요한 당신, 에이서 스위프트 3">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3019115" href="https://post.naver.com/viewer/postView.nhn?volumeNo=16433528&amp;memberNo=11534881">
<span class="td_mw">
<img alt="" class="td_m" height="108" src="https://s.pstatic.net/static/www/mobile/edit/2018/0806/mobile_164809861754.PNG" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">대화면, 고성능 울트라북이 필요한 당신, 에이서 스위프트 3</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">디바이스 탐구생활</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-10 23:59" data-expsstartymdt="2018-08-07 16:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196643" data-title="스타트업에서 여성 개발자로 일하는 것">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3019148" href="https://post.naver.com/viewer/postView.nhn?volumeNo=16412173&amp;memberNo=27889218&amp;searchKeyword=%EC%8A%A4%ED%83%80%ED%8A%B8%EC%97%85&amp;searchRank=7">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://s.pstatic.net/static/www/mobile/edit/2018/0806/mobile_165226753324.PNG" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">스타트업에서 여성 개발자로 일하는 것</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">스타트업 라운지</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-10 23:59" data-expsstartymdt="2018-08-07 14:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196645" data-title="아이폰에 이어 아이패드 프로까지 이어폰 단자 제거?">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3019168" href="https://post.naver.com/viewer/postView.nhn?volumeNo=16419965&amp;memberNo=32922216">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://s.pstatic.net/static/www/mobile/edit/2018/0806/cropImg_166x108_134009332645572377.jpeg" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">아이폰에 이어 아이패드 프로까지 이어폰 단자 제거?</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">기획 : 음향기기</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-09 23:59" data-expsstartymdt="2018-08-07 13:30" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196932" data-title="‘취업=발품’…잘 나가는 SW기업 찾기">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3021999" href="https://blog.naver.com/PostView.nhn?blogId=tech-plus&amp;logNo=221334080392&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Ftech-plus%2F221334080392">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://blogthumb.pstatic.net/MjAxODA4MDdfMjgy/MDAxNTMzNjA0OTczNTc4.eGhJ9uI9X3oCAJMMH_sgMo6YbrPW6eyFg7-hj7f_tE8g.d3SVnq5idpMTNMvOcKAtxcfi0PJGjrfwcym0QPym-aYg.JPEG.tech-plus/%C3%A4%BF%EB_%B8%E9%C1%A2_%BB%E7%C1%F8.jpg?type=w2" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">‘취업=발품’…잘 나가는 SW기업 찾기</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">에디터 초이스</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-10 23:59" data-expsstartymdt="2018-08-07 12:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196647" data-title="세계 태블릿 시장 하락세 속 애플‧화웨이만 ↑">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3019209" href="https://blog.naver.com/PostView.nhn?blogId=tech-plus&amp;logNo=221332023524&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Ftech-plus%2F221332023524">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://s.pstatic.net/static/www/mobile/edit/2018/0806/mobile_16575441704.jpg" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">세계 태블릿 시장 하락세 속 애플‧화웨이만 ↑</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">에디터 초이스</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-10 23:59" data-expsstartymdt="2018-08-07 10:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196641" data-title="샤오미가 만든 피처폰 샤오미 진(Qin)">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3019141" href="https://post.naver.com/viewer/postView.nhn?volumeNo=16445494&amp;memberNo=501&amp;navigationType=push">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://s.pstatic.net/static/www/mobile/edit/2018/0806/mobile_165039235277.PNG" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">샤오미가 만든 피처폰 샤오미 진(Qin)</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">디바이스 탐구생활</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-10 23:59" data-expsstartymdt="2018-08-07 08:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196625" data-title="깜깜한 바닷속, 귀로 본다! 소나(Sonar)">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3019085" href="https://blog.naver.com/PostView.nhn?blogId=tech-plus&amp;logNo=221333429191&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Ftech-plus%2F221333429191">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://s.pstatic.net/static/www/mobile/edit/2018/0806/cropImg_166x108_134008856692611505.jpeg" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">깜깜한 바닷속, 귀로 본다! 소나(Sonar)</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">밀리터리 인 테크</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-10 23:59" data-expsstartymdt="2018-08-07 06:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196622" data-title="HD? FHD? 4K? 8K? TV 해상도에 대해 알아보자!">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3019075" href="https://post.naver.com/viewer/postView.nhn?volumeNo=16423390&amp;memberNo=10728965&amp;navigationType=push">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://s.pstatic.net/static/www/mobile/edit/2018/0806/cropImg_166x108_134008939508582745.jpeg" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">HD? FHD? 4K? 8K? TV 해상도에 대해 알아보자!</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">IT용어사전</span>
</span>
</li>
<li class="tl_default" data-expsendymdt="2018-08-09 23:59" data-expsstartymdt="2018-08-06 18:00" data-fixedexpsendymdt="" data-fixedexpsstartymdt="" data-fixedseq="0" data-seq="196009" data-title="가성비 스마트폰, 샤오미 미믹스2S 사용해보니">
<a class="td_a" data-clk="tcc_tec.contents" data-gdid="UAT_3014464" href="https://blog.naver.com/PostView.nhn?blogId=seagreen0314&amp;logNo=221330602729&amp;proxyReferer=&amp;proxyReferer=https%3A%2F%2Fblog.naver.com%2Fseagreen0314%2F221330602729">
<span class="td_mw">
<img alt="" class="td_m" data-src="https://s.pstatic.net/static/www/mobile/edit/2018/0803/cropImg_166x108_133752688834268884.jpeg" height="108" src="https://s.pstatic.net/static/www/m/guide/dummy_1X1.jpg" width="166"/>
<span class="td_bd"></span>
</span>
<span class="td_tw">
<span class="td_t">가성비 스마트폰, 샤오미 미믹스2S 사용해보니</span>
</span>
</a>
<span class="td_ow">
<span class="td_o">디바이스 탐구생활</span>
</span>
</li>
</ul>
</div>
</div>
</div>
</div>
</div>
<!-- //주제형캐스트 -->
<div class="section_shoppingcast" id="shp_cst">
<iframe frameborder="0" height="882" id="cnsv_shbx" marginheight="0" marginwidth="0" scrolling="no" src="https://castbox.shopping.naver.com/shopbox/main.nhn?svgless=true" title="쇼핑캐스트" width="330">쇼핑캐스트 : <a href="https://castbox.shopping.naver.com/shopbox/main.nhn?svgless=true">https://castbox.shopping.naver.com/shopbox/main.nhn?svgless=true</a></iframe>
</div>
<!-- 쇼핑캐스트 -->
<!-- //쇼핑캐스트 -->
</div>
<div class="column_banner">
<div class="section_btmbn">
<ul class="btmbanner_list">
<li class="bl_item">
<a class="bl_a" data-clk="mcb.left" href="https://happybean.naver.com/flower/brand/withmy" target="_blank">
<div class="bl_mw">
<img alt="해피빈 공감 천연유래성분 치약 임산부도 안심하고 사용하는 안전한 레몬향 치약" class="bl_m" height="88" src="https://s.pstatic.net/static/www/mobile/edit/2018/0807/mobile_161645589211.jpg" title="해피빈 공감 천연유래성분 치약 임산부도 안심하고 사용하는 안전한 레몬향 치약" width="166"/>
<span class="bl_bd"></span>
</div>
<div class="bl_tw">
<span class="bl_s">해피빈 공감</span>
<strong class="bl_t">천연유래성분 치약</strong>
<span class="bl_d">임산부도 안심하고 사용하는<br/>안전한 레몬향 치약</span>
</div>
</a>
</li>
<li class="bl_item">
<a class="bl_a" data-clk="mcb.right" href="https://www.playsw.or.kr/main" target="_blank">
<div class="bl_mw">
<img alt="소프트웨어야 놀자 온·오프라인 무료 교육 집에서 시작하는 즐거운 소프트웨어 학습!" class="bl_m" height="88" src="https://s.pstatic.net/static/www/mobile/edit/2018/0618/mobile_154236102364.png" title="소프트웨어야 놀자 온·오프라인 무료 교육 집에서 시작하는 즐거운 소프트웨어 학습!" width="166"/>
<span class="bl_bd"></span>
</div>
<div class="bl_tw">
<span class="bl_s">소프트웨어야 놀자</span>
<strong class="bl_t">온·오프라인 무료 교육</strong>
<span class="bl_d">집에서 시작하는<br/>즐거운 소프트웨어 학습!</span>
</div>
</a>
</li>
</ul>
</div>
<div class="section_rbn">
<!-- 광고 -->
<div id="veta_time2">
<iframe align="center" data-veta-preview="main_below" frameborder="0" height="130" id="da_iframe_below" marginheight="0" marginwidth="0" name="da_iframe_below" scrolling="no" src="https://nv.veta.naver.com/fxshow?su=SU10082&amp;nrefreshx=0" title="광고" width="332"></iframe>
<div class="veta_bdt"></div><div class="veta_bdr"></div><div class="veta_bdb"></div><div class="veta_bdl"></div>
</div>
<!-- //광고 -->
</div>
</div>
</div>
<div class="section_footer" role="contentinfo">
<div class="notice">
<div class="area_notice">
<h3 class="an_tit"><a class="an_ta" data-clk="ntc.notice" href="//www.naver.com/NOTICE">공지사항</a></h3>
<a class="an_a" data-clk="ntc.notice" href="https://www.naver.com/NOTICE/read/1100001014/10000000000030662540">네이버 PC 메인의 보안 강화를 위한 로그인 영역 변경 완료 안내 (8.2)</a>
</div>
<div class="area_services">
<a class="as_a" data-clk="ntc.svcmap" href="more.html">서비스 전체보기<span class="as_ico_all"></span></a>
</div>
</div>
<div class="aside">
<div class="area_flower">
<div class="af_tw">
<h3 class="af_tit">프로젝트 꽃</h3>
<a class="af_a" data-clk="prj.link" href="https://search.naver.com/search.naver?where=nexearch&amp;sm=top_hty&amp;fbm=1&amp;ie=utf8&amp;query=%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EA%BD%83">바로가기</a>
</div>
<div class="af_mw">
<a class="af_qr" data-clk="prj.link" href="https://search.naver.com/search.naver?where=nexearch&amp;sm=top_hty&amp;fbm=1&amp;ie=utf8&amp;query=%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EA%BD%83"><span class="blind">프로젝트 꽃</span></a>
</div>
</div>
<div class="area_whale">
<div class="aw_tw">
<h3 class="aw_tit">웨일 브라우저</h3>
<a class="aw_a" data-clk="wbd.bt" href="http://whale.naver.com/">다운받기</a>
</div>
<div class="aw_mw">
<a class="aw_qr" data-clk="wbd.bt" href="http://whale.naver.com/"><span class="blind">네이버웨일</span></a>
</div>
</div>
<div class="area_user">
<div class="au_wrap">
<h3 class="au_tit">Creators</h3>
<ul class="au_l">
<li class="au_item"><a class="au_a" data-clk="crt.creator" href="http://www.navercorp.com/ko/service/creators.nhn">크리에이터</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="crt.smbusiness" href="http://www.navercorp.com/ko/service/business.nhn">스몰비즈니스</a></li>
</ul>
</div>
<div class="au_wrap">
<h3 class="au_tit">Partners</h3>
<ul class="au_l">
<li class="au_item"><a class="au_a" data-clk="ptn.guide" href="http://business.naver.com/guide.html">비즈니스 파트너 안내</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="ptn.service" href="http://business.naver.com/service.html">비즈니스 · 광고</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="ptn.store" href="https://sell.storefarm.naver.com/#/home/about">스토어 개설</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="ptn.place" href="https://smartplace.naver.com/">지역업체 등록</a></li>
</ul>
</div>
<div class="au_wrap">
<h3 class="au_tit">Developers</h3>
<ul class="au_l">
<li class="au_item"><a class="au_a au_sa" data-clk="dvl.center" href="http://developers.naver.com">네이버 개발자센터</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="dvl.openapi" href="https://developers.naver.com/docs/common/openapiguide/#/apilist.md/">오픈 API</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="dvl.opensource" href="http://naver.github.io/">오픈소스</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="dvl.d2" href="http://d2.naver.com/">네이버 D2</a></li>
<li class="au_item"><span class="au_bar"></span><a class="au_a" data-clk="dvl.labs" href="http://www.naverlabs.com/">네이버 랩스</a></li>
</ul>
</div>
</div>
</div>
<div class="footer">
<div class="area_terms">
<h3 class="blind">네이버 정책 및 약관</h3>
<ul class="at_l">
<li class="at_item"><a class="at_a" data-clk="plc.intronhn" href="http://www.navercorp.com/">회사소개</a></li>
<li class="at_item"><span class="at_bar"></span><a class="at_a" data-clk="plc.recruit" href="http://recruit.navercorp.com/naver/recruitMain">인재채용</a></li>
<li class="at_item"><span class="at_bar"></span><a class="at_a" data-clk="plc.contact" href="https://www.navercorp.com/ko/company/proposalGuide.nhn">제휴제안</a></li>
<li class="at_item"><span class="at_bar"></span><a class="at_a" data-clk="plc.service" href="/policy/service.html">이용약관</a></li>
<li class="at_item"><span class="at_bar"></span><a class="at_a" data-clk="plc.privacy" href="/policy/privacy.html"><strong class="at_st">개인정보처리방침</strong></a></li>
<li class="at_item"><span class="at_bar"></span><a class="at_a" data-clk="plc.youth" href="/policy/youthpolicy.html">청소년보호정책</a></li>
<li class="at_item"><span class="at_bar"></span><a class="at_a" data-clk="plc.policy" href="/policy/spamcheck.html">네이버 정책</a></li>
<li class="at_item"><span class="at_bar"></span><a class="at_a" data-clk="plc.helpcenter" href="https://help.naver.com/">고객센터</a></li>
</ul>
<address class="at_cr">ⓒ <a class="at_ca" data-clk="plc.nhn" href="http://www.navercorp.com/" target="_blank">NAVER Corp.</a></address>
</div>
</div>
</div>
</div>
<script src="https://pm.pstatic.net/js/c/jindo_v180212.js"></script>
<script>
		var svr = "<!--cweb310.ntop-->";
		var svt = "20180808163449";
		var aPanelListAll;
		
		var nmainJS = ["https://pm.pstatic.net/js/c/nmain_v180719.js"];
		
		var sThemecastAdScriptUrl = 'https://ssl.pstatic.net/tveta/libs/assets/js/pc/main/min/pc.veta.core.min.js?20180330';
		nmainJS.push(sThemecastAdScriptUrl);

		function loadJS() {

			jindo.LazyLoading.load(nmainJS, function(){

				try { naver.main.nelo.setEnable(true); } catch(e) { };

				if ( svr === "<!--cweb301.ntop-->" ) {
					JEagleEyeClient.setEnable(true);
				}

				if(typeof initPage != 'undefined') {
    				initPage();
				}	

				try {
					aPanelListAll = [{"adMap":null,"code":"LIVINGHOME","name":"리빙","css":"livinghome","nclick":"lif","openDate":null},{"adMap":null,"code":"LIVING","name":"푸드","css":"living","nclick":"fod","openDate":null},{"adMap":null,"code":"SPORTS","name":"스포츠","css":"sports","nclick":"spo","openDate":null},{"adMap":null,"code":"CARGAME","name":"자동차","css":"cargame","nclick":"aut","openDate":null},{"adMap":null,"code":"BEAUTY","name":"패션뷰티","css":"beauty","nclick":"bty","openDate":null},{"adMap":null,"code":"MOMKIDS","name":"부모i","css":"momkids","nclick":"mom","openDate":null},{"adMap":null,"code":"HEALTH","name":"건강","css":"health","nclick":"hea","openDate":null},{"adMap":null,"code":"BBOOM","name":"웹툰","css":"bboom","nclick":"web","openDate":null},{"adMap":null,"code":"GAMEAPP","name":"게임","css":"gameapp","nclick":"gam","openDate":null},{"adMap":null,"code":"VIDEO","name":"TV연예","css":"video","nclick":"tvc","openDate":null},{"adMap":null,"code":"MUSIC","name":"뮤직","css":"music","nclick":"muc","openDate":null},{"adMap":{"id":"p_main_movie_00","adPath":"%2Ffxshow%3Fsu%3DSU10199%26da_dom_id%3Dp_main_movie_00%26tb%3DMOVIE_1"},"code":"MOVIE","name":"영화","css":"movie","nclick":"mov","openDate":null},{"adMap":null,"code":"CULTURE","name":"책문화","css":"culture","nclick":"bok","openDate":null},{"adMap":null,"code":"WITH","name":"함께N","css":"with","nclick":"pub","openDate":null},{"adMap":{"id":"p_main_travel_00","adPath":"%2Ffxshow%3Fsu%3DSU10198%26da_dom_id%3Dp_main_travel_00%26tb%3DTRAVEL_1"},"code":"TRAVEL","name":"여행+","css":"travel","nclick":"tra","openDate":null},{"adMap":null,"code":"DESIGN","name":"디자인","css":"design","nclick":"des","openDate":null},{"adMap":null,"code":"FINANCE","name":"경제M","css":"finance","nclick":"fin","openDate":null},{"adMap":{"id":"p_main_job_00","adPath":"%2Ffxshow%3Fsu%3DSU10200%26da_dom_id%3Dp_main_job_00%26tb%3DJOB_1"},"code":"JOB","name":"JOB&","css":"job","nclick":"job","openDate":null},{"adMap":null,"code":"SCIENCE","name":"과학","css":"science","nclick":"sci","openDate":null},{"adMap":null,"code":"CHINA","name":"중국","css":"china","nclick":"chn","openDate":null},{"adMap":{"id":"p_main_business_00","adPath":"%2Ffxshow%3Fsu%3DSU10204%26da_dom_id%3Dp_main_business_00%26tb%3DBUSINESS_1"},"code":"BUSINESS","name":"비즈니스","css":"business","nclick":"bsn","openDate":null},{"adMap":null,"code":"FARM","name":"FARM","css":"farm","nclick":"far","openDate":null},{"adMap":{"id":"p_main_school_01","adPath":"%2Ffxshow%3Fsu%3DSU10210%26da_dom_id%3Dp_main_school_01%26tb%3DSCHOOL_1"},"code":"SCHOOL","name":"스쿨잼","css":"school","nclick":"scl","openDate":null},{"adMap":null,"code":"SHOW","name":"공연전시","css":"show","nclick":"sow","openDate":"20170622"},{"adMap":null,"code":"LAW","name":"법률","css":"law","nclick":"law","openDate":"20170803"},{"adMap":null,"code":"ANIMAL","name":"동물공감","css":"animal","nclick":"ani","openDate":"20170824"},{"adMap":null,"code":"WEDDING","name":"연애·결혼","css":"wedding","nclick":"wed","openDate":"20170831"},{"adMap":null,"code":"ITTECH","name":"테크","css":"ittech","nclick":"tec","openDate":"20170921"},{"adMap":null,"code":"EMOTION","name":"감성충전","css":"emotion","nclick":"emo","openDate":"20180322"}]; 
				} catch(e) {
					JEagleEyeClient.sendError("invalid panel.json");
				}
				naver.main.PageRefresh.init();

				naver.main.Panel.init(aPanelListAll);

				naver.main.Log.init();

				naver.main.ServiceNavi.init();
				naver.main.ThemecastNavi.init({
					bFlick: false,
					sAdList: '{"header":{"msg":"success","code":0},"body":{"adScriptList":[{"adScriptPCMain1":{"http":"https://ssl.pstatic.net/tveta/libs/assets/js/pc/main/min/pc.veta.core.min.js?20180330","https":"https://ssl.pstatic.net/tveta/libs/assets/js/pc/main/min/pc.veta.core.min.js?20180330"}}],"adList":[{"menu":"ANIMAL","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000124","singleDomAdUrl":"https://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_animal_00","tb":"ANIMAL_1","unit":"SU10261","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"BEAUTY","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000106","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_beauty_00","tb":"BEAUTY_1","unit":"SU10249","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"BUSINESS","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000084","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_business_00","tb":"BUSINESS_1","unit":"SU10204","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"CARGAME","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000102","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_cargame_00","tb":"CARGAME_1","unit":"SU10253","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"CHINA","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000107","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_china_00","tb":"CHINA_1","unit":"SU10206","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"DESIGN","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000090","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_design_00","tb":"DESIGN_1","unit":"SU10205","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"FARM","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000101","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_farm_00","tb":"FARM_1","unit":"SU10207","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"FINANCE","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000105","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_finance_00","tb":"FINANCE_1","unit":"SU10250","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"ITTECH","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000113","singleDomAdUrl":"https://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_ittech_00","tb":"ITTECH_1","unit":"SU10260","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"JOB","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000088","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_job_00","tb":"JOB_1","unit":"SU10200","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"LAW","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000100","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_law_00","tb":"LAW_1","unit":"SU10255","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"LIVING","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000104","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_living_00","tb":"LIVING_1","unit":"SU10251","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"LIVINGHOME","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000103","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_livinghome_00","tb":"LIVINGHOME_1","unit":"SU10252","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"MOMKIDS","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000089","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_momkids_00","tb":"MOMKIDS_1","unit":"SU10226","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"MOVIE","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000087","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_movie_00","tb":"MOVIE_1","unit":"SU10199","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"SCHOOL","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000085","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_school_01","tb":"SCHOOL_1","unit":"SU10210","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"SHOW","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000112","singleDomAdUrl":"https://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_show_00","tb":"SHOW_1","unit":"SU10262","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"TRAVEL","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000086","singleDomAdUrl":"http://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_travel_00","tb":"TRAVEL_1","unit":"SU10198","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]},{"menu":"WEDDING","adType":"singleDom","multiDomAdUrl":"","multiDomUnit":"","infoList":[{"adposId":"1000128","singleDomAdUrl":"https://nv.veta.naver.com/fxshow","param":{"da_dom_id":"p_main_wedding_00","tb":"WEDDING_1","unit":"SU10263","calp":"-"},"type":{"position":"rel","positionIndex":0,"subject":"contents"},"dom":null}]}]}}'
				});
				naver.main.CenterBanner.init();
				newSmartSearch();
	
				new naver.main.Newsstand({
					rcode : "09680101",
        		    newspaperURL : "newspaper.naver.com",
            		newsStandURL : "newsstand.naver.com",
		            userInfoURL : "userinfo.www.naver.com",
    		        newsCastInfo : "",
        		    newsStandInfo : "",
            		headlineList : {"pid" : ["002","003","005","006","008","009","011","013","014","015","016","018","020","021","022","023","024","025","028","029","030","031","032","038","042","044","047","050","052","055","056","057","073","075","076","079","081","082","083","087","088","089","092","108","109","117","120","122","123","135","138","139","140","143","144","213","214","215","241","243","277","293","296","301","308","310","311","312","314","326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","344","345","346","354","355","356","361","362","363","364","366","368","374","376","384","385","386","387","388","389","390","391","396","404","410","416","417","421","422","440","447","477","529","536","539","901","902","903","904","905","906","907","908","909","910","911","912","913","914","915","916","917","920","921","922","923","924","925","926","927","928","930","932","933","934","935","936","937","938","939","940","941","942","943","944","945","946","947","948","949","950","951","952","953","954","955","956","957","958","959","960","961","962","963","964","965","966","967","968","969","970","971","972","973","974","975","976","977","978","979","980","981","982","983","984","985"], "amigo" : [], "invalid" : []},
					pressCategory : {"ct1":[{"pid":"032","name":"경향신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14372435.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"005","name":"국민일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd1438916.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"079","name":"노컷뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143958887.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"327","name":"뉴데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144037935.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"930","name":"뉴스타파","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144152433.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"003","name":"뉴시스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14449981.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"368","name":"데일리안","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14463367.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"020","name":"동아일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14479875.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"029","name":"디지털타임스","img":"https://s.pstatic.net/static/newsstand/up/2018/0719/nsd162516824.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"117","name":"마이데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144944309.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"009","name":"매일경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145032565.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"008","name":"머니투데이","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145214517.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"021","name":"문화일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd19245981.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"006","name":"미디어오늘","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145346617.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"293","name":"블로터","img":"https://s.pstatic.net/static/newsstand/up/2018/0316/nsd175350622.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"011","name":"서울경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145718601.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"081","name":"서울신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145738195.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"022","name":"세계일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145813557.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"314","name":"스포츠동아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145951763.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"073","name":"스포츠서울","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd15042554.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"076","name":"스포츠조선","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd183553864.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"139","name":"스포탈코리아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd151840663.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"308","name":"시사인","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd151929775.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"277","name":"아시아경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153432228.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"031","name":"아이뉴스24","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153955864.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"422","name":"연합뉴스TV","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154219877.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"047","name":"오마이뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154314463.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"018","name":"이데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154426359.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"241","name":"일간스포츠","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154619739.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"030","name":"전자신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162528724.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"366","name":"조선비즈","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162659528.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"023","name":"조선일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162718792.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"330","name":"중앙데일리","img":"https://s.pstatic.net/static/newsstand/up/2018/0626/nsd103519292.png","cate":"ct5","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"025","name":"중앙일보","img":"https://s.pstatic.net/static/newsstand/up/2018/0807/nsd1484475.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"092","name":"지디넷코리아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16425834.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"376","name":"지지통신","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16432873.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"044","name":"코리아헤럴드","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17341942.png","cate":"ct5","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"014","name":"파이낸셜뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172557496.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"002","name":"프레시안","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172615885.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"028","name":"한겨레","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17263596.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"015","name":"한국경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172736175.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"215","name":"한국경제TV","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172755139.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"038","name":"한국일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172837200.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"016","name":"헤럴드경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172855569.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"904","name":"JTBC","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173111263.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"056","name":"KBS","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173124306.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"326","name":"KBS World","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173138949.png","cate":"ct5","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"214","name":"MBC","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17324940.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"057","name":"MBN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173223533.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"109","name":"OSEN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17338859.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"055","name":"SBS","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173335676.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"052","name":"YTN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173559874.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null}],"ct2":[{"pid":"960","name":"건설경제신문","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161545206.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"032","name":"경향신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14372435.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"005","name":"국민일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd1438916.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"944","name":"나우뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14392079.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"079","name":"노컷뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143958887.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"327","name":"뉴데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144037935.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"930","name":"뉴스타파","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144152433.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"913","name":"뉴스토마토","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14431117.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"914","name":"뉴스핌","img":"https://s.pstatic.net/static/newsstand/up/2017/0613/nsd173430698.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"536","name":"더팩트","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144543120.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"368","name":"데일리안","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14463367.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"020","name":"동아일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14479875.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"009","name":"매일경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145032565.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"969","name":"매일노동뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161443290.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"417","name":"머니에스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145150694.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"008","name":"머니투데이","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145214517.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"961","name":"메트로신문","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161618979.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"021","name":"문화일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd19245981.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"006","name":"미디어오늘","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145346617.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"985","name":"미주중앙일보","img":"https://s.pstatic.net/static/newsstand/up/2018/0406/nsd201556421.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"939","name":"브릿지경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145512265.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"943","name":"비즈니스워치","img":"https://s.pstatic.net/static/newsstand/up/2017/1102/nsd155540688.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"942","name":"비즈니스포스트","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145630550.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"973","name":"비즈한국","img":"https://s.pstatic.net/static/newsstand/up/2017/1209/nsd14224593.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"011","name":"서울경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145718601.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"081","name":"서울신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145738195.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"022","name":"세계일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145813557.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"970","name":"소비자가만드는신문","img":"https://s.pstatic.net/static/newsstand/up/2017/1209/nsd1421922.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"957","name":"시사위크","img":"https://s.pstatic.net/static/newsstand/up/2017/1127/nsd8401364.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"975","name":"시사저널이코노미","img":"https://s.pstatic.net/static/newsstand/up/2017/1209/nsd1413096.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"277","name":"아시아경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153432228.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"920","name":"아시아투데이","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153458161.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"921","name":"아주경제","img":"https://s.pstatic.net/static/newsstand/up/2018/0611/nsd111954432.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"963","name":"에너지경제","img":"https://s.pstatic.net/static/newsstand/up/2018/0118/nsd105113618.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"013","name":"연합인포맥스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154238686.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"047","name":"오마이뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154314463.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"539","name":"위키트리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd15444343.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"964","name":"이뉴스투데이","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd16174237.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"018","name":"이데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154426359.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"243","name":"이코노미스트","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd15444742.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"922","name":"이투데이","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd15453589.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"923","name":"인민망","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154522345.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"971","name":"일요시사","img":"https://s.pstatic.net/static/newsstand/up/2017/1205/nsd95610984.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"925","name":"일요신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd192546763.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"366","name":"조선비즈","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162659528.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"023","name":"조선일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162718792.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"123","name":"조세일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162739461.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"025","name":"중앙일보","img":"https://s.pstatic.net/static/newsstand/up/2018/0807/nsd1484475.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"941","name":"초이스경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd164431529.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"143","name":"쿠키뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172415111.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"014","name":"파이낸셜뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172557496.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"002","name":"프레시안","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172615885.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"028","name":"한겨레","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17263596.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"015","name":"한국경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172736175.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"968","name":"한국금융신문","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161235556.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"038","name":"한국일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172837200.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"016","name":"헤럴드경제","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172855569.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"974","name":"BBS NEWS","img":"https://s.pstatic.net/static/newsstand/up/2017/1209/nsd14324918.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"932","name":"CEO스코어데일리","img":"https://s.pstatic.net/static/newsstand/up/2018/0627/nsd124328796.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"954","name":"CNB뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/1122/nsd113655834.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"120","name":"EBN","img":"https://s.pstatic.net/static/newsstand/up/2017/1017/nsd173540697.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"959","name":"M이코노미뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161518383.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"972","name":"PD저널","img":"https://s.pstatic.net/static/newsstand/up/2017/1207/nsd13738461.png","cate":"ct2","amigo":"N","viewer":"Y","today":"N","local":null}],"ct3":[{"pid":"421","name":"뉴스1","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14405515.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"003","name":"뉴시스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14449981.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"916","name":"머니투데이방송","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145249746.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"934","name":"아리랑TV","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153357809.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"422","name":"연합뉴스TV","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154219877.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"376","name":"지지통신","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16432873.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"903","name":"채널에이","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd164352456.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"215","name":"한국경제TV","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172755139.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"933","name":"CNN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173010586.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"344","name":"EBS","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173043431.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"904","name":"JTBC","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173111263.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"980","name":"KBC광주방송","img":"https://s.pstatic.net/static/newsstand/up/2018/0126/nsd114019464.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"056","name":"KBS","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173124306.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"906","name":"KNN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173151831.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"214","name":"MBC","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17324940.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"057","name":"MBN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173223533.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"340","name":"OBS","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173252323.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"055","name":"SBS","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173335676.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"374","name":"SBSCNBC","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173348251.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"902","name":"TV조선","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd1735138.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"052","name":"YTN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173559874.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"945","name":"YTN사이언스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173618176.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"981","name":"tbs교통방송","img":"https://s.pstatic.net/static/newsstand/up/2018/0201/nsd19842442.png","cate":"ct3","amigo":"N","viewer":"Y","today":"N","local":null}],"ct4":[{"pid":"910","name":"넥스트데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143938201.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"138","name":"디지털데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14481127.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"029","name":"디지털타임스","img":"https://s.pstatic.net/static/newsstand/up/2018/0719/nsd162516824.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"952","name":"보안뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/1122/nsd113617499.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"293","name":"블로터","img":"https://s.pstatic.net/static/newsstand/up/2018/0316/nsd175350622.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"031","name":"아이뉴스24","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153955864.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"030","name":"전자신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162528724.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"092","name":"지디넷코리아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16425834.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"953","name":"키뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/1122/nsd113635611.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"977","name":"헬로디디","img":"https://s.pstatic.net/static/newsstand/up/2017/1214/nsd112148521.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"917","name":"IT조선","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173057968.png","cate":"ct4","amigo":"N","viewer":"Y","today":"N","local":null}],"ct5":[{"pid":"330","name":"중앙데일리","img":"https://s.pstatic.net/static/newsstand/up/2018/0626/nsd103519292.png","cate":"ct5","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"044","name":"코리아헤럴드","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17341942.png","cate":"ct5","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"326","name":"KBS World","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173138949.png","cate":"ct5","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"946","name":"YONHAPNEWS","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173542219.png","cate":"ct5","amigo":"N","viewer":"Y","today":"N","local":null}],"ct6":[{"pid":"447","name":"뉴스엔","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144110729.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"117","name":"마이데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144944309.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"108","name":"스타뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14592836.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"144","name":"스포츠경향","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14593063.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"314","name":"스포츠동아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145951763.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"073","name":"스포츠서울","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd15042554.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"396","name":"스포츠월드","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd1521496.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"076","name":"스포츠조선","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd183553864.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"940","name":"스포츠투데이","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd183628961.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"962","name":"스포츠한국","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161647719.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"139","name":"스포탈코리아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd151840663.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"477","name":"스포티비뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/1221/nsd134325318.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"311","name":"엑스포츠뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154117.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"529","name":"엠스플뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/1121/nsd103843372.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"241","name":"일간스포츠","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154619739.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"947","name":"조이뉴스24","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162759461.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"312","name":"텐아시아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172519405.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"440","name":"티브이데일리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172538465.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"410","name":"MK스포츠","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173237747.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"109","name":"OSEN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17338859.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"416","name":"SBS연예스포츠","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173430905.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"213","name":"TV리포트","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173446621.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"404","name":"enews24","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173715121.png","cate":"ct6","amigo":"N","viewer":"Y","today":"N","local":null}],"ct7":[{"pid":"356","name":"게임메카","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143454437.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"363","name":"과학동아","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143721586.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"908","name":"국방일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143827635.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"938","name":"그린포스트코리아","img":"https://s.pstatic.net/static/newsstand/up/2017/1106/nsd95428551.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"984","name":"낚시춘추","img":"https://s.pstatic.net/static/newsstand/up/2018/0312/nsd11361752.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"911","name":"농민신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144020188.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"912","name":"뉴스컬처","img":"https://s.pstatic.net/static/newsstand/up/2018/0525/nsd141715196.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"905","name":"더스쿠프","img":"https://s.pstatic.net/static/newsstand/up/2018/0626/nsd103415937.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"042","name":"데일리한국","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144629578.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"955","name":"독서신문","img":"https://s.pstatic.net/static/newsstand/up/2017/1127/nsd93333581.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"345","name":"디자인정글","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144732945.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"915","name":"르몽드 디플로마티크","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd1449112.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"024","name":"매경이코노미","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145011543.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"075","name":"맥스무비","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd183033195.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"122","name":"법률신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145431309.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"958","name":"베리타스알파","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161315555.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"355","name":"사이언스타임즈","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145657590.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"329","name":"소년한국일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14583498.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"308","name":"시사인","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd151929775.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"135","name":"시사저널","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153228485.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"140","name":"씨네21","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd153251814.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"979","name":"약사공론","img":"https://s.pstatic.net/static/newsstand/up/2018/0212/nsd161550299.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"328","name":"에이블뉴스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154040656.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"354","name":"엘르","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154119884.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"310","name":"여성신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154151666.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"950","name":"월간중앙","img":"https://s.pstatic.net/static/newsstand/up/2017/1122/nsd113515807.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"982","name":"이코노미조선","img":"https://s.pstatic.net/static/newsstand/up/2018/0226/nsd13574834.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"924","name":"인벤","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154539705.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"362","name":"자동차생활","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162354371.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"965","name":"전기신문","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161818802.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"966","name":"정신의학신문","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd161847464.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"361","name":"채널예스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd164412540.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"956","name":"철강금속신문","img":"https://s.pstatic.net/static/newsstand/up/2018/0406/nsd201637238.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"928","name":"컴퓨터월드","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17150763.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"967","name":"코리아쉬핑가제트","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd162046351.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"296","name":"코메디닷컴","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172354656.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"951","name":"포브스코리아","img":"https://s.pstatic.net/static/newsstand/up/2017/1122/nsd113546163.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"948","name":"한겨레21","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172654646.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"050","name":"한경비즈니스","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172712628.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"384","name":"한국대학신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172816434.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"346","name":"헬스조선","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd172911723.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"364","name":"PC사랑","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173322105.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null},{"pid":"949","name":"TheAsiaN","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd173523100.png","cate":"ct7","amigo":"N","viewer":"Y","today":"N","local":null}],"ct8":[{"pid":"335","name":"강원도민일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14341394.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"강원","code":"01"}]},{"pid":"087","name":"강원일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143434899.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"강원","code":"01"}]},{"pid":"339","name":"경기일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143511509.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경기","code":"02"},{"name":"인천","code":"11"}]},{"pid":"333","name":"경남신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143531816.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경남","code":"03"},{"name":"부산","code":"08"},{"name":"울산","code":"10"}]},{"pid":"978","name":"경북도민일보","img":"https://s.pstatic.net/static/newsstand/up/2017/1214/nsd111929299.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경북","code":"04"},{"name":"대구","code":"06"}]},{"pid":"907","name":"경북매일신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143555345.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경북","code":"04"},{"name":"대구","code":"06"}]},{"pid":"337","name":"경북일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143612100.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경북","code":"04"},{"name":"대구","code":"06"},{"name":"울산","code":"10"}]},{"pid":"935","name":"경상일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143628241.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"울산","code":"10"}]},{"pid":"338","name":"경인일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143645415.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경기","code":"02"},{"name":"인천","code":"11"}]},{"pid":"301","name":"광주드림","img":"https://s.pstatic.net/static/newsstand/up/2017/1201/nsd17629468.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"광주","code":"05"}]},{"pid":"083","name":"광주일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143742681.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"광주","code":"05"},{"name":"전남","code":"12"}]},{"pid":"332","name":"국제신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd143844997.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경남","code":"03"},{"name":"부산","code":"08"},{"name":"울산","code":"10"}]},{"pid":"909","name":"기호일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14392544.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경기","code":"02"},{"name":"인천","code":"11"}]},{"pid":"936","name":"대구일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144433908.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경북","code":"04"},{"name":"대구","code":"06"}]},{"pid":"089","name":"대전일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd144457151.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"대전","code":"07"},{"name":"충남","code":"15"},{"name":"충북","code":"16"},{"name":"세종","code":"17"}]},{"pid":"088","name":"매일신문","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd14505572.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경북","code":"04"},{"name":"대구","code":"06"}]},{"pid":"976","name":"무등일보","img":"https://s.pstatic.net/static/newsstand/up/2017/1221/nsd13422489.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"광주","code":"05"},{"name":"전남","code":"12"}]},{"pid":"082","name":"부산일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd145450220.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경남","code":"03"},{"name":"부산","code":"08"},{"name":"울산","code":"10"}]},{"pid":"385","name":"영남일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154255890.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경북","code":"04"},{"name":"대구","code":"06"}]},{"pid":"386","name":"울산매일","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154334776.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"울산","code":"10"}]},{"pid":"387","name":"인천일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd154558680.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경기","code":"02"},{"name":"인천","code":"11"}]},{"pid":"388","name":"전남일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162423309.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"광주","code":"05"},{"name":"전남","code":"12"}]},{"pid":"937","name":"전북도민일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16244628.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"전북","code":"13"}]},{"pid":"336","name":"전북일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16256807.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"전북","code":"13"}]},{"pid":"901","name":"제민일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd16254923.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"제주","code":"14"}]},{"pid":"389","name":"제주도민일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd1626960.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"제주","code":"14"}]},{"pid":"334","name":"제주의소리","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162631114.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"제주","code":"14"}]},{"pid":"390","name":"중도일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162822857.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"대전","code":"07"},{"name":"충남","code":"15"}]},{"pid":"983","name":"중부매일신문","img":"https://s.pstatic.net/static/newsstand/up/2018/0212/nsd162058391.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"대전","code":"07"},{"name":"충남","code":"15"},{"name":"충북","code":"16"},{"name":"세종","code":"17"}]},{"pid":"926","name":"중부일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd162931439.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"경기","code":"02"},{"name":"인천","code":"11"}]},{"pid":"927","name":"충북일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd164449667.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"충북","code":"16"},{"name":"세종","code":"17"}]},{"pid":"391","name":"충청일보","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17115481.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"대전","code":"07"},{"name":"충남","code":"15"},{"name":"충북","code":"16"},{"name":"세종","code":"17"}]},{"pid":"331","name":"충청투데이","img":"https://s.pstatic.net/static/newsstand/up/2017/0424/nsd17133978.png","cate":"ct8","amigo":"N","viewer":"Y","today":"N","local":[{"name":"대전","code":"07"},{"name":"충남","code":"15"},{"name":"충북","code":"16"},{"name":"세종","code":"17"}]}]},
					isSupportedFlicking : false
    		    });

				new naver.main.Timesquare({
    	    	    aOrderedPanel : 
[{"code":"weather","name":"날씨"},{"code":"news","name":"뉴스"},{"code":"sports","name":"스포츠"},{"code":"finance","name":"금융"},{"code":"conversation","name":"회화"},{"code":"lifetools","name":"생활도구"}]
,
        	    	isSupportedFlicking : false
		        });

				new naver.main.RealtimeKeyword();
				if ( !($Agent().navigator().ie && $Agent().navigator().version <= 8) ) {	
					naver_adbd.Manager().activate();
				}

				naver.main.SchoolFixed.init("(none)");
				naver.main.bestseller.init();

			});
		}

		if (window.addEventListener) { 
			window.addEventListener("load", function() { loadJS(); }, true);
		} else if (window.attachEvent) { 
			window.attachEvent("onload", loadJS);
		} else {
			window.onload = loadJS;
		}
		
	</script>
</body>
</html>
```

# 태그안에 또다른 태그 소스 출력하기

- bs.태그1.태그2

```python
# a 태그안에 span 태그
print(bs.a.span)
<span>뉴스스탠드 바로가기</span>
```

# 특정 태그의 텍스트 출력하기

- bs.태그.string

```python
print(bs.a.string)
뉴스스탠드 바로가기
```

# 아이디로 찾기

- bs.find(id="아이디이름")

```python
print(bs.find(id="where"))
<select class="blind" id="where" name="where" title="검색 범위 선택">
<option selected="selected" value="nexearch">통합검색</option><option value="post">블로그</option><option value="cafeblog">카페</option><option value="cafe">- 카페명</option><option value="article">- 카페글</option><option value="kin">지식iN</option><option value="news">뉴스</option><option value="web">사이트</option><option value="category">- 카테고리</option><option value="site">- 사이트</option><option value="movie">영화</option><option value="webkr">웹문서</option><option value="dic">사전</option><option value="100">- 백과사전</option><option value="endic">- 영어사전</option><option value="eedic">- 영영사전</option><option value="krdic">- 국어사전</option><option value="jpdic">- 일본어사전</option><option value="hanja">- 한자사전</option><option value="terms">- 용어사전</option><option value="book">책</option><option value="music">음악</option><option value="doc">전문자료</option><option value="shop">쇼핑</option><option value="local">지역</option><option value="video">동영상</option><option value="image">이미지</option><option value="mypc">내PC</option><optgroup label="스마트 파인더"><option value="movie">영화</option><option value="auto">자동차</option><option value="game">게임</option><option value="health">건강</option><option value="people">인물</option></optgroup><optgroup label="네이버 랩"><option>긍정부정검색</option></optgroup>
</select>
```

# 특정 아이디의 텍스트 출력하기

- bs.find(id="아이디이름").string

```python
print(bs.find(id="autoFrame").string)
None
```

# html 태그를 변수로 지정해서 연습하기

```python
html = """
<html>
    <body>
        <h1 id='title'>hello python</h1>
        <p id="body">웹페이지 분석</p>
        <p>웹스크래핑</p>
    </body>
</html>
"""
bs = BeautifulSoup(html,"html.parser")
print(bs)
<html>
<body>
<h1 id="title">hello python</h1>
<p id="body">웹페이지 분석</p>
<p>웹스크래핑</p>
</body>
</html>
```



```python
print(bs.find(id="title"))
<h1 id="title">hello python</h1>
```



```python
print(bs.find(id="title").string)
hello python
```

# 클래스이름으로 찾기

- bs.find*all(class*='클래스이름')
- 리스트 구조

```python
html = """
<html>
    <body>
        <ul>
            <li class ='fruit'>사과</li>
            <li>양파</li>
            <li>고구마</li>
            <li class ='fruit'>바나나</li>
        </ul>
    </body>
</html>
"""
bs = BeautifulSoup(html,"html.parser")
print(bs)
<html>
<body>
<ul>
<li class="fruit">사과</li>
<li>양파</li>
<li>고구마</li>
<li class="fruit">바나나</li>
</ul>
</body>
</html>
```



```python
fruit_list = bs.find_all(class_='fruit')
print(fruit_list,type(fruit_list))

for i in fruit_list:
                print(i)
for i in fruit_list:
                print(i.string)
[<li class="fruit">사과</li>, <li class="fruit">바나나</li>] <class 'bs4.element.ResultSet'>
<li class="fruit">사과</li>
<li class="fruit">바나나</li>
사과
바나나
```



```python
from urllib.request import urlopen
import urllib.request
from bs4 import BeautifulSoup
html = urlopen('http://www.pythonscraping.com/pages/warandpeace.html')
# 다른 함수를 사용할 수 있게 객체 생성
bs = BeautifulSoup(html.read(),'html.parser')
print(bs)
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

# 1.green 클래스가 적용된 태그 소스 -> 라스트로 변경한 후 텍스트만 출력한다.

```python
greenlist = bs.find_all(class_='green')
print(greenlist)
print('-'*40)
for i in greenlist:
                print(i.string)
print(len(greenlist))
[<span class="green">Anna
Pavlovna Scherer</span>, <span class="green">Empress Marya
Fedorovna</span>, <span class="green">Prince Vasili Kuragin</span>, <span class="green">Anna Pavlovna</span>, <span class="green">St. Petersburg</span>, <span class="green">the prince</span>, <span class="green">Anna Pavlovna</span>, <span class="green">Anna Pavlovna</span>, <span class="green">the prince</span>, <span class="green">the prince</span>, <span class="green">the prince</span>, <span class="green">Prince Vasili</span>, <span class="green">Anna Pavlovna</span>, <span class="green">Anna Pavlovna</span>, <span class="green">the prince</span>, <span class="green">Wintzingerode</span>, <span class="green">King of Prussia</span>, <span class="green">le Vicomte de Mortemart</span>, <span class="green">Montmorencys</span>, <span class="green">Rohans</span>, <span class="green">Abbe Morio</span>, <span class="green">the Emperor</span>, <span class="green">the prince</span>, <span class="green">Prince Vasili</span>, <span class="green">Dowager Empress Marya Fedorovna</span>, <span class="green">the baron</span>, <span class="green">Anna Pavlovna</span>, <span class="green">the Empress</span>, <span class="green">the Empress</span>, <span class="green">Anna Pavlovna's</span>, <span class="green">Her Majesty</span>, <span class="green">Baron
Funke</span>, <span class="green">The prince</span>, <span class="green">Anna
Pavlovna</span>, <span class="green">the Empress</span>, <span class="green">The prince</span>, <span class="green">Anatole</span>, <span class="green">the prince</span>, <span class="green">The prince</span>, <span class="green">Anna
Pavlovna</span>, <span class="green">Anna Pavlovna</span>]
----------------------------------------
Anna
Pavlovna Scherer
Empress Marya
Fedorovna
Prince Vasili Kuragin
Anna Pavlovna
St. Petersburg
the prince
Anna Pavlovna
Anna Pavlovna
the prince
the prince
the prince
Prince Vasili
Anna Pavlovna
Anna Pavlovna
the prince
Wintzingerode
King of Prussia
le Vicomte de Mortemart
Montmorencys
Rohans
Abbe Morio
the Emperor
the prince
Prince Vasili
Dowager Empress Marya Fedorovna
the baron
Anna Pavlovna
the Empress
the Empress
Anna Pavlovna's
Her Majesty
Baron
Funke
The prince
Anna
Pavlovna
the Empress
The prince
Anatole
the prince
The prince
Anna
Pavlovna
Anna Pavlovna
41
```

# 2.red 클래스가 적용된 태그 소스 -> 라스트로 변경한 후 텍스트만 출력한다.

```python
redlist = bs.find_all(class_='red')
print(redlist)
print('-'*40)
for i in redlist:
                print(i.string)
print(len(redlist))
[<span class="red">Well, Prince, so Genoa and Lucca are now just family estates of the
Buonapartes. But I warn you, if you don't tell me that this means war,
if you still try to defend the infamies and horrors perpetrated by
that Antichrist- I really believe he is Antichrist- I will have
nothing more to do with you and you are no longer my friend, no longer
my 'faithful slave,' as you call yourself! But how do you do? I see
I have frightened you- sit down and tell me all the news.</span>, <span class="red">If you have nothing better to do, Count [or Prince], and if the
prospect of spending an evening with a poor invalid is not too
terrible, I shall be very charmed to see you tonight between 7 and 10-
Annette Scherer.</span>, <span class="red">Heavens! what a virulent attack!</span>, <span class="red">First of all, dear friend, tell me how you are. Set your friend's
mind at rest,</span>, <span class="red">Can one be well while suffering morally? Can one be calm in times
like these if one has any feeling?</span>, <span class="red">You are
staying the whole evening, I hope?</span>, <span class="red">And the fete at the English ambassador's? Today is Wednesday. I
must put in an appearance there,</span>, <span class="red">My daughter is
coming for me to take me there.</span>, <span class="red">I thought today's fete had been canceled. I confess all these
festivities and fireworks are becoming wearisome.</span>, <span class="red">If they had known that you wished it, the entertainment would
have been put off,</span>, <span class="red">Don't tease! Well, and what has been decided about Novosiltsev's
dispatch? You know everything.</span>, <span class="red">What can one say about it?</span>, <span class="red">What has been decided? They have decided that
Buonaparte has burnt his boats, and I believe that we are ready to
burn ours.</span>, <span class="red">Oh, don't speak to me of Austria. Perhaps I don't understand
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
monarch. He will save Europe!</span>, <span class="red">I think,</span>, <span class="red">that if you had been
sent instead of our dear <span class="green">Wintzingerode</span> you would have captured the
<span class="green">King of Prussia</span>'s consent by assault. You are so eloquent. Will you
give me a cup of tea?</span>, <span class="red">In a moment. A propos,</span>, <span class="red">I am
expecting two very interesting men tonight, <span class="green">le Vicomte de Mortemart</span>,
who is connected with the <span class="green">Montmorencys</span> through the <span class="green">Rohans</span>, one of
the best French families. He is one of the genuine emigres, the good
ones. And also the <span class="green">Abbe Morio</span>. Do you know that profound thinker? He
has been received by <span class="green">the Emperor</span>. Had you heard?</span>, <span class="red">I shall be delighted to meet them,</span>, <span class="red">But tell me,</span>, <span class="red">is it true that the Dowager Empress wants Baron Funke
to be appointed first secretary at Vienna? The baron by all accounts
is a poor creature.</span>, <span class="red">Baron Funke has been recommended to the Dowager Empress by her
sister,</span>, <span class="red">Now about your family. Do you know that since your daughter came
out everyone has been enraptured by her? They say she is amazingly
beautiful.</span>, <span class="red">I often think,</span>, <span class="red">I often think how unfairly sometimes the
joys of life are distributed. Why has fate given you two such splendid
children? I don't speak of <span class="green">Anatole</span>, your youngest. I don't like
him,</span>, <span class="red">Two such charming children. And really you appreciate
them less than anyone, and so you don't deserve to have them.</span>, <span class="red">I can't help it,</span>, <span class="red">Lavater would have said I
lack the bump of paternity.</span>, <span class="red">Don't joke; I mean to have a serious talk with you. Do you know I
am dissatisfied with your younger son? Between ourselves</span>, <span class="red">he was mentioned at Her
Majesty's and you were pitied....</span>, <span class="red">What would you have me do?</span>, <span class="red">You know I did all
a father could for their education, and they have both turned out
fools. Hippolyte is at least a quiet fool, but Anatole is an active
one. That is the only difference between them.</span>, <span class="red">And why are children born to such men as you? If you were not a
father there would be nothing I could reproach you with,</span>, <span class="red">I am your faithful slave and to you alone I can confess that my
children are the bane of my life. It is the cross I have to bear. That
is how I explain it to myself. It can't be helped!</span>]
----------------------------------------
Well, Prince, so Genoa and Lucca are now just family estates of the
Buonapartes. But I warn you, if you don't tell me that this means war,
if you still try to defend the infamies and horrors perpetrated by
that Antichrist- I really believe he is Antichrist- I will have
nothing more to do with you and you are no longer my friend, no longer
my 'faithful slave,' as you call yourself! But how do you do? I see
I have frightened you- sit down and tell me all the news.
If you have nothing better to do, Count [or Prince], and if the
prospect of spending an evening with a poor invalid is not too
terrible, I shall be very charmed to see you tonight between 7 and 10-
Annette Scherer.
Heavens! what a virulent attack!
First of all, dear friend, tell me how you are. Set your friend's
mind at rest,
Can one be well while suffering morally? Can one be calm in times
like these if one has any feeling?
You are
staying the whole evening, I hope?
And the fete at the English ambassador's? Today is Wednesday. I
must put in an appearance there,
My daughter is
coming for me to take me there.
I thought today's fete had been canceled. I confess all these
festivities and fireworks are becoming wearisome.
If they had known that you wished it, the entertainment would
have been put off,
Don't tease! Well, and what has been decided about Novosiltsev's
dispatch? You know everything.
What can one say about it?
What has been decided? They have decided that
Buonaparte has burnt his boats, and I believe that we are ready to
burn ours.
Oh, don't speak to me of Austria. Perhaps I don't understand
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
monarch. He will save Europe!
I think,
None
In a moment. A propos,
None
I shall be delighted to meet them,
But tell me,
is it true that the Dowager Empress wants Baron Funke
to be appointed first secretary at Vienna? The baron by all accounts
is a poor creature.
Baron Funke has been recommended to the Dowager Empress by her
sister,
Now about your family. Do you know that since your daughter came
out everyone has been enraptured by her? They say she is amazingly
beautiful.
I often think,
None
Two such charming children. And really you appreciate
them less than anyone, and so you don't deserve to have them.
I can't help it,
Lavater would have said I
lack the bump of paternity.
Don't joke; I mean to have a serious talk with you. Do you know I
am dissatisfied with your younger son? Between ourselves
he was mentioned at Her
Majesty's and you were pitied....
What would you have me do?
You know I did all
a father could for their education, and they have both turned out
fools. Hippolyte is at least a quiet fool, but Anatole is an active
one. That is the only difference between them.
And why are children born to such men as you? If you were not a
father there would be nothing I could reproach you with,
I am your faithful slave and to you alone I can confess that my
children are the bane of my life. It is the cross I have to bear. That
is how I explain it to myself. It can't be helped!
34
```

# 3.id명이 text로 지정된 부분의 소스를 출력한다.

```python
print(bs.find(id="text"))
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
```