package lv.javaguru.java3.config;

import lv.javaguru.java3.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class CORSRequestFilter implements ContainerRequestFilter {

    @Context
    HttpServletRequest request;

    @Autowired
    UserService userService;

    @Override
    public void filter(ContainerRequestContext requestCtx) throws IOException {

        // When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
        if (requestCtx.getRequest().getMethod().equals("OPTIONS")) {
            // Just send a OK signal back to the browser
            requestCtx.abortWith(Response.status(Response.Status.OK).build());
        } else {
            //try to authenticate
            try {
                String requestUriPath = requestCtx.getUriInfo().getRequestUri().getPath();
                if (requestUriPath.contains("authorize")){
                    requestCtx.abortWith(Response.status(Response.Status.OK).build());
                    return;
                }
                String username = "";
                String password = "";

                String authorization = request.getHeader("authorization");

                if (null != authorization && authorization.length() > "Basic ".length()) {
                    String usernamePassword = new String(javax.xml.bind.DatatypeConverter.parseBase64Binary(authorization.substring("Basic ".length())));
                    if (usernamePassword.indexOf(":") != -1) {
                        username = usernamePassword.substring(0, usernamePassword.indexOf(":"));
                        if (usernamePassword.indexOf(":") + 1 < usernamePassword.length()) {
                            password = usernamePassword.substring(usernamePassword.indexOf(":") + 1);
                        }
                    }
                }

                if (username==""){
                    requestCtx.abortWith(Response.status(Response.Status.FORBIDDEN).build());
                    return;
                }

                try {
                    userService.authorize(username,password);
                } catch (Exception ex) {
                    requestCtx.abortWith(Response.status(Response.Status.FORBIDDEN).build());
                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
                try {
                    request.logout();
                } catch (ServletException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}