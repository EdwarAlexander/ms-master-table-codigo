package com.dev.ed.infrastructure.repository;

import com.dev.ed.domain.model.response.ResponseCapturesPage;
import com.dev.ed.infrastructure.entity.CapturesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CapturesRepository extends JpaRepository<CapturesEntity, Long> {

    @Query("SELECT new com.dev.ed.domain.model.response.ResponseCapturesPage(capture.id,capture.dateCapture,CONCAT(customer.name,' ',customer.lastName),seller.name) "
            +"FROM CapturesEntity capture "
            +"INNER JOIN CustomerEntity customer "
            +"ON customer.id = capture.customerEntity.id "
            +"INNER JOIN SellersEntity seller "
            +"ON seller.id = capture.sellersEntity.id "
    )
    Page<ResponseCapturesPage> getCapture(Pageable page);
}
