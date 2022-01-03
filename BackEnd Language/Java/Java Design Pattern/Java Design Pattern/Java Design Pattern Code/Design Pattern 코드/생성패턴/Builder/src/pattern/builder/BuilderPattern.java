package pattern.builder;

public class BuilderPattern {
    public static void main(String[] args) {
        // 빌더 객체를 하나 만듭니다.
        PersonInfoBuilder personInfoBuilder = new PersonInfoBuilder();
        // 빌더 객체에 원하는 데이터를 입력합니다. 순서는 상관 없습니다.
        PersonInfo result = personInfoBuilder
                .setName("MISTAKE")
                .setAge(20)
                .setFavoriteAnimal("cat")
                .setFavoriteColor("black")
                .setName("JDM") // 다시 같은 메소드를 호출한다면 나중에 호출한 값이 들어갑니다.
                .setFavoriteNumber(7)
                // 마지막에 .build() 메소드를 호출해서 최종적인 결과물을 만들어 반환합니다.
                .build();
        // print is "name:JDM, age:20, favoriteColor:black, favoriteAnimal:cat, favoriteNumber:7"
        System.out.println(result.getPersonInfo());
    }
}
