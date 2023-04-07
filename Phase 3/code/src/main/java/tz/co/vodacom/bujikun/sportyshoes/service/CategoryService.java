package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.dto.CategoryDTO;
import tz.co.vodacom.bujikun.sportyshoes.entity.Category;
import tz.co.vodacom.bujikun.sportyshoes.exception.CategoryNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.CategoryRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService implements GenericService<Category,Integer> {
    private final CategoryRepository categoryRepository;
    @Override
    public void createNew(Category category) {
        category.setDeleted(false);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        var category = findById(id);
        category.setDeleted(true);
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {

        var categoryFromDB = findActiveById(category.getId());
        categoryFromDB.setUpdatedOn(LocalDateTime.now());
        categoryFromDB.setDeleted(category.getDeleted());
        categoryFromDB.setName(category.getName());
        categoryFromDB.setDescription(category.getDescription());
        categoryRepository.save(categoryFromDB);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("CategoryNotFound"));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "createdOn","deleted"));
    }

    public List<Category> findAllActive(){
        return categoryRepository.findAllActive();
    }
    public List<Category> findAllActiveAndWithStockedProducts(){
        var  activeCat = categoryRepository.findAllActive();
        //filter  linked out of stock products
       var filtered=  activeCat.stream()
                .filter(c->c.getProducts().size()>0)
                .toList();
       return filtered;
    }


    public Category findActiveById(Integer id){
        return categoryRepository.findActiveById(id)
                .orElseThrow(()-> new CategoryNotFoundException("CategoryNotFound"));
    }
}
