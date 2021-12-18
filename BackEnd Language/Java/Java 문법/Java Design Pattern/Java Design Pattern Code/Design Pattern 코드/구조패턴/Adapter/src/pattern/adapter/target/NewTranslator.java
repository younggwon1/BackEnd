package pattern.adapter.target;

/**
 * 
 * @author mz01-gyk
 * NewTranslator가 client가 알고있는 target이 된다.
 * 한국어, 중국어, 러시아어, 불어를 번역하는 기능을 가지고 있다.
 *
 */
public interface NewTranslator {
	
    public void koreanTranslation();

    public void chineseTranslation();

    public void russianTranslation();

    public void frenchTranslation();

}
