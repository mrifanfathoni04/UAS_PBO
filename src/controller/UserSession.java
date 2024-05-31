package controller;

public class UserSession {

    private String userRole;
    private String userNama;

    private static UserSession instance;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setUserNama(String userNama) {
        this.userNama = userNama;
    }

    public String getUserName() {
        return userNama;
    }

    public String getUserRole() {
        return userRole;
    }

    public void clearSession() {
        userRole = null;
        userNama = null;
    }

    public boolean isUserLoggedIn() {
        return userRole != null;
    }

}
