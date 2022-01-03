package pattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mz01-gyk
 * 만약 DB로부터 가져온 데이터를 우리의 프로그램에서 수차례 수정을 해야하는 경우
 * 매번 new라는 키워드를 통해 객체를 생성하여 DB로부터 항상 모든 데이터를 가져오는 것은 좋지않다.(DB 접근을 통한 데이터 수집은 비용이 크기때문)
 * 따라서 한번 DB에 접근하여 데이터를 가져온 객체를 필요에 따라 새로운 객체에 복사하여 데이터 수정 작업을 하는 것이 더 효율
 * 
 * 다음 코드를 보게되면 clone() 메소드를 재정의하기 위해 Cloneable 인터페이스를 구현
 * 즉, 복제를 구현하기 위해서 Cloneable 인터페이스를 구현한다.
 * Cloneable 구현 시 clone 메소드를 오버라이드하여 정의해주어야한다.
 * object를 반환하는 타입으로 clone()을 정의하고, 기능은 객체를 복제한 결과를 반환하는 구조이다.
 *
 */
public class Employees implements Cloneable{
	 
    private List<String> empList;
	
    public Employees(){
        empList = new ArrayList<String>();
    }
	
    public Employees(List<String> list){
        this.empList=list;
    }
    
    public void loadData(){
        //read all employees from database and put into the list
        empList.add("Pankaj");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }
	
    public List<String> getEmpList() {
        return empList;
    }
 
    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<String>();
        for(String s : this.empList){
            temp.add(s);
        }
        return new Employees(temp);
    }
	
}
