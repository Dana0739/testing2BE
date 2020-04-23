package dana.lab.testing2.testSuites;

import dana.lab.testing2.services.MainControllerMockedTest;
import dana.lab.testing2.services.WebScrappingServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainControllerMockedTest.class,
        WebScrappingServiceTest.class
})
public class ServicesTests {
}
