package ua.mkorniie.util;

import ua.mkorniie.DAO.UserDAO;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;

public class ToUserCommand {

    public void execute(String id) {
        Integer num = null;
        try {
            num = Integer.parseInt(id);
        } catch (NumberFormatException e) {
        }
        if (num != null) {
            UserDAO dao = new UserDAO();
            User user = dao.selectById(num);
            if (user != null && user.getRole() != Roles.USER) {
                user.setRole(Roles.USER);
                dao.update(user);
            }
        }
    }
}
