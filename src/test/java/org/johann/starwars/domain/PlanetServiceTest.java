package org.johann.starwars.domain;

import static org.johann.starwars.common.PlanetConstants.INVALID_PLANET;
import static org.johann.starwars.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// para testes de unidade, utilizamos só o mockito, sem a anotação do spring boot
@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {
    // @Autowired
    @InjectMocks
    private PlanetService planetService;

    // @MockitoBean
    @Mock
    private PlanetRepository planetRepository;

    @Test
    //operacao_estado_retorno
    public void createPlanet_WithValidData_ReturnsPlanet() {
        // AAA
        // Arrange
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        // Act
        // sut = system under test (alvo do teste)
        Planet sut = planetService.create(PLANET);

        // Assert
        assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    public void createPlanet_WithInvalidData_ThrowsException() {
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy( ()  -> planetService.create(INVALID_PLANET) ).isInstanceOf(RuntimeException.class);
    }
}
