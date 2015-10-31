package lv.javaguru.java3.core.database.client;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.client.Client;
import org.springframework.stereotype.Component;

@Component
class ClientDAOImpl extends CRUDOperationDAOImpl<Client, Long> implements ClientDAO {

}
