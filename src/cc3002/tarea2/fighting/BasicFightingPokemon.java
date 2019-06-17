package cc3002.tarea2.fighting;

import cc3002.tarea2.*;

import java.util.List;

/**
 * Class that represents a basic fighting Pokemon.
 *
 * @author Guillermo Martinez Salazar.
 */
public class BasicFightingPokemon extends AbstractFightingPokemon implements IBasicPokemon {

    /**
     * Creates a new basic fighting Pokemon.
     *
     * @param pokedexNumber Pokemon's pokedex unique number.
     * @param hp Pokemon's hit points.
     * @param maxHP Pokemon's maximum hit points
     * @param selectedAbility Pokemon's selected ability.
     * @param abilityList Pokemon's abilities.
     * @param energies Pokemon's energies.
     */
    public BasicFightingPokemon(String pokedexNumber, int hp, int maxHP, IAbility selectedAbility, List<IAbility> abilityList, EnergyCounter energies){
        super(pokedexNumber, hp, maxHP, selectedAbility, abilityList, energies);
    }

    public void accept(Visitor visitor){
        visitor.visitBasicPokemon(this);
    }
}
