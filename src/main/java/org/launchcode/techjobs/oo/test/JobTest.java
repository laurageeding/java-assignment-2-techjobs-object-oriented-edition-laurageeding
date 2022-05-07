package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)

public class JobTest {

    private Job job1;
    private Job job2;
    private Job job3;
    private Job job4;
    private Job job5;
    private Job job6;
    private Job job7;

    @Before
    public void createJob() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job5 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job6 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
        job7 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertTrue(job2.getId() > job1.getId());
        assertEquals(1, job2.getId() - job1.getId());
        assertTrue(job1.getId() != job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3 instanceof Job);
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testForBlankLines() {
        assertEquals(job3.toString().startsWith("\n"), true);
        assertEquals(job3.toString().endsWith("\n"), true);
    }

    @Test
    public void testStringShouldContainLabelForEachField() {
        assertEquals("\n" +
                "Id: " +  job4.getId() + "\n" +
                "Name: Web Developer\n" +
                "Employer: LaunchCode\n" +
                "Location: St. Louis\n" +
                "Position Type: Front-end developer\n" +
                "Core Competency: JavaScript\n",
                job4.toString());
    }

    @Test
    public void testEmptyField() {
        assertEquals("\n" +
                "Id: " +  job6.getId() + "\n" +
                "Name: Ice cream tester\n" +
                "Employer: Data not available\n" +
                "Location: Home\n" +
                "Position Type: UX\n" +
                "Core Competency: Tasting ability\n" ,
                job6.toString());
    }

    @Test
    public void testAllFieldsEmptyExceptId() {
        assertEquals("OOPS! This job does not seem to exist", job7.toString());
    }

}
