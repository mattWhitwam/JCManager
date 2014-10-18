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
import za.co.dwarfsun.jcmanager.domain.JobCardAttribute;
import za.co.dwarfsun.jcmanager.repository.JobCardAttributeRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobCardAttributeRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobCardAttributeRepository repo;
    
    public JobCardAttributeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJobCardAttribute(){
        repo = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = new JobCardAttribute.Builder(69)
                .attrib(null)
                .jobCard(null)
                .build();
        repo.save(jobCardAttribute);
        id = jobCardAttribute.getId();
        Assert.assertNotNull(jobCardAttribute);
    }
    
    @Test(dependsOnMethods = "createJobCardAttribute", enabled = true)
    public void readJobCardAttribute(){
        repo = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = repo.findOne(id);
        Assert.assertEquals(jobCardAttribute.getLineNum(), 69);
    }
    
    @Test(dependsOnMethods = "readJobCardAttribute", enabled=true)
    public void updateJobCardAttribute(){
        repo = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = repo.findOne(id);
        JobCardAttribute updatedJobCardAttribute = new JobCardAttribute.Builder(0)
                .jobCardAttribute(jobCardAttribute)
                .lineNum(13)
                .build();
        repo.save(updatedJobCardAttribute);
        JobCardAttribute newJobCardAttribute = repo.findOne(id);
        Assert.assertEquals(newJobCardAttribute.getLineNum(), 13);
    }
    
    @Test(dependsOnMethods = "updateJobCardAttribute", enabled = true)
    public void deleteJobCardAttribute(){
        repo = ctx.getBean(JobCardAttributeRepository.class);
        JobCardAttribute jobCardAttribute = repo.findOne(id);
        repo.delete(jobCardAttribute);
        JobCardAttribute deletedJobCardAttribute = repo.findOne(id);
        Assert.assertNull(deletedJobCardAttribute);
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
