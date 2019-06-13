package ua.mkorniie.util;

import ua.mkorniie.DAO.UserDAO;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;

public class ToAdminCommand {

    public void execute(String id) {
        Integer num = null;
        try {
            num = Integer.parseInt(id);
        } catch (NumberFormatException e) {
        }
        if (num != null) {
            UserDAO dao = new UserDAO();
            User user = dao.selectById(num);
            if (user != null && user.getRole() != Roles.ADMIN) {
                user.setRole(Roles.ADMIN);
                dao.update(user);
            }
        }
    }
}
