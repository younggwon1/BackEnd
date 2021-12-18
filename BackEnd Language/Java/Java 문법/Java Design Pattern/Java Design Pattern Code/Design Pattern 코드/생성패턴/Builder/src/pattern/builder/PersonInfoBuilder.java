package pattern.builder;

/**
 * 
 * @author mz01-gyk
 * 해결해야할 사항
 * 1. 불필요한 생성자를 만들지 않고 객체를 만든다.
 * 2. 데이터의 순서에 상관없이 객체를 만들어낸다.
 * 3. 사용자가 봤을 때 명시적이고 이해할 수 있어야한다.
 *
 */
public class PersonInfoBuilder {
    private String name;
    private Integer age;
    private String favoriteColor;
    private String favoriteAnimal;
    private Integer favoriteNumber;

    public PersonInfoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonInfoBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PersonInfoBuilder setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
        return this;
    }

    public PersonInfoBuilder setFavoriteAnimal(String favoriteAnimal) {
        this.favoriteAnimal = favoriteAnimal;
        return this;
    }

    public PersonInfoBuilder setFavoriteNumber(Integer favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
        return this;
    }

    public PersonInfo build(){
        PersonInfo personInfo = new PersonInfo(name, age, favoriteColor, favoriteAnimal, favoriteNumber);
        return personInfo;
    }
}
