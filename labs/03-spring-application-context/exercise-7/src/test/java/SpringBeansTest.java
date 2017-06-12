import logic.machine.CoffeeMachine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testApplicationContext.xml")
public class SpringBeansTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("testApplicationContext.xml");

    @Test
    public void test() {
        CoffeeMachine coffeeMachine = (CoffeeMachine) applicationContext.getBean("coffeeMachine");
        CoffeeMachine coffeeMachine2 = (CoffeeMachine) applicationContext.getBean("coffeeMachine");
        assertEquals(coffeeMachine, coffeeMachine2);
        assertNotNull(coffeeMachine.getDispenser());
    }

    @Test
    public void testLactoseFreeCoffeeMachine() {
        CoffeeMachine coffeeMachine = (CoffeeMachine) applicationContext.getBean("coffeeMachine");
        CoffeeMachine lactoseFreeCoffeeMachine = (CoffeeMachine) applicationContext.getBean("lactoseFreeCoffeeMachine");
        CoffeeMachine lactoseFreeCoffeeMachine2 = (CoffeeMachine) applicationContext.getBean("lactoseFreeCoffeeMachine");

        assertNotEquals(coffeeMachine, lactoseFreeCoffeeMachine);
        assertNotNull(coffeeMachine.getDispenser());
        assertNotNull(lactoseFreeCoffeeMachine.getDispenser());
        assertNotEquals(coffeeMachine.getDispenser(), lactoseFreeCoffeeMachine.getDispenser());
        assertEquals(lactoseFreeCoffeeMachine.getDispenser(), lactoseFreeCoffeeMachine2.getDispenser());
        assertEquals(lactoseFreeCoffeeMachine, lactoseFreeCoffeeMachine2);
    }

    @Test
    public void testFutureCoffeeMachines() {
        CoffeeMachine coffeeMachine = (CoffeeMachine) applicationContext.getBean("coffeeMachine");
        CoffeeMachine testCoffeeMachine = (CoffeeMachine) applicationContext.getBean("testCoffeeMachine");
        CoffeeMachine lactoseFreeCoffeeMachine = (CoffeeMachine) applicationContext.getBean("lactoseFreeCoffeeMachine");

        assertNotEquals(testCoffeeMachine, coffeeMachine);
        assertNotEquals(testCoffeeMachine, lactoseFreeCoffeeMachine);
        assertNotNull(testCoffeeMachine.getDispenser());
        assertNotEquals(testCoffeeMachine.getDispenser(), coffeeMachine.getDispenser());
        assertNotEquals(testCoffeeMachine.getDispenser(), lactoseFreeCoffeeMachine.getDispenser());
    }
}
