package testproject.web.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import testproject.model.Takmicar;
import testproject.service.TakmicarService;
import testproject.support.TakmicarDTOtoTakmicar;
import testproject.support.TakmicarToTakmicarDTO;
import testproject.web.dto.TakmicarDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/takmicari")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiTakmicarController {

    private @NonNull TakmicarService takmicarService;
    private @NonNull TakmicarToTakmicarDTO takmicarToTakmicarDTO;
    private @NonNull TakmicarDTOtoTakmicar takmicarDTOtoTakmicar;

    @GetMapping
    public @ResponseBody
    Iterable<TakmicarDTO> getTakmicari(
            @RequestParam(required = false) String imeIprezime,
            @RequestParam(required = false) String drzava,
            @RequestParam(required = false) Integer minGodiste,
            @RequestParam(required = false) Integer maxGodiste,
            @RequestParam(defaultValue = "0") int page) {

        Page<Takmicar> takmicariPaged;
        List<Takmicar> takmicari;

        takmicariPaged = getTakmicars(imeIprezime, drzava, minGodiste, maxGodiste, page);

        takmicari = takmicariPaged.getContent();

        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(takmicariPaged.getTotalPages()));


        return takmicari.stream().sorted(Comparator.comparing(Takmicar::getImeIprezime))
                .map(takmicarToTakmicarDTO::convert)
                .collect(Collectors.toList());
    }

    private Page<Takmicar> getTakmicars(String imeIprezime, String drzava, Integer minGodiste,
                                        Integer maxGodiste, int page) {
        Page<Takmicar> takmicariPaged;
        if (imeIprezime != null || drzava != null || minGodiste != null || maxGodiste != null) {
            takmicariPaged = takmicarService.pretraga(imeIprezime, drzava, minGodiste, maxGodiste, page);
        } else {
            takmicariPaged = takmicarService.findAll(page);
        }
        return takmicariPaged;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    TakmicarDTO getTakmicar(@PathVariable Long id) {

        return takmicarService.findById(id)
                .map(takmicar -> takmicarToTakmicarDTO.convert(takmicar))
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji takmicar sa id:" + id));

    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    TakmicarDTO deleteTakmicar(@PathVariable Long id) {

        return takmicarService.delete(id)
                .map(takmicar -> takmicarToTakmicarDTO.convert(takmicar))
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji takmicar sa id:" + id));
    }

    @PostMapping
    public @ResponseBody
    TakmicarDTO saveTakmicar(@RequestBody @Validated TakmicarDTO takmicarDTO) {

        Takmicar takmicar = takmicarService.save(takmicarDTOtoTakmicar.convert(takmicarDTO));

        return takmicarToTakmicarDTO.convert(takmicar);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<TakmicarDTO> editTakmicar(@RequestBody @Validated TakmicarDTO takmicarDTO, @PathVariable Long id) {

        if(!takmicarDTO.getId().equals(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Takmicar takmicar = takmicarService.save(takmicarDTOtoTakmicar.convert(takmicarDTO));

        return new ResponseEntity<>(takmicarToTakmicarDTO.convert(takmicar), HttpStatus.OK);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
