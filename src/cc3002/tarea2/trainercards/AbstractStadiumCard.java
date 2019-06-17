package cc3002.tarea2.trainercards;

import cc3002.tarea2.AbstractTrainerCard;
import cc3002.tarea2.ITrainerCard;

/**
 * Abstract class that represents a Stradium Card.
 *
 * @author Guillermo Martinez Salazar.
 */
public abstract class AbstractStadiumCard extends AbstractTrainerCard implements ITrainerCard {

    /**
     * Creates a new Stadium Card.
     *
     * @param name Name of the card.
     * @param descr Description of the card.
     */
    public AbstractStadiumCard(String name, String descr){
        super(name, descr);
    }
}
