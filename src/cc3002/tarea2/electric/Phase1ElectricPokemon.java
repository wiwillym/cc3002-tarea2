package cc3002.tarea2.electric;

import cc3002.tarea2.*;

import java.util.List;

/**
 * Class that represents a phase 1 electric Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public class Phase1ElectricPokemon extends AbstractElectricPokemon implements IPhase1Pokemon {

    /**
     * Creates a new phase 1 electric Pokemon.
     *
     * @param pokedexNumber Pokemon's pokedex unique number.
     * @param hp Pokemon's hit points.
     * @param maxHP Pokemon's maximum hit points
     * @param selectedAbility Pokemon's selected ability.
     * @param abilityList Pokemon's abilities.
     * @param energies Pokemon's energies.
     */
    public Phase1ElectricPokemon(String pokedexNumber, int hp, int maxHP, IAbility selectedAbility, List<IAbility> abilityList, EnergyCounter energies) {
        super(pokedexNumber, hp, maxHP, selectedAbility, abilityList, energies);
    }

    public void accept(Visitor visitor){
        visitor.visitPhase1Pokemon(this);
    }
}
