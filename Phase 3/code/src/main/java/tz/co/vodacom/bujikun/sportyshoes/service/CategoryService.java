package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.dto.CategoryDTO;
import tz.co.vodacom.bujikun.sportyshoes.entity.Category;
import tz.co.vodacom.bujikun.sportyshoes.exception.CategoryNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.CategoryRepository;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService implements GenericService<Category,Integer> {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    @Override
    public void createNew(Category category) {
        category.setDeleted(1);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        var category = findById(id);
        category.setDeleted(1);
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("CategoryNotFound"));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findAllActive(){
        return categoryRepository.findAllActive();
    }

    public Category findActiveById(Integer id){
        return categoryRepository.findActiveById(id)
                .orElseThrow(()-> new CategoryNotFoundException("CategoryNotFound"));
    }
}
