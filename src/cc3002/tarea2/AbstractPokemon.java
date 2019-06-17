package cc3002.tarea2;

import cc3002.tarea2.electric.ElectricEnergy;
import cc3002.tarea2.fighting.FightingEnergy;
import cc3002.tarea2.fire.FireEnergy;
import cc3002.tarea2.grass.GrassEnergy;
import cc3002.tarea2.psychic.PsychicEnergy;
import cc3002.tarea2.water.WaterEnergy;

import java.util.List;
import java.util.Random;

/**
 * Abstract class that represents a generic Pokemon. This class contains the necessary methods to
 * attack and receive damage, and definitions to get the properties of each Pokemon, like its pokedex ID, hp,
 * list of attacks, list of energies applied to the Pokemon and the selected attack.
 *
 * @author Guillermo Martinez Salazar
 */

public abstract class AbstractPokemon extends AbstractCard implements IPokemon {

    private String pokedexNumber;
    private int hp;
    private int maxHP;
    private List<IAbility> abilityList;
    private EnergyCounter energies;
    private IAbility selectedAbility;

    /**
     * Creates a new Pokemon
     *
     * @param pokedexNumber Pokemon's pokedex number.
     * @param hp Pokemon's hit points.
     * @param maxHP Pokemon's maximum hit points
     * @param selectedAbility Pokemon's selected attack.
     * @param abilityList Pokemon's attacks.
     * @param energies Pokemon's energies.
     */

    protected AbstractPokemon(String pokedexNumber, int hp, int maxHP, IAbility selectedAbility, List<IAbility> abilityList, EnergyCounter energies){
        super("Pokémon " + pokedexNumber);
        this.pokedexNumber = pokedexNumber;
        this.hp = hp;
        this.maxHP = maxHP;
        this.selectedAbility = null;
        this.abilityList = abilityList;
        this.energies = energies;
    }

    @Override
    public void attack(ITrainer trainer) {
    }

    @Override
    public void addAbility(IAbility ability){
        if (this.abilityList.size() < 4){
            this.abilityList.add(ability);
        }
    }

    @Override
    public void addGrassEnergy(GrassEnergy grassEnergy){
        energies.setGrassEnergy(energies.getGrassEnergy() + 1);
    }

    @Override
    public void addWaterEnergy(WaterEnergy waterEnergy){
        energies.setWaterEnergy(energies.getWaterEnergy() + 1);
    }

    @Override
    public void addElectricEnergy(ElectricEnergy electricEnergy){
        energies.setElectricEnergy(energies.getElectricEnergy() + 1);
    }

    @Override
    public void addFightingEnergy(FightingEnergy fightingEnergy){
        energies.setFightingEnergy(energies.getFightingEnergy() + 1);
    }

    @Override
    public void addFireEnergy(FireEnergy fireEnergy){
        energies.setFireEnergy(energies.getFireEnergy() + 1);
    }

    @Override
    public void addPsychicEnergy(PsychicEnergy psychicEnergy){
        energies.setPsychicEnergy(energies.getPsychicEnergy() + 1);
    }

    @Override
    public String getPokedexNumber(){
        return pokedexNumber;
    }

    @Override
    public int getHP(){
        return hp;
    }

    @Override
    public int getMaxHP(){
        return maxHP;
    }

    @Override
    public List<IAbility> getAbilities(){
        return abilityList;
    }

    @Override
    public EnergyCounter getEnergies(){
        return this.energies;
    }

    @Override
    public IAbility getSelectedAbility(){
        return this.selectedAbility;
    }

    @Override
    public void genericAttack(ITrainer target){
        if (this.getEnergies().greaterThan(this.getSelectedAbility().getCostOfEnergies())){
            this.useAbility(target);
        }
    }

    @Override
    public void useAbility(ITrainer target){
    }

    @Override
    public boolean isAlive(){
        return this.getHP() > 0;
    }

    /**
     * Receives an attack.
     *
     * @param attack Received attack.
     */
    protected void receiveAttack(IAttack attack){
        setHP(this.getHP() - attack.getBaseDamage());
    }

    /**
     * Receives an attack to which this Pokemon is weak.
     *
     * @param attack Received attack.
     */
    protected void receiveWeaknessAttack(IAttack attack){
        setHP(this.getHP() - attack.getBaseDamage()*2);
    }

    /**
     * Receives an attack to which this Pokemon is resistant.
     *
     * @param attack Received attack.
     */
    protected void receiveResistantAttack(IAttack attack){
        setHP(this.getHP() - attack.getBaseDamage() + 30);
    }

    @Override
    public void selectAbility(int index){ this.selectedAbility = abilityList.get(index);}

    @Override
    public void setHP(int newHP){
        this.hp = newHP < 0 ? 0 : newHP;
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof IPokemon && ((IPokemon) obj).getPokedexNumber().equals(pokedexNumber)
                && ((IPokemon) obj).getHP() == hp && ((IPokemon) obj).getAbilities().equals(abilityList)
                && ((IPokemon) obj).getEnergies().equals(energies);
    }
}
