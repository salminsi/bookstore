package bookstore.bookstore;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Tämä luokka sisältää tietoa mihin url-osoitteisiin on pääsy

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

        @Bean
        public BCryptPasswordEncoder passwordEncoder() { // nyt osaa kryptata salasanan tietokantaan
                return new BCryptPasswordEncoder();
        }

        @Bean // url-tasoisten oikeuksien määrittely
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {

                http.authorizeHttpRequests(
                                authorize -> authorize
                                                .requestMatchers("/css/**").permitAll()
                                                .requestMatchers(HttpMethod.GET, "/books**").permitAll() // tähän urliin
                                                                                                         // pääsee
                                                                                                         // kirjautumatta
                                                                                                         // kaikki ja
                                                                                                         // lukuoikeus
                                                                                                         // (myös
                                                                                                         // rest-rajapinta)
                                                                                                         // sallittu
                                                                                                         // kaikille
                                                .requestMatchers(HttpMethod.POST, "/books**").permitAll() // kaikilla
                                                                                                          // post-oikeus
                                                .requestMatchers(HttpMethod.PUT, "/books**").permitAll() // kaikilla
                                                                                                         // put-oikeus
                                                .requestMatchers(HttpMethod.DELETE, "/books**").hasAuthority("admin") // vain
                                                                                                                      // admin
                                                                                                                      // pystyy
                                                                                                                      // deletoimaan.
                                                                                                                      // Pitää
                                                                                                                      // olla
                                                                                                                      // Authority,
                                                                                                                      // ei
                                                                                                                      // Role.
                                                .requestMatchers("/h2-console/**").permitAll() // for h2console,
                                                                                               // vaihdettu suora url
                                                                                               // niin toimii
                                                .anyRequest().authenticated()) // kaikki muut rekvestit pitää
                                                                               // autentikoida
                                // Käyttää HTTP Basic -autentikointia oletusasetuksilla (Postman)
                                .httpBasic(Customizer.withDefaults()) // tämän avulla voi tehdä Postmanin kautta
                                                                      // kirjautumisen, jotta
                                                                      // voi testata restien toiminnan
                                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions
                                                .disable())) // for h2console
                                .formLogin(formlogin -> formlogin // login-sivulle kaikilla oikeudet
                                                .defaultSuccessUrl("/booklist", true) // mihin mennään onnistuneen
                                                                                      // loggauksen jälkeen
                                                .permitAll())
                                .logout(logout -> logout.permitAll()) // logout-sivulle kaikilla oikeudet
                                .csrf(csrf -> csrf.disable()); // for h2console. liittyy restiin
                // not for production, just for development

                return http.build();
        }

        /*
         * private UserDetailsService userDetailsService; // type of attribute ->
         * interface
         * 
         * // Constructor injection
         * public WebSecurityConfig(UserDetailsService userDetailsService) {
         * this.userDetailsService = userDetailsService;
         */
        /*
         * @Autowired // tutkii seuraavaksi salasana (ilman tätä kryptaus ei toiminut
         * tai en ainakaan
         * // onnistunut kirjautumaan)
         * public void configureGlobal(AuthenticationManagerBuilder auth) throws
         * Exception {
         * auth.userDetailsService(userDetailsService).passwordEncoder(new
         * BCryptPasswordEncoder());
         * }
         */

}
