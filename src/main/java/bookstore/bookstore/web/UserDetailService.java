package bookstore.bookstore.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bookstore.bookstore.domain.AppUser;
import bookstore.bookstore.domain.AppUserRepository;

//täällä on Käyttäjän hallinta. 
//Tämän voi kopioida, tulee olemaan kaikilla samanlainen.
// olisi ollut parempi olla paketissa "service" web sijasta

@Service
public class UserDetailService implements UserDetailsService {

    AppUserRepository repository;

    // Constructor Injection
    public UserDetailService(AppUserRepository appUserRepository) {
        this.repository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }

}
