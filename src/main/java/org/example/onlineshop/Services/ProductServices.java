package org.example.onlineshop.Services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.onlineshop.Services.impl.ProductInterface;
import org.example.onlineshop.dto.Product.ProductDtoFilter;
import org.example.onlineshop.dto.Product.ProductDtoResponse;
import org.example.onlineshop.entity.Product;
import org.example.onlineshop.repository.ProductRepository;
import org.example.onlineshop.repository.criteria.ProductRepositoryCriteria;
import org.example.onlineshop.util.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServices implements ProductInterface {
    private final ProductRepository productRepository;
    private final EntityManager entityManager;

    @Autowired
    public ProductServices(ProductRepository productRepository, ProductRepositoryCriteria criteria, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager; // Tránh sử dụng `criteria.entityManager` nếu có thể bị null
    }

    @Override
    public ProductDtoResponse GetProductByID(int id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            return null;
        }
        return ProductMapper.ToResponse(product);
    }

    @Override
    public List<ProductDtoResponse> Filter(ProductDtoFilter filter) {
        StringBuilder stringBuilder = new StringBuilder("SELECT p FROM Product p WHERE 1=1");

        if (filter.getCategoryId() != null) {
            stringBuilder.append(" AND p.category.id = :categoryId");
        }

        if (filter.getPriceFrom() != null && filter.getPriceTo() != null) {
            stringBuilder.append(" AND p.price BETWEEN :priceFrom AND :priceTo");
        }

        System.out.println(stringBuilder.toString());
        String countQueryStr = stringBuilder.toString().replace("SELECT p", "SELECT COUNT(p.id)");
        Query countQuery =  entityManager.createQuery(countQueryStr);

        TypedQuery<Product> productTypedQuery = entityManager.createQuery(stringBuilder.toString(), Product.class);

        if (filter.getCategoryId() != null) {
            productTypedQuery.setParameter("categoryId", filter.getCategoryId());
            countQuery.setParameter("categoryId", filter.getCategoryId());

        }

        if (filter.getPriceFrom() != null && filter.getPriceTo() != null) {
            productTypedQuery.setParameter("priceFrom", filter.getPriceFrom());
            productTypedQuery.setParameter("priceTo", filter.getPriceTo());
            countQuery.setParameter("priceFrom", filter.getPriceFrom());
            countQuery.setParameter("priceTo", filter.getPriceTo());
        }
Long count = (Long) countQuery.getSingleResult();
     Integer index =filter.getPageIndex();
     Integer size = filter.getPageSize();
     long totalPage = count/size;
     if (count%size!= 0){
totalPage++;

     }

        List<Product> products = productTypedQuery.getResultList();
        return products.stream().map(ProductMapper::ToResponse).collect(Collectors.toList());
    }
}
