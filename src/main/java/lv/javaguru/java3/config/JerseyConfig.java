package lv.javaguru.java3.config;

import lv.javaguru.java3.rest.HealthController;
import lv.javaguru.java3.rest.clients.ClientResourceImpl;
import lv.javaguru.java3.rest.gallery.GalleryResourceImpl;
import lv.javaguru.java3.rest.mail.FolderResourceImpl;
import lv.javaguru.java3.rest.mail.MailResourceImpl;
import lv.javaguru.java3.rest.comment.CommentResourceImpl;
import lv.javaguru.java3.rest.post.PostResourceImpl;
import lv.javaguru.java3.rest.user.GroupResourceImpl;
import lv.javaguru.java3.rest.user.UserResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CORSRequestFilter.class);
        register(CORSResponseFilter.class);

        register(HealthController.class);
        register(ClientResourceImpl.class);
        register(UserResourceImpl.class);
        register(GroupResourceImpl.class);
        register(MailResourceImpl.class);
        register(FolderResourceImpl.class);
        register(PostResourceImpl.class);
        register(CommentResourceImpl.class);
        register(GalleryResourceImpl.class);
    }

}