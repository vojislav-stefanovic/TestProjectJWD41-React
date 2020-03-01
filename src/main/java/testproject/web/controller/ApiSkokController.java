package testproject.web.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testproject.model.Skok;
import testproject.service.SkokService;
import testproject.support.SkokToSkokDTO;
import testproject.web.dto.SkokDTO;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skokovi")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiSkokController {

    private @NonNull SkokService skokService;
    private @NonNull SkokToSkokDTO skokToSkokDTO;

    @GetMapping
    public @ResponseBody Iterable<SkokDTO> getSkokovi() {

        return skokService.findAll().stream().sorted(Comparator.comparing(Skok::getDaljina))
                .map(skokToSkokDTO::convert)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}")
    public ResponseEntity<SkokDTO> skok(
            @PathVariable Long id,
            @RequestParam(value="sudija1") Double sudija1,
            @RequestParam(value="sudija2") Double sudija2,
            @RequestParam(value="sudija3") Double sudija3,
            @RequestParam(value="sudija4") Double sudija4,
            @RequestParam(value="sudija5") Double sudija5,
            @RequestParam(value="daljina") Double daljina) {

        Skok skok = skokService.skok(id, sudija1, sudija2, sudija3, sudija4, sudija5, daljina);

        if (skok == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(skokToSkokDTO.convert(skok), HttpStatus.OK);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
