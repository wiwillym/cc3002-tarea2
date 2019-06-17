package visitortest;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.BasicElectricPokemon;
import cc3002.tarea2.fighting.BasicFightingPokemon;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.grass.BasicGrassPokemon;
import cc3002.tarea2.psychic.BasicPsychicPokemon;
import cc3002.tarea2.water.BasicWaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class BasicPokemonTest {
    private IBasicPokemon
            dummy1,
            dummy2,
            dummy3,
            dummy4,
            dummy5,
            dummy6;
    private ITrainer trainer1;
    private EnergyCounter pcostOfEnergies = new EnergyCounter();
    private Visitor visitor;

    @Before
    public void setUp(){
        dummy1 = new BasicFirePokemon("1", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy2 = new BasicElectricPokemon("2", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy3 = new BasicWaterPokemon("3", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy4 = new BasicPsychicPokemon("4", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy5 = new BasicFightingPokemon("5", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy6 = new BasicGrassPokemon("6", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        trainer1 = new Trainer(dummy2, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, null);
        visitor = new VisitorPlayCard(trainer1);
    }

    @Test
    public void VisitBasicPokemonTest(){
        trainer1.addCardToHand(dummy1);
        trainer1.addCardToHand(dummy2);
        trainer1.addCardToHand(dummy3);
        trainer1.addCardToHand(dummy4);
        trainer1.addCardToHand(dummy5);
        trainer1.addCardToHand(dummy6);
        assertEquals(new ArrayList<>(), trainer1.getBenchCards());
        visitor.visitBasicPokemon(dummy1);
        assertEquals(new ArrayList<>(Arrays.asList(dummy1)), trainer1.getBenchCards());
        visitor.visitBasicPokemon(dummy2);
        visitor.visitBasicPokemon(dummy3);
        visitor.visitBasicPokemon(dummy4);
        visitor.visitBasicPokemon(dummy5);
        visitor.visitBasicPokemon(dummy6);
        assertEquals(new ArrayList<>(Arrays.asList(dummy1, dummy2, dummy3, dummy4, dummy5)), trainer1.getBenchCards());
    }
}
