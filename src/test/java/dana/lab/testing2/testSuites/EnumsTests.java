package dana.lab.testing2.testSuites;

import dana.lab.testing2.model.enums.DocumentPartTypesTests;
import dana.lab.testing2.model.enums.OutputFileTypesTests;
import dana.lab.testing2.model.enums.OutputTypesTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DocumentPartTypesTests.class,
        OutputFileTypesTests.class,
        OutputTypesTests.class
})
public class EnumsTests {
}
