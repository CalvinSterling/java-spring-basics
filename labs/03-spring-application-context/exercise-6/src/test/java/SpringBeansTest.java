import logic.machine.CoffeeMachine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SpringBeansTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test() {
        // Try changing this back to applicationContext.getBean(CoffeeMachine.class); after you made the other test pass and see what happens.
        // Explain to your neighbor why that happens.
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
        assertEquals(coffeeMachine.getDispenser(), lactoseFreeCoffeeMachine.getDispenser());
        assertEquals(lactoseFreeCoffeeMachine.getDispenser(), lactoseFreeCoffeeMachine2.getDispenser());
        assertEquals(lactoseFreeCoffeeMachine, lactoseFreeCoffeeMachine2);
    }
}
