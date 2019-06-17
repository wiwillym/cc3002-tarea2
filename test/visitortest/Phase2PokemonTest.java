package visitortest;

import cc3002.tarea2.*;
import cc3002.tarea2.electric.BasicElectricPokemon;
import cc3002.tarea2.electric.Phase1ElectricPokemon;
import cc3002.tarea2.electric.Phase2ElectricPokemon;
import cc3002.tarea2.fighting.BasicFightingPokemon;
import cc3002.tarea2.fighting.Phase1FightingPokemon;
import cc3002.tarea2.fighting.Phase2FightingPokemon;
import cc3002.tarea2.fire.BasicFirePokemon;
import cc3002.tarea2.fire.Phase1FirePokemon;
import cc3002.tarea2.fire.Phase2FirePokemon;
import cc3002.tarea2.grass.BasicGrassPokemon;
import cc3002.tarea2.grass.Phase1GrassPokemon;
import cc3002.tarea2.grass.Phase2GrassPokemon;
import cc3002.tarea2.psychic.BasicPsychicPokemon;
import cc3002.tarea2.psychic.Phase1PsychicPokemon;
import cc3002.tarea2.psychic.Phase2PsychicPokemon;
import cc3002.tarea2.water.BasicWaterPokemon;
import cc3002.tarea2.water.Phase1WaterPokemon;
import cc3002.tarea2.water.Phase2WaterPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Phase2PokemonTest {

    private IPhase1Pokemon
            dummy1,
            dummy2,
            dummy3,
            dummy4,
            dummy5,
            dummy6;
    private IPhase2Pokemon
            dummy7,
            dummy8,
            dummy9,
            dummy10,
            dummy11,
            dummy12;

    private ITrainer trainer1, trainer2;
    private EnergyCounter pcostOfEnergies = new EnergyCounter();
    private Visitor visitor;

    @Before
    public void setUp(){
        dummy1 = new Phase1FirePokemon("1", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy2 = new Phase1ElectricPokemon("2", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy3 = new Phase1WaterPokemon("3", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy4 = new Phase1PsychicPokemon("4", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy5 = new Phase1FightingPokemon("5", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy6 = new Phase1GrassPokemon("6", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy7 = new Phase2FirePokemon("1", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy8 = new Phase2ElectricPokemon("2", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy9 = new Phase2WaterPokemon("3", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy10 = new Phase2PsychicPokemon("4", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy11 = new Phase2FightingPokemon("5", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        dummy12 = new Phase2GrassPokemon("6", 100, 100, null, new ArrayList<>(), pcostOfEnergies);
        trainer1 = new Trainer((IPokemon) dummy2, new ArrayList<>(Arrays.asList((IPokemon)dummy1, (IPokemon)dummy3, (IPokemon)dummy4, (IPokemon)dummy5, (IPokemon)dummy6)), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, null);
        trainer2 = new Trainer((IPokemon)dummy3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), null, null);
        visitor = new VisitorPlayCard(trainer1);
    }

    @Test
    public void VisitPhase2PokemonTest(){
        assertEquals(dummy2, trainer1.getActivePokemon());
        trainer1.addCardToHand((ICard)dummy7);
        trainer1.addCardToHand((ICard)dummy8);
        trainer1.addCardToHand((ICard)dummy9);
        trainer1.addCardToHand((ICard)dummy10);
        trainer1.addCardToHand((ICard)dummy11);
        trainer1.addCardToHand((ICard)dummy12);
        trainer1.setSelectedPokemon((IPokemon)dummy2);
        visitor.visitPhase2Pokemon(dummy8);
        assertEquals(dummy8, trainer1.getActivePokemon());
        trainer1.setSelectedPokemon((IPokemon) dummy1);
        visitor.visitPhase2Pokemon(dummy7);
        trainer1.setSelectedPokemon((IPokemon) dummy3);
        visitor.visitPhase2Pokemon(dummy9);
        trainer1.setSelectedPokemon((IPokemon)dummy4);
        visitor.visitPhase2Pokemon(dummy10);
        trainer1.setSelectedPokemon((IPokemon)dummy5);
        visitor.visitPhase2Pokemon(dummy11);
        trainer1.setSelectedPokemon((IPokemon)dummy6);
        visitor.visitPhase2Pokemon(dummy12);
        assertEquals(new ArrayList<>(Arrays.asList(dummy7, dummy9, dummy10, dummy11, dummy12)), trainer1.getBenchCards());
    }
}
