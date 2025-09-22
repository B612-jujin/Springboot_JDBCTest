package kr.ac.kopo.cjj.springboot_jdbctest.controller;

import kr.ac.kopo.cjj.springboot_jdbctest.domain.Detail;
import kr.ac.kopo.cjj.springboot_jdbctest.domain.Product;
import kr.ac.kopo.cjj.springboot_jdbctest.repository.DetailRepository;
import kr.ac.kopo.cjj.springboot_jdbctest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06")
public class Example06Controller {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DetailRepository detailRepository;

    @GetMapping
    private String requestInsert(Model model) {
        Product product = new Product();
        product.setName("Iphone 17");
        product.setPrice(1200000);

        Detail detail = new Detail();
        detail.setDescription("아이폰 117 2205 신형");
        detail.setWeight(200f);
        detail.setWidth(75f);
        detail.setHeight(150f);

        detail.setProduct(product);
        detailRepository.save(detail);

        product.setDetail(detail);
        productRepository.save(product);

        Iterable<Product> productList = productRepository.findAll();
        Iterable<Detail> detailList = detailRepository.findAll();

        model.addAttribute("detailList", detailList);
        model.addAttribute("productList", productList);
        return "viewPage06";
    }

}
