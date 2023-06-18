package br.com.avesideal.application.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public final class ConverterDTO<T> {

    private final ModelMapperConfig modelMapperConfig;

    public T convertObject(T object, Class<T> type){
        return modelMapperConfig.modelMapper().map(object,type);
    }

    public List<T> convertListObjects(List<T> objectList, Class<T> type){

        return objectList.stream()
                         .map(response -> new ModelMapper().map(response,type))
                         .collect(Collectors.toList());
    }
}
