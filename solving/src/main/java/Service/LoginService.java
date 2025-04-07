package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Login;
import io.nats.bridge.admin.LoginRepo;

@Service
public class LoginService 
{

    @Autowired
    private LoginRepo rep;

    public Login log(String username, String password) 
    {
        return ((Object) rep).findByUsernameAndPassword(username, password);
    }
}
