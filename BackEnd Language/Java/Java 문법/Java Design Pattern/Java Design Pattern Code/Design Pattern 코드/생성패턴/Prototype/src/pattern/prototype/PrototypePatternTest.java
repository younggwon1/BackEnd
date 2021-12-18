package pattern.prototype;

import java.util.List;

/**
 * 
 * @author mz01-gyk
 * 만약 Employees 클래스에서 clone()을 제공하지 않았다면, 
 * DB로부터 매번 employee 리스트를 직접 가져와야 했을 것이고, 이로인해 큰 비용이 발생.
 * 하지만 프로토타입을 사용한다면 1회의 DB 접근을 통해 가져온 데이터를 복사하여 사용한다면 이를 해결할 수 있다. 
 * 
 */
public class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
        Employees emps = new Employees();
        emps.loadData();
		
        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");
		
        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }

}
