package ua.mkorniie.util;

import ua.mkorniie.DAO.UserDAO;

public class DeleteUserCommand {

    public void execute(String id) {
        try {
            Integer num = Integer.parseInt(id);
            new UserDAO().delete(num);
        } catch (NumberFormatException e) {
        }
    }
}