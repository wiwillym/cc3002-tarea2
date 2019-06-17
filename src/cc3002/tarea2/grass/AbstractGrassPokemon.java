package cc3002.tarea2.grass;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.AbstractElectricPokemon;
import cc3002.tarea2.fighting.AbstractFightingPokemon;
import cc3002.tarea2.fire.AbstractFirePokemon;
import cc3002.tarea2.psychic.AbstractPsychicPokemon;
import cc3002.tarea2.water.AbstractWaterPokemon;

import java.util.List;

/**
 * Abstract class that represents a grass type Pokemon.
 *
 * @author Guillermo Martinez Salazar
 */
public abstract class AbstractGrassPokemon extends AbstractPokemon implements IPokemon {

    /**
     * Creates a new grass Pokemon.
     *
     * @param pokedexNumber Pokemon's pokedex unique number.
     * @param hp Pokemon's hit points.
     * @param maxHP Pokemon's maximum hit points
     * @param selectedAbility Pokemon's selected ability.
     * @param abilityList Pokemon's abilities.
     * @param energies Pokemon's energies.
     */
    public AbstractGrassPokemon(String pokedexNumber, int hp, int maxHP, IAbility selectedAbility, List<IAbility> abilityList, EnergyCounter energies){
        super(pokedexNumber, hp, maxHP, selectedAbility, abilityList, energies);
    }

    @Override
    public void useAbility(ITrainer target){target.getActivePokemon().receiveGrassAttack(this);}

    @Override
    public void attack(ITrainer target){
        target.getActivePokemon().receiveGrassAttack(this);
    }

    @Override
    public void receiveFireAttack(AbstractFirePokemon other){
        this.receiveWeaknessAttack((IAttack) other.getSelectedAbility());
    }

    @Override
    public void receiveWaterAttack(AbstractWaterPokemon other){
        this.receiveResistantAttack((IAttack) other.getSelectedAbility());
    }

    @Override
    public void receiveElectricAttack(AbstractElectricPokemon other){
        this.receiveAttack((IAttack) other.getSelectedAbility());
    }

    @Override
    public void receiveFightingAttack(AbstractFightingPokemon other){
        this.receiveAttack((IAttack) other.getSelectedAbility());
    }

    @Override
    public void receiveGrassAttack(AbstractGrassPokemon other){
        this.receiveAttack((IAttack) other.getSelectedAbility());
    }

    @Override
    public void receivePsychicAttack(AbstractPsychicPokemon other){
        this.receiveAttack((IAttack) other.getSelectedAbility());
    }
}
