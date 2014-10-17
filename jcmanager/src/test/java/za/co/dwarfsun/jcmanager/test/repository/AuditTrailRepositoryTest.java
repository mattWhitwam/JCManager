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
import za.co.dwarfsun.jcmanager.domain.AuditTrail;
import za.co.dwarfsun.jcmanager.repository.AuditTrailRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;
import java.util.Date;
/**
 *
 * @author Matthew
 */
public class AuditTrailRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AuditTrailRepository repo;
    
    public AuditTrailRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createAuditTrail(){
        repo = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = new AuditTrail.Builder(new Date())
                .tableName("TEST")
                .field("Test")
                .oldValue(null)
                .newValue("test data")
                .type("VARCHAR")
                .build();
        repo.save(auditTrail);
        id = auditTrail.getId();
        Assert.assertNotNull(auditTrail);
    }
    
    @Test(dependsOnMethods = "createAuditTrail", enabled = true)
    public void readAuditTrail(){
        repo = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = repo.findOne(id);
        Assert.assertEquals(auditTrail.getField(), "Test");
    }
    
    @Test(dependsOnMethods = "readAuditTrail", enabled=true)
    public void updateAuditTrail(){
        repo = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = repo.findOne(id);
        AuditTrail updatedAuditTrail = new AuditTrail.Builder(auditTrail.getTod())
                .AuditTrail(auditTrail)
                .oldValue("test data")
                .newValue("other test data")
                .build();
        repo.save(updatedAuditTrail);
        AuditTrail newAuditTrail = repo.findOne(id);
        Assert.assertEquals(newAuditTrail.getNewValue(), "other test data");
    }
    
    @Test(dependsOnMethods = "updateAuditTrail", enabled = true)
    public void deleteAuditTrail(){
        repo = ctx.getBean(AuditTrailRepository.class);
        AuditTrail auditTrail = repo.findOne(id);
        repo.delete(auditTrail);
        AuditTrail deletedAuditTrail = repo.findOne(id);
        Assert.assertNull(deletedAuditTrail);
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
