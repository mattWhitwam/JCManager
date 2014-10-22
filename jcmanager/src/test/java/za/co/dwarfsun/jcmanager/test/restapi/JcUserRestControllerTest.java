/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.test.restapi;

import java.net.URI;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
//import org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.co.dwarfsun.jcmanager.domain.JcUser;

/**
 *
 * @author Matthew
 */
public class JcUserRestControllerTest {
    private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8084/jcmanager/";
    
    public JcUserRestControllerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test (enabled = true)
    public void testDemo() {
        String s = new String();
        HttpEntity<String> requestEntity = new HttpEntity<>(s, getContentType());
        System.out.println();
        /*ResponseEntity<String> responseEntity = restTemplate.exchange(URL + "demo",
                HttpMethod.GET,
                requestEntity,
                String.class);
        
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        */
    }
    /*
    @Test
    public void testCreate(){
        JcUser jcUser = new JcUser.Builder("matt")
                .build();
        HttpEntity<JcUser> requestEntity = new HttpEntity<>(jcUser, getContentType());
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/user/demo", HttpMethod.POST, requestEntity, String.class);
        
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        
    }/*
    private HttpEntity<?> getHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }/**/
    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.TEXT_PLAIN);
        return requestHeaders;
    }/**/

    @BeforeClass
    public static void setUpClass() throws Exception {
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
