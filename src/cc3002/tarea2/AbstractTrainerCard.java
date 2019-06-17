package cc3002.tarea2;

/**
 * Abstract class that represents a trainer card.
 *
 * @author Guillermo Martinez Salazar.
 */
public abstract class AbstractTrainerCard extends AbstractCard implements ITrainerCard {

    private String name;
    private String descr;

    /**
     * Creates a new trainer card.
     *
     * @param name Name of the trainer card.
     * @param descr Description of the trainer card.
     */
    public AbstractTrainerCard(String name, String descr){
        super(name);
        this.name = name;
        this.descr = descr;
    }
}
