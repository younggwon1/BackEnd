package pattern.builder;

/**
 * 이 클래스는 한 사람의 정보를 담기 위한 것이다.
 * 제약사항 : 이 객체는 한번 생성되면 읽기(Read)만 가능해야 합니다.(setter 메서드x)
 * 따라서 setter 메서드는 존재할 수 없고 오로지 생성자를 통해서만 데이터를 입력 받는다는 가정으로 만든 클래스이다.
 * 
 * 생성자를 보면 모든 매개변수를 받도록 하고있다. 하지만 어떤 사람의 정보의 경우 모든 데이터가 없을 수도 있다.
 * 또한 데이터를 입력하는 순서가 달라질 수도 있다.
 * 따라서 이러한 문제를 해결하기 위해 좀 더 명시적이고 명확하게 객체를 만들어내야한다.
 */
public class PersonInfo {
    private String name;
    private Integer age;
    private String favoriteColor;
    private String favoriteAnimal;
    private Integer favoriteNumber;

    public PersonInfo(String name, Integer age, String favoriteColor, String favoriteAnimal, Integer favoriteNumber){
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
        this.favoriteAnimal = favoriteAnimal;
        this.favoriteNumber = favoriteNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public String getFavoriteAnimal() {
        return favoriteAnimal;
    }

    public Integer getFavoriteNumber() {
        return favoriteNumber;
    }

    public String getPersonInfo(){
        String personInfo = String.format("name:%s, age:%d, favoriteColor:%s, favoriteAnimal:%s, favoriteNumber:%d"
                , name, age, favoriteColor, favoriteAnimal, favoriteNumber);
        return personInfo;
    }
}