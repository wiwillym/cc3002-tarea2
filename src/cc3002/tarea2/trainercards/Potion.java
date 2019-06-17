package cc3002.tarea2.trainercards;

import cc3002.tarea2.ITrainer;
import cc3002.tarea2.ITrainerCard;
import cc3002.tarea2.Visitor;

/**
 * Class that represents a "Potion" Item Card.
 *
 * @author Guillermo Martinez Salazar.
 */
public class Potion extends AbstractItemCard implements ITrainerCard {

    /**
     * Creates a new Potion Card.
     *
     * @param name Name of the card.
     * @param descr Description of the card.
     */
    public Potion(String name, String descr){
        super(name, descr);
    }

    public void accept(Visitor visitor){
        visitor.visitPotion(this);
    }
}
