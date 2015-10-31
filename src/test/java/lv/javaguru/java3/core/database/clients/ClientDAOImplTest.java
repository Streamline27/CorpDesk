package lv.javaguru.java3.core.database.clients;

import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.core.domain.Client;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static lv.javaguru.java3.core.domain.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


public class ClientDAOImplTest extends DatabaseHibernateTest {

    private final boolean SH = false;

    @Test
    @Transactional
    public void testCreateClient() {


        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        assertThat(client.getId(), is(nullValue()));
        clientDAO.create(client);
        assertThat(client.getId(), is(notNullValue()));

        if (SH) {
            useDBManager();
        }


    }

    @Test
    @Transactional
    public void testGetClientById() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        clientDAO.create(client);
        Client clientFromDb = clientDAO.getById(client.getId());
        assertThat(clientFromDb, is(notNullValue()));


    }

    private void useDBManager(){
        try {
            org.hsqldb.util.DatabaseManagerSwing.main(new String[]{
                    "--url", "jdbc:hsqldb:mem:testdb", "--noexit"
                });
                Thread.currentThread().join();
        }catch (Exception e){
            System.out.println("Thread Exception");
        }
    }

}