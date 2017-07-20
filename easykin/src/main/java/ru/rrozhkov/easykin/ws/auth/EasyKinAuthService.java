package ru.rrozhkov.easykin.ws.auth;

import ru.rrozhkov.easykin.auth.AuthManager;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by rrozhkov on 2/28/2017.
 */
@WebService(serviceName="EasyKinAuth", portName="EasyKinAuthPort", targetNamespace="http://rrozhkov.ru/easykin/auth")
public class EasyKinAuthService {

    @WebMethod
    public int auth(String user, String pass) {
        AuthManager authManager = AuthManager.instance();
        authManager.signIn(user, pass);
        if(authManager.isSignedIn())
            return 1;
        return -1;
    }

}
