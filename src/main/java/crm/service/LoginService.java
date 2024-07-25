package crm.service;

import crm.model.User;
import crm.repository.UserRepository;

import java.util.List;

public class LoginService {
    private UserRepository userRepository = new UserRepository();
    public boolean checkLogin(String username, String password) {
        List<User> list = userRepository.getUserByUserNameAndPassword(username, password);
        if (list.size() > 0) {
            return true;
        }else {
            return false;
        }
    }
}
