package pattern.adapter.adaptee;

/**
 * 
 * @author mz01-gyk
 * ATranslator는 OldTranslator를 실체화한 것이다.
 */
public class ATranslator implements OldTranslator {
    @Override
    public void koreanTranslation() {
        System.out.println("한국어로 번역합니다.");
    }

    @Override
    public void chineseTranslation() {
        System.out.println("중국어로 번역합니다.");
    }
}
