import models.Car;
import repository.CarRepository;
import repository.CarRepositoryFileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CarRepositoryTest {

    @Mock
    private InputStream inputStream;

    private CarRepository repository;

    @BeforeEach
    public void setup() {
        String testData = "Toyota,Corolla,2020,150,8,7,9\n" +
                "Ferrari,488 Pista,2019,720,10,6,8\n";

        inputStream = new ByteArrayInputStream(testData.getBytes());
        repository = new CarRepositoryFileImpl(inputStream);
    }

    @Test
    public void shouldReturnAllCarsWhenFindAllIsCalled() throws IOException {
        List<Car> expectedCars = Arrays.asList(
                new Car("Toyota", "Corolla", 2020, 150, 8, 7, 9),
                new Car("Ferrari", "488 Pista", 2019, 720, 10, 6, 8)
        );

        assertEquals(expectedCars, repository.findAll());
    }

    @Test
    public void shouldReturnCarWhenValidIdProvided() {
        given(repository.findById(anyLong())).willReturn(new Car("Toyota", "Corolla", 2020, 150, 8, 7, 9));

        Car foundCar = repository.findById(1L);
        assertEquals("Toyota", foundCar.getMake());
    }

    @Test
    public void shouldReturnNullWhenInvalidIdProvided() {
        given(repository.findById(anyLong())).willReturn(null);

        Car foundCar = repository.findById(-1L);
        assertNull(foundCar);
    }

    @Test
    public void shouldSaveNewCarSuccessfully() {
        Car newCar = new Car("BMW", "X5", 2022, 300, 7, 8, 9);
        repository.save(newCar);

    }

    @Test
    public void shouldUpdateExistingCar() {
        Car updatedCar = new Car("Ford", "Mustang", 2021, 400, 8, 7, 9);
        repository.update(updatedCar);

    }

    @Test
    public void shouldDeleteCarById() {
        long idToRemove = 1L;
        repository.delete(idToRemove);

    }

    @Test
    public void shouldReturnEmptyCollectionIfNoCarsPresent() throws IOException {
        repository = new CarRepositoryFileImpl((InputStream) Collections.emptyList());
        assertEquals(Collections.emptyList(), repository.findAll());
    }
}