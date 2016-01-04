package lv.javaguru.java3.core.rest;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.rest.clients.ClientResource;
import lv.javaguru.java3.rest.post.PostResource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(randomPort = true)
@SpringApplicationConfiguration(classes = {AppCoreConfig.class})
public class RESTResourceTest {

    @Value("${local.server.port}")
    private int port;

    protected ClientResource clientResource;
    protected PostResource postResource;


    @Before
    public void init() {
        String url = "http://localhost:" + port;

        clientResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(ClientResource.class, url);

        postResource = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new JAXRSContract())
                .target(PostResource.class, url);
    }

}