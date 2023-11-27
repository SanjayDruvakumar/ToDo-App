package services;

import Dto.UserDto;
import Helper.AES;
import Dao.DataDao;

public class UserService {
	public boolean saveUser(UserDto dto) {
		if (dto.getAge() < 18) {
			return false;
		} else {
			DataDao dao = new DataDao();
			UserDto dto2 = dao.fingByEmail(dto.getEmail());
			if (dto2 != null) {
				return false;
			} else {
				dto.setPass(AES.encrypt(dto.getPass(), "123"));
				dao.saveUser(dto);
				return true;
			}
		}
	}
	
	public boolean login(String email,String Password) {
		DataDao dao = new DataDao();
		UserDto dto1 = dao.fingByEmail(email);
		if(dto1==null) {
			return false;
		}else {
			
			if (Password.equals(AES.decrypt(dto1.getPass(), "123"))) {
				return true;
			}else {
				return false;
			}
	}
}
}
