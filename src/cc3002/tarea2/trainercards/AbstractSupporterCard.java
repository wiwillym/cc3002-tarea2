package cc3002.tarea2.trainercards;

import cc3002.tarea2.AbstractTrainerCard;
import cc3002.tarea2.ITrainerCard;

/**
 * Abstract class that represents a Supporter Card.
 *
 * @author Guillermo Martinez Salazar.
 */
public abstract class AbstractSupporterCard extends AbstractTrainerCard implements ITrainerCard {

    /**
     * Creates a new Supporter Card.
     *
     * @param name Name of the card.
     * @param descr Description of the card.
     */
    public AbstractSupporterCard(String name, String descr){
        super(name, descr);
    }
}
