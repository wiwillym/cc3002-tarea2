package cc3002.tarea2.trainercards;

import cc3002.tarea2.ITrainer;
import cc3002.tarea2.ITrainerCard;
import cc3002.tarea2.Visitor;

/**
 * Class that represents a "Lucky Stadium" Stadium Card.
 *
 * @author Guillermo Martinez Salazar.
 */
public class LuckyStadium extends AbstractStadiumCard implements ITrainerCard {

    /**
     * Creates a new Lucky Stadium card.
     *
     * @param name Name of the card.
     * @param descr Description of the card.
     */
    public LuckyStadium(String name, String descr){
        super(name, descr);
    }

    public void accept(Visitor visitor){
        visitor.visitLuckyStadium(this);
    }
}
