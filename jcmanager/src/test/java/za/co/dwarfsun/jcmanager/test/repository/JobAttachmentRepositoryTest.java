/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.test.repository;

//import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
//import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.co.dwarfsun.jcmanager.domain.JobAttachment;
import za.co.dwarfsun.jcmanager.repository.JobAttachmentRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobAttachmentRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobAttachmentRepository repo;
    
    public JobAttachmentRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJobAttachment(){
        repo = ctx.getBean(JobAttachmentRepository.class);
        JobAttachment jobAttachment = new JobAttachment.Builder("testfile.txt")
                .build();
        repo.save(jobAttachment);
        id = jobAttachment.getId();
        Assert.assertNotNull(jobAttachment);
    }
    
    @Test(dependsOnMethods = "createJobAttachment", enabled = true)
    public void readJobAttachment(){
        repo = ctx.getBean(JobAttachmentRepository.class);
        JobAttachment jobAttachment = repo.findOne(id);
        Assert.assertEquals(jobAttachment.getFilePath(), "testfile.txt");
    }
    
    @Test(dependsOnMethods = "readJobAttachment", enabled=true)
    public void updateJobAttachment(){
        repo = ctx.getBean(JobAttachmentRepository.class);
        JobAttachment jobAttachment = repo.findOne(id);
        JobAttachment updatedJobAttachment = new JobAttachment.Builder("")
                .JobAttachment(jobAttachment)
                .filePath("testfile.csv")
                .build();
        repo.save(updatedJobAttachment);
        JobAttachment newJobAttachment = repo.findOne(id);
        Assert.assertEquals(newJobAttachment.getFilePath(), "testfile.csv");
    }
    
    @Test(dependsOnMethods = "updateJobAttachment", enabled = true)
    public void deleteJobAttachment(){
        repo = ctx.getBean(JobAttachmentRepository.class);
        JobAttachment jobAttachment = repo.findOne(id);
        repo.delete(jobAttachment);
        JobAttachment deletedJobAttachment = repo.findOne(id);
        Assert.assertNull(deletedJobAttachment);
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
