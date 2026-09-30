package com.example.libraryManagement.services;

import com.example.libraryManagement.models.UserPrincipal;
import com.example.libraryManagement.models.employee;
import com.example.libraryManagement.models.students;
import com.example.libraryManagement.repository.employeeRepo;
import com.example.libraryManagement.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
   private employeeRepo repoEmployee;
    @Autowired
    private studentRepo repoStud;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        employee empl = repoEmployee.findByName(username);
        students stud = repoStud.findByName(username);
        if(empl != null){
            return new UserPrincipal(empl.getName(),empl.getPassword(),"EMPLOYEE");
        } else if (stud != null) {
            return new UserPrincipal(stud.getName(),stud.getPassword(),"STUDENT");
        }else {
            throw new UsernameNotFoundException("User not found with such username" + username);
        }
    }
}
