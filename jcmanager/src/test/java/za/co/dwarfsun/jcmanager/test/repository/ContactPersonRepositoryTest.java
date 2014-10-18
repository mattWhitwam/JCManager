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
import za.co.dwarfsun.jcmanager.domain.ContactPerson;
import za.co.dwarfsun.jcmanager.repository.ContactPersonRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class ContactPersonRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ContactPersonRepository repo;
    
    public ContactPersonRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createContactPerson(){
        repo = ctx.getBean(ContactPersonRepository.class);
        ContactPerson contactPerson = new ContactPerson.Builder("testContact")
                .build();
        repo.save(contactPerson);
        id = contactPerson.getId();
        Assert.assertNotNull(contactPerson);
    }
    
    @Test(dependsOnMethods = "createContactPerson", enabled = true)
    public void readContactPerson(){
        repo = ctx.getBean(ContactPersonRepository.class);
        ContactPerson contactPerson = repo.findOne(id);
        Assert.assertEquals(contactPerson.getDescription(), "testContact");
    }
    
    @Test(dependsOnMethods = "readContactPerson", enabled=true)
    public void updateContactPerson(){
        repo = ctx.getBean(ContactPersonRepository.class);
        ContactPerson contactPerson = repo.findOne(id);
        ContactPerson updatedContactPerson = new ContactPerson.Builder("")
                .contactPerson(contactPerson)
                .description("contactTest")
                .build();
        repo.save(updatedContactPerson);
        ContactPerson newContactPerson = repo.findOne(id);
        Assert.assertEquals(newContactPerson.getDescription(), "contactTest");
    }
    
    @Test(dependsOnMethods = "updateContactPerson", enabled = true)
    public void deleteContactPerson(){
        repo = ctx.getBean(ContactPersonRepository.class);
        ContactPerson contactPerson = repo.findOne(id);
        repo.delete(contactPerson);
        ContactPerson deletedContactPerson = repo.findOne(id);
        Assert.assertNull(deletedContactPerson);
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
