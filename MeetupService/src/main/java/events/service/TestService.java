package events.service;

import events.api.rest.dto.EventDto;
import events.api.rest.dto.EventFilterDto;
import info.nino.jpatron.pagination.Page;
import info.nino.jpatron.pagination.PageRequest;
import info.nino.jpatron.services.entity.EntityService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Set;

@ApplicationScoped
@Slf4j
public class TestService {

    @SuppressWarnings({"rawtypes"})
    public Page<EventDto> filter(PageRequest pageRequest, EventFilterDto filterDto) {
        Integer pageNumber = 0;
        Integer pageSize = 10;
        long totalItems = 1000;
        EntityService.QueryExpression.Conditional filters = pageRequest.getQueryFilters();
        Set<EntityService.QueryExpression.Filter> queryFilters = filters.getFilters();
        Set<EntityService.QueryExpression.Conditional> querySubFilters = filters.getConditionals();
        //log.info(queryFilters.toString());
        //log.info(querySubFilters.toString());

        return new Page<EventDto>(pageNumber, pageSize, totalItems, Collections.emptyList());
    }
}
