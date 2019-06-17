package cc3002.tarea2.fighting;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.AbstractElectricPokemon;
import cc3002.tarea2.fire.AbstractFirePokemon;
import cc3002.tarea2.grass.AbstractGrassPokemon;
import cc3002.tarea2.psychic.AbstractPsychicPokemon;
import cc3002.tarea2.water.AbstractWaterPokemon;

import java.util.List;

/**
 * Abstract class that represents a fighting type Pokemon.
 *
 * @author Guillermo Martinez Salazar
 */
public abstract class AbstractFightingPokemon extends AbstractPokemon implements IPokemon {

    /**
     * Creates a new fighting Pokemon.
     *
     * @param pokedexNumber Pokemon's pokedex unique number.
     * @param hp Pokemon's hit points.
     * @param maxHP Pokemon's maximum hit points
     * @param selectedAbility Pokemon's selected ability.
     * @param abilityList Pokemon's abilities.
     * @param energies Pokemon's energies.
     */
    public AbstractFightingPokemon(String pokedexNumber, int hp, int maxHP, IAbility selectedAbility, List<IAbility> abilityList, EnergyCounter energies){
        super(pokedexNumber, hp, maxHP, selectedAbility, abilityList, energies);
    }

    @Override
    public void attack(ITrainer target){
        target.getActivePokemon().receiveFightingAttack(this);
    }

    @Override
    public void useAbility(ITrainer target){target.getActivePokemon().receiveFightingAttack(this);}

    @Override
    public void receivePsychicAttack(AbstractPsychicPokemon other){
        this.receiveWeaknessAttack((IAttack) other.getSelectedAbility());
    }

    @Override
    public void receiveGrassAttack(AbstractGrassPokemon other){
        this.receiveWeaknessAttack((IAttack) other.getSelectedAbility());
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
    public void receiveFireAttack(AbstractFirePokemon other){
        this.receiveAttack((IAttack) other.getSelectedAbility());
    }

    @Override
    public void receiveWaterAttack(AbstractWaterPokemon other){
        this.receiveAttack((IAttack) other.getSelectedAbility());
    }
}
