package dana.lab.testing2;

import dana.lab.testing2.testSuites.ModelTests;
import dana.lab.testing2.testSuites.ServicesTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ModelTests.class,
        ServicesTests.class
})
public class TestExecutor {
}
