package cc3002.tarea2.psychic;

import cc3002.tarea2.*;

import java.util.List;

/**
 * Class that represents a phase 1 psychic Pokemon.
 *
 * @author Guillermo Martinez Salzar.
 */
public class Phase1PsychicPokemon extends AbstractPsychicPokemon implements IPhase1Pokemon {

    /**
     * Creates a new phase 1 psychic Pokemon.
     *
     * @param pokedexNumber Pokemon's pokedex unique number.
     * @param hp Pokemon's hit points.
     * @param maxHP Pokemon's maximum hit points
     * @param selectedAbility Pokemon's selected ability.
     * @param abilityList Pokemon's abilities.
     * @param energies Pokemon's energies.
     */
    public Phase1PsychicPokemon(String pokedexNumber, int hp, int maxHP, IAbility selectedAbility, List<IAbility> abilityList, EnergyCounter energies) {
        super(pokedexNumber, hp, maxHP, selectedAbility, abilityList, energies);
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visitPhase1Pokemon(this);
    }
}
