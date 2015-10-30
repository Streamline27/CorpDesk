package lv.javaguru.java3.core.services;

import lv.javaguru.java3.core.domain.client.Client;


public interface ClientService {

    Client update(Long clientId,
                  String newLogin,
                  String newPassword);

    Client get(Long clientId);

}
