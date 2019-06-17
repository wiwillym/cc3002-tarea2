package cc3002.tarea2.water;

import cc3002.tarea2.*;

import java.util.List;

/**
 * Class that represents a phase 2 water Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public class Phase2WaterPokemon extends AbstractWaterPokemon implements IPhase2Pokemon {

    /**
     * Creates a new phase 2 water Pokemon.
     *
     * @param pokedexNumber Pokemon's pokedex unique number.
     * @param hp Pokemon's hit points.
     * @param maxHP Pokemon's maximum hit points
     * @param selectedAbility Pokemon's selected ability.
     * @param abilityList Pokemon's abilities.
     * @param energies Pokemon's energies.
     */
    public Phase2WaterPokemon(String pokedexNumber, int hp, int maxHP, IAbility selectedAbility, List<IAbility> abilityList, EnergyCounter energies) {
        super(pokedexNumber, hp, maxHP, selectedAbility, abilityList, energies);
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visitPhase2Pokemon(this);
    }
}
