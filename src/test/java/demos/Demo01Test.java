package demos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import swapi.PeopleTest;
import swapi.PlanetTest;
import swapi.StarshipTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlanetTest.class,
        StarshipTest.class,
        PeopleTest.class
})
public class Demo01Test { }
