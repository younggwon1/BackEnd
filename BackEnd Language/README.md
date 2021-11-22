# 자주쓰는 정규식

**숫자만 : ^[0-9]\*$**
**영문만 : ^[a-zA-Z]\*$**
**영문만, 띄어쓰기가능 : /^[a-zA-Z\s]+$/**
**한글만 : ^[가-힣]\*$**
**한글만,띄어쓰기가능 : /^[가-힣\s]+$/**
**한글 & 영문만 : /^[가-힣a-zA-Z]+$/;**
**영문 & 숫자만 : ^[a-zA-Z0-9]\*$**
**E-Mail : ^[a-zA-Z0-9]+@[a-zA-Z0-9]+$**
**휴대폰 : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$**
**일반전화 : ^\d{2,3} - \d{3,4} - \d{4}$**
**URL : /^(file|gopher|news|nntp|telnet|https?|ftps?|sftp):\/\/([a-z0-9-]+\.)+[a-z0-9]{2,4}.\*$/**
**주민등록번호 : \d{6} \- [1-4]\d{6}**
**IP 주소 : ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3}) \. ([0-9]{1,3})**