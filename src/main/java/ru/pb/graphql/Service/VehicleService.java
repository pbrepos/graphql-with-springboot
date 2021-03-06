package ru.pb.graphql.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pb.graphql.DAO.Entity.Vehicle;
import ru.pb.graphql.DAO.Repository.VehicleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public Vehicle createVehicle(final String type,
                                 final String modelCode,
                                 final String brandName,
                                 final String launchDate
    ) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        if (Objects.nonNull(launchDate)) {
            vehicle.setLaunchDate(LocalDate.parse(launchDate));
        }
        return vehicleRepository.save(vehicle);

    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return vehicleRepository.findAll().stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return vehicleRepository.findById(id);
    }
}
