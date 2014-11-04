/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.test.repository;

//import junit.framework.Assert;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
//import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.co.dwarfsun.jcmanager.domain.Client;
import za.co.dwarfsun.jcmanager.domain.Site;
import za.co.dwarfsun.jcmanager.repository.ClientRepository;
import za.co.dwarfsun.jcmanager.test.ConnectionConfigTest;

/**
 *
 * @author Matthew
 */
public class ClientRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ClientRepository repo;
    
    public ClientRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled=true)
    public void createClient(){
        repo = ctx.getBean(ClientRepository.class);
        Client client = new Client.Builder("testClient")
                .contactPerson(null)
                .site(null)
                .build();
        repo.save(client);
        id = client.getId();
        Assert.assertNotNull(client);
    }
    
    @Test(dependsOnMethods = "createClient", enabled = true)
    public void readClient(){
        repo = ctx.getBean(ClientRepository.class);
        Client client = repo.findOne(id);
        Assert.assertEquals(client.getName(), "testClient");
    }
    
    @Test(dependsOnMethods = "readClient", enabled=true)
    public void updateClient(){
        repo = ctx.getBean(ClientRepository.class);
        Client client = repo.findOne(id);
        Client updatedClient = new Client.Builder("")
                .client(client)
                .name("testclient")
                .build();
        repo.save(updatedClient);
        Client newClient = repo.findOne(id);
        Assert.assertEquals(newClient.getName(), "testclient");
    }
    
    @Test(dependsOnMethods = "updateClient", enabled = true)
    public void deleteClient(){
        repo = ctx.getBean(ClientRepository.class);
        Client client = repo.findOne(id);
        repo.delete(client);
        Client deletedClient = repo.findOne(id);
        Assert.assertNull(deletedClient);
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
