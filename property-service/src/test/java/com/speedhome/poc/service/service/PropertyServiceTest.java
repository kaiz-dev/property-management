package com.property.poc.service.service;

import com.property.poc.service.mapper.PropertyMapper;
import com.property.poc.service.mock.PropertyData;
import com.property.poc.service.repository.PropertyRepository;
import com.property.poc.service.search.PropertySearch;
import com.property.poc.service.service.PropertyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceTest {
    @InjectMocks
    PropertyService service;

    @Mock
    PropertyRepository repository;

    @Mock
    PropertyMapper mapper;

    @Mock
    PropertySearch propertySearch;

    @Test
    public void createProperty() {
        service.createProperty(PropertyData.mockPropertyReq());
    }

    @Test
    public void updateProperty() {
        service.updateProperty(PropertyData.PROPERTY_ID, PropertyData.mockPropertyReq());
    }

    @Test
    public void approveProperty() {
        service.approveProperty(PropertyData.PROPERTY_ID, PropertyData.mockPropertyApproveReq());
    }

    @Test
    public void searchProperty() {
        service.search("MOCK_TERM");
    }
}
