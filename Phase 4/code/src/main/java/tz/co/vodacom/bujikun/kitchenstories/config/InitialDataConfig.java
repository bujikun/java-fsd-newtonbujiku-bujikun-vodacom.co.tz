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
            foodRepository.deleteAll();
            try {
                var f1 = Food.builder()
                        .price(new BigDecimal(20.55d))
                        .name("Spaghetti")
                        .createdOn(LocalDateTime.now())
                        .imageUrl("https://www.inspiredtaste.net/wp-content/uploads/2019/03/" +
                                "Spaghetti-with-Meat-Sauce-Recipe-1-1200.jpg")
                        .build();
                var f2 = Food.builder()
                        .price(new BigDecimal(10d))
                        .name("Burger")
                        .createdOn(LocalDateTime.now())
                        .imageUrl("https://www.allrecipes.com/thmb/5JVfA7MxfTUPfRerQMdF-nGKsLY=/1500x0/filters:" +
                                "no_upscale():max_bytes(150000):strip_icc()/25473-the-perfect-basic-" +
                                "burger-DDMFS-4x3-56eaba3833fd4a26a82755bcd0be0c54.jpg")
                        .build();

                var f3 = Food.builder()
                        .price(new BigDecimal(5.99d))
                        .name("French Fries")
                        .createdOn(LocalDateTime.now())
                        .imageUrl("https://www.seriouseats.com/thmb/Il7mv9ZSDh7n0cZz3t3V-28ImkQ=/1500x0/filters:no_upscale()" +
                                ":max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration_" +
                                "_serious_eats__seriouseats.com__2018__04__20180309-french-fries-vicky-wasik-" +
                                "15-5a9844742c2446c7a7be9fbd41b6e27d.jpg")
                        .build();
                var f4 = Food.builder()
                        .price(new BigDecimal(15.99d))
                        .name("Tacos")
                        .createdOn(LocalDateTime.now())
                        .imageUrl("https://static.onecms.io/wp-content/uploads/sites/43/2023/01/30/70935-taqueria-style-" +
                                "tacos-mfs-3x2-35.jpg")
                        .build();
                var f5 = Food.builder()
                        .price(new BigDecimal(2.77d))
                        .name("Biscuits")
                        .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Biscuits_in_Ghana.jpg/220px" +
                                "-Biscuits_in_Ghana.jpg")
                        .createdOn(LocalDateTime.now())
                        .build();

                var f6 = Food.builder()
                        .price(new BigDecimal(7.50d))
                        .name("French Pasta")
                        .imageUrl("https://www.sidechef.com/recipe/81372375-5170-4e31-884d-b5f7070fb924.jpg?d=1408x1120")
                        .createdOn(LocalDateTime.now())

                        .build();
                var f7 = Food.builder()
                        .price(new BigDecimal(22.55d))
                        .name("Bread")
                        .createdOn(LocalDateTime.now())
                        .imageUrl("https://www.allrecipes.com/thmb/CjzJwg2pACUzGODdxJL1BJDRx9Y=/1500x0/filters:no_upscale()" +
                                ":max_bytes(150000):strip_icc()/6788-amish-white-bread-DDMFS-4x3-6faa1e552bdb4f" +
                                "6eabdd7791e59b3c84.jpg")
                        .build();

                var f8 = Food.builder()
                        .price(new BigDecimal(24.50d))
                        .name("Smoked Fish")
                        .createdOn(LocalDateTime.now())
                        .imageUrl("https://www.charbroil.com/media/ctm//E/a/Easy_Smoked_Fish.jpg.jpeg")
                        .build();
                var f9 = Food.builder()
                        .price(new BigDecimal(19.99d))
                        .name("Pizza")
                        .createdOn(LocalDateTime.now())
                        .imageUrl("https://www.allrecipes.com/thmb/0xH8n2D4cC97t7mcC7eT2SDZ0aE=/1500x0/filters:no_upscale()" +
                                ":max_bytes(150000):strip_icc()/6776_Pizza-Dough_ddmfs_2x1_" +
                                "1725-fdaa76496da045b3bdaadcec6d4c5398.jpg")
                        .build();
                foodRepository.saveAll(List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9));

                var perm8 = Permission.builder()
                        .name("customer:read:all")
                        .createdOn(dateUtil.now())
                        .build();
                var perm6 = Permission.builder()
                        .name("food:create:one")
                        .createdOn(dateUtil.now())
                        .build();

                var perm5 = Permission.builder()
                        .name("food:read:one")
                        .createdOn(dateUtil.now())
                        .build();

                var perm7 = Permission.builder()
                        .name("food:delete:one")
                        .createdOn(dateUtil.now())
                        .build();

                var perm4 = Permission.builder()
                        .name("order:read:all")
                        .createdOn(dateUtil.now())
                        .build();

                var perm3 = Permission.builder()
                        .name("user:change-password")
                        .createdOn(dateUtil.now())
                        .build();

                permissionRepository.saveAll(Set.of(perm3,perm4,perm5,perm6,perm7,perm8));

                var admin = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("password"))
                        .isEnabled(true)
                        .isAccountExpired(false)
                        .isAccountLocked(false)
                        .isCredentialsExpired(false)
                        .createdOn(dateUtil.now())
                        .userPermissions(new HashSet<>())
                        .build();

                admin.linkPermissions(Set.of(perm3,perm4,perm5,perm6,perm7,perm8));

                var manager = User.builder()
                        .username("manager")
                        .password(passwordEncoder.encode("password"))
                        .isEnabled(true)
                        .isAccountExpired(false)
                        .isAccountLocked(false)
                        .isCredentialsExpired(false)
                        .createdOn(dateUtil.now())
                        .userPermissions(new HashSet<>())
                        .build();
                manager.linkPermissions(Set.of(perm3,perm4));
                userRepository.save(admin);
                userRepository.save(manager);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
