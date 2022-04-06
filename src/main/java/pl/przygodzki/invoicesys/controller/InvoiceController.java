package pl.przygodzki.invoicesys.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.przygodzki.invoicesys.model.Invoice;
import pl.przygodzki.invoicesys.model.InvoiceRepository;

import java.net.URI;
import java.util.List;

@Controller
public class InvoiceController {
    private final InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAllInvoices(Model model) {
        List<Invoice> allInvoices = repository.findAll();
        model.addAttribute("allInvoices", allInvoices);
        return "gui";
    }

    @GetMapping("/invoices")
    ResponseEntity<List<Invoice>> getAllInv() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/save")
    public String addInvoice(@ModelAttribute Invoice invoice) {
        repository.save(invoice);
        return "redirect:/";
    }

    @PostMapping("/invoices")
    ResponseEntity<Invoice> addInv(@RequestBody Invoice invoice) {
        Invoice result = repository.save(invoice);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam int id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @DeleteMapping("/invoices/{id}")
    ResponseEntity<Invoice> deleteInv(@PathVariable int id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/invoices/{id}")
    ResponseEntity<Invoice> updateInvoice(@PathVariable int id, @RequestBody Invoice toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(invoice -> {
                    invoice.updateFrom(toUpdate);
                    repository.save(invoice);
                });
        return ResponseEntity.noContent().build();
    }


}
