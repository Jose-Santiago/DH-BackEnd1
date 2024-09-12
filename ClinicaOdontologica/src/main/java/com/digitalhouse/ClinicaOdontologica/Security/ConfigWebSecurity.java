package com.digitalhouse.ClinicaOdontologica.Security;

import com.digitalhouse.ClinicaOdontologica.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ConfigWebSecurity{
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    //Provedor de auntenticacion DAO
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }
    //ahora necesitamos otorgan las autorizaciones
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                        //permitimos el acceso a la pagina principal index.html
                        .requestMatchers( "/").permitAll()
                        //permitimos que el user ADMIN pueda consumir todos los endpoints
                        .requestMatchers("/paciente/**", "/odontologo/**", "/turno/**").hasAuthority("ROLE_ADMIN")
                        //Permitimos que el Usuario USER solo pueda trabajar con los turnos
                        .requestMatchers("/turno/**").hasAuthority("ROLE_USER")
                        //Cualquier otro Endpoint requiere autenticacion.
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .logout(withDefaults());
        return http.build();
    }

}
