package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.security.entities.Usuario;
import com.security.enums.PerfilEnum;
import com.security.repositories.UsuarioRepository;
import com.security.utils.PasswordUtils;

@SpringBootApplication
public class AuthJwtApplication {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthJwtApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner comandLineRunner() {
		return args -> {
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(PasswordUtils.gerarBCrypt("12345"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(PasswordUtils.gerarBCrypt("12345"));
			this.usuarioRepository.save(admin);
		};
	}
}
