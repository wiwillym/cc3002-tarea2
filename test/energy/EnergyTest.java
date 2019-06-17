package energy;

import cc3002.tarea2.EnergyCounter;
import cc3002.tarea2.electric.ElectricEnergy;
import cc3002.tarea2.fighting.FightingEnergy;
import cc3002.tarea2.fire.FireEnergy;
import cc3002.tarea2.grass.GrassEnergy;
import cc3002.tarea2.psychic.PsychicEnergy;
import cc3002.tarea2.water.WaterEnergy;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class EnergyTest {

    private ElectricEnergy electricEnergy;
    private FireEnergy fireEnergy;
    private GrassEnergy grassEnergy;
    private PsychicEnergy psychicEnergy;
    private WaterEnergy waterEnergy;
    private FightingEnergy fightingEnergy;

    private EnergyCounter cnttest1 = new EnergyCounter();
    private EnergyCounter cnttest2 = new EnergyCounter();



    @Before
    public void setUp() {
        electricEnergy = new ElectricEnergy("electricenergy", "does smthn1");
        fightingEnergy = new FightingEnergy("fightingenergy", "does smthn2");
        fireEnergy = new FireEnergy("fireenergy", "does smthn3");
        grassEnergy = new GrassEnergy("grassenergy", "does smthn4");
        psychicEnergy = new PsychicEnergy("psychicenergy", "does smthn5");
        waterEnergy = new WaterEnergy("waterenergy", "does smthn6");

    }

    @Test
    public void equalsTest(){
        assertEquals(fireEnergy, new FireEnergy("fireenergy", "does smthn3"));
        assertNotEquals(psychicEnergy, new PsychicEnergy("psychicenergy ", "does smth5"));
        assertNotEquals(waterEnergy, new GrassEnergy("waterenergy", "does smthn6"));
        assertNotEquals(grassEnergy, new GrassEnergy(" grassenergy", "does smthn4"));
        assertEquals(electricEnergy, new ElectricEnergy("electricenergy", "does smthn1"));
        assertEquals(fightingEnergy, new FightingEnergy("fightingenergy","does smthn2"));
    }

    @Test
    public void getDescriptionTest(){
        assertEquals("does smthn1", electricEnergy.getDescription());
        assertNotEquals("does smthn5", waterEnergy.getDescription());
    }

    @Test
    public void greaterThanTest(){
        assertTrue(cnttest1.greaterThan(cnttest2));
        cnttest2.setFightingEnergy(4);
        assertFalse(cnttest1.greaterThan(cnttest2));
    }
}
