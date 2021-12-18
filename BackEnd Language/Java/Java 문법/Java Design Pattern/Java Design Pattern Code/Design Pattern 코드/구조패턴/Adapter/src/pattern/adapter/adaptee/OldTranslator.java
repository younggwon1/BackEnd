package pattern.adapter.adaptee;

/**
 * 
 * @author mz01-gyk
 * OldTranslator는 변환이 되는 대상인 Adaptee이다.
 * 한국어와 중국어만 변환할 수 있다.
 * 
 */
public interface OldTranslator {
	
    public void koreanTranslation();

    public void chineseTranslation();
}
