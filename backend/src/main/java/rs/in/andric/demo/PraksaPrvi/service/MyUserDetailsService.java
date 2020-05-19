package rs.in.andric.demo.PraksaPrvi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.in.andric.demo.PraksaPrvi.model.MyUserDetails;
import rs.in.andric.demo.PraksaPrvi.model.User;
import rs.in.andric.demo.PraksaPrvi.repository.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user =  userRepository.findByUsername(username);
       user.orElseThrow(() -> new UsernameNotFoundException("Not found: " +username));
       return user.map(MyUserDetails::new).get();
    }
}
