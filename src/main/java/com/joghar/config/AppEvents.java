package com.joghar.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.joghar.model.Role;
import com.joghar.payload.RolePayload;
import com.joghar.repository.RoleRepository;

@Configuration
public class AppEvents {
	@Autowired
	RoleRepository roleRepository;
	
	@EventListener(ApplicationReadyEvent.class)
    public void onReadyApplicationEvent() {

		Optional<Role> roleUser = roleRepository.findByName(RolePayload.ROLE_USER);
		if(!roleUser.isPresent()) {
			Role roleUserObj = new Role();
			roleUserObj.setName(RolePayload.ROLE_USER);
			roleRepository.save(roleUserObj);
		}
		
		Optional<Role> roleModerator = roleRepository.findByName(RolePayload.ROLE_MODERATOR);
		if(!roleModerator.isPresent()) {
			Role roleModeratorObj = new Role();
			roleModeratorObj.setName(RolePayload.ROLE_MODERATOR);
			roleRepository.save(roleModeratorObj);
		}
		
		Optional<Role> roleAdmin = roleRepository.findByName(RolePayload.ROLE_ADMIN);
		if(!roleAdmin.isPresent()) {
			Role roleAdminObj = new Role();
			roleAdminObj.setName(RolePayload.ROLE_ADMIN);
			roleRepository.save(roleAdminObj);
		}
		
		
		
	}
}
