package springguide.securing.webapps.usersecurity;

public interface IUserInfoDAO {
    UserInfo getActiveUser(String userName);
} 