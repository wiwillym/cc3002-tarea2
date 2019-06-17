package cc3002.tarea2;

import cc3002.tarea2.trainercards.LuckyStadium;
import cc3002.tarea2.trainercards.Potion;
import cc3002.tarea2.trainercards.ProfessorJuniper;

/**
 * Abstract class that represents the Visitor for the Visitor Pattern.
 *
 * @author Guillermo Martinez Salazar.
 */
public abstract class Visitor implements IVisitor{

    protected ITrainer trainer;

    /**
     * Creates a new Visitor.
     *
     * @param trainer Trainer of the visitor.
     */
    public Visitor(ITrainer trainer){
        this.trainer = trainer;
    }

    @Override
    public void visitBasicPokemon(IBasicPokemon pokemon){}

    @Override
    public void visitPhase1Pokemon(IPhase1Pokemon pokemon){}

    @Override
    public void visitPhase2Pokemon(IPhase2Pokemon pokemon){}

    @Override
    public void visitStrikesBack(StrikesBack strikesBackAbility){}

    @Override
    public void visitElectricShock(ElectricShock electricShockAttack){}

    @Override
    public void visitLuckyStadium(LuckyStadium luckyStadiumCard){}

    @Override
    public void visitPotion(Potion potionCard){}

    @Override
    public void visitProfessorJuniper(ProfessorJuniper professorJuniperCard){}
}
