package cc3002.tarea2;

import cc3002.tarea2.trainercards.LuckyStadium;
import cc3002.tarea2.trainercards.Potion;
import cc3002.tarea2.trainercards.ProfessorJuniper;

/**
 * Interface for the Visitor Pattern.
 *
 * @author Guillermo Martinez Salazar.
 */
public interface IVisitor {

    /**
     * Visits a basic Pokemon.
     *
     * @param pokemon Pokemon visited.
     */
    void visitBasicPokemon(IBasicPokemon pokemon);

    /**
     * Visits a phase 1 Pokemon.
     *
     * @param pokemon Pokemon visited.
     */
    void visitPhase1Pokemon(IPhase1Pokemon pokemon);

    /**
     * Visits a phase 2 Pokemon.
     *
     * @param pokemon Pokemon visited.
     */
    void visitPhase2Pokemon(IPhase2Pokemon pokemon);

    /**
     * Visits a Strikes Back ability.
     *
     * @param strikesBackAbility Ability visited.
     */
    void visitStrikesBack(StrikesBack strikesBackAbility);

    /**
     * Visits an Electric Shock attack.
     *
     * @param electricShockAttack Electric Shock attack visited.
     */
    void visitElectricShock(ElectricShock electricShockAttack);

    /**
     * Visits a Lucky Stadium card.
     *
     * @param luckyStadiumCard Lucky Stadium card visited.
     */
    void visitLuckyStadium(LuckyStadium luckyStadiumCard);

    /**
     * Visits a Potion card.
     *
     * @param potionCard Potion card visited.
     */
    void visitPotion(Potion potionCard);

    /**
     * Visits a Professor Juniper Card.
     *
     * @param professorJuniperCard Professor Juniper card visited.
     */
    void visitProfessorJuniper(ProfessorJuniper professorJuniperCard);
}
