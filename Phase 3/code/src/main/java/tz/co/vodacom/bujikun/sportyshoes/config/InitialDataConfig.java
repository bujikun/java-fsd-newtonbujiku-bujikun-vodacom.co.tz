package tz.co.vodacom.bujikun.sportyshoes.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tz.co.vodacom.bujikun.sportyshoes.entity.Category;
import tz.co.vodacom.bujikun.sportyshoes.entity.Product;
import tz.co.vodacom.bujikun.sportyshoes.repository.CategoryRepository;
import tz.co.vodacom.bujikun.sportyshoes.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Configuration
public class InitialDataConfig {



    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository) {
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
