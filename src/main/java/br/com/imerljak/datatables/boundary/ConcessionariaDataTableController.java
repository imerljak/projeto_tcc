package br.com.imerljak.datatables.boundary;

import br.com.imerljak.concessionarias.entity.Concessionaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/datatable")
public class ConcessionariaDataTableController {

    private final ConcessionariaDataTableRepository concessionariaRepository;

    @Autowired
    public ConcessionariaDataTableController(ConcessionariaDataTableRepository concessionariaRepository) {
        this.concessionariaRepository = concessionariaRepository;
    }

    @GetMapping("/concessionarias")
    public DataTablesOutput<Concessionaria> getConcessionarias(@Valid DataTablesInput input) {
        return concessionariaRepository.findAll(input);
    }

}

