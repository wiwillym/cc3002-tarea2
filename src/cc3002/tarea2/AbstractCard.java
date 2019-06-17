package cc3002.tarea2;

/**
 * Base class for all the cards. This class contains the necessary methods to access the cards properties
 *
 * @author Guillermo Martínez Salazar
 */
public abstract class AbstractCard implements ICard {

    protected String name;

    /**
     * Creates a new card.
     *
     * @param name Name of the new card.
     */
    public AbstractCard(String name) {
        this.name = name;
    }

    @Override
    public String getCardName(){
        return this.name;
    }

    @Override
    public void play(ITrainer trainer){
    }
}
