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
import za.co.dwarfsun.jcmanager.domain.JcUser;
import za.co.dwarfsun.jcmanager.repository.JcUserRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JcUserRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JcUserRepository repo;
    
    public JcUserRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJcUser(){
        repo = ctx.getBean(JcUserRepository.class);
        JcUser jcUser = new JcUser.Builder("testuser")
                .password("P@ssword")
                .build();
        repo.save(jcUser);
        id = jcUser.getId();
        Assert.assertNotNull(jcUser);
    }
    
    @Test(dependsOnMethods = "createJcUser", enabled = true)
    public void readJcUser(){
        repo = ctx.getBean(JcUserRepository.class);
        JcUser jcUser = repo.findOne(id);
        Assert.assertEquals(jcUser.getUserName(), "testuser");
    }
    
    @Test(dependsOnMethods = "readJcUser", enabled=true)
    public void updateJcUser(){
        repo = ctx.getBean(JcUserRepository.class);
        JcUser jcUser = repo.findOne(id);
        JcUser updatedJcUser = new JcUser.Builder("testuser")
                .jcUser(jcUser)
                .password("12345")
                .build();
        repo.save(updatedJcUser);
        JcUser newJcUser = repo.findOne(id);
        Assert.assertEquals(newJcUser.getPassword(), "12345");
    }
    
    @Test(dependsOnMethods = "updateJcUser", enabled = true)
    public void deleteJcUser(){
        repo = ctx.getBean(JcUserRepository.class);
        JcUser jcUser = repo.findOne(id);
        repo.delete(jcUser);
        JcUser deletedJcUser = repo.findOne(id);
        Assert.assertNull(deletedJcUser);
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
