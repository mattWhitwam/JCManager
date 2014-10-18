/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.test.repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.co.dwarfsun.jcmanager.domain.JobData;
import za.co.dwarfsun.jcmanager.repository.JobDataRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobDataRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobDataRepository repo;
    
    public JobDataRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJobData(){
        repo = ctx.getBean(JobDataRepository.class);
        JobData jobData = new JobData.Builder("Test")
                .attrib(null)
                .build();
        repo.save(jobData);
        id = jobData.getId();
        Assert.assertNotNull(jobData);
    }
    
    @Test(dependsOnMethods = "createJobData", enabled = true)
    public void readJobData(){
        repo = ctx.getBean(JobDataRepository.class);
        JobData jobData = repo.findOne(id);
        Assert.assertEquals(jobData.getValue(), "Test");
    }
    
    @Test(dependsOnMethods = "readJobData", enabled=true)
    public void updateJobData(){
        repo = ctx.getBean(JobDataRepository.class);
        JobData jobData = repo.findOne(id);
        JobData updatedJobData = new JobData.Builder("")
                .jobData(jobData)
                .val("Different Test")
                .build();
        repo.save(updatedJobData);
        JobData newJobData = repo.findOne(id);
        Assert.assertEquals(newJobData.getValue(), "Different Test");
    }
    
    @Test(dependsOnMethods = "updateJobData", enabled = true)
    public void deleteJobData(){
        repo = ctx.getBean(JobDataRepository.class);
        JobData jobData = repo.findOne(id);
        repo.delete(jobData);
        JobData deletedJobData = repo.findOne(id);
        Assert.assertNull(deletedJobData);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
