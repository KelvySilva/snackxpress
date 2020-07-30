package br.com.sg.snackxpress.repository;


import br.com.sg.snackxpress.domain.payment.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
