package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.order.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleOrderRepository  extends JpaRepository<SaleOrder, Long> {

    @Modifying
    @Query("update SaleOrder so set so.status = :status where so.id = :id")
    SaleOrder setStatusForSaleOrder(@Param("id") Long id,@Param("status") SaleOrder.STATUS status);
}
