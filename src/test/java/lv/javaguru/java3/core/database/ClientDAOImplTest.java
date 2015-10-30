package lv.javaguru.java3.core.database;

import lv.javaguru.java3.core.database.client.ClientDAO;
import lv.javaguru.java3.core.domain.client.Client;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static lv.javaguru.java3.core.domain.client.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ClientDAOImplTest extends DatabaseHibernateTest {

    @Autowired
    protected ClientDAO clientDAO;

    @Test
    public void testCreateClient() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        assertThat(client.getId(), is(nullValue()));
        clientDAO.create(client);
        assertThat(client.getId(), is(notNullValue()));
    }

    @Test
    public void testGetClientById() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        clientDAO.create(client);
        Client clientFromDb = clientDAO.getById(client.getId());
        assertThat(clientFromDb, is(notNullValue()));
    }

}