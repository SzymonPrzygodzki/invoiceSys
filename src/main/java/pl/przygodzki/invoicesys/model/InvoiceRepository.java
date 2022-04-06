package pl.przygodzki.invoicesys.model;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {
    List<Invoice> findAll();

    Optional<Invoice> findById(Integer id);

    Invoice save(Invoice inv);

    boolean existsById(Integer id);

    void deleteById(Integer id);

}
