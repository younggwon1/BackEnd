package pattern.proxy.realsubject;

import pattern.proxy.subject.Subject;

/**
 * 
 * @author mz01-gyk
 * RealSubject는 실제 서비스들을 하는 주 객체가 된다.
 * 실제 필요한 로직을 작성한다.
 *
 */
public class RealSubject implements Subject {
    @Override
    public void print() {
        System.out.println("안녕하세요!");
    }
}
