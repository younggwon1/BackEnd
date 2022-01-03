package pattern.adapter.client;

import pattern.adapter.adaptee.ATranslator;
import pattern.adapter.adapter.OldTranslatorAdapter;
import pattern.adapter.target.NewTranslator;

/**
 * 
 * @author mz01-gyk
 * 클라이언트는 Adapter를 통해 NewTranslator로 OldeTranslator의 구현체인 ATranslator를 사용할 수 있다.
 * NewTranslator의 기능들 중 구현할 수 없는 것들은 예외를 던졌지만 클라이언트는 NewTranslator만 알고 있으면 된다.
 * 유연한 설계를 할 수 있게 되었다.
 *
 */
public class Client {
	public static void main(String[] args) {
		ATranslator aTranslator = new ATranslator();
		NewTranslator oldTranslatorAdapter = new OldTranslatorAdapter(aTranslator);
		oldTranslatorAdapter.chineseTranslation();
		oldTranslatorAdapter.koreanTranslation();
	}
}
