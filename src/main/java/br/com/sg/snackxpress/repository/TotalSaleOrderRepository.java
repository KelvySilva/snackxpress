package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.order.SaleOrder;
import br.com.sg.snackxpress.domain.order.TotalSaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TotalSaleOrderRepository extends JpaRepository<SaleOrder, Long> {

    @Query(value = "select new br.com.sg.snackxpress.domain.order.TotalSaleOrder(p.id, p.name, count(so.client.id), sum(so.total)) from Person p inner join SaleOrder so on p.id = so.client.id group by p.name,p.id order by sum(so.total) DESC ")
    List<TotalSaleOrder> findTotalByClient();
}
