package tz.co.vodacom.bujikun.kitchenstories.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.entity.Permission;
import tz.co.vodacom.bujikun.kitchenstories.entity.User;
import tz.co.vodacom.bujikun.kitchenstories.repository.FoodRepository;
import tz.co.vodacom.bujikun.kitchenstories.repository.PermissionRepository;
import tz.co.vodacom.bujikun.kitchenstories.repository.UserRepository;
import tz.co.vodacom.bujikun.kitchenstories.util.DateUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration(proxyBeanMethods = false)
public class InitialDataConfig {
    @Bean
    public CommandLineRunner commandLineRunner(FoodRepository foodRepository,
                                               UserRepository userRepository,
                                               PermissionRepository permissionRepository,
                                               DateUtil dateUtil,
                                               PasswordEncoder passwordEncoder
                                               ) {
        return args -> {
            try{
            var f1 = Food.builder()
                    .price(new BigDecimal(20.55d))
                    .name("Spaghetti")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();
            var f2 = Food.builder()
                    .price(new BigDecimal(10d))
                    .name("Burger")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();

            var f3 = Food.builder()
                    .price(new BigDecimal(5.99d))
                    .name("French Fries")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();
            var f4 = Food.builder()
                    .price(new BigDecimal(15.99d))
                    .name("Tacos")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();
            var f5 = Food.builder()
                    .price(new BigDecimal(2.77d))
                    .name("Biscuits")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();
            var f6 = Food.builder()
                    .price(new BigDecimal(7.50d))
                    .name("French Pasta")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();
            var f7 = Food.builder()
                    .price(new BigDecimal(22.55d))
                    .name("Bread")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();
            var f8 = Food.builder()
                    .price(new BigDecimal(24.50d))
                    .name("Smoked Fish")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();
            var f9 = Food.builder()
                    .price(new BigDecimal(19.99d))
                    .name("Pizza")
                    .createdOn(LocalDateTime.now())
                    .imageUrl("")
                    .build();

            var perm1 = Permission.builder()
                    .name("order:view")
                    .createdOn(dateUtil.now())
                    .build();
            var perm2 = Permission.builder()
                    .name("food:delete")
                    .createdOn(dateUtil.now())

                    .build();
                permissionRepository.saveAll(Set.of(perm1,perm2));

            var user = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("password"))
                    .isEnabled(true)
                    .isAccountExpired(false)
                    .isAccountLocked(false)
                    .isCredentialsExpired(false)
                    .createdOn(dateUtil.now())
                    .userPermissions(new HashSet<>())
                    .build();

            user.linkPermission(perm1);
            user.linkPermission(perm2);


                userRepository.save(user);
                foodRepository.saveAll(List.of(f1,f2,f3,f4,f5,f6,f7,f8,f9));
            }catch (Exception e){
                e.printStackTrace();
            }
        };
    }
}
