package br.com.sg.snackxpress.service;

import br.com.sg.snackxpress.domain.payment.PaymentMethod;
import br.com.sg.snackxpress.error.ResourceNotFoundException;
import br.com.sg.snackxpress.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class PaymentMethodService {

    private PaymentMethodRepository repository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public List<PaymentMethod> listAll() {
        List<PaymentMethod> all = this.repository.findAll();
        if (all.isEmpty()){
            throw new ResourceNotFoundException("Nenhuma forma de pagamento cadastrada");
        }
        return all;
    }

    public PaymentMethod findOne(Long id) {
        return this.repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Forma de Pagamento com ID: %s não encontrada", id))
                );
    }

    @Transactional
    public PaymentMethod saveOne(PaymentMethod method) {
        return this.repository.save(method);
    }

    @Transactional
    public PaymentMethod updateOne(Long id, PaymentMethod method) {
        PaymentMethod paymentMethod = this.repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Forma de Pagamento com ID: %s não encontrada", id))
        );
        if (Objects.nonNull(method.getId()) && !(method.getName().equals(paymentMethod.getName()))) {
            paymentMethod.setName(method.getName());
        }
        return this.repository.saveAndFlush(paymentMethod);
    }
}
