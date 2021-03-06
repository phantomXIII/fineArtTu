package models;

import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class User extends Model{

	@Id
	public String username;
	@Column(nullable=false)
	public String password;

	public static User authenticate(String username, String password) {
        User user = find.byId(username);
		if(user == null){
            return null;
        }
        else if(!username.equals(user.username) || !password.equals(user.password)){
            return null;
        }
        return user;
	}

	@SuppressWarnings("unchecked")
	public static Finder<String,User> find = new Finder(String.class,User.class);
}
