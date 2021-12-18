# [Spring] e.toString(), e.getMessage(),e.printStackTrace()예외처리

참고

[e.toString(), e.getMessage(),e.printStackTrace()예외처리](https://lnsideout.tistory.com/entry/JAVA-etoString-egetMessage-eprintStackTrace-%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC)



### **1. 예외(Exception)란**

**프로그램 실행 중 발생할 수 있는 정상적인 범위를 벗어난 경우에 처리를 하기 위한 방법**

 

### **2. JAVA Exception 에러 출력**

**e.getMessage() : 에러의 원인을 간단하게 출력합니다.**

**e.toString() : 에러의 Exception 내용과 원인을 출력합니다.**

**e.printStackTrace() : 에러의 발생근원지를 찾아서 단계별로 에러를 출력합니다.**

 

### 3. 에러 출력

#### e.getMessage() 에러 출력

```java
package joon;

public class codeTest {
    public static void main(String[] args) throws Exception{
        try{
        /* int로 형변환이 안되는 문자열을 넣어 강제로 Exception 발생 */
            String product = "사과";
            int productCnt = Integer.valueOf(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
```

#### Exception 처리 결과



![img](https://blog.kakaocdn.net/dn/bNn7zE/btqFa6zBXse/pI4euMPTu1tKhcW0laeVck/img.png)



**-> For input string: "사과"**

**e.getMessage() 은 정말 Exception의 유형도 없이 정말 간단하게 왜 에러가 발생하였는지 보여주기만 한다.**

 

 

#### **e.toString() 에러 출력**

```java
package joon;

public class codeTest {
    public static void main(String[] args) throws Exception{
        try{
            String product = "사과";
            int productCnt = Integer.valueOf(product);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
```

#### **Exception 처리 결과**



![img](https://blog.kakaocdn.net/dn/m1Dgh/btqE9dG9Obd/QKJ2VPG7BKQOyujMsr35Pk/img.png)



**-> java.lang.NumberFormatException: For input string: "사과"**

**e.toString() 은 어떤 Exception이 발생하였으며, 원인이유를 보여준다. 하지만 에러의 발생위치는 보여주지않는다.**

 

#### **e.printStackTrace() 에러 출력**

```java
package joon;

public class codeTest {
    public static void main(String[] args) throws Exception{
        try{
            String product = "사과";
            int productCnt = Integer.valueOf(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
```

#### **Exception 처리결과**



![img](https://blog.kakaocdn.net/dn/1IeFZ/btqE81mC5If/5mBpT8ibQClaG1l7KUXdgK/img.png)



**Exception 이 발생한 이유와 위치는 어디에서 발생했는지 전체적인 단계를 다 출력한다.**

**위치까지 정확하게 알려주어서 어디서 에러가 발생하였는지 빠르게 파악이 가능하다.**

 

**log4에서는 e.printStackTrace()를 log 안에 담을수 없기 떄문에**

**log.error("error : ", e); 로 사용하면 된다.**