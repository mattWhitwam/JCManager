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
import za.co.dwarfsun.jcmanager.domain.JobInfo;
import za.co.dwarfsun.jcmanager.repository.JobInfoRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JobInfoRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JobInfoRepository repo;
    
    public JobInfoRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJobInfo(){
        repo = ctx.getBean(JobInfoRepository.class);
        JobInfo jobInfo = new JobInfo.Builder("Test Information")
                .complete(Boolean.FALSE)
                .status("Unallocated")
                .build();
        repo.save(jobInfo);
        id = jobInfo.getId();
        Assert.assertNotNull(jobInfo);
    }
    
    @Test(dependsOnMethods = "createJobInfo", enabled = true)
    public void readJobInfo(){
        repo = ctx.getBean(JobInfoRepository.class);
        JobInfo jobInfo = repo.findOne(id);
        Assert.assertEquals(jobInfo.isComplete(), Boolean.FALSE);
    }
    
    @Test(dependsOnMethods = "readJobInfo", enabled=true)
    public void updateJobInfo(){
        repo = ctx.getBean(JobInfoRepository.class);
        JobInfo jobInfo = repo.findOne(id);
        JobInfo updatedJobInfo = new JobInfo.Builder("")
                .jobInfo(jobInfo)
                .complete(Boolean.TRUE)
                .status("Cancelled by client")
                .build();
        repo.save(updatedJobInfo);
        JobInfo newJobInfo = repo.findOne(id);
        Assert.assertEquals(newJobInfo.isComplete(), Boolean.TRUE);
    }
    
    @Test(dependsOnMethods = "updateJobInfo", enabled = true)
    public void deleteJobInfo(){
        repo = ctx.getBean(JobInfoRepository.class);
        JobInfo jobInfo = repo.findOne(id);
        repo.delete(jobInfo);
        JobInfo deletedJobInfo = repo.findOne(id);
        Assert.assertNull(deletedJobInfo);
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
