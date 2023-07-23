package com.app.rentACarApp.utilities.mappers;
import org.modelmapper.ModelMapper;
public interface ModelMapperService {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
