import logic.machine.CoffeeMachine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SpringBeansTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CoffeeMachine coffeeMachine = applicationContext.getBean(CoffeeMachine.class);
        CoffeeMachine coffeeMachine2 = (CoffeeMachine) applicationContext.getBean("coffeeMachine");

        assertEquals(coffeeMachine, coffeeMachine2);
        assertNotNull(coffeeMachine.getDispenser());
    }
}
