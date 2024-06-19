package asif.rest.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import asif.rest.api.data.User;

@Service
public class UserDaoService {

	public static List<User> list = new ArrayList<>();
	private static int usercount = 0;
	static {
		list.add(new User(++usercount,"asif",LocalDate.now()));
		list.add(new User(++usercount,"ayesha",LocalDate.now().minusYears(2)));
	}
	
	public List<User> getAllUsers(){
		return list;
	}
	
	public User getUserById(int id ) {
		for(User user : list) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(++usercount);
		list.add(user);
	}
	
	public void deleteUser(int id) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId()==id)
				list.remove(i);
		}
	}
}
