package testproject.web.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testproject.model.Skakaonica;
import testproject.service.SkakaonicaService;
import testproject.support.SkakaonicaToSkakaonicaDTO;
import testproject.web.dto.SkakaonicaDTO;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/skakaonice")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiSkakaonicaController {

    private @NonNull SkakaonicaService skakaonicaService;
    private @NonNull SkakaonicaToSkakaonicaDTO skakaonicaToSkakaonicaDTO;

    @GetMapping
    public @ResponseBody
    Iterable<SkakaonicaDTO> getSkakaonice() {

        return skakaonicaService.findAll()
                .stream().sorted(Comparator.comparing(Skakaonica::getNaziv))
                .map(skakaonicaToSkakaonicaDTO::convert)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
