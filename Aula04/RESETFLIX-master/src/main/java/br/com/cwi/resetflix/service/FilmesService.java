package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private DiretoresRepository diretoresRepository;

    @Autowired
    private FilmeResponseMapper filmeResponseMapper;

    @Autowired
    private FilmeEntityMapper filmeEntityMapper;

    @Autowired
    private ConsultarDetalhesFilmeResponseMapper consultarDetalhesFilmeResponseMapper;

    public List<FilmeResponse> getFilmes()

}
