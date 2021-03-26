package ru.pb.graphql.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pb.graphql.DAO.Entity.Vehicle;
import ru.pb.graphql.Service.VehicleService;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> vehicles(Number count) {
        return vehicleService.getAllVehicles(count.intValue());
    }

    public Optional<Vehicle> getVehicle(final int id) {
        return vehicleService.getVehicle(id);
    }

}
