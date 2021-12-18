package pattern.facade.facade;

import pattern.facade.subclass.Beverage;
import pattern.facade.subclass.Movie;
import pattern.facade.subclass.Remote_Control;

/**
 * 
 * @author mz01-gyk
 * Facade 클래스다. 
 * 복잡한 서브 클래스들에 대한 인스턴스를 가지며 복잡한 호출 방식에 대하여 view_Movie() 메서드 내에서 구현을 하도록 하였다.
 *
 */
public class Facade {
    
    private String beverage_Name ="";
    private String Movie_Name="";
    
    public Facade(String beverage_Name,String Movie_Name)
    {
        this.beverage_Name=beverage_Name;
        this.Movie_Name=Movie_Name;
    }
    
    public void view_Movie()
    {
        Beverage beverage = new Beverage(beverage_Name);
        Remote_Control remote= new Remote_Control();
        Movie movie = new Movie(Movie_Name);
        
        beverage.Prepare();
        remote.Turn_On();
        movie.Search_Movie();
        movie.Charge_Movie();
        movie.play_Movie();
    }
}

