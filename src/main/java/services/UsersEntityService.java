package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutcontrol.dto.UserEntityDTO;
import com.manutcontrol.entities.UsersEntity;
import com.manutcontrol.repository.UserEntityRepository;

@Service
public class UsersEntityService {

	@Autowired
	private UserEntityRepository userEntityRepository;

	public UsersEntityService(UserEntityRepository userEntityRepository) {
		this.userEntityRepository = userEntityRepository;
	}

	public void saveUserEntityF() {

		UsersEntity usersEntity = new UsersEntity();

		UserEntityDTO userEntityDTO = new UserEntityDTO();
	

	}

}
