package dana.lab.testing2.testSuites;

import dana.lab.testing2.model.ScrappedPageTests;
import dana.lab.testing2.model.WebScrapperStateTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EnumsTests.class,
        ScrappedPageTests.class,
        WebScrapperStateTests.class
})
public class ModelTests {
}
