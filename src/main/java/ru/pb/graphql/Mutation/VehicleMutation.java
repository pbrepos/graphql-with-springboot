package ru.pb.graphql.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pb.graphql.DAO.Entity.Vehicle;
import ru.pb.graphql.Service.VehicleService;

@Component
public class VehicleMutation  implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    public Vehicle  createVehicle(
            final String type,
            final String modelCode,
            final String brandName,
            final String launchDate) {
        return vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}
