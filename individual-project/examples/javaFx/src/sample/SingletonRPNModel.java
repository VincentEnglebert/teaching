package sample;

/**
 * Creates and manage ONE unique instance of the calculator model
 * @author Vincent Englebert
 */
public class SingletonRPNModel {

    private static ModelCalculator model=null;
    private SingletonRPNModel(){}

    /**
     * cf. Singleton Pattern.
     * @return a unique instance of the ModelCalculator.
     */
    static public ModelCalculator getInstance(){
        if (model==null){
            model=new ModelCalculator();
        }
        return model;
    }
}
