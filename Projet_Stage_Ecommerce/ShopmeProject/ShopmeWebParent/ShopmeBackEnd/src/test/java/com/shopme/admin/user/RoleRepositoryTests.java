package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	@Autowired
	 private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin" , "manage everythings");
		Role savedRole =repo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);	

}
	@Test
	public void testCreateRestRoles() {
		Role rolesalesperson = new Role("salesperson" , "manage producr price,"
	+"customers,shipping,oerders and sales report");
		
		Role roleeditor= new Role("Editor" , "manage categories,brans"
				+"products,articles and menu");
		
		Role roleShipper = new Role("shipper","viexs products,views orders"+
		"and update order status");
		
		Role roleAssistant = new Role("Assistant","manage questions and reviews");
		repo.saveAll(List.of(rolesalesperson,roleeditor,roleShipper,roleAssistant));
		
		
	}
}