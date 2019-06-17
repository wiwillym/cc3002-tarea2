package cc3002.tarea2.trainercards;

import cc3002.tarea2.AbstractTrainerCard;
import cc3002.tarea2.ITrainerCard;

/**
 * Abstract class that represents an Item Card.
 *
 * @author Guillermo Martinez Salazar.
 */
public abstract class AbstractItemCard extends AbstractTrainerCard implements ITrainerCard {

    /**
     * Creates a new Item Card.
     *
     * @param name Name of the card.
     * @param descr Description of the card.
     */
    public AbstractItemCard(String name, String descr){
        super(name, descr);
    }
}
