package cc3002.tarea2;

import java.util.List;
import cc3002.tarea2.electric.ElectricEnergy;
import cc3002.tarea2.electric.AbstractElectricPokemon;
import cc3002.tarea2.fighting.FightingEnergy;
import cc3002.tarea2.fighting.AbstractFightingPokemon;
import cc3002.tarea2.fire.FireEnergy;
import cc3002.tarea2.fire.AbstractFirePokemon;
import cc3002.tarea2.grass.GrassEnergy;
import cc3002.tarea2.grass.AbstractGrassPokemon;
import cc3002.tarea2.psychic.PsychicEnergy;
import cc3002.tarea2.psychic.AbstractPsychicPokemon;
import cc3002.tarea2.water.WaterEnergy;
import cc3002.tarea2.water.AbstractWaterPokemon;

import javax.swing.*;

/**
 * Common interface for all the Pokemon. Every Pokemon has a pokedex number, hit points, list of attacks
 * and a list of energies.
 *
 * @author Guillermo Martinez Salazar
 */
public interface IPokemon extends ICard{

    /**
     * Accept method for the visitor.
     *
     * @param visitor Visitor that "visits" the pokemon cards.
     */
    void accept(Visitor visitor);

    /**
     * Adds ability to a Pokemon.
     *
     * @param ability Ability intended to be added to the Pokemon.
     */
    void addAbility(IAbility ability);

    /**
     * Attacks other trainers' active pokemon.
     *
     * @param trainer Target of the attack.
     */
    void attack(ITrainer trainer);

    /**
     * Adds a grass energy to the pokemon.
     *
     * @param grassEnergy Energy that is intended to be added.
     */
    void addGrassEnergy(GrassEnergy grassEnergy);

    /**
     * Adds an electric energy to the pokemon.
     *
     * @param electricEnergy Energy that is intended to be added.
     */
    void addElectricEnergy(ElectricEnergy electricEnergy);

    /**
     * Adds a fighting energy to the pokemon.
     *
     * @param fightingEnergy Energy that is intended to be added.
     */
    void addFightingEnergy(FightingEnergy fightingEnergy);

    /**
     * Adds a fire energy to the pokemon.
     *
     * @param fireEnergy Energy that is intended to be added.
     */
    void addFireEnergy(FireEnergy fireEnergy);

    /**
     * Adds a psychic energy to the pokemon.
     *
     * @param psychicEnergy Energy that is intended to be added.
     */
    void addPsychicEnergy(PsychicEnergy psychicEnergy);

    /**
     * Adds a water energy to the pokemon.
     *
     * @param waterEnergy Energy that is intended to be added.
     */
    void addWaterEnergy(WaterEnergy waterEnergy);

    /**
     * Definition of a generic attack.
     *
     * @param target Target intended to be attacked.
     */
    void genericAttack(ITrainer target);

    /**
     * Getter for the list of attacks of the Pokemon.
     *
     * @return List with all the Pokemon attacks.
     */
    List<IAbility> getAbilities();

    /**
     * Getter for the Pokemon applied energies.
     *
     * @return List with all the Pokemon energies.
     */
    EnergyCounter getEnergies();

    /**
     * Getter for the Pokemon´s pokedex unique number.
     *
     * @return Pokemon's pokedex unique number.
     */
    String getPokedexNumber();

    /**
     * Getter for the Pokemon´s hit points.
     *
     * @return Pokemon's hit points.
     */
    int getHP();

    /**
     * Getter for the Pokemon's maximum hit points.
     *
     * @return Pokemon's maximum hit points.
     */
    int getMaxHP();

    /**
     * Getter for the selected ability.
     *
     * @return The current selected ability.
     */
    IAbility getSelectedAbility();

    /**
     * Checks if the Pokemon is alive or not.
     *
     * @return <code>true</code> if Pokemon hit points are over 0, <code>false</code> otherwise.
     */
    boolean isAlive();


    /**
     * Receives damage from a grass attack.
     *
     * @param pokemon Other pokemon.
     */
    void receiveGrassAttack(AbstractGrassPokemon pokemon);

    /**
     * Receives damage from a fire attack.
     *
     * @param pokemon Other pokemon.
     */
    void receiveFireAttack(AbstractFirePokemon pokemon);

    /**
     * Receives damage from a water attack.
     *
     * @param pokemon Other pokemon.
     */
    void receiveWaterAttack(AbstractWaterPokemon pokemon);

    /**
     * Receives damage from an electric attack.
     *
     * @param pokemon Other pokemon.
     */
    void receiveElectricAttack(AbstractElectricPokemon pokemon);

    /**
     * Receives damage from a psychic attack.
     *
     * @param pokemon Other pokemon.
     */
    void receivePsychicAttack(AbstractPsychicPokemon pokemon);

    /**
     * Receives damage from a fighting attack.
     *
     * @param pokemon Other pokemon.
     */
    void receiveFightingAttack(AbstractFightingPokemon pokemon);

    /**
     * Selects an ability.
     *
     * @param index Index of the ability to be selected.
     */
    void selectAbility(int index);

    /**
     * Set the new hit points of the pokemon that received an attack.
     *
     * @param newHP new hit points after the attack.
     */
    void setHP(int newHP);

    /**
     * Uses the selected ability.
     *
     * @param target Target to be attacked.
     */
    void useAbility(ITrainer target);
}
