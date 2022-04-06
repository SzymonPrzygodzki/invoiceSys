package pl.przygodzki.invoicesys.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.przygodzki.invoicesys.model.Invoice;
import pl.przygodzki.invoicesys.model.InvoiceRepository;

public interface SqlInvoiceRepository extends InvoiceRepository, JpaRepository<Invoice, Integer> {

}