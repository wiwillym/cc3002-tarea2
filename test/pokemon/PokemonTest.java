package pokemon;

import cc3002.tarea2.EnergyCounter;
import cc3002.tarea2.IPokemon;
import cc3002.tarea2.ITrainer;
import cc3002.tarea2.Trainer;
import cc3002.tarea2.electric.BasicElectricPokemon;
import cc3002.tarea2.electric.ElectricAttack;
import cc3002.tarea2.electric.ElectricEnergy;
import cc3002.tarea2.electric.AbstractElectricPokemon;
import cc3002.tarea2.fighting.BasicFightingPokemon;
import cc3002.tarea2.fighting.FightingAttack;
import cc3002.tarea2.fighting.FightingEnergy;
import cc3002.tarea2.fighting.AbstractFightingPokemon;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.fire.FireAttack;
import cc3002.tarea2.fire.FireEnergy;
import cc3002.tarea2.fire.AbstractFirePokemon;
import cc3002.tarea2.grass.BasicGrassPokemon;
import cc3002.tarea2.grass.GrassAttack;
import cc3002.tarea2.grass.GrassEnergy;
import cc3002.tarea2.grass.AbstractGrassPokemon;
import cc3002.tarea2.psychic.BasicPsychicPokemon;
import cc3002.tarea2.psychic.PsychicAttack;
import cc3002.tarea2.psychic.PsychicEnergy;
import cc3002.tarea2.psychic.AbstractPsychicPokemon;
import cc3002.tarea2.water.BasicWaterPokemon;
import cc3002.tarea2.water.WaterAttack;
import cc3002.tarea2.water.WaterEnergy;
import cc3002.tarea2.water.AbstractWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class PokemonTest {

    private IPokemon
            dummy1,
            dummy2,
            dummy3,
            dummy4,
            dummy5,
            dummy6,
            dummy7;

    private ElectricAttack electricAttack;
    private FightingAttack fightingAttack;
    private FireAttack fireAttack;
    private GrassAttack grassAttack;
    private PsychicAttack psychicAttack;
    private WaterAttack waterAttack;
    private EnergyCounter costOfEnergies1 = new EnergyCounter();
    private EnergyCounter costOfEnergies2 = new EnergyCounter();
    private EnergyCounter costOfEnergies3 = new EnergyCounter();
    private EnergyCounter costOfEnergies4 = new EnergyCounter();
    private EnergyCounter costOfEnergies5 = new EnergyCounter();
    private EnergyCounter costOfEnergies6 = new EnergyCounter();

    private EnergyCounter pcostOfEnergies1 = new EnergyCounter();
    private EnergyCounter pcostOfEnergies2 = new EnergyCounter();
    private EnergyCounter pcostOfEnergies3 = new EnergyCounter();
    private EnergyCounter pcostOfEnergies4 = new EnergyCounter();
    private EnergyCounter pcostOfEnergies5 = new EnergyCounter();
    private EnergyCounter pcostOfEnergies6 = new EnergyCounter();

    private EnergyCounter test = new EnergyCounter();

    private ElectricEnergy electricEnergy;
    private FireEnergy fireEnergy;
    private GrassEnergy grassEnergy;
    private PsychicEnergy psychicEnergy;
    private WaterEnergy waterEnergy;
    private FightingEnergy fightingEnergy;

    private ITrainer trainer1, trainer2;

    @Before
    public void setUp(){
        electricAttack = new ElectricAttack("Thundershock", 40, "Does something", costOfEnergies1);
        fightingAttack = new FightingAttack("Cross Chop", 50, "Does something", costOfEnergies2);
        fireAttack = new FireAttack("Fire Spin", 15, "Does something", costOfEnergies3);
        grassAttack = new GrassAttack("Seed Bomb", 55, "Does something", costOfEnergies4);
        psychicAttack = new PsychicAttack("Psyshock", 65, "Does something", costOfEnergies5);
        waterAttack = new WaterAttack("Bubble", 30, "Does something", costOfEnergies6);

        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), pcostOfEnergies1);
        dummy2 = new BasicWaterPokemon("2", 100, 100, null, new ArrayList<>(Arrays.asList(waterAttack)), pcostOfEnergies2);
        dummy3 = new BasicElectricPokemon("3", 100, 100, null, new ArrayList<>(Arrays.asList(electricAttack)), pcostOfEnergies3);
        dummy4 = new BasicFightingPokemon("4", 100, 100, null, new ArrayList<>(Arrays.asList(fightingAttack)), pcostOfEnergies4);
        dummy5 = new BasicGrassPokemon("5", 100, 100, null, new ArrayList<>(Arrays.asList(grassAttack)), pcostOfEnergies5);
        dummy6 = new BasicPsychicPokemon("6", 100, 100, null, new ArrayList<>(Arrays.asList(psychicAttack)), pcostOfEnergies6);
        dummy7 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(Arrays.asList(fireAttack)), pcostOfEnergies1);

        electricEnergy = new ElectricEnergy("electricenergy", "does smthn1");
        fightingEnergy = new FightingEnergy("fightingenergy", "does smthn2");
        fireEnergy = new FireEnergy("fireenergy", "does smthn3");
        grassEnergy = new GrassEnergy("grassenergy", "does smthn4");
        psychicEnergy = new PsychicEnergy("psychicenergy", "does smthn5");
        waterEnergy = new WaterEnergy("waterenergy", "does smthn6");

        trainer1 = new Trainer(dummy2, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, null);
        trainer2 = new Trainer(dummy3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, null);
    }

    @Test
    public void constructorTest(){
        assertEquals("2", dummy2.getPokedexNumber());
        assertEquals(100, dummy2.getHP());
        assertEquals(1, dummy2.getAbilities().size());
        assertEquals(waterAttack, dummy2.getAbilities().get(0));
        assertEquals(electricAttack, dummy3.getAbilities().get(0));
        assertEquals(grassAttack, dummy5.getAbilities().get(0));
        assertEquals(psychicAttack, dummy6.getAbilities().get(0));
    }

    @Test
    public void addAttackTest() {
        assertEquals(new ArrayList<>(), dummy1.getAbilities());
        dummy1.addAbility(waterAttack);
        assertEquals(new ArrayList<>(Arrays.asList(waterAttack)), dummy1.getAbilities());
    }

    @Test
    public void addGrassEnergyTest(){
        assertEquals(test.getGrassEnergy(), dummy1.getEnergies().getGrassEnergy());
        dummy1.addGrassEnergy(grassEnergy);
        assertNotEquals(test.getGrassEnergy(), dummy1.getEnergies().getGrassEnergy());
        test.setGrassEnergy(1);
        assertEquals(test.getGrassEnergy(), dummy1.getEnergies().getGrassEnergy());
    }
    @Test
    public void addElectricEnergyTest(){
        assertEquals(test.getElectricEnergy(), dummy1.getEnergies().getElectricEnergy());
        dummy1.addElectricEnergy(electricEnergy);
        assertNotEquals(test.getElectricEnergy(), dummy1.getEnergies().getElectricEnergy());
        test.setElectricEnergy(1);
        assertEquals(test.getElectricEnergy(), dummy1.getEnergies().getElectricEnergy());
    }
    @Test
    public void addFightingEnergyTest(){
        assertEquals(test.getFightingEnergy(), dummy1.getEnergies().getFightingEnergy());
        dummy1.addFightingEnergy(fightingEnergy);
        assertNotEquals(test.getFightingEnergy(), dummy1.getEnergies().getFightingEnergy());
        test.setFightingEnergy(1);
        assertEquals(test.getFightingEnergy(), dummy1.getEnergies().getFightingEnergy());
    }
    @Test
    public void addFireEnergyTest(){
        assertEquals(test.getFireEnergy(), dummy1.getEnergies().getFireEnergy());
        dummy1.addFireEnergy(fireEnergy);
        assertNotEquals(test.getFireEnergy(), dummy1.getEnergies().getFireEnergy());
        test.setFireEnergy(1);
        assertEquals(test.getFireEnergy(), dummy1.getEnergies().getFireEnergy());
    }
    @Test
    public void addPsychicEnergyTest(){
        assertEquals(test.getPsychicEnergy(), dummy1.getEnergies().getPsychicEnergy());
        dummy1.addPsychicEnergy(psychicEnergy);
        assertNotEquals(test.getPsychicEnergy(), dummy1.getEnergies().getPsychicEnergy());
        test.setPsychicEnergy(1);
        assertEquals(test.getPsychicEnergy(), dummy1.getEnergies().getPsychicEnergy());
    }
    @Test
    public void addWaterEnergyTest(){
        assertEquals(test.getWaterEnergy(), dummy1.getEnergies().getWaterEnergy());
        dummy1.addWaterEnergy(waterEnergy);
        assertNotEquals(test.getWaterEnergy(), dummy1.getEnergies().getWaterEnergy());
        test.setWaterEnergy(1);
        assertEquals(test.getWaterEnergy(), dummy1.getEnergies().getWaterEnergy());
    }

    @Test
    public void genericAttackTest(){
        assertEquals(100, dummy3.getHP());
        costOfEnergies1.setWaterEnergy(1);
        dummy1.addWaterEnergy(waterEnergy);
        dummy1.addAbility(waterAttack);
        dummy1.selectAbility(0);
        dummy1.genericAttack(trainer2);
        assertEquals(70, dummy3.getHP());
    }

    @Test
    public void getAttacksTest(){
        assertEquals(new ArrayList<>(Arrays.asList(waterAttack)), dummy2.getAbilities());
        assertNotEquals(new ArrayList<>(Arrays.asList(fightingAttack)), dummy3.getAbilities());
        assertEquals(new ArrayList<>(), dummy1.getAbilities());
    }

    @Test
    public void selectAndGetSelectedAttackTest(){
        dummy2.selectAbility(0);
        assertEquals(waterAttack, dummy2.getSelectedAbility());
        dummy3.selectAbility(0);
        assertEquals(electricAttack, dummy3.getSelectedAbility());
        dummy4.selectAbility(0);
        assertEquals(fightingAttack, dummy4.getSelectedAbility());
        dummy5.selectAbility(0);
        assertEquals(grassAttack, dummy5.getSelectedAbility());
        dummy6.selectAbility(0);
        assertEquals(psychicAttack, dummy6.getSelectedAbility());
    }

    @Test
    public void waterAttackTest(){
        dummy2.selectAbility(0);
        assertEquals(100, dummy3.getHP());
        dummy2.attack(trainer2);
        assertNotEquals(100, dummy3.getHP());
        assertEquals(70, dummy3.getHP());
    }
    @Test
    public void electricAttackTest(){
        dummy3.selectAbility(0);
        assertEquals(100, dummy2.getHP());
        dummy3.attack(trainer1);
        assertNotEquals(100, dummy2.getHP());
        assertEquals(100, dummy3.getHP());
    }
    @Test
    public void fightingAttackTest(){
        dummy4.selectAbility(0);
        assertEquals(100, dummy3.getHP());
        dummy4.attack(trainer2);
        assertNotEquals(100, dummy3.getHP());
        assertEquals(0, dummy3.getHP());
    }
    @Test
    public void fireAttackTest(){
        dummy1.addAbility(fireAttack);
        dummy1.selectAbility(0);
        assertEquals(100, dummy3.getHP());
        dummy1.attack(trainer2);
        assertNotEquals(100, dummy3.getHP());
        assertEquals(85, dummy3.getHP());
    }
    @Test
    public void grassAttackTest(){
        dummy5.selectAbility(0);
        assertEquals(100, dummy3.getHP());
        dummy5.attack(trainer2);
        assertNotEquals(100, dummy3.getHP());
        assertEquals(45, dummy3.getHP());
    }
    @Test
    public void psychicAttackTest(){
        dummy6.selectAbility(0);
        assertEquals(100, dummy3.getHP());
        dummy6.attack(trainer2);
        assertNotEquals(100, dummy3.getHP());
        assertEquals(35, dummy3.getHP());
    }

    @Test
    public void getPokedexNumberTest(){
        assertEquals("3", dummy3.getPokedexNumber());
        assertNotEquals("4", dummy2.getPokedexNumber());
    }

    @Test
    public void getEnergiesTest(){
        assertEquals(test.getWaterEnergy(), costOfEnergies1.getWaterEnergy());
        costOfEnergies1.setWaterEnergy(1);
        assertNotEquals(test.getWaterEnergy(), costOfEnergies1.getWaterEnergy());
    }

    @Test
    public void receiveWaterAttackTest(){
        dummy2.selectAbility(0);
        assertEquals(100, dummy1.getHP());
        assertEquals(100, dummy2.getHP());
        assertEquals(100, dummy3.getHP());
        assertEquals(100, dummy4.getHP());
        assertEquals(100, dummy5.getHP());
        assertEquals(100, dummy6.getHP());
        dummy1.receiveWaterAttack((AbstractWaterPokemon) dummy2);
        dummy2.receiveWaterAttack((AbstractWaterPokemon) dummy2);
        dummy3.receiveWaterAttack((AbstractWaterPokemon) dummy2);
        dummy4.receiveWaterAttack((AbstractWaterPokemon) dummy2);
        dummy5.receiveWaterAttack((AbstractWaterPokemon) dummy2);
        dummy6.receiveWaterAttack((AbstractWaterPokemon) dummy2);
        assertEquals(40, dummy1.getHP());
        assertEquals(70, dummy2.getHP());
        assertEquals(70, dummy3.getHP());
        assertEquals(70, dummy4.getHP());
        assertEquals(100, dummy5.getHP());
        assertEquals(70, dummy6.getHP());

    }

    @Test
    public void receiveGrassAttackTest(){
        dummy5.selectAbility(0);
        assertEquals(100, dummy1.getHP());
        assertEquals(100, dummy2.getHP());
        assertEquals(100, dummy3.getHP());
        assertEquals(100, dummy4.getHP());
        assertEquals(100, dummy5.getHP());
        assertEquals(100, dummy6.getHP());
        dummy1.receiveGrassAttack((AbstractGrassPokemon) dummy5);
        dummy2.receiveGrassAttack((AbstractGrassPokemon) dummy5);
        dummy3.receiveGrassAttack((AbstractGrassPokemon) dummy5);
        dummy4.receiveGrassAttack((AbstractGrassPokemon) dummy5);
        dummy5.receiveGrassAttack((AbstractGrassPokemon) dummy5);
        dummy6.receiveGrassAttack((AbstractGrassPokemon) dummy5);
        assertEquals(45, dummy1.getHP());
        assertEquals(0, dummy2.getHP());
        assertEquals(45, dummy3.getHP());
        assertEquals(0, dummy4.getHP());
        assertEquals(45, dummy5.getHP());
        assertEquals(45, dummy6.getHP());
    }

    @Test
    public void receiveFireAttackTest(){
        dummy1.addAbility(fireAttack);
        dummy1.selectAbility(0);
        assertEquals(100, dummy1.getHP());
        assertEquals(100, dummy2.getHP());
        assertEquals(100, dummy3.getHP());
        assertEquals(100, dummy4.getHP());
        assertEquals(100, dummy5.getHP());
        assertEquals(100, dummy6.getHP());
        dummy1.receiveFireAttack((AbstractFirePokemon) dummy1);
        dummy2.receiveFireAttack((AbstractFirePokemon) dummy1);
        dummy3.receiveFireAttack((AbstractFirePokemon) dummy1);
        dummy4.receiveFireAttack((AbstractFirePokemon) dummy1);
        dummy5.receiveFireAttack((AbstractFirePokemon) dummy1);
        dummy6.receiveFireAttack((AbstractFirePokemon) dummy1);
        assertEquals(85, dummy1.getHP());
        assertEquals(85, dummy2.getHP());
        assertEquals(85, dummy3.getHP());
        assertEquals(85, dummy4.getHP());
        assertEquals(70, dummy5.getHP());
        assertEquals(85, dummy6.getHP());
    }

    @Test
    public void receiveFightingAttackTest(){
        dummy4.selectAbility(0);
        assertEquals(100, dummy1.getHP());
        assertEquals(100, dummy2.getHP());
        assertEquals(100, dummy3.getHP());
        assertEquals(100, dummy4.getHP());
        assertEquals(100, dummy5.getHP());
        assertEquals(100, dummy6.getHP());
        dummy1.receiveFightingAttack((AbstractFightingPokemon) dummy4);
        dummy2.receiveFightingAttack((AbstractFightingPokemon) dummy4);
        dummy3.receiveFightingAttack((AbstractFightingPokemon) dummy4);
        dummy4.receiveFightingAttack((AbstractFightingPokemon) dummy4);
        dummy5.receiveFightingAttack((AbstractFightingPokemon) dummy4);
        dummy6.receiveFightingAttack((AbstractFightingPokemon) dummy4);
        assertEquals(50, dummy1.getHP());
        assertEquals(80, dummy2.getHP());
        assertEquals(0, dummy3.getHP());
        assertEquals(50, dummy4.getHP());
        assertEquals(50, dummy5.getHP());
        assertEquals(80, dummy6.getHP());
    }

    @Test
    public void receiveElectricAttackTest(){
        dummy3.selectAbility(0);
        assertEquals(100, dummy1.getHP());
        assertEquals(100, dummy2.getHP());
        assertEquals(100, dummy3.getHP());
        assertEquals(100, dummy4.getHP());
        assertEquals(100, dummy5.getHP());
        assertEquals(100, dummy6.getHP());
        dummy1.receiveElectricAttack((AbstractElectricPokemon) dummy3);
        dummy2.receiveElectricAttack((AbstractElectricPokemon) dummy3);
        dummy3.receiveElectricAttack((AbstractElectricPokemon) dummy3);
        dummy4.receiveElectricAttack((AbstractElectricPokemon) dummy3);
        dummy5.receiveElectricAttack((AbstractElectricPokemon) dummy3);
        dummy6.receiveElectricAttack((AbstractElectricPokemon) dummy3);
        assertEquals(60, dummy1.getHP());
        assertEquals(20, dummy2.getHP());
        assertEquals(60, dummy3.getHP());
        assertEquals(60, dummy4.getHP());
        assertEquals(60, dummy5.getHP());
        assertEquals(60, dummy6.getHP());
    }

    @Test
    public void receivePsychicAttackTest(){
        dummy6.selectAbility(0);
        assertEquals(100, dummy1.getHP());
        assertEquals(100, dummy2.getHP());
        assertEquals(100, dummy3.getHP());
        assertEquals(100, dummy4.getHP());
        assertEquals(100, dummy5.getHP());
        assertEquals(100, dummy6.getHP());
        dummy1.receivePsychicAttack((AbstractPsychicPokemon) dummy6);
        dummy2.receivePsychicAttack((AbstractPsychicPokemon) dummy6);
        dummy3.receivePsychicAttack((AbstractPsychicPokemon) dummy6);
        dummy4.receivePsychicAttack((AbstractPsychicPokemon) dummy6);
        dummy5.receivePsychicAttack((AbstractPsychicPokemon) dummy6);
        dummy6.receivePsychicAttack((AbstractPsychicPokemon) dummy6);
        assertEquals(35, dummy1.getHP());
        assertEquals(35, dummy2.getHP());
        assertEquals(35, dummy3.getHP());
        assertEquals(0, dummy4.getHP());
        assertEquals(35, dummy5.getHP());
        assertEquals(0, dummy6.getHP());
    }

    @Test
    public void isAliveTest(){
        assertTrue(dummy1.isAlive());
        dummy1.setHP(0);
        assertFalse(dummy1.isAlive());
        dummy1.setHP(2);
        assertTrue(dummy1.isAlive());
        dummy1.setHP(-3);
        assertFalse(dummy1.isAlive());
    }

    @Test
    public void useAbilityTest(){
        dummy2.selectAbility(0);
        assertEquals(100, trainer2.getActivePokemon().getHP());
        dummy2.useAbility(trainer2);
        assertEquals(70, trainer2.getActivePokemon().getHP());
        dummy3.selectAbility(0);
        dummy3.useAbility(trainer2);
        assertEquals(30, trainer2.getActivePokemon().getHP());
        dummy4.selectAbility(0);
        dummy4.useAbility(trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHP());
        dummy5.selectAbility(0);
        dummy5.useAbility(trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHP());
        dummy6.selectAbility(0);
        dummy6.useAbility(trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHP());
        dummy7.selectAbility(0);
        dummy7.useAbility(trainer2);
        assertEquals(0, trainer2.getActivePokemon().getHP());
    }
}
