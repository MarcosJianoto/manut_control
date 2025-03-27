package services;

import java.util.List;

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

	public void createUser(UserEntityDTO userEntityDTO) {

		if (userEntityRepository.existsByEmail(userEntityDTO.getEmail())) {
			throw new IllegalArgumentException("E-mail já está em uso!");
		}

		UsersEntity userEntity = new UsersEntity(userEntityDTO.getEmail(), userEntityDTO.getPassword());
		userEntityRepository.save(userEntity);
	}

	public UsersEntity findUser(Integer id) {
		return userEntityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found "));
	}

	public void editUser(Integer id, UserEntityDTO userDTO) {
		UsersEntity user = findUser(id);
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

		userEntityRepository.save(user);

	}

	public UserEntityDTO getUser(Integer id) {
		UsersEntity user = findUser(id);
		return new UserEntityDTO(user.getId(), user.getEmail(), user.getPassword());
	}

	public List<UserEntityDTO> getAllUsers() {
		return userEntityRepository.findAll().stream()
				.map(user -> new UserEntityDTO(user.getId(), user.getEmail(), user.getPassword())).toList();
	}

	public void deleteUser(Integer id) {
		try {
			if (!userEntityRepository.existsById(id)) {
				throw new IllegalArgumentException("User not found");
			}
			userEntityRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Error deleting user" + e.getMessage());
		}
	}

}
