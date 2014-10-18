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
import za.co.dwarfsun.jcmanager.domain.JobCard;
import za.co.dwarfsun.jcmanager.repository.JobCardRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobCardRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobCardRepository repo;
    
    public JobCardRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJobCard(){
        repo = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = new JobCard.Builder("testjobcard")
                .build();
        repo.save(jobCard);
        id = jobCard.getId();
        Assert.assertNotNull(jobCard);
    }
    
    @Test(dependsOnMethods = "createJobCard", enabled = true)
    public void readJobCard(){
        repo = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = repo.findOne(id);
        Assert.assertEquals(jobCard.getName(), "testjobcard");
    }
    
    @Test(dependsOnMethods = "readJobCard", enabled=true)
    public void updateJobCard(){
        repo = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = repo.findOne(id);
        JobCard updatedJobCard = new JobCard.Builder("")
                .jobCard(jobCard)
                .name("anothertestjobcard")
                .build();
        repo.save(updatedJobCard);
        JobCard newJobCard = repo.findOne(id);
        Assert.assertEquals(newJobCard.getName(), "anothertestjobcard");
    }
    
    @Test(dependsOnMethods = "updateJobCard", enabled = true)
    public void deleteJobCard(){
        repo = ctx.getBean(JobCardRepository.class);
        JobCard jobCard = repo.findOne(id);
        repo.delete(jobCard);
        JobCard deletedJobCard = repo.findOne(id);
        Assert.assertNull(deletedJobCard);
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
