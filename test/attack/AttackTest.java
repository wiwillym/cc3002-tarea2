package attack;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.ElectricAttack;
import cc3002.tarea2.fighting.FightingAttack;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.fire.FireAttack;
import cc3002.tarea2.grass.GrassAttack;
import cc3002.tarea2.psychic.PsychicAttack;
import cc3002.tarea2.water.WaterAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AttackTest {
    private IAttack
            electricAttack,
            fightingAttack,
            fireAttack,
            grassAttack,
            psychicAttack,
            waterAttack,
            waterAttack2;
    private IBasicPokemon dummy1, dummy2;
    private ITrainer trainer1, trainer2;
    private List<IPokemon> benchList;
    private List<ICard> handList;
    private List<ICard> deckList;
    private List<ICard> discardPile;
    private List<ICard> rewardCards;

    private EnergyCounter costOfEnergies1 = new EnergyCounter();
    private EnergyCounter costOfEnergies2 = new EnergyCounter();
    private EnergyCounter costOfEnergies3 = new EnergyCounter();
    private EnergyCounter costOfEnergies4 = new EnergyCounter();
    private EnergyCounter costOfEnergies5 = new EnergyCounter();
    private EnergyCounter costOfEnergies6 = new EnergyCounter();
    private EnergyCounter costOfEnergies7 = new EnergyCounter();
    private EnergyCounter costOfEnergiesTest1 = new EnergyCounter();
    private EnergyCounter costOfEnergiesTest2 = new EnergyCounter();

    @Before
    public void setUp(){
        costOfEnergies1.setPsychicEnergy(2);
        costOfEnergies2.setFireEnergy(1);
        costOfEnergies3.setElectricEnergy(1);
        costOfEnergies4.setWaterEnergy(1);
        costOfEnergies5.setFireEnergy(1);
        costOfEnergies6.setGrassEnergy(5);
        costOfEnergies7.setGrassEnergy(5);
        electricAttack = new ElectricAttack("Thundershock", 4, "Does something1", costOfEnergies1);
        fightingAttack = new FightingAttack("Combo", 420, "Does something2", costOfEnergies2);
        fireAttack = new FireAttack("Fuego", 40, "Does something3", costOfEnergies3);
        grassAttack = new GrassAttack("Supasto", 1000, "Does something4", costOfEnergies4);
        psychicAttack = new PsychicAttack("Filosofar", 0, "Does something5", costOfEnergies5);
        waterAttack = new WaterAttack("Aguita", 30, "Does something6", costOfEnergies6);
        waterAttack2 = new WaterAttack("Aguita", 69, "Does something7", costOfEnergies7);

        dummy1 = new BasicFirePokemon("1", 100, 100, fireAttack, new ArrayList<>(Arrays.asList(fireAttack)), costOfEnergies3);
        dummy2 = new BasicFirePokemon("1", 100, 100, fireAttack, new ArrayList<>(Arrays.asList(fireAttack)), costOfEnergies3);

        benchList = new ArrayList<>();
        handList = new ArrayList<>();
        deckList = new ArrayList<>();
        discardPile = new ArrayList<>();
        rewardCards = new ArrayList<>();
        trainer1 = new Trainer(dummy1, benchList, handList, deckList, discardPile, rewardCards, null, null);
        trainer2 = new Trainer(dummy2, benchList, handList, deckList, discardPile, rewardCards, null, null);
    }

    @Test
    public void constructorTest(){
        assertEquals("Thundershock", electricAttack.getName());
        assertEquals(40, fireAttack.getBaseDamage());
        assertEquals("Does something7", waterAttack2.getDescription());
    }

    @Test
    public void getNameTest(){
        assertEquals("Combo", fightingAttack.getName());
        assertNotEquals("Fuego", psychicAttack.getName());
        assertEquals("Fuego", fireAttack.getName());
    }

    @Test
    public void getBaseDamageTest(){
        assertEquals(420, fightingAttack.getBaseDamage());
        assertNotEquals(1001, grassAttack.getBaseDamage());
    }

    @Test
    public void getDescriptionTest(){
        assertEquals("Does something6", waterAttack.getDescription());
        assertNotEquals("Does something2", psychicAttack.getDescription());
    }

    @Test
    public void playTest(){
        trainer1.setOpponent(trainer2);
        dummy1.selectAbility(0);
        assertEquals(100, trainer2.getActivePokemon().getHP());
        fireAttack.play(trainer1);
        assertEquals(60, trainer2.getActivePokemon().getHP());

    }

    @Test
    public void equalsTest(){
        assertEquals(new FireAttack("Fuego", 40,"Does something3", costOfEnergies3), fireAttack);
    }
}
