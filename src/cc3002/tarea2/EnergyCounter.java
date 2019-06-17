package cc3002.tarea2;

import java.util.EnumMap;
import java.util.Map;

/**
 * Class that represents a map with every type of energy and an integer associated to all of them. It is used to know
 * how many energies of every type there is.
 *
 * @author Guillermo Martinez Salazar
 */
public class EnergyCounter{
    private Map<EnergyType, Integer> energies = new EnumMap<>(EnergyType.class);

    /**
     * Creates a new energy counter.
     */
    public EnergyCounter(){
        for (EnergyType type : EnergyType.values()){
            energies.put(type, 0);
        }
    }

    /**
     * Puts a grass energy into the map.
     *
     * @param value Quantity of grass energy put in the map.
     */
    public void setGrassEnergy(int value){
        energies.put(EnergyType.GRASS, value);
    }

    /**
     * Puts a fire energy into the map.
     *
     * @param value Quantity of fire energy put in the map.
     */
    public void setFireEnergy(int value){
        energies.put(EnergyType.FIRE, value);
    }

    /**
     * Puts a water energy into the map.
     *
     * @param value Quantity of water energy put in the map.
     */
    public void setWaterEnergy(int value){
        energies.put(EnergyType.WATER, value);
    }

    /**
     * Puts an electric energy into the map.
     *
     * @param value Quantity of electric energy put in the map.
     */
    public void setElectricEnergy(int value){
        energies.put(EnergyType.ELECTRIC, value);
    }

    /**
     * Puts a fighting energy into the map.
     *
     * @param value Quantity of fighting energy put in the map.
     */
    public void setFightingEnergy(int value){
        energies.put(EnergyType.FIGHTING, value);
    }

    /**
     * Puts a psychic energy into the map.
     *
     * @param value Quantity of psychic energy put in the map.
     */
    public void setPsychicEnergy(int value){
        energies.put(EnergyType.PSYCHIC, value);
    }

    /**
     * Getter for the grass energy value.
     *
     * @return number of grass energies.
     */
    public int getGrassEnergy(){
        return energies.get(EnergyType.GRASS);
    }

    /**
     * Getter for the fire energy value.
     *
     * @return number of fire energies.
     */
    public int getFireEnergy(){
        return energies.get(EnergyType.FIRE);
    }

    /**
     * Getter for the water energy value.
     *
     * @return number of water energies.
     */
    public int getWaterEnergy(){
        return energies.get(EnergyType.WATER);
    }

    /**
     * Getter for the electric energy value.
     *
     * @return number of electric energies.
     */
    public int getElectricEnergy(){
        return energies.get(EnergyType.ELECTRIC);
    }

    /**
     * Getter for the fighting energy value.
     *
     * @return number of fighting energies.
     */
    public int getFightingEnergy(){
        return energies.get(EnergyType.FIGHTING);
    }

    /**
     * Getter for the psychic energy value.
     *
     * @return number of psychic energies.
     */
    public int getPsychicEnergy(){
        return energies.get(EnergyType.PSYCHIC);
    }

    /**
     * Compares two energy counters.
     *
     * @param other Energy counter to be compared with.
     * @return <code>true</code> if the other energy counter is smaller, <code>false</code> otherwise.
     */
    public boolean greaterThan(EnergyCounter other){
        for (EnergyType type : EnergyType.values()){
            if (energies.get(type) < other.energies.get(type)){
                return false;
            }
        }
        return true;
    }
}
