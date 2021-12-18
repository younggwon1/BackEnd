package pattern.adapter.adapter;

import pattern.adapter.adaptee.OldTranslator;
import pattern.adapter.target.NewTranslator;

/**
 * 
 * @author mz01-gyk
 * 실제 Adapter 역할을 하는 Adapter이다.
 * OldTranslator를 구성하고 있으며 NewTranslator를 상속받고 있다.
 * NewTranslator의 기능들 중 OldTranslator가 가지고 있는 기능은 메서드를 호출하여 그대로 기능하고 나머지 기능들은 예외를 던진다.
 *
 */
public class OldTranslatorAdapter implements NewTranslator {

	private OldTranslator oldTranslator;

	public OldTranslatorAdapter(OldTranslator oldTranslator) {
		this.oldTranslator = oldTranslator;
	}

	@Override
	public void koreanTranslation() {
		oldTranslator.koreanTranslation();
	}

	@Override
	public void chineseTranslation() {
		oldTranslator.chineseTranslation();
	}

	@Override
	public void russianTranslation() {
		throw new UnsupportedOperationException("지원되지 않는 기능입니다.");
	}

	@Override
	public void frenchTranslation() {
		throw new UnsupportedOperationException("지원되지 않는 기능입니다.");
	}
}
