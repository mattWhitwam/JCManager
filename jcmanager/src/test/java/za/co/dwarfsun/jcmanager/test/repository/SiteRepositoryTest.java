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
import za.co.dwarfsun.jcmanager.domain.Site;
import za.co.dwarfsun.jcmanager.repository.SiteRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class SiteRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private SiteRepository repo;
    
    public SiteRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createSite(){
        repo = ctx.getBean(SiteRepository.class);
        Site site = new Site.Builder("Test")
                .address("257 SIX,\n64 Sir Lowry Rd,\nZonnebloem")
                .build();
        repo.save(site);
        id = site.getId();
        Assert.assertNotNull(site);
    }
    
    @Test(dependsOnMethods = "createSite", enabled = true)
    public void readSite(){
        repo = ctx.getBean(SiteRepository.class);
        Site site = repo.findOne(id);
        Assert.assertEquals(site.getName(), "Test");
    }
    
    @Test(dependsOnMethods = "readSite", enabled=true)
    public void updateSite(){
        repo = ctx.getBean(SiteRepository.class);
        Site site = repo.findOne(id);
        Site updatedSite = new Site.Builder("")
                .site(site)
                .name("Matt")
                .build();
        repo.save(updatedSite);
        Site newSite = repo.findOne(id);
        Assert.assertEquals(newSite.getName(), "Matt");
    }
    
    @Test(dependsOnMethods = "updateSite", enabled = true)
    public void deleteSite(){
        repo = ctx.getBean(SiteRepository.class);
        Site site = repo.findOne(id);
        repo.delete(site);
        Site deletedSite = repo.findOne(id);
        Assert.assertNull(deletedSite);
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
