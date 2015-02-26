package designpatterns.dao;

/**
 *
 * @author Migue
 */
public class FactoryImpl extends Factory{

    @Override
    public BookDao getDao() {
        if(Util.isTestMode()){
            return new InMemoryBookDao();
        }else{
            return new DataBaseBookDao();
        }
    }
    
}
