package card;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.BasicElectricPokemon;
import cc3002.tarea2.electric.ElectricEnergy;
import cc3002.tarea2.electric.AbstractElectricPokemon;
import cc3002.tarea2.fighting.FightingEnergy;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.fire.FireEnergy;
import cc3002.tarea2.fire.AbstractFirePokemon;
import cc3002.tarea2.grass.GrassEnergy;
import cc3002.tarea2.psychic.PsychicEnergy;
import cc3002.tarea2.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class CardTest {

    private ICard
            card1,
            card2,
            card3,
            card4,
            card5,
            card6,
            card7,
            card8,
            card9;
    private AbstractTrainerCard abstractTrainerCard;

    private IPokemon dummy1;

    private EnergyCounter pcostOfEnergies1 = new EnergyCounter();

    private ITrainer trainer1;

    @Before
    public void setUp(){
        card1 = new BasicElectricPokemon("1", 100, 100,null,  new ArrayList<>(), new EnergyCounter());
        card2 = new WaterEnergy("waterenergy", "description");
        card3 = new BasicElectricPokemon("1", 100,100, null,  new ArrayList<>(), new EnergyCounter());
        card4 = new BasicElectricPokemon("2", 90, 90, null,  new ArrayList<>(), new EnergyCounter());
        card5 = new ElectricEnergy("eenergy", "description");
        card6 = new FireEnergy("frenergy", "description");
        card7 = new PsychicEnergy("penergy", "description");
        card8 = new GrassEnergy("genergy", "description");
        card9 = new FightingEnergy("fenergy", "description");

        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), pcostOfEnergies1);

        trainer1 = new Trainer(dummy1, new ArrayList<>(), new ArrayList<>(Arrays.asList(card1)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, null);
    }

    @Test
    public void getCardNameTest(){
        assertEquals("Pokémon 1", card1.getCardName());
        assertEquals("waterenergy", card2.getCardName());
    }

    @Test
    public void playTest(){
        assertEquals(new ArrayList<>(), trainer1.getBenchCards());
        trainer1.setSelectedPokemon(trainer1.getActivePokemon());
        card2.play(trainer1);
        card5.play(trainer1);
        card6.play(trainer1);
        card7.play(trainer1);
        card8.play(trainer1);
        card9.play(trainer1);
        assertEquals(1, trainer1.getActivePokemon().getEnergies().getWaterEnergy());
        assertEquals(1, trainer1.getActivePokemon().getEnergies().getElectricEnergy());
        assertEquals(1, trainer1.getActivePokemon().getEnergies().getGrassEnergy());
        assertEquals(1, trainer1.getActivePokemon().getEnergies().getPsychicEnergy());
        assertEquals(1, trainer1.getActivePokemon().getEnergies().getFightingEnergy());
        assertEquals(1, trainer1.getActivePokemon().getEnergies().getFireEnergy());
    }
}
