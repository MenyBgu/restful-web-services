package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //field1, field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBrean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mapping = filterByFields(Arrays.asList(someBean),"field1","field2");

        return mapping;
    }

    //field2, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBrean() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1x", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));

        MappingJacksonValue mapping=filterByFields(list,"field2","field3");

        return mapping;
    }


    private MappingJacksonValue filterByFields(List<SomeBean> someBean,String filterA,String filterB) {
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept(filterA,filterB);

        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }
}
