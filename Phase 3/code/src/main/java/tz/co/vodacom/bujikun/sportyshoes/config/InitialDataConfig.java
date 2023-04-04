package tz.co.vodacom.bujikun.sportyshoes.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import tz.co.vodacom.bujikun.sportyshoes.entity.*;
import tz.co.vodacom.bujikun.sportyshoes.repository.*;
import tz.co.vodacom.bujikun.sportyshoes.util.Util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class InitialDataConfig {

    @Bean
    public CommandLineRunner securityDataRunner(PermissionRepository permissionRepository,
                                               RoleRepository roleRepository,
                                               UserRepository userRepository,
                                               PasswordEncoder passwordEncoder){
        return args -> {
            var userPermissions = new String[]{
                    "user:view","user:edit",
                    "category:view",
                    "product:view",
                    "order:view","order:create",
                    "cart:view"
            };

            var adminPermissions = new String[]{
                    "user:delete","user:view:all",
                    "category:edit","category:delete","category:link:product","category:view:all",
                    "product:edit","product:delete","product:link:category",
                    "stock:view"
            };

            var userPermissionSet = Arrays.stream(userPermissions)
                    .map(pName -> Permission.builder()
                            .name(pName)
                            .build())
                    .collect(Collectors.toSet());
            var adminPermissionSet = Arrays.stream(adminPermissions)
                    .map(pName -> Permission.builder()
                            .name(pName)
                            .build())
                    .collect(Collectors.toSet());
            permissionRepository.saveAll(userPermissionSet);
            permissionRepository.saveAll(adminPermissionSet);

            var userRole = Role.builder().name("USER").permissions(userPermissionSet).build();
            var adminRole = Role.builder().name("ADMIN").permissions(adminPermissionSet).build();

            roleRepository.saveAll(Set.of(userRole,adminRole));

            var user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("password"))
                    .roles(Set.of(userRole))
                    .build();
            var admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("password"))
                    .roles(Set.of(userRole,adminRole))
                    .build();
            userRepository.saveAll(Set.of(user,admin));
        };
    }

    @Bean
    public CommandLineRunner businessDataRunner(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return args -> {
            var cat1 = Category.builder()
                    .name("Athletic")
                    .description("Running shoes")
                    .deleted(false)
                    .build();
            var cat2 = Category.builder()
                    .name("Boxing")
                    .description("Boxing shoes")
                    .deleted(false)

                    .build();
            var cat3 = Category.builder()
                    .name("Cycling")
                    .description("Cycling shoes")
                    .deleted(false)

                    .build();
            var cat4 = Category.builder()
                    .name("Casual")
                    .description("Just casual sportswear")
                    .deleted(false)

                    .build();
            var cat5 = Category.builder()
                    .name("All Sports")
                    .description("For a wide range of sports")
                    .deleted(false)

                    .build();

            categoryRepository.saveAll(List.of(cat1, cat2, cat3, cat4, cat5));

            var prod1 = Product.builder()
                    .name("Nike Air Max")
                    .price(new BigDecimal(123.99))
                    .description("Nike Air 2020 Model")
                    .imageUrl("/imgs/nike-air.png")
                    .categories(Set.of(cat3, cat4, cat5))
                    .count(20)
                    .build();

            var prod2 = Product.builder()
                    .name("Specialized S-Works")
                    .price(new BigDecimal(150.55))
                    .description("For Road Cycling 2023")
                    .imageUrl("/imgs/s-works.jpg")
                    .categories(Set.of(cat1, cat5))
                    .count(5)
                    .build();
            var prod3 = Product.builder()
                    .name("Nike Air Max")
                    .price(new BigDecimal(123.99))
                    .description("Nike Air 2020 Model")
                    .imageUrl("/imgs/nike-air.png")
                    .categories(Set.of(cat3, cat4, cat5))
                    .count(0)
                    .build();

            var prod4 = Product.builder()
                    .name("Specialized S-Works")
                    .price(new BigDecimal(150.55))
                    .description("For Road Cycling 2023")
                    .imageUrl("/imgs/s-works.jpg")
                    .categories(Set.of(cat1, cat5))
                    .count(13)
                    .build();
            var prod5 = Product.builder()
                    .name("Nike Air Max")
                    .price(new BigDecimal(123.99))
                    .description("Nike Air 2020 Model")
                    .imageUrl("/imgs/nike-air.png")
                    .categories(Set.of(cat3, cat4, cat5))
                    .count(8)
                    .build();

            var prod6 = Product.builder()
                    .name("Specialized S-Works")
                    .price(new BigDecimal(150.55))
                    .description("Specialized S-Works For Road Cycling 2023")
                    .imageUrl("/imgs/s-works.jpg")
                    .categories(Set.of(cat1, cat5))
                    .count(17)
                    .build();
            productRepository.save(prod1);
            productRepository.save(prod2);
            productRepository.save(prod3);
            productRepository.save(prod4);
            productRepository.save(prod5);
            productRepository.save(prod6);


        };
    }
}
