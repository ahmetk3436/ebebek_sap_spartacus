package com.test.dao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public Class EbebekCaseDaoImpl implements TestDao{

@Autowired
     FlexibleSearchService flexibleSearchService;

public List<ProductModel> getProducts()
        {
final Map<String, Object> params = new HashMap<String, Object>();
        String query =”SELECT {p:pk} FROM {Product AS p} WHERE {p:code} LIKE ?code”
        params.put("code",”001”);
//If do not want to pass any condition in query remove where clause and params as well but getting all products is not recommended
final SearchResult<ProductModel> searchResult = flexibleSearchService.search(query, params);
        return searchResult.getResults();
        }

        }