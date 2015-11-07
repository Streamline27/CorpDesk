package lv.javaguru.java3.core.services.client;

import lv.javaguru.java3.core.domain.client.Client;

public interface ClientFactory {

    Client create(String login, String password);

}
