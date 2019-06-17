package cc3002.tarea2.trainercards;

import cc3002.tarea2.ICard;
import cc3002.tarea2.ITrainer;
import cc3002.tarea2.ITrainerCard;
import cc3002.tarea2.Visitor;

/**
 * Class that represents a "Professor Juniper" Supporter Card.
 *
 * @author Guillermo Martinez Salazar.
 */
public class ProfessorJuniper extends AbstractSupporterCard implements ITrainerCard {

    /**
     * Creates a new Professor Juniper card.
     *
     * @param name Name of the card.
     * @param descr Description of the card.
     */
    public ProfessorJuniper(String name, String descr){
        super(name, descr);
    }

    public void accept(Visitor visitor){
        visitor.visitProfessorJuniper(this);
    }
}
