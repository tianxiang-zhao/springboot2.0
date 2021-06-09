package com.tianxinag.springboot7.Service;


import com.tianxinag.springboot7.domain.Authority;
import com.tianxinag.springboot7.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname UserDetailsServiceImpl
 * @Description 自定义一个UserDetailsService接口实现类进行用户认证信息封装
 * @Date 2019-3-5 16:08
 * @Created by CrazyStone
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomer(s);
        List<Authority> customerAuthority = customerService.getCustomerAuthority(s);//获取用户的权限集合

        List<SimpleGrantedAuthority> list = customerAuthority.stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());

        User user = new User(customer.getUsername(), customer.getPassword(), list);

        return user;
    }
}

