package eu.accesa.springboottraining.security;

import eu.accesa.springboottraining.db.InternRepository;
import eu.accesa.springboottraining.entity.Intern;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private InternRepository internRepository;

    public UserPrincipalDetailsService(InternRepository internRepository) {
        this.internRepository = internRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Intern intern = this.internRepository.findByName(s);
        UserPrincipal userPrincipal = new UserPrincipal(intern);

        return userPrincipal;
    }

}
