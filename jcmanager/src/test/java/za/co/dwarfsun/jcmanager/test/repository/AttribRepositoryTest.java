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
import za.co.dwarfsun.jcmanager.domain.Attrib;
import za.co.dwarfsun.jcmanager.repository.AttribRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class AttribRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AttribRepository repo;
    
    public AttribRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createAttrib(){
        repo = ctx.getBean(AttribRepository.class);
        Attrib attrib = new Attrib.Builder("testAttribute")
                .tblName("TEST")
                .fldName("Test")
                .isakey(Boolean.TRUE)
                .build();
        repo.save(attrib);
        id = attrib.getId();
        Assert.assertNotNull(attrib);
    }
    
    @Test(dependsOnMethods = "createAttrib", enabled = true)
    public void readAttrib(){
        repo = ctx.getBean(AttribRepository.class);
        Attrib attrib = repo.findOne(id);
        Assert.assertEquals(attrib.getDescription(), "testAttribute");
    }
    
    @Test(dependsOnMethods = "readAttrib", enabled=true)
    public void updateAttrib(){
        repo = ctx.getBean(AttribRepository.class);
        Attrib attrib = repo.findOne(id);
        Attrib updatedAttrib = new Attrib.Builder("")
                .attrib(attrib)
                .description("wtf")
                .build();
        repo.save(updatedAttrib);
        Attrib newAttrib = repo.findOne(id);
        Assert.assertEquals(newAttrib.getDescription(), "wtf");
    }
    
    @Test(dependsOnMethods = "updateAttrib", enabled = true)
    public void deleteAttrib(){
        repo = ctx.getBean(AttribRepository.class);
        Attrib attrib = repo.findOne(id);
        repo.delete(attrib);
        Attrib deletedAttrib = repo.findOne(id);
        Assert.assertNull(deletedAttrib);
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
