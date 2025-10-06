package bookstore.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Tämä luokka sisältää tietoa mihin url-osoitteisiin on pääsy

@Configuration
@EnableMethodSecurity(securedEnabled = true) //mahdollistaa metoditasoisia security-asetuksia
public class WebSecurityConfig {

    private UserDetailsService userDetailsService; // type of attribute -> interface

    // Constructor injection
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/books**").permitAll() // tähän pääsee kirjautumatta kaikki
                        // .requestMatchers(toH2Console()).permitAll() // for h2console, pääsee kaikki
                        .requestMatchers("/h2-console/").permitAll() // vaihdettu suora url niin toimii
                        .anyRequest().authenticated()) // kaikki muut rekvestit pitää autentikoida
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions
                        .disable())) // for h2console
                .formLogin(formlogin -> formlogin // login-sivulle kaikilla oikeudet
                        .defaultSuccessUrl("/booklist", true) // mihin mennään onnistuneen loggauksen jälkeen
                        .permitAll())
                .logout(logout -> logout.permitAll()) // logout-sivulle kaikilla oikeudet
                .csrf(csrf -> csrf.disable()); // for h2console. liittyy restiin
        // not for production, just
        // for development

        return http.build();

    }

    @Autowired // tutkii seuraavaksi salasana (ilman tätä kryptaus ei toiminut tai en ainakaan
               // onnistunut kirjautumaan)
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
