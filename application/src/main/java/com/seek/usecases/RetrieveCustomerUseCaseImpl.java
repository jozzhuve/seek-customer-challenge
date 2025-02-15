package com.seek.usecases;

import com.seek.config.SeekConfigurationProperties;
import com.seek.models.Customer;
import com.seek.models.exception.CustomerException;
import com.seek.ports.in.RetrieveCustomerUseCase;
import com.seek.ports.out.CustomerRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
public class RetrieveCustomerUseCaseImpl implements RetrieveCustomerUseCase {

  protected final CustomerRepositoryPort customerRepositoryPort;
  protected final SeekConfigurationProperties properties;

  @Override
  public Customer getAverageAgeAndStandardDeviationAges() {
    List<Customer> customers = customerRepositoryPort.findAll();
    List<Integer> ages = customers
        .stream()
        .map(Customer::getEdad)
        .toList();

    double average = calculateAgeAverage(ages);
    double standardDeviation = calculateStandardDeviation(ages, average);

    log.debug("promedio de edades {}", average);
    log.debug("desviacion estandar {}", standardDeviation);

    Customer customerReturn = new Customer();
    customerReturn.setPromedioEdad(average);
    customerReturn.setDesviacionEstandarEdad(standardDeviation);

    return customerReturn;
  }

  @Override
  public Customer getAllCustomersAndLifeExpectancy() {
    List<Customer> customers = customerRepositoryPort.findAll()
        .stream()
        .map(this::calculateLifeExpectancy).collect(Collectors.toList());
    Customer customerReturn = new Customer();
    customerReturn.setCustomers(customers);
    return customerReturn;
  }

  private Double calculateAgeAverage(List<Integer> ages) {
    if (ages.isEmpty()) {
      throw new CustomerException(HttpStatus.UNPROCESSABLE_ENTITY.value(),
          "Error calculo de promedio de edades",
          "No se encontro edades disponibles para el calculo");
    }
    return ages.stream()
        .mapToDouble(Integer::doubleValue)
        .average().orElse(0.0);
  }

  private Double calculateStandardDeviation(List<Integer> ages, double average) {
    if (ages.isEmpty()) {
      throw new CustomerException(HttpStatus.UNPROCESSABLE_ENTITY.value(),
          "Error calculo de desviacion estandar",
          "No se encontro edades disponibles para el calculo");
    }
    double sumSquares = ages.stream()
        .mapToDouble(edad -> Math.pow(edad - average, 2))
        .sum();

    return Math.sqrt(sumSquares / ages.size());
  }

  public Customer calculateLifeExpectancy(Customer customer) {
    List<Integer> edadesFuturas = properties.getCustomer().getEdadesMortalidadPeru()
        .stream()
        .filter(edad -> edad > customer.getEdad()).toList();

    if (edadesFuturas.isEmpty()) {
      throw new CustomerException(HttpStatus.UNPROCESSABLE_ENTITY.value(),
          "Error calculo de esperanza de vida",
          "No se encontro edades disponibles para el calculo");
    }
    customer.setEsperanzaVida(edadesFuturas.stream()
        .mapToDouble(Integer::doubleValue)
        .average()
        .orElse(0));
    return customer;
  }
}
