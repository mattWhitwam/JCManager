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
import za.co.dwarfsun.jcmanager.domain.JcRole;
import za.co.dwarfsun.jcmanager.repository.JcRoleRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class JcRoleRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private JcRoleRepository repo;
    
    public JcRoleRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createJcRole(){
        repo = ctx.getBean(JcRoleRepository.class);
        JcRole jcRole = new JcRole.Builder("testrole")
                .build();
        repo.save(jcRole);
        id = jcRole.getId();
        Assert.assertNotNull(jcRole);
    }
    
    @Test(dependsOnMethods = "createJcRole", enabled = true)
    public void readJcRole(){
        repo = ctx.getBean(JcRoleRepository.class);
        JcRole jcRole = repo.findOne(id);
        Assert.assertEquals(jcRole.getDescription(), "testrole");
    }
    
    @Test(dependsOnMethods = "readJcRole", enabled=true)
    public void updateJcRole(){
        repo = ctx.getBean(JcRoleRepository.class);
        JcRole jcRole = repo.findOne(id);
        JcRole updatedJcRole = new JcRole.Builder("")
                .jcRole(jcRole)
                .description("anothertestrole")
                .build();
        repo.save(updatedJcRole);
        JcRole newJcRole = repo.findOne(id);
        Assert.assertEquals(newJcRole.getDescription(), "anothertestrole");
    }
    
    @Test(dependsOnMethods = "updateJcRole", enabled = true)
    public void deleteJcRole(){
        repo = ctx.getBean(JcRoleRepository.class);
        JcRole jcRole = repo.findOne(id);
        repo.delete(jcRole);
        JcRole deletedJcRole = repo.findOne(id);
        Assert.assertNull(deletedJcRole);
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
